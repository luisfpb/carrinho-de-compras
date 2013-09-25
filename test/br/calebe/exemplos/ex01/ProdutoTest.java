/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex01;

/**
 *
 * @author Luis Benassi & Daniel Maeda
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {
 
    Produto produto;
    @Test
    public void CriarProduto(){
        String nome = "Carro";
        Double preco = 2300.0;
        produto = new Produto(nome,preco);
        Assert.assertEquals(preco, produto.getPreco(),0d);
    }
    
    @Test
    public void ProdutosIguais(){
        produto = new Produto("Livro",10);
        Produto produto2 = new Produto("Livro",10);
        Assert.assertEquals(produto2, produto);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void inserirNomeNull(){
        produto = new Produto(null,0);
    } 
    
}
