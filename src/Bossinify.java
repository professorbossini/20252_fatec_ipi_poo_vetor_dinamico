import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Bossinify{
//Pesquisa feita em aula
// LisoFlix 0
// SPobreFy 2
// Bossinify 10
// RBMusic 1
// Timbre 0
// TuneMusic 0 
  public static void main(String[] args) {
    //Java 5+: Generics
    //Java 10+: operador de inferência de tipo
    var musicas = new ArrayList<Musica>();
    var leitor = new Scanner(System.in);
    var menu = "1-Cadastrar\n2-Ver todas (ordenado por nome)\n3-Ver todas (ordenado por comprimento do titulo\n4-Avaliar\n0-Sair";
    int op;
    do{
      do{
        System.out.println(menu);
        op = leitor.nextInt();
      }while(op < 0 || op > 3);
      switch(op){
        case 1:{
          System.out.println("Título:");
          leitor.nextLine();
          var titulo = leitor.nextLine();
          // var m = new Musica();
          // musicas.add(m);
          musicas.add(new Musica(titulo));
          System.out.println("Música cadastrada!");
          break;
        } 
        case 2:{
          //ordenar por nome antes de exibir
          // musicas.sort(null);
          //in-place
          Collections.sort(musicas);
          System.out.println(musicas);
          break;
        }
        case 3:{
          Collections.sort(
            musicas, 
            new ComprimentoDoTituloComparator(false)
          );
          System.out.println(musicas);
          break;
        }
        case 0:{
          System.out.println("Até logo");
          break;
        }   
      }
    }while(op != 0);   
  }
  
}
