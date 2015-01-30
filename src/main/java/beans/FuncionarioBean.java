/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controller.FuncionarioRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Funcionario;
import util.Util;

/**
 *
 * @author deivid
 */
@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

    private Funcionario funcionario;
    private List<Funcionario> lista;

    @PostConstruct
    public void init() {
        this.funcionario = new Funcionario();
        this.lista = new ArrayList<>();
        listar();
    }

    public void listar() {
        this.lista = new FuncionarioRN().listar("SELECT vo FROM Funcionario vo"
                + " ORDER BY vo.id DESC");
    }

    public void salvar() {
        if (new FuncionarioRN().salvar(this.funcionario)) {
            novo();
        }
    }

    public void novo() {
        this.funcionario = new Funcionario();
        listar();
        atualizarLimpar();
    }

    private void atualizarLimpar() {
        Util.atualizarComponente("funcionario");
        Util.resetarComponente("funcionario");
    }

    public void editar(Funcionario f) {
        FuncionarioRN rn = new FuncionarioRN();
        Funcionario fu = pegarFuncionario(f,rn);

        this.funcionario = fu;
        atualizarLimpar();
    }

    public void excluir(Funcionario f) {
        FuncionarioRN rn = new FuncionarioRN();
        Funcionario fu = pegarFuncionario(f,rn);

        if (rn.excluir(fu)) {
            novo();
        }
    }
    
    
    private Funcionario pegarFuncionario(Funcionario f,FuncionarioRN rn) {
        
        String hql = "SELECT vo FROM Funcionario vo "
                + " WHERE vo.id=" + f.getId() + "";
        Funcionario fu = rn.pegar(hql);
        return fu;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getLista() {
        return lista;
    }

    public void setLista(List<Funcionario> lista) {
        this.lista = lista;
    }

}
