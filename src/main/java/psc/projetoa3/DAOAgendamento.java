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
public class DAOAgendamento {
    //quebrei a query em várias strings para melhor visualização
    private String ag1 = "INSERT INTO tb_Pedidos (Local, Tipo, dataAgendamento, Horario, idCliente) ";
    private String ag2 = "VALUES (?, ?, ?, ?, ?)";
    private String h1 = "SELECT Nome, `Local`, Tipo, dataAgendamento, Horario ";
    private String h2 = "FROM tb_Cliente, tb_Pedidos ";
    private String h3 = "WHERE tb_Pedidos.idCliente = tb_Cliente.id AND idCliente =?";

    public void novoAgendamento(Agendamento agendamento) throws Exception {
        Agendamento ag = agendamento;
        
        try (Connection con = BaseDeDados.conectar();
            PreparedStatement ps = con.prepareStatement(ag1 + ag2)) {
            
            ps.setString(1, ag.getLocal());
            ps.setString(2, ag.getTipo());
            ps.setString(3, ag.getData());
            ps.setString(4, ag.getHorario());
            ps.setInt(5, ag.getIdCliente());
            
            ps.execute();
        }
    }
    
//    public Agendamento[][] buscarHistoricoAdm() throws Exception {
//        try (Connection con = BaseDeDados.conectar();
//            PreparedStatement ps = con.prepareStatement(hAdm1 + hAdm2,
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//                ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = ps.executeQuery()) {
//
//            int totalDeAg = rs.last() ? rs.getRow() : 0;
//            Agendamento[][] agendamentos = new Agendamento[1][totalDeAg];
//            rs.beforeFirst();
//            
//            int contador = 0;
//            while(rs.next()) {
//                String local = rs.getString(2);
//                String tipo = rs.getString(3);
//                String data = rs.getString(4);
//                String hora = rs.getString(5);
//                int id = rs.getInt(6);
//                
//                agendamentos[0][contador++] = new Agendamento(local, tipo, data, hora, id);
//            }
//            return agendamentos;
//        } 
//    }
    
    public String[][] buscarHistorico(Dados userData) throws Exception {
        try (Connection conexao = BaseDeDados.conectar();
            PreparedStatement ps = conexao.prepareStatement(h1 + h2 + h3,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) {
            
            ps.setInt(1, userData.getId());
            ResultSet rs = ps.executeQuery();
            
            int totalLinhas = rs.last() ? rs.getRow() : 0;
            String[][] agendamentos = new String[totalLinhas][5];
            rs.beforeFirst();
            String nome, local, tipo, data, hora;
            
            int contador = 0;
            while(rs.next()) {
                agendamentos[contador][0] = nome = rs.getString(1);
                agendamentos[contador][1] = local = rs.getString(2);
                agendamentos[contador][2] = tipo = rs.getString(3);
                agendamentos[contador][3] = data = rs.getString(4);
                agendamentos[contador][4] = hora = rs.getString(5);
                contador++;
            }
            return agendamentos;
        } 
    }
}
