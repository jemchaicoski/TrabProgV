
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import models.Produto;

@ManagedBean
@ViewScoped
public class BeanProduto {

    private int idproduto;
    private String descricao;
    private String categoria;
    private float preco;
    private int qtdestoque;
    private String observacao;   
    private String filtro;
    private List<Produto> lista = new ArrayList<>();
    private boolean isFiltrarCategoria;

    public void consultarById(int id){
        Produto ct = new Produto();
        ct = ct.consultarById(id);       
    }
        
    public String redirectEditar(int idproduto){
        return "editaProduto?faces-redirect=true&idproduto="+idproduto ;
    }
    
    public void consultar(){      
      lista = new Produto().consultar(getDescricao());  
    } 
    public void consultarCategoria(){      
      lista = new Produto().consultarCategoria(getCategoria());  
    }
    
     public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
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
   
    
     public List<Produto> getLista() {
        return lista;
    }
     
    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }     

    public void salvar() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (descricao.equals("")) {
            msg = new FacesMessage("Informe a descricao");
            view.addMessage(null, msg);
        }

        if (categoria.equals("")) {
            msg = new FacesMessage("Informe a categoria");
            view.addMessage(null, msg);
        } 

        if (preco == 0.0) {
            msg = new FacesMessage("Informe o preço");
            view.addMessage(null, msg);
        }
        if (qtdestoque == 0) {
            msg = new FacesMessage("Informe a quantidade em estoque");
            view.addMessage(null, msg);
        }
        if (observacao.equals("")) {
            msg = new FacesMessage("Informe a observacao");
            view.addMessage(null, msg);
        }

        if (msg == null) {
            Produto ct = new Produto(this.descricao, this.categoria, this.preco, this.qtdestoque, this.observacao);
            if (ct.salvar()) {
                msg = new FacesMessage("Contato salvo com sucesso");
                view.addMessage(null, msg);
            }
        }
    }  
    
     public void update() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

       if (descricao.equals("")) {
            msg = new FacesMessage("Informe a descricao");
            view.addMessage(null, msg);
        }

        if (categoria.equals("")) {
            msg = new FacesMessage("Informe a categoria");
            view.addMessage(null, msg);
        } 

        if (preco == 0.0) {
            msg = new FacesMessage("Informe o preço");
            view.addMessage(null, msg);
        }
        if (qtdestoque == 0) {
            msg = new FacesMessage("Informe a quantidade em estoque");
            view.addMessage(null, msg);
        }
        if (observacao.equals("")) {
            msg = new FacesMessage("Informe a observacao");
            view.addMessage(null, msg);
        }


        if (msg == null) {
            Produto ct = new Produto(this.descricao, this.categoria, this.preco, this.qtdestoque, this.observacao);
            if (ct.update()) {
                msg = new FacesMessage("Contato salvo com sucesso");
                view.addMessage(null, msg);
            }
        }
    } 
     
     
     public Boolean getIsFiltrarCategoria() {
        return isFiltrarCategoria;
    }

    public void setIsFiltrarCategoria(Boolean isFiltrarCategoria) {
        this.isFiltrarCategoria = isFiltrarCategoria;
    }

   

}
