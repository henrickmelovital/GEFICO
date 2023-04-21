/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psc.projetoa3;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author d4rkwav3
 */
public class DAODados {
    private String up1 = "UPDATE tb_Cliente ";
    private String up2 = "SET Logradouro=?, Numero=?, Bairro=?, UF=?, CEP=?, Cidade=?, Telefone=?, Email=?, Complemento=? ";
    private String up3 = "WHERE idUsuario =?";
    
    public void atualizarCadastro(Dados userData) throws Exception {
        try (Connection conexao = BaseDeDados.conectar();
            PreparedStatement ps = conexao.prepareStatement(up1 + up2 + up3)) {
            
            ps.setString(1, userData.getLogradouro());
            ps.setInt(2, userData.getNumero());
            ps.setString(3, userData.getBairro());
            ps.setString(4, userData.getUf());
            ps.setString(5, userData.getCep());
            ps.setString(6, userData.getCidade());
            ps.setString(7, userData.getTelefone());
            ps.setString(8, userData.getEmail());
            ps.setString(9, userData.getComplemento());
            ps.setInt(10, userData.getId());
            
            ps.execute();
        }
    }
}
