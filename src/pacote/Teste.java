package pacote;
import java.util.ArrayList;
import java.util.Scanner;


public class Teste {

	public static void main(String[] args) {
		System.out.printf("Seja bem vindo(a) ao leilão!\n\n\n");
        
		boolean continuarLeilao = true;
		
		Scanner scanner = new Scanner(System.in);
		Leilao leilao = new Leilao();


		while (continuarLeilao) {

		    System.out.printf("Digite a opção desejada:\n\n");
		    System.out.printf("Inserir novo lote e os produtoa a serem leiloados neste lote[1]\n");
		    System.out.printf("Listar produtos disponiveis para leilao e seus maiores lances no momento[2]\n");
		    System.out.printf("Fazer um lance para um produto [3]\n");
		    System.out.printf("Encerrar o leilão e eibir as vendas feitas no leilão [4]\n");

		    int numero = scanner.nextInt();

		    if (numero < 1 || numero > 4) {
		        while (numero < 1 || numero > 4) {
		            System.out.printf("Digite uma opção válida:\n\n");
		            numero = scanner.nextInt();
		        }
		    }

		    switch (numero) {//Inserir novo produto para ser leiloado [1]
		        case 1: {
		    		boolean adicionaProduto = true;
		        	Lote lote = new Lote();


		    		
		    		while (adicionaProduto) {

			        	
			            System.out.printf("Digite o valor inicial do produto:\n");
			            Float valor = scanner.nextFloat();
			            scanner.nextLine(); // limpa o buffer de entrada

			            System.out.printf("Digite a descrição(nome) do produto:\n");
			            String descricao = scanner.nextLine();
			            			            
			        	Pessoa pessoa = new Pessoa("Administrador", "Leilão@contato.com");
			        	Lance lance = new Lance(valor, pessoa);
			        	Produto produto = new Produto(descricao, lance);
			        	lote.inserirProduto(produto);
			        	
			            System.out.printf("Gostaria de adicionar mais um produto neste lote ? Sim [1] Não[0]\n");
					    int opcao = scanner.nextInt();

					    while (opcao != 0 && opcao != 1) {
					        System.out.printf("Digite uma opção válida: 1 para Sim ou 0 para Não\n");
					        opcao = scanner.nextInt();
					    }

					    if (opcao == 0) {
					    	adicionaProduto = false;
					    }

					}

		            leilao.inserirLote(lote);
		            
                    System.out.printf("Lote e seu(s) respectivo(s) produto(s) cadastrado(s) com sucesso!\n");



		            break;
		        }
		        case 2: {
                    ArrayList<Produto> produtos = leilao.listarProdutos();

		            if(produtos == null || produtos.isEmpty())
			            System.out.printf("Não tem produtos no leilão disponíveis no momento:\n");
		            else {
		            System.out.printf("Estes são os produtos disponíveis até o momento e seus maiores valores:\n");
		            
		            for(Produto prod :produtos) 
		                System.out.printf("Produto: %s | Valor: %.2f\n", prod.getDescricao(), prod.getMaiorLance().getValor());
		            
		            }
		            break;
		         }
		        case 3: { 
		            
		            System.out.printf("Aqui está o número de lote e o seu produto referente:\n");
		            for (Lote lote1 : leilao.getLotes()) {
		                int numLote = leilao.getLotes().indexOf(lote1);
		                for (Produto prod : lote1.getProdutos()) {
		                    System.out.printf("Número do lote: %d | Descrição do produto: %s\n", numLote, prod.getDescricao());
		                }
		            }

		            

		        	
		        	System.out.printf("Digite o nome da pessoa que fará o lance:\n");
		            String nome = scanner.nextLine();
		            scanner.nextLine(); // Consumir a quebra de linha pendente


		            
		            System.out.printf("Digite o melhor contato/email da pessoa que fará o lance:\n");
		            String contato = scanner.nextLine();
					Pessoa pessoa = new Pessoa(nome, contato);	
					
		            System.out.printf("Digite o número do lote que o lance será feito:\n");
		            int numLote = scanner.nextInt();
		            scanner.nextLine(); // Consumir a quebra de linha pendente

		            
		            System.out.printf("Digite a descrição do produto:\n");
		            String descricao = scanner.nextLine();


		            System.out.printf("Digite o valor do lance:\n");
		            int valor = scanner.nextInt();
		            scanner.nextLine(); 
		            
		        	Lance lance = new Lance(valor, pessoa);

		            
		            leilao.receberLance(numLote, descricao, lance);
		            
		            System.out.printf("Lance realizado com sucesso!!\n");

					
					break;	
		        }
		        case 4: {
		        	leilao.encerrarLeilao();
		        	scanner.close();
		        	System.out.println("Programa encerrando...");
		        	System.exit(0);      	
		        	
		        	break;
		        }
		        default:
		            break;
		    }

		    System.out.printf("Deseja continuar o leilão? Sim[1] Não[0]\n");
		    int opcao = scanner.nextInt();

		    while (opcao != 0 && opcao != 1) {
		        System.out.printf("Digite uma opção válida: 1 para Sim ou 0 para Não\n");
		        opcao = scanner.nextInt();
		    }

		    if (opcao == 0) {
		        continuarLeilao = false;
				leilao.encerrarLeilao();
				scanner.close();
				System.out.println("Programa encerrando...");
				System.exit(0); 
		    }
		}




	}

}
