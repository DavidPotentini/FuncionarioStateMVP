/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package serviceState;

import java.awt.event.ActionEvent;
import presenter.FuncionarioPresenter;

/**
 *
 * @author USER
 */
public interface InterfaceEstado {
    public void proximoEstado(FuncionarioPresenter estado, ActionEvent e);
}
