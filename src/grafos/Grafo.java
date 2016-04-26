/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
import grafos.Arestas;
/**
 *
 * @author Felipe
 */
public class Grafo {
  private int mat[][]; // Matriz de Pesos dos Vértices
  private int numVertices; // Numero de Vértices do Grafo 
  private int pos[]; // posição atual ao se percorrer os adjs de um vértice v

  public Grafo (int numVertices) {
    this.mat = new int[numVertices][numVertices]; 
    this.pos = new int[numVertices]; 
    this.numVertices = numVertices; 
    for (int i = 0; i < this.numVertices; i++) {
      for (int j = 0; j < this.numVertices; j++) this.mat[i][j] = 0;
      this.pos[i] = -1; 
    }
  }
  public Grafo (int numVertices, int numArestas) {
    this.mat = new int[numVertices][numVertices];
    this.pos = new int[numVertices]; 
    this.numVertices = numVertices; 
    for (int i = 0; i < this.numVertices; i++) {
      for (int j = 0; j < this.numVertices; j++) this.mat[i][j] = 0;
      this.pos[i] = -1; 
    }
  }
  // Adiciona o peso da aresta v1-v2 na Matriz de adjacências
  public void insereAresta (int v1, int v2, int peso) {
    this.mat[v1][v2] = peso; 
  }
  
  // Consulto se existe uma aresta ligando V1 e V2
  public boolean existeAresta (int v1, int v2) {
    return (this.mat[v1][v2] > 0);
  }
  
  // Consulto se a Lista de Adj do vértice V está vazia, quando não houver mais 
  // arestas ligando o V a outro vértice
  public boolean listaAdjVazia (int v) {
    for (int i =0; i < this.numVertices; i++)
      if (this.mat[v][i] > 0) return false;
    return true;
  }
  
  
  public Arestas primeiroListaAdj (int v) {
    // Retorna a primeira aresta que o vertice v participa ou
    //  null se a lista de adjacencia de v for vazia
    this.pos[v] = -1; return this.proxAdj (v);
  }
  
  public Arestas proxAdj (int v) {
    // Retorna a proxima aresta que o vertice v participa ou
    // null se a lista de adjacencia de v estiver no fim
    this.pos[v] ++;
    while ((this.pos[v] < this.numVertices) && 
           (this.mat[v][this.pos[v]] == 0)) this.pos[v]++;
    if (this.pos[v] == this.numVertices) return null;
    else return new Arestas (v, this.pos[v], this.mat[v][this.pos[v]]);
  }
  
  // Eliminar uma aresta que liga V1 e V2
  public Arestas retiraAresta (int v1, int v2) {
    if (this.mat[v1][v2] == 0) 
        return null; // Aresta nao existe
    else {
      Arestas aresta = new Arestas (v1, v2, this.mat[v1][v2]);
      this.mat[v1][v2] = 0; return aresta;
      // se a aresta existir eu vou atribuir o peso dela a 0(zero), isso significa
      // dizer que o vertice v1 não está ligado com v2
    }
  }
  
  // função para imprimir o grafo 
  public void imprime () {
    System.out.print ("   ");
    for (int i = 0; i < this.numVertices; i++) 
      System.out.print (i + "   "); 
    System.out.println ();
    for (int i = 0; i < this.numVertices; i++) { 
      System.out.print (i + "  ");
      for (int j = 0; j < this.numVertices; j++)
        System.out.print (this.mat[i][j] + "   ");
      System.out.println ();
    }
  }
  
  // returna o numero de vértices 
  public int numVertices () { return this.numVertices; }
  
  // retorna a matriz de pesos 
  public int[][] MatrizPesos(){
     return this.mat;
  }
}
