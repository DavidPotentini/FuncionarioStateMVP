/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceState;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import presenter.FuncionarioPresenter;
import serviceControlador.ControladorTelaInclusao;
import serviceTratamentoErro.InterfaceTratamentoErro;
import view.FuncionarioViewTelaInclusao;

/**
 *
 * @author USER
 */
public class TelaInclusaoState implements InterfaceEstado, InterfaceTratamentoErro{
    
    private FuncionarioViewTelaInclusao view;
    private FuncionarioPresenter presenter;
    private ControladorTelaInclusao controlador;

    public TelaInclusaoState(FuncionarioPresenter presenter){
    this.presenter = presenter;
    this.view = new FuncionarioViewTelaInclusao();
    this.controlador = new ControladorTelaInclusao(view, presenter, this);
    controlador.configuraTela();
    }
    
    public TelaInclusaoState(String nome, String cargo, double salario){
        this.view = new FuncionarioViewTelaInclusao();
        this.controlador = new ControladorTelaInclusao(view, presenter, this);
        controlador.visualizarFuncionario(nome, cargo, salario);
    }

    
    
    @Override
    public void proximoEstado(FuncionarioPresenter estado, ActionEvent e) {
        exibirMensagem("O estado atual não possui estados subsequentes", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void exibirMensagem(String mensagem, String titulo, int tipoMensagem){
        JOptionPane.showMessageDialog(view, mensagem, titulo, tipoMensagem);
    }
    
}
