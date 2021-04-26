package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conexao;

public class Produto {

    private int idproduto;
    private String descricao;
    private String categoria;
    private float preco;
    private int qtdestoque;
    private String observacao;   
   
    public Produto() {
    }

    public Produto(int idproduto, String descricao, String categoria, float preco, int qtdestoque, String observacao) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.qtdestoque = qtdestoque;
        this.observacao = observacao;
        
    }

    public Produto(String descricao, String categoria, float preco, int qtdestoque, String observacao) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.qtdestoque = qtdestoque;
        this.observacao = observacao;
    }
    
    public Produto consultarById(int id){
       ResultSet rs = null;
       Produto ct = null;
       try {
            String sql = "select * from Produto"
                      + " where idproduto = ? ";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs.next()){
              ct = new Produto(
                      rs.getInt("id"),
                      rs.getString("descricao"),
                      rs.getString("categoria"),
                      rs.getFloat("preco"),
                      rs.getInt("qtdestoque"),
                      rs.getString("observacao"));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
       return ct;
    }
    
    
    public List<Produto> consultar(String filtro){
        ResultSet rs = null;
        List<Produto> lista = new ArrayList<>();
        try {
            String sql = "select * from Produto"
                      + " where descricao like '%"+filtro+"%'";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
              lista.add(new Produto(
                      rs.getInt("idproduto"),
                      rs.getString("descricao"),
                      rs.getString("categoria"),
                      rs.getFloat("preco"),
                      rs.getInt("qtdestoque"),
                      rs.getString("observacao")));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return lista;
    }
    public List<Produto> consultarCategoria(String filtro){
        ResultSet rs = null;
        List<Produto> lista = new ArrayList<>();
        try {
            String sql = "select * from Produto"
                      + " where categoria like '%"+filtro+"%'";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
              lista.add(new Produto(
                      rs.getInt("idproduto"),
                      rs.getString("descricao"),
                      rs.getString("categoria"),
                      rs.getFloat("preco"),
                      rs.getInt("qtdestoque"),
                      rs.getString("observacao")));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return lista;
    }
    
    public boolean salvar(){
        try {
            String sql = "insert into Produto(descricao, categoria, preco, qtdestoque, observacao)" +
                    "values(?,?,?,?,?)";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql); 
            stm.setString(1, this.getDescricao());
            stm.setString(2, this.getCategoria());
            stm.setFloat(3, this.getPreco());
            stm.setInt(4, this.getQtdestoque());
            stm.setString(5, this.getObservacao());
            stm.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    public boolean update(){
        try {
            String sql = "update Produto set "
                     + " descricao = ?, "
                     + " categoria = ?, "
                     + " preco = ?, " 
                     + " qtdestoque = ?, "
                     + " observacao = ?, "
                     + " where idproduto = ?";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql); 
            stm.setString(1, this.getObservacao());
            stm.setString(2, this.getCategoria());
            stm.setFloat(3, this.getPreco());
            stm.setInt(4, this.getQtdestoque());
            stm.setString(5, this.getObservacao());
            stm.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }
    
    
    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtdestoque() {
        return qtdestoque;
    }

    public void setQtdestoque(int qtdestoque) {
        this.qtdestoque = qtdestoque;
    }
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
}
