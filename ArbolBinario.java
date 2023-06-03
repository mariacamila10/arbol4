/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol4;


public class ArbolBinario {
    protected Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo raizArbol() {
        return raiz;
    }

    // Comprueba el estado del árbol
    public boolean esVacio() {
        return raiz == null;
    }

    public static Nodo nuevoArbol(Nodo ramaIzqda, double valor, Nodo ramaDrcha) {
        return new Nodo(ramaIzqda,valor, ramaDrcha);
    }

    @Override
    public String toString() {
        return raiz.toString();
    }

    public void mostrarEnOrden(Nodo nodo) {
        if (nodo != null) {
            mostrarEnOrden(nodo.getRamaIzdo());
            System.out.print(nodo.getValorNumerico() + " ");
            mostrarEnOrden(nodo.getRamaDcho());
        }
    }

    public void mostrarPreOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValorNumerico() + " ");
            mostrarPreOrden(nodo.getRamaIzdo());
            mostrarPreOrden(nodo.getRamaDcho());
        }
    }

    public void mostrarPostOrden(Nodo nodo) {
        if (nodo != null) {
            mostrarPostOrden(nodo.getRamaIzdo());
            mostrarPostOrden(nodo.getRamaDcho());
            System.out.print(nodo.getValorNumerico() + " ");
        }
    }
}