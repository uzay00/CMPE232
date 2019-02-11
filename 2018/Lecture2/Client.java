/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture2;

/**
 *
 * @author uzaycetin
 */
public class Client {
    public static void main(String[] args) {
        In in = new In("tinyG.txt");
        Graph G = new Graph(in);
        System.out.print(G);
        
    }
}
