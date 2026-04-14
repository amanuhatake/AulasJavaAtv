import java.util.ArrayList;
import java.util.Scanner;

class Produto {

    String PNproduto;
    double Ppreco = 0;
};

class pedido {
    String nome;
    double Qntd;
    int Npedido = 0;
    
};
   
class carrinho{

    ArrayList<pedido> carrinhos = new ArrayList<>(); // criando um array para lincar em 
}

public class Exercicio3 {

         public static void  menu() {//Aqui ele é um metodo pq pode executar algo(imprimir)
                System.out.println("====================");
                System.out.println("1- Cadastrar produto");
                System.out.println("2- Fazer pedido");
                System.out.println("3- Consultar pedido");
                System.out.println("4 - Sair");
                System.out.println("====================");
            }
            
    public static void main (String[] args) {//Aqui será o onde tem a ação das classes
            
           

                //int i =0;
                int operacao =0;

                ArrayList<pedido> ped = new ArrayList<>(); //Criando um array list para pedidos 
                ArrayList<Produto> Arrayprod = new ArrayList<>(); //Array list declarado
            
                while (operacao !=4) {//Enquanto não for dife
                    
                Exercicio3.menu();//Chamando a classe menu
                Scanner entrada = new Scanner(System.in); // atribui o valor que o usuario digitar
                System.out.println("O que deseja?"); //pergunta para o usuario o qu quer

                operacao = entrada.nextInt();
                entrada.nextLine();//Limpa o buffer( O enter ficou salvo no next int anteriror (lido como \n))

                //System.out.println(operacao);
                if (operacao == 1 ) {
                    Produto pObjeto = new Produto();// instanciando (criando) o objeto 'pObjeto' para funcionar como um mini array guardando em apenas um lugar

                                        
                    System.out.println("Qual nome do produto?");
                    pObjeto.PNproduto = entrada.nextLine();//Atribui o valor inserido na variavel PNproduto, dentro do objeto
                    //System.out.println(pObjeto.PNproduto);
                    
                    System.out.println("Qual o valor do produto?");
                    pObjeto.Ppreco =entrada.nextInt();
                    entrada.nextLine();

                    Arrayprod.add(pObjeto);//Adiciona o objeto e suas variaveis dentro do array de produtos, podendo salvar mais de um produto por execução
                    //System.out.println("Tamanho do array: " + Arrayprod.size()); // Informa quanto de espaço estamos usando da memoria.
                    
                    System.out.println("Produto cadastrado com sucesso");

                        for(Produto a: Arrayprod){ //Imprime tudo que esta salvo no array
                            System.out.println("Nome do produto: " + a.PNproduto);
                            System.out.println("O valor salvo foi: " + a.Ppreco);
                        }
                   
                }
               }
                
            /*
                for  (i =0; i<2; i++){ //Usa o i para repetir 3 vezes
                
                
                
                     
                p.PNproduto = entrada.nextLine(); //nprod recebe o valor, que é armazenado no objeto "p" 

                Scanner entrada2 = new Scanner(System.in); 
                System.out.println("Qual o preço");

                p.Ppreco = entrada2.nextInt();//preco recebe o valor e já armazena em p

                f.Npedido = i;

                prod.add(p); //Adicionando as informações que estão dentro do objeto p dentro da classe produto
                ped.add(f);
            }*/
    
            
 /*
    for(Produto a:Arrayprod){

        System.out.println(a.PNproduto);
        System.out.println(a.Ppreco);
}*/
}
}