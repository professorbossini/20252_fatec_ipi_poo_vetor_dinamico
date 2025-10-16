import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @ToString
public class Musica implements Comparable <Musica>{
  private String titulo;
  private int avaliacao;
  
  Musica(String titulo){
    this.titulo = titulo;
  }

  @Override
  public String toString() {
    return titulo;
  }

  @Override
  public int compareTo(Musica outra) {
    return this.titulo.compareTo(outra.titulo);

  }
}
