/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author osx
 */
public class Arestas {
    
    private int v1;   // identifição do primeiro vertice, indices 1 a N
    private int v2;   // identifição do segundo vertice, indices 1 a N
    private int peso; // Peso da aresta que liga estes 2 vértices

    public Arestas(int v1, int v2, int peso) {  // não faz sentido um construtor sem mandar os vertices e 
        this.v1 = v1;                           // o peso dessa aresta.
        this.v2 = v2;
        this.peso = peso;
    }

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

        
    
}
