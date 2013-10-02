/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex01;
import br.calebe.exemplos.ex01.Produto;
/**
 *
 * @author 41005155
 */
public class Livro extends Produto{
    private String editora;
    private String autor;
    public Livro (String nome, double valor, String editora, String autor){
        super (nome, valor);
        this.editora = editora;
        this.autor = autor;
    }
    
}
