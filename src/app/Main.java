package app;

import java.util.List;
import java.util.Scanner;

import models.Estoque;
import models.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();
        if (!estoque.carregarProdutos()) {
            System.out.println("ERRO: não foi possivel carregar a lista, criando uma lista nova vazia...");
        }

        boolean valor = true;

        while (valor) { // MENU PRINCIPAL
            System.out.println("--------------MENU--------------");
            System.out.println("(1) - Adicionar Produto");
            System.out.println("(2) - Listar Produtos");
            System.out.println("(3) - Pesquisar Produto");
            System.out.println("(4) - Alterar Informações de produto");
            System.out.println("(5) - Remover Produto");
            System.out.println("(6) - Sair");
            System.out.println("--------------------------------");
            int opcao = sc.nextInt();

            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do produto: ");
                    String nomeProduto = sc.nextLine();

                    System.out.println("Digite o preço: ");
                    double precoProduto = sc.nextDouble();

                    int quantidadeProduto;

                    while (true) {
                        System.out.println("Quantidade: ");

                        if (sc.hasNextInt()) {
                            quantidadeProduto = sc.nextInt();

                            if (quantidadeProduto >= 0) {
                                break;
                            } else {
                                System.out.println("Quantidade inválida, deve ser maior ou igual a 0");
                            }
                        }
                    }

                    sc.nextLine();

                    System.out.println("Validade do produto: ");
                    String validade = sc.nextLine();


                    Produto produto = new Produto(nomeProduto, quantidadeProduto, validade, precoProduto);
                    estoque.adicionarProduto(produto);
                    System.out.println("Produto Adicionado Com Sucesso.");
                    estoque.salvarProdutos();
                    break;
                
                case 2:
                    List<Produto> lista = estoque.listarProdutos();

                    System.out.println("---------------------------------------");
                    
                    for (Produto p : lista) {
                        System.out.println(
                            "ID: " + p.getId() + 
                            " | Nome: " + p.getNome() + 
                            " | Quantidade: " + p.getQuantidade() + 
                            " | Preço: " + p.getPreco() + " R$" +
                            " | Validade: " + p.getValidade()
                        );
                    }

                    System.out.println("---------------------------------------");
                    break;

                case 3:
                    System.out.println("Digite o ID do produto: ");
                    int buscaDeID = sc.nextInt();

                    Produto pesquisarProduto = estoque.pesquisarProduto(buscaDeID);

                    if (pesquisarProduto != null) {
                        System.out.println("ENCONTRADO: " + pesquisarProduto.getNome());
                        System.out.println("ID: " + pesquisarProduto.getId());
                        System.out.println("Quantidade: " + pesquisarProduto.getQuantidade());
                        System.out.println("Preço: " + pesquisarProduto.getPreco());
                        System.out.println("Data de Validade: " + pesquisarProduto.getValidade());
                    }

                    break;

                case 4:

                    boolean continua = true;

                    while (continua) {

                        System.out.println("Digite o ID: ");
                        int buscaID = sc.nextInt();

                        sc.nextLine();

                        Produto p = estoque.buscaPorId(buscaID);

                        if (p != null) {
                            System.out.println("Encontramos o produto " + p.getNome());
                        }

                        if (p != null) { // MENU DE ALTERAÇÃO DE PRODUTO
                            System.out.println();
                            System.out.println("O que deseja alterar de " + p.getNome().toUpperCase());
                            System.out.println("(1) - NOME");
                            System.out.println("(2) - PREÇO");
                            System.out.println("(3) - QUANTIDADE");
                            System.out.println("(4) - VALIDADE");
                            System.out.println("(5) - CANCELAR");
                            System.out.println();

                            int opcao2 = sc.nextInt();
                            sc.nextLine();

                            switch (opcao2) {
                                case 1:
                                    System.out.println("Digite o novo nome: ");
                                    String novoNome = sc.nextLine();
                                    p.setNome(novoNome);
                                    estoque.salvarProdutos();
                                    break;
                            
                                case 2:
                                    System.out.println("Digite o novo preço: ");
                                    double novoPreco = sc.nextDouble();
                                    p.setPreco(novoPreco);
                                    estoque.salvarProdutos();
                                    break;
                            
                                case 3:
                                    int novaQuantidadeProduto; 

                                    while (true) {
                                        System.out.println("Quantidade nova: ");

                                        if (sc.hasNextInt()) {
                                            novaQuantidadeProduto = sc.nextInt();

                                            if (novaQuantidadeProduto >= 0) {
                                                p.setQuantidade(novaQuantidadeProduto);
                                                estoque.salvarProdutos();
                                                break;
                                            } else {
                                                System.out.println("Quantidade inválida, deve ser maior ou igual a 0");
                                            }
                                        }
                                    }

                                    sc.nextLine();
                                    break;

                                case 4: 
                                    System.out.println("Digte a nova validade: ");
                                    String novaValidade = sc.nextLine();
                                    p.setValidade(novaValidade);
                                    estoque.salvarProdutos();
                                    break;
                        
                                case 5:
                                    System.out.println("Cancelando atualização...");
                                    continua = false;
                                    break;
                            }

                        } else {
                            System.out.println("Produto não encontrado");
                            break;
                        }

                    }

                    break;

                case 5:

                    while (true) {

                        System.out.println("Digite o ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        Produto p2 = estoque.buscaPorId(id);

                        if (p2 == null) {
                            System.out.println("PRODUTO NÃO ENCONTRADO");
                            break;
                        }

                        System.out.println("VOCÊ QUER REMOVER: " + p2.getNome());

                        System.out.println("CONFIRMAR? (Y/N)");
                        String confirmacao = sc.nextLine();

                        if (confirmacao.equalsIgnoreCase("y")) {
                            estoque.removerProduto(id);
                            estoque.salvarProdutos();
                            break;
                        } else if (confirmacao.equalsIgnoreCase("n")) {
                            break;
                        }
                        System.out.println("Não foi identificado, tente novamente digitando (y/n)"); 
                    }

                    break;

                case 6:
                    System.out.println("Saindo do menu...");
                    valor = false;
                    break;
            
                default:
                    System.out.println("Essa opção não existe, tente novamente");
                    break;
            }
        }
    }   
}
