/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.FuncionarioModel;
import presenter.FuncionarioPresenter;
import serviceState.TelaInclusaoState;
import serviceTratamentoErro.InterfaceTratamentoErro;
import view.FuncionarioViewTelaInclusao;

/**
 *
 * @author USER
 */
public class ControladorTelaInclusao implements InterfaceConfiguracaoTela, InterfaceTratamentoErro{
    private FuncionarioViewTelaInclusao view;
    private FuncionarioPresenter presenter;
    private TelaInclusaoState telaInclusao;

    public ControladorTelaInclusao(FuncionarioViewTelaInclusao view, FuncionarioPresenter presenter, TelaInclusaoState telaInclusao) {
        this.view = view;
        this.presenter = presenter;
        this.telaInclusao = telaInclusao;
    }

    @Override
    public void configuraTela(){
        view.setVisible(false);
        
        view.getBtnSalvar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                salvarFuncionarios();
            }
        });
        
        view.getBtnCancelar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                limparCampos();
            }
        });
        view.setVisible(true);
    }


    public void salvarFuncionarios(){
        String nome = view.getTextFieldNome().getText();
        String cargo = view.getTextFieldCargo().getText();
        String valor = view.getTextFieldSalario().getText();
              
        if(tryParseDouble(valor)){
        double salario = Double.parseDouble(valor);
        FuncionarioModel model = new FuncionarioModel(nome, cargo, salario);
        presenter.adicionarFuncionario(model);
        
        limparCampos();
        }
    }
    
     public void limparCampos(){
        view.getTextFieldNome().setText("");
        view.getTextFieldCargo().setText("");
        view.getTextFieldSalario().setText("");
        
        view.getTextFieldNome().requestFocus();
    }

    public boolean tryParseDouble(String valor){
        try{
            Double.parseDouble(valor);
            return true;
        }catch(NumberFormatException e){
            exibirMensagem("O salario inserido é invalido", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void visualizarFuncionario(String nome, String cargo, double salario){
        view.getTextFieldNome().setText(nome);
        view.getTextFieldCargo().setText(cargo);
        view.getTextFieldSalario().setText(String.valueOf(salario));
        
        view.getTextFieldNome().setEditable(false);
        view.getTextFieldCargo().setEditable(false);
        view.getTextFieldSalario().setEditable(false);
    }
    
    @Override
    public void exibirMensagem(String mensagem, String titulo, int tipoMensagem){
        JOptionPane.showMessageDialog(view, mensagem, titulo, tipoMensagem);
    }
    
}