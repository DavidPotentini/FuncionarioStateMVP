/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;


import java.util.ArrayList;
import model.FuncionarioModel;
import serviceState.InterfaceEstado;
import serviceState.TelaPrincipalState;

/**
 *
 * @author USER
 */
public class FuncionarioPresenter {
    private InterfaceEstado estadoInicial;
    private InterfaceEstado estado;
    private ArrayList <FuncionarioModel> models;
    
    public FuncionarioPresenter(){
        this.estadoInicial = new TelaPrincipalState(this);
        this.models = new ArrayList<>();
    }
    
    public void adicionarFuncionario(FuncionarioModel m){
        models.add(m);
    }
    
    public void setTela(InterfaceEstado estado){
        this.estado = estado;
    }
    
    public ArrayList<FuncionarioModel> retornarTodos(){
        return models;
    }
}
