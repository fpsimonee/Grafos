/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
import grafos.Grafo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author osx
 */
public class Dijkistra extends Grafo {
    
    private boolean VerticesVisitados[];
    private int distancias[];
    private int Pais[];
    private List ListaAdjacencia = new ArrayList<Integer>();
    private int origem;
    private static int infinito = 2147483647; 
    
    
    public Dijkistra(int numVertices) {
        super(numVertices);
        //como sera considerado de 0 - n-1 
        VerticesVisitados = new boolean[numVertices];
        //como sera considerado de 0 - n-1 
        distancias = new int[numVertices];
        //antecesor do vertice
        Pais = new int[numVertices];         
    }
    
    private int dijkistra(int origem, int destino)throws Exception{
 
        if(origem < 0 || origem > super.numVertices())
            throw new Exception("origem eh menor que 0 ou destino nao existe");
                 
        try{
            iniciaMenorCaminho(origem);
        }catch(Exception ex){
            System.out.println("Erro ao iniciar os dados "+ex);
        }
         
                 
        while(!ListaAdjacencia.isEmpty()){             
            Integer verticeMenorPeso = extraiMenor();     
             
             
            for(int i = 0 ; i < super.numVertices(); i++){
                 
                if(super.MatrizPesos()[verticeMenorPeso][i] > 0)                     
                    relaxa(verticeMenorPeso,i);                 
            }
             
        }
        printDistancias();
        return distancias[destino];                          
    }
    /* 
      até aqui o algoritmo do dijkistra, o relaxamento está a parte para poder 
      controlar melhor 
    
    */
    
     /*
     * Inicia dados do algoritmo
     */
    private void iniciaMenorCaminho(int origem){
        for(int i = 0 ; i < super.numVertices(); i++){
            distancias[i] = infinito;
            VerticesVisitados[i] = false;     
            Pais[i] = infinito;
            ListaAdjacencia.add(new Integer(i));//adiciona a aresta na fila
        }
        distancias[origem] = 0;//inicia o vetor de distancias
         
    } 
    
    /*
     * Relaxa arestas no grafo
     */
    private void relaxa(int u, int v){
         
            if (distancias[v] > distancias[u]+super.MatrizPesos()[u][v]){                 
                distancias[v] = distancias[u]+super.MatrizPesos()[u][v];
                Pais[v] = u;                         
            }
    }
    
    // Uso um iterator para extrair da minha lista de Adjacenciaas o menor valor
    private int extraiMenor(){
        int menorValor = infinito;   
        int verticeDeMenorPeso=0;
         
        Iterator<Integer>it = ListaAdjacencia.iterator();
        while(it.hasNext()){
            int verticeAtual = it.next();             
            if(distancias[verticeAtual] < menorValor){                 
                menorValor = distancias[verticeAtual];
                verticeDeMenorPeso = verticeAtual;
            }
        } 
      //remove o vertice com menor distancia da lista de Adjacencias e retorna o menor peso  
      ListaAdjacencia.remove(new Integer(verticeDeMenorPeso));     
      return verticeDeMenorPeso;
   }
    
    public int getOrigem() {
        return origem;
    }
 
    public void setOrigem(int origem) {
        this.origem = origem;
    }
     
    public List getListaAdjacencia() {
        return ListaAdjacencia;
    }
 
    public void setListaAdjacencia(List ListaAdjacencia) {
        this.ListaAdjacencia = ListaAdjacencia;
    }
     
    private void printDistancias(){
        for(int i = 0 ; i < super.numVertices(); i++)
            System.out.print("["+distancias[i]+"] ");
        System.out.println();
    } 
    
    public static void main(String args[]){
         
         
        try{
            Dijkistra dij = new Dijkistra(5);
            dij.insereAresta(0, 1, 10);
            dij.insereAresta(0, 2, 5);
            dij.insereAresta(1, 2, 2);
            dij.insereAresta(1, 3, 1);
            dij.insereAresta(2, 1, 3);
            dij.insereAresta(2, 3, 9);
            dij.insereAresta(2, 4, 2);
            dij.insereAresta(3, 4, 4);         
            dij.insereAresta(4, 3, 6);
            dij.insereAresta(4, 0, 7);
            
            dij.imprime();
            System.out.println("Menor caminho entre 0 e 4 "+dij.dijkistra(0,4 ));             
            //dij.printMatriz(dij.getMatrizDePesos());
        }catch(Exception ex){
            if(ex.getMessage() == null)
                  System.out.println("Ocorreu um erro de "+ex+" no main");
            else 
                System.out.println(ex.getMessage()+"XXX");
        }
         
    } 
}
