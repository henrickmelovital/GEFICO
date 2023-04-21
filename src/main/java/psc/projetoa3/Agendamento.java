/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psc.projetoa3;

/**
 *
 * @author d4rkwav3
 */
public class Agendamento {
    private String local, tipo, data, horario;
    private int idCliente;
    
    Agendamento(String local, String tipo, String data, String hora, int id) {
        String ano = "20" + data.substring(4, 6);
        String mes = data.substring(2, 4);
        String dia = data.substring(0, 2);        
        
        String hour = hora.substring(0, 2);
        String minuto = hora.substring(2, 4);
        
        this.local = local;
        this.tipo = tipo;
        this.data = ano + mes + dia;
        this.horario = hour + minuto + "00";
        this.idCliente = id;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setDataApp(String data) {
        String ano = "20" + data.substring(4, 6);
        String mes = data.substring(2, 4);
        String dia = data.substring(0, 2);
        this.data = ano + mes + dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        String hora = horario.substring(0, 2);
        String minuto = horario.substring(2, 4);
        this.horario = hora + ":" + minuto + ":00";
    }
    
//    @Override
//    public String toString() {
//        return this.local;
//    }
}
