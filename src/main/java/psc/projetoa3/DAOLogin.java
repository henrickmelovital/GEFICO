/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psc.projetoa3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author d4rkwav3
 */
public class DAOLogin {
    private String login = "SELECT * FROM tb_Usuario WHERE Login =? AND Senha =?";
    private String setPrivileges = "SELECT ADM, id FROM tb_Usuario WHERE Login =? AND Senha =?";
    private String data = "SELECT * FROM tb_Cliente WHERE idUsuario =?";
    
    public boolean consultaLogin (String userLogin, String userSenha) throws Exception {
        
    try (Connection conexao = BaseDeDados.conectar(); //conecta com a base
        PreparedStatement ps = conexao.prepareStatement(login)) { //cria a query
        ps.setString(1, userLogin); //insere o nome do usuário na query
        ps.setString(2, userSenha); //insere a senha do usuário na query
            
        try(ResultSet rs = ps.executeQuery()){ //executa a query
            return rs.next(); //Se houver resultado retorna true
            }
        }
    }
    
    public Usuario setLocalUser (String login, String senha) throws Exception {
        // Esse método copia os dados da base para um objeto Usuario e retorna o objeto Usuario
        
        Usuario loggedUser = new Usuario(login, senha); //o objeto a ser retornado
        
        try (Connection conexao = BaseDeDados.conectar(); //conecta com a base
            PreparedStatement ps = conexao.prepareStatement(setPrivileges)) { //prepara a query
            
            ps.setString(1, loggedUser.getNome()); //insere o nome do usuário na query
            ps.setString(2, loggedUser.getSenha());//insere a senha do usuário na query
            
            try (ResultSet rs = ps.executeQuery()) { //executa a query
                rs.next(); //o ponteiro inicia antes do registro, esse método avança para o registro em si
                loggedUser.setPrivilegios(rs.getBoolean(1)); //pega o privilégio da base e salva no objeto Usuario
                loggedUser.setId(rs.getInt(2));
                return loggedUser; 
            } 
        }
    }
    
    public Dados setLocalUserData (Usuario user) throws Exception {
        Usuario loggedUser = user;
        Dados dados = new Dados();
        
        try (Connection con = BaseDeDados.conectar();
                PreparedStatement ps = con.prepareStatement(data, ResultSet.CONCUR_READ_ONLY)) {
            
            ps.setInt(1, loggedUser.getId());
            
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                dados.setId(rs.getInt(1));
                dados.setNome(rs.getString(2));
                dados.setCpf(rs.getString(3));
                dados.setIdade(rs.getInt(4));
                dados.setPreferencia(rs.getBoolean(5));
                dados.setCep(rs.getString(6));
                dados.setLogradouro(rs.getString(7));
                dados.setCidade(rs.getString(8));
                dados.setUf(rs.getString(9));
                dados.setBairro(rs.getString(10));
                dados.setNumero(rs.getInt(11));
                dados.setComplemento(rs.getString(12));
                dados.setTelefone(rs.getString(13));
                dados.setEmail(rs.getString(14));
                
                return dados;
            }
        }    
    }
}
