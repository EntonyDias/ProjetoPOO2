/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author s.lucas
 */
public class UsuarioController {
    public boolean autenticar(String login, String senha){
            String sql = "SELECT * from TBUSUARIO WHERE login = ? and senha = ? and ativo = true";
    
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;
    ResultSet resultado = null;
    
    try {
        comando = gerenciador.prepararComando(sql);
        
        comando.setString(1, login);
        comando.setString(2, senha);
        
        resultado = comando.executeQuery();
        
        if (resultado.next()){
            return true;
        }
        
    } catch (SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    } finally {
        gerenciador.fecharConexao(comando, resultado);
    }
    return false;
    }
    public boolean inserirUsuario(Usuario user) {
        String sql = "INSERT into TBUSUARIO (nome, login, senha, datanasc, ativo) values (?,?,?,?,?)";
    
        GerenciadorConexao gen = new GerenciadorConexao();
        PreparedStatement comando = null;
        
        try {
            comando = gen.prepararComando(sql);
            comando.setString(1, user.getNome());
            comando.setString(2, user.getLogin());
            comando.setString(3, user.getSenha());
            comando.setDate(4, new java.sql.Date(user.getDataNasc().getTime()));
            comando.setBoolean(5, user.isAtivo());
            
            comando.executeUpdate();
            return true;
            
        } catch (SQLException e){ JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        } finally { gen.fecharConexao(comando);}
    return false;    
    }
    
    public List<Usuario> buscarUsuario(int tpFiltro, String filtro){
    //Guarda o SQL
    String sql = "SELECT pkusuario, nome, login, senha, datanasc, ativo from TBUSUARIO";
    
    if(!filtro.equals("")){
        if (tpFiltro == 0 || tpFiltro == 1){
        sql += " WHERE nome LIKE ? ";
        } else if (tpFiltro == 2 || tpFiltro == 3){
        sql += " WHERE login LIKE ? ";
        }
    }
    
    //Cria um gerenciador de conexão
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    
    //Cria as váriaveis vazias antes do try pois vão ser usuários
    PreparedStatement comando = null;
    ResultSet resultado = null;
    
    //Cria a lista de usuários vazia
    List<Usuario> listarUsuario = new ArrayList<>();
    
    try {
        //Preparo do comando SQL
        comando = gerenciador.prepararComando(sql);
        
        if(!filtro.equals("")){
            if (tpFiltro == 0){
        comando.setString(1, filtro+"%");
            }else if (tpFiltro == 1){
        comando.setString(1, "%"+filtro+"%");
            } else if (tpFiltro == 2){
        comando.setString(1, filtro+"%");
            } else if (tpFiltro == 3){
        comando.setString(1, "%"+filtro+"%");
            }
        }
        
        //Como não há parãmetros, já executo direto
        resultado = comando.executeQuery();
        
        //Irá percorrer os registros do resultado SQL
        //A cada "next()" a variavel resultado aponta para a proxima linha da tabela  
        //Enquanto "next() == true" quer dizer que tem registro para ser considerado verdadeiro
        while (resultado.next()){
            
            //Cria um novo usuário vazio
            Usuario user = new Usuario();
            
            //Pega os atributos do SQL e coloca no Objeto usuário
            user.setPkusuario(resultado.getInt("pkusuario"));
            user.setNome(resultado.getString("nome"));
            user.setLogin(resultado.getString("login"));
            user.setSenha(resultado.getString("senha"));
            user.setDataNasc(resultado.getTime("datanasc"));
            user.setAtivo(resultado.getBoolean("ativo"));
            
        //Adiciona o Objeto a Lista
        listarUsuario.add(user);
        }
    } // Se ocorrer um erro, cairá nisso aqui 
    catch (SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    } 
    //Retorna a lista no final do método
    return listarUsuario;
    }
}