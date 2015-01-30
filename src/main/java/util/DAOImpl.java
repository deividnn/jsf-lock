/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;

public class DAOImpl<T> implements DAO<T> {

    private final Session sessao;
    private final Class<T> classe;

    public DAOImpl(Session sessao, Class<T> classe) {
        super();
        this.sessao = sessao;
        this.classe = classe;
    }

    @Override
    public boolean salvar(T t) {
        try {
            this.sessao.save(t);
            return true;
        } catch (Exception e) {
            System.out.println("erro(dao): " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(T t) {
        try {
            this.sessao.merge(t);
            return true;
        } catch (Exception e) {
            System.out.println("erro(dao): " + e);
            if (e instanceof StaleObjectStateException) {
                StaleObjectStateException ex = (StaleObjectStateException) e;
                Util.criarMensagemErro("Erro: " + ex.getEntityName() + " foi alterado recentemente (atualize a pagina)");
                throw new HibernateException(ex);
            }
            return false;
        }
    }

    @Override
    public boolean excluir(T t) {
        try {
            this.sessao.delete(t);
            return true;
        } catch (Exception e) {
            System.out.println("erro(dao): " + e);
            Util.criarMensagemErro("Erro ao excluir o registro (atualize a pagina)");
            throw new HibernateException(e);

        }
    }

    @Override
    public T pegar(String hql) {
        try {
            return (T) this.sessao.createQuery(hql).uniqueResult();
        } catch (Exception e) {
            System.out.println("erro(dao): " + e);
        }
        return null;
    }

    @Override
    public List<T> listar(String hql) {
        try {
            return this.sessao.createQuery(hql).list();
        } catch (Exception e) {
            System.out.println("erro(dao): " + e);
        }
        return null;
    }

}
