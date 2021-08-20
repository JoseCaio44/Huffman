package huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator; 
import java.io.File; 
import java.util.Scanner; 
import java.io.FileOutputStream;  
import java.io.FileInputStream;  

class Comparador implements Comparator<HuffNode>{
    public int compare(HuffNode node1,HuffNode node2 ){
        return node2.frequencia<node1.frequencia? 1 : -1;
    }  
}

public class Huffman {

    ArrayList<HuffNode> fila;
    ArrayList<Caracter> tabela;
    HuffNode raizDaArvore;

    Huffman(){
        this.fila = new ArrayList<HuffNode>();
        this.tabela = new ArrayList<Caracter>();
        this.raizDaArvore = null;
    }

    void teste(){

        HuffNode node1 = new HuffNode('a',10);
        HuffNode node2 = new HuffNode('b',6);
        HuffNode node3 = new HuffNode('e',1);
        HuffNode node4 = new HuffNode('g',2);

        this.fila.add(node4);
        this.fila.add(node1);
        this.fila.add(node2);
        this.fila.add(node3);

        Collections.sort(this.fila, new Comparador()); // Método para orderar de acordo com as frquencias

        System.out.println(this.fila.remove(0)); // Remove o elemento de menor prioridade
        System.out.println(this.fila.remove(0)); // Remove o elemento de menor prioridade

        for (HuffNode element : fila) System.out.print(element + " ");
    }

    public void criarArvore(String texto){
        return; //Crie a arvore para ser utilizada no metodo de gerar a tabela e descompactar
    }

    public void gerartabela(){
        //Crie aqui o método para gerar uma tabela de conversão utilizando a arvore
        return;
    }

    public void compactar(String texto){
        String sequenciadebits = "";
        //Faça aqui um algoritmo para compactar a string texto utilizando a tabela de conversão
        this.escreverBits(sequenciadebits);
        return;
    }

    public void descompactar(){
        String sequenciadebits = this.lerBits();
        //Faça aqui um algoritmo para descompactar a string texto utilizando a arvore
        return;
    }

    public String lertxt(){
        String saida = "";
        try{
            File file = new File("C:\\Users\\pcals\\Dropbox\\Codes\\Algorithms\\Huffman\\texto.txt"); 
            Scanner sc = new Scanner(file); 
            while (sc.hasNextLine()) saida+=sc.nextLine(); 
            sc.close();
        }
        catch(Exception e){  
            e.printStackTrace();  
        }
        return saida;
    }

    public void escreverBits(String sequenciadebits){
        String texto = sequenciadebits;
        if (sequenciadebits.length()%8==0){
            texto = "00000001"+texto;
        }else{
            int qtd = 7-(sequenciadebits.length()%8);
            texto = "0".repeat(qtd)+"1"+texto;
        }
        try{    
            FileOutputStream fout = new FileOutputStream("C:\\Users\\pcals\\Dropbox\\Codes\\Algorithms\\Huffman\\saida.txt");    
            for(int i=0;i<texto.length()-7;i+=8){
                fout.write(Integer.parseInt(texto.substring(i,i+8),2));
            }    
            fout.close();    
            System.out.println("Arquivo Gravado...");
           }
        catch(Exception e){
            System.out.println(e);
        }    
    }

    public String lerBits(){
        try{    
            FileInputStream fin = new FileInputStream("C:\\Users\\pcals\\Dropbox\\Codes\\Algorithms\\Huffman\\saida.txt");    
            int data = fin.read(); // read next byte
            String primeirasequencia = Integer.toBinaryString(data).toString();
            primeirasequencia = String.format("%8s", primeirasequencia).replace(' ', '0');
            int a = 0;
            for(int i=0;i<primeirasequencia.length();i++){
                if(primeirasequencia.charAt(i)=='1'){
                    a = i+1;
                    break;
                }
            }
            String saida = primeirasequencia.substring(a);
            while(data != -1) {
                data = fin.read();
                if (data!=-1){
                    String temp = Integer.toBinaryString(data).toString();
                    saida += String.format("%8s", temp).replace(' ', '0');
                }
            }  
            fin.close();    
            System.out.println("Arquivo Lido...");
            return saida;
           }
        catch(Exception e){
            System.out.println(e);
            return "";
        }
    }

}