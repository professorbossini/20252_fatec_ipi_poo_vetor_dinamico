public class VetorDinamico {
  private int [] elementos;
  private int quantidade;
  private int capacidade;
  private static final int CAPACIDADE_MINIMA = 4;

  public VetorDinamico(int capacidadeInicial){
    quantidade = 0;
    if(capacidadeInicial >= CAPACIDADE_MINIMA){
      elementos = new int[capacidadeInicial];
      capacidade = capacidadeInicial;
    }
    else{
      elementos = new int [CAPACIDADE_MINIMA];
      capacidade = CAPACIDADE_MINIMA;
    }
  }

  // private void aumentarCapacidade(){
  //   capacidade = capacidade * 2;
  //   var aux = new int[capacidade];
  //   for(int i = 0; i < quantidade; i++){
  //     aux[i] = elementos[i];    
  //   }
  //   elementos = aux;
  // }

  private void redimensionar(double fatorRedimensionamento){
    capacidade = (int)(capacidade * fatorRedimensionamento);
    var aux = new int[capacidade];
    for(int i = 0; i < quantidade; i++){
      aux[i] = elementos[i];    
    }
    elementos = aux;
  }

  // private void reduzirCapacidade(){
  //   capacidade = capacidade / 2;
  //   var aux = new int[capacidade];
  //   for(int i = 0; i < quantidade; i++){
  //     aux[i] = elementos[i];    
  //   }
  //   elementos = aux;
  // }

  public void remover(){
    if(!estaVazio()){
      quantidade--;
    }
    if(capacidade > CAPACIDADE_MINIMA && quantidade <= capacidade / 4){
      redimensionar(0.5);
    }
  }

  public void adicionar(int elemento){
    if(estaCheio())
     redimensionar(2);
    elementos[quantidade] = elemento;
    quantidade++;
  }

  public boolean estaCheio(){
    return quantidade == capacidade;
  }
  
  public boolean estaVazio(){
    return quantidade == 0;
  }

  @Override
  public String toString() {
    //Java 10+
    var sb = new StringBuilder("");
    // String s = "";
    if(!estaVazio()){
      sb.append("Elementos: ");
      //Java 5+
      //foreach
      //enhanced for
      // for(int elemento : elementos){
      //   // s = s + elemento + " ";
      //   sb.append(elemento).append(" ");
      // }
      for(int i = 0; i < quantidade; i++){
        sb.append(elementos[i]).append(" ");  
      }
    }
    else{
      sb.append("Coleção vazia");
    }
    sb
    .append("\n")
    .append("Qtde: ")
    .append(quantidade)
    .append("\n")
    .append("Cap: ")
    .append(capacidade);
    return sb.toString();
  }
    
}
