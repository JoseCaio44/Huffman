package huffman;

public class HuffNode {

    int frequencia;
    HuffNode direita, esquerda;
    char caracter;

    HuffNode(char caracter, int frequencia){
        this.frequencia = frequencia;
        this.direita = null;
        this.esquerda = null;
        this.caracter = caracter;
    }

    HuffNode(HuffNode node1, HuffNode node2){
        this.direita = node1;
        this.esquerda = node2;
        this.frequencia = this.direita.frequencia+this.esquerda.frequencia;
        this.caracter = '+';
    }
    
    public String toString(){
        return Character.toString(this.caracter);
    }

}