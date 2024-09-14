package model;

import java.util.Date;

public class Usuario {

    private int pkusuario;
    private String nome;
    private String login;
    private String senha;
    private Date dataNasc;
    private boolean ativo;

    public Usuario() {
    }

    public Usuario(int pkusuario, String nome, String login, String senha, Date dataNasc, boolean ativo) {
        this.pkusuario = pkusuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.ativo = ativo;
    }

    public int getPkusuario() {
        return pkusuario;
    }

    public void setPkusuario(int pkusuario) {
        this.pkusuario = pkusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String ativoToString() {
        if(ativo){
            return "Ativado";
        }else{
            return "Não ativo";
    }
}
}   