package huffman;

public class main {
    public static void main(String[] args){
        
        Huffman AlgHuff = new Huffman();
        //AlgHuff.teste();

        //String texto =  AlgHuff.lertxt();
        //System.out.println(texto);

        String sequenciadebits = "011110101111110101010";
        AlgHuff.escreverBits(sequenciadebits);
        System.out.println(sequenciadebits);

        System.out.println(AlgHuff.lerBits());
    }
}
