package br.calebe.exemplos.ex01;

import junit.framework.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void colocandoZeroProduto() throws CarrinhoVazioExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{null}, new Object[]{menor});
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        assertArrayEquals(new Object[]{original}, new Object[]{copia});
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void inserirObjetoNull(){
        carrinho.add(null);
    }    
    
    @Test 
    public void adicionarOutroTipoProduto() throws CarrinhoVazioExpected{
        Livro livro = new Livro("Abril",40, "Java","Daniel");
        carrinho.add(livro);
        Produto menor = carrinho.menorProduto();
        Assert.assertEquals(menor,livro);
    }
    
    @Test
    public void removeProdutoCarrinho(){
        carrinho.add(new Produto("Teste",10));
        carrinho.add(new Produto("Java",15));
        carrinho.add(new Produto("ProgMat",30));
        double antes = carrinho.getTotal();
        carrinho.remove("Java");
        double depois = carrinho.getTotal();
        Assert.assertEquals(antes,depois);
    }
    
    @Test
    public void calculaTotal(){
        Produto prod1 = new Produto("Teste",10);
        Produto prod2 = new Produto("Java",20);
        Produto prod3 = new Produto("TeoComp",30);
        carrinho.add(prod1);
        carrinho.add(prod2);
        carrinho.add(prod3);
        double soma;
        soma = prod1.getPreco()+prod2.getPreco()+prod3.getPreco();
        double somafunc;
        somafunc = carrinho.getSoma();
        Assert.assertEquals(soma, somafunc, 0d);
    }
    
}
