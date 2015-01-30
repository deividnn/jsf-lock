/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import model.Funcionario;
import util.DAOImpl;
import util.Util;

/**
 *
 * @author deivid
 */
public class FuncionarioRN implements Serializable {

    private final DAOImpl<Funcionario> dao;

    public FuncionarioRN() {
        this.dao = new DAOImpl<>(Util.pegarSessao(), Funcionario.class);
    }

    public boolean salvar(Funcionario funcionario) {
        try {
            funcionario.setAlteracao(new Date());

            if (funcionario.getId() == null) {
                this.dao.salvar(funcionario);
                Util.criarMensagem("inserido");
                return true;
            } else {
                this.dao.atualizar(funcionario);
                Util.criarMensagemAviso("atualizado");
                return true;
            }
        } catch (Exception e) {
            System.out.println("erro(rn): " + e);
            return false;
        }
    }

    public boolean excluir(Funcionario funcionario) {
        try {

            this.dao.excluir(funcionario);
            Util.criarMensagem("excluido");
            return true;
        } catch (Exception e) {
            System.out.println("erro(rn): " + e);
            return false;
        }
    }

    public List<Funcionario> listar(String hql) {
        return this.dao.listar(hql);
    }

    public Funcionario pegar(String hql) {
        return this.dao.pegar(hql);
    }
}
