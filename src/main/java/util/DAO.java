/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;

/**
 *
 * @author deivid
 * @param <T>
 */
public interface DAO<T> {
    
    public boolean salvar(T t);
    
    public boolean atualizar(T t);
    
    public boolean excluir(T t);
    
    public T pegar(String hql);
    
    public List<T> listar(String hql);
}
