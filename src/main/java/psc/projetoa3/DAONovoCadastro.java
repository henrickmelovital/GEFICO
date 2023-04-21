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
public class DAONovoCadastro {
    //quebrei a query em várias strings para melhor visualização
    private String q1 = "INSERT INTO tb_Cliente "; 
    private String q2 = "(Nome, CPF, Idade, Preferencia, CEP, Logradouro, Cidade, ";
    private String q3 = "UF, Bairro, Numero, Complemento, Telefone, Email, idUsuario) VALUES ";
    private String q4 = "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //query pra inserir um novo usuário
    private String cl = "SELECT * FROM tb_Usuario WHERE Login =?";
    private String uq = "INSERT INTO tb_Usuario (Login, Senha) VALUES (?, ?)";
    
    //pega o id no usuário recém-criado para criar seus dados
    private String id = "SELECT id FROM tb_Usuario WHERE Login =?";
    
    //método que cadastra os dados de um novo usuário
    public void inserirCadastro(Dados novosDados, Usuario user) throws Exception {
        Dados nd = novosDados;
        Usuario u = user;
        
        try (Connection conexao = BaseDeDados.conectar();
            PreparedStatement ps = conexao.prepareStatement(q1 + q2 + q3 + q4)) {
            
            ps.setString(1, nd.getNome());
            ps.setString(2, nd.getCpf());
            ps.setInt(3, nd.getIdade());
            ps.setBoolean(4, nd.isPreferencia());
            ps.setString(5, nd.getCep());
            ps.setString(6, nd.getLogradouro());
            ps.setString(7, nd.getCidade());
            ps.setString(8, nd.getUf());
            ps.setString(9, nd.getBairro());
            ps.setInt(10, nd.getNumero());
            ps.setString(11, nd.getComplemento());
            ps.setString(12, nd.getTelefone());
            ps.setString(13, nd.getEmail());
            ps.setInt(14, u.getId());
           
            ps.execute();
        }
    }
    
    //Verifica se o usuário já existe na base
    public boolean consultaLogin (Usuario user) throws Exception {
        Usuario u = user;
        
        try (Connection conexao = BaseDeDados.conectar(); //conecta com a base
            PreparedStatement ps = conexao.prepareStatement(cl)) { //cria a query
            ps.setString(1, u.getNome()); //insere o nome do usuário na query

            try(ResultSet rs = ps.executeQuery()) { //executa a query
                return rs.next(); //Se houver resultado retorna true
            }
        }
    }
    //pega o id de um usuário recém-criado
    public Usuario prepareNewUser(Usuario user) throws Exception {
        Usuario newUser = user;
        
        try (Connection conexao = BaseDeDados.conectar();
                PreparedStatement ps = conexao.prepareStatement(id)) {
            
            ps.setString(1, user.getNome());
            
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                newUser.setId(rs.getInt(1));
                return newUser;
            }
        }
    }
    //cria um novo usuário
    public void novoUsuario(Usuario user) throws Exception {
        Usuario u = user;
        
        try (Connection con = BaseDeDados.conectar();
                PreparedStatement ps = con.prepareStatement(uq)) {
            
            ps.setString(1, u.getNome());
            ps.setString(2, u.getSenha());
            ps.execute();
        }
    }
}
