/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presenter.FuncionarioPresenter;
import serviceState.TelaPrincipalState;
import view.FuncionarioViewTelaPrincipal;

/**
 *
 * @author USER
 */
public class ControladorTelaPrincipal implements InterfaceConfiguracaoTela{
    private FuncionarioPresenter estado;
    private FuncionarioViewTelaPrincipal view;
    private TelaPrincipalState telaPrincipal;

    public ControladorTelaPrincipal(FuncionarioPresenter estado, FuncionarioViewTelaPrincipal view, TelaPrincipalState telaPrincipal) {
        this.estado = estado;
        this.view = view;
        this.telaPrincipal = telaPrincipal;
    }
    
    @Override
    public void configuraTela() {
        view.setVisible(false);
        view.getBtnAdicionarFuncionario().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                telaPrincipal.proximoEstado(estado, e);
            }
        });
        view.getBtnConsultar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               telaPrincipal.proximoEstado(estado,  e);
            }
        });
        view.setVisible(true);
        
    }
}
