/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol4;

public class Nodo {
    double valorNumerico;
    Nodo ramaIzdo;
    Nodo ramaDcho;

    public Nodo(double valorNumerico) {
        this.valorNumerico = valorNumerico;
        this.ramaIzdo = null;
        this.ramaDcho = null;
    }

  public Nodo(Nodo ramaIzdo, double valorNumerico, Nodo ramaDcho) {
        this.valorNumerico = valorNumerico;
        this.ramaIzdo = ramaIzdo;
        this.ramaDcho = ramaDcho;
    }

    public double getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(double valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public Nodo getRamaIzdo() {
        return ramaIzdo;
    }

    public void setRamaIzdo(Nodo ramaIzdo) {
        this.ramaIzdo = ramaIzdo;
    }

    public Nodo getRamaDcho() {
        return ramaDcho;
    }

    public void setRamaDcho(Nodo ramaDcho) {
        this.ramaDcho = ramaDcho;
    }
}
