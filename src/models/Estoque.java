package models;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Estoque {
    private int proximoID = 1;
    private List<Produto> produtos = new ArrayList<>();

    public boolean carregarProdutos(){
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("produtos.json")) {

            Type tipoLista = new TypeToken<ArrayList<Produto>>(){}.getType();
            produtos = gson.fromJson(reader, tipoLista);

            if (produtos == null) {
                produtos = new ArrayList<>();
            }
            
        } catch (IOException e) {
            produtos = new ArrayList<>();
        }

        int maiorID = 0;

        for (Produto p : produtos) {
            if (p.getId() > maiorID) {
                maiorID = p.getId();
            }
        }

        proximoID = maiorID + 1;

        return !produtos.isEmpty();
    }

    public boolean salvarProdutos(){
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("produtos.json")){
            gson.toJson(produtos, writer);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos");
            e.printStackTrace();
            return false;
        }
    }

    public void adicionarProduto(Produto produto){
        produto.setId(proximoID);
        proximoID++;

        produtos.add(produto);
    }

    public List<Produto> listarProdutos(){
        return new ArrayList<>(produtos);
    }

    public Produto pesquisarProduto(int id){
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }    
        }
        return null;
    }
    

    public Produto buscaPorId(int id){
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            } 
        }
        return null;
    }

    public boolean removerProduto(int id){
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.remove(i);
                return true;
            } 
        }
        return false;  
    }
}
