/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
import grafos.Grafo;
import grafos.Arestas;
import grafos.Dijkistra;

/**
 *
 * @author osx
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int numVertices = 4; 
        int numArestas = 5;
        // Criando as arestas do grafo
        Arestas aresta1 = new Arestas(1, 1, 2);
        Arestas aresta2 = new Arestas(1, 2, 3); 
        Arestas aresta3 = new Arestas(1, 3, 2);
        Arestas aresta4 = new Arestas(2, 3, 5);
        Arestas aresta5 = new Arestas(3, 2, 2);
        // Lembrar que as os vertices vou contar de 0 até n-1, neste caso 0 - (4-1) 
        
        
        // Criando o grafo e sua matriz de adjacencias
        Grafo grafo = new Grafo(numVertices, numArestas);
        grafo.insereAresta(aresta1.getV1(), aresta1.getV2(), aresta1.getPeso());
        grafo.insereAresta(aresta2.getV1(), aresta2.getV2(), aresta2.getPeso());
        grafo.insereAresta(aresta3.getV1(), aresta3.getV2(), aresta3.getPeso());
        grafo.insereAresta(aresta4.getV1(), aresta4.getV2(), aresta4.getPeso());
        grafo.insereAresta(aresta5.getV1(), aresta5.getV2(), aresta5.getPeso());
        
        //Impressão da Matriz de adjacências do Grafo
        grafo.imprime();
        
        // Teste para verificar se existe aresta entre os Vertices v1 e v2
        if(!grafo.existeAresta(3, 0))
            System.out.println("Não Existe aresta!!");
        else 
            System.out.println("Existe aresta!!");
        
        
        
    }
    
}
