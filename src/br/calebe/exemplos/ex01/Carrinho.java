package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public Produto menorProduto() throws CarrinhoVazioExpected {
        if (produtos.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        Produto menor = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }
        }
        return menor;
    }
    
    public double getSoma(){
        double soma = 0;
        Produto prod = produtos.get(0);
        for(Produto produto : produtos){
            soma = soma + prod.getPreco();
        }
        return soma;
    }
    
    public void remove(String nome){
     
        for(int i = 0 ; i< produtos.size(); i++){
            if(nome.equals(produtos.get(i).getNome()))
            {
                produtos.remove(i);
            }
            
        }
    }
    
    public double getTotal(){
        return produtos.size();
    }
}
