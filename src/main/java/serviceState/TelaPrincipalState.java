/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import presenter.FuncionarioPresenter;
import serviceControlador.ControladorTelaPrincipal;
import view.FuncionarioViewTelaPrincipal;

/**
 *
 * @author USER
 */
public class TelaPrincipalState implements InterfaceEstado{
    
    private FuncionarioPresenter estado;
    private FuncionarioViewTelaPrincipal view;
    private ControladorTelaPrincipal controlador;
    
    public TelaPrincipalState(FuncionarioPresenter estado){
        this.estado = estado;
        this.view = new FuncionarioViewTelaPrincipal();
        this.controlador = new ControladorTelaPrincipal(estado, view, this);
        controlador.configuraTela();
    }

    
    @Override
    public void proximoEstado(FuncionarioPresenter estado, ActionEvent e) {
        if(e.getSource() == view.getBtnAdicionarFuncionario()){
        estado.setTela(new TelaInclusaoState(estado));
        }else if(e.getSource() == view.getBtnConsultar()){
        estado.setTela(new TelaConsultaState(estado));
        }
    }
}
