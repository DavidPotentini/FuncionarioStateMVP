/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceState;

import java.awt.event.ActionEvent;
import presenter.FuncionarioPresenter;
import serviceControlador.ControladorTelaConsulta;

import view.FuncionarioViewTelaConsulta;

/**
 *
 * @author USER
 */
public class TelaConsultaState implements InterfaceEstado{
    private FuncionarioPresenter presenter;
    private FuncionarioViewTelaConsulta view;
    private ControladorTelaConsulta controlador;

    
    public TelaConsultaState(FuncionarioPresenter presenter){
    this.presenter = presenter;
    this.view = new FuncionarioViewTelaConsulta();
    this.controlador = new ControladorTelaConsulta(presenter, view, this);
    controlador.configuraTela();
    controlador.gerarTabela();
    }
    
    
    @Override
    public void proximoEstado(FuncionarioPresenter estado, ActionEvent e) {
        estado.setTela(new TelaInclusaoState(controlador.getNome(), controlador.getCargo(), controlador.getSalario()));
    }
    
}
