/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psc.projetoa3;

/**
 * 
 * @author d4rkwav3
 */
public class Usuario {
    private String nome;
    private String senha;
    private int id;
    private boolean adm = false;
    private Dados dados;  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario(String nome, String senha, boolean privileges) {
        this(nome, senha);
        this.adm = privileges;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public void setPrivilegios(boolean privilegio){
        this.adm = privilegio;
    }
    
    public boolean isAdm() {
        return this.adm;
    }
    
    public void setDados(Dados dados) {
        this.dados = dados;
    }
    
    public Dados getDados() {
        return this.dados;
    }
}
