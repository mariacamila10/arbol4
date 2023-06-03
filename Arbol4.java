/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol4;

import javax.swing.JOptionPane;

public class Arbol4 {

    ArbolBinario arbol;
    Nodo raiz;

    public Arbol4() {
        arbol = new ArbolBinario();
    }

    public static void main(String[] args) throws Exception {
        new Arbol4().menu();
    }

    public void menu() {
        String opcion;
        int n = -1;
        do {
            try {
                opcion = JOptionPane.showInputDialog(null,
                        "Árbol Binario\n\n"
                        + "1. Incluir un nodo\n"
                        + "2. Buscar un nodo\n"
                        + "3. Eliminar un nodo \n"
                        + "4. Mostrar el arbol\n"
                        + "0. Salir\n\n"
                        + "Introduzca la opción deseada:",
                        "Menú de opciones", JOptionPane.QUESTION_MESSAGE);

                if (opcion != null && !opcion.equals("")) {
                    n = Integer.parseInt(opcion);

                    switch (n) {
                        case 1:
                            incluirNodo();
                            break;
                        case 2:
                            buscarNodo();
                            break;

                        case 3:

                            Double valor = Double.parseDouble(JOptionPane.showInputDialog("ingrese el numero que desea eliminar"));
                            eliminarNodo(valor);
                            
                            break;

                        case 4:
                            mostrarMenuMostrarArbol();
                            break;
                        case 0:
                            JOptionPane.showMessageDialog(null, "Saliendo...");
                            System.exit(0);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "No es una opción válida!!");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No es una opción válida!!");
            }
        } while (n != 0);
    }

    public void mostrarMenuMostrarArbol() {
        String opcion;
        int n = -1;
        do {
            try {
                opcion = JOptionPane.showInputDialog(null,
                        "Mostrar Árbol\n\n"
                        + "1. Mostrar en orden\n"
                        + "2. Mostrar en preorden\n"
                        + "3. Mostrar en postorden\n"
                        + "4. Volver al menú principal\n\n"
                        + "Introduzca la opción deseada:",
                        "Menú de opciones", JOptionPane.QUESTION_MESSAGE);

                if (opcion != null && !opcion.equals("")) {
                    n = Integer.parseInt(opcion);

                    switch (n) {
                        case 1:
                            mostrarArbol();
                            arbol.mostrarEnOrden(arbol.raizArbol());
                            System.out.println();
                            break;
                        case 2:
                            mostrarArbol();
                            arbol.mostrarPreOrden(arbol.raizArbol());
                            System.out.println();
                            break;
                        case 3:
                            mostrarArbol();
                            arbol.mostrarPostOrden(arbol.raizArbol());
                            System.out.println();
                            break;
                        case 4:
                            menu();// Volver al menú principal
                        default:
                            JOptionPane.showMessageDialog(null, "No es una opción válida!!");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No es una opción válida!!");
            }
        } while (n != 0);
    }

    public void incluirNodo() {
        boolean continuar = true;

        while (continuar) {
            String dato = JOptionPane.showInputDialog(null, "Ingrese el dato del nodo:", "Incluir Nodo", JOptionPane.QUESTION_MESSAGE);
            double valor = Double.parseDouble(dato); // Convertir el dato a double (asumiendo que es numérico)
            Nodo nuevoNodo = new Nodo(valor);

            if (arbol == null || arbol.esVacio()) {
                arbol = new ArbolBinario(nuevoNodo); // Inicializar el árbol con el nuevo nodo como raíz
            } else {
                insertarNodo(arbol.raizArbol(), nuevoNodo); // Llamar a un método auxiliar para insertar el nodo
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "Nodo incluido correctamente"
                    + "\n ¿Desea continuar insertando nodos?", "Continuar", JOptionPane.YES_NO_OPTION);
            continuar = (respuesta == JOptionPane.YES_OPTION);
        }
    }

    public void insertarNodo(Nodo raiz, Nodo nuevoNodo) {
        if (nuevoNodo.getValorNumerico() < raiz.getValorNumerico()) {
            if (raiz.getRamaIzdo() == null) {
                raiz.setRamaIzdo(nuevoNodo); // Insertar el nodo en el subárbol izquierdo
            } else {
                insertarNodo(raiz.getRamaIzdo(), nuevoNodo); // Llamar recursivamente con el subárbol izquierdo como nueva raíz
            }
        } else if (nuevoNodo.getValorNumerico() > raiz.getValorNumerico()) {
            if (raiz.getRamaDcho() == null) {
                raiz.setRamaDcho(nuevoNodo); // Insertar el nodo en el subárbol derecho
            } else {
                insertarNodo(raiz.getRamaDcho(), nuevoNodo); // Llamar recursivamente con el subárbol derecho como nueva raíz
            }
        } else {
            // El nodo con el mismo valor ya existe en el árbol, puedes manejar esta situación según tus necesidades
            JOptionPane.showMessageDialog(null, "El nodo ya existe en el árbol.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarNodo() {
        String dato = JOptionPane.showInputDialog(null, "Ingrese el dato a buscar:", "Buscar Nodo", JOptionPane.QUESTION_MESSAGE);
        double valor = Double.parseDouble(dato); // Convertir el dato a double (asumiendo que es numérico)

        if (buscarValor(arbol.raizArbol(), valor)) {
            JOptionPane.showMessageDialog(null, "El nodo se encuentra en el árbol.", "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El nodo no se encuentra en el árbol.", "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);
        }
    }

    private boolean buscarValor(Nodo raiz, double valor) {
        if (raiz == null) {
            return false; // No se encontró el valor, el árbol o subárbol está vacío
        }

        if (valor == raiz.valorNumerico) {
            return true; // Se encontró el valor en el nodo actual
        } else if (valor < raiz.valorNumerico) {
            return buscarValor(raiz.getRamaIzdo(), valor); // Llamar recursivamente con el subárbol izquierdo
        } else {
            return buscarValor(raiz.getRamaDcho(),
                     valor); // Llamar recursivamente con el subárbol derecho
        }
    }

    public void eliminarNodo(double valor) {

        if (arbol != null && !arbol.esVacio()) {

          if (buscarValor(arbol.raizArbol(), valor)) {
             arbol.raiz = eliminarNodoRecursivo(arbol.raizArbol(), valor);
            JOptionPane.showMessageDialog(null, "Nodo eliminado con exito.", "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
            mostrarArbol();
        } else {
            JOptionPane.showMessageDialog(null, "El nodo no se encuentra en el árbol.", "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);

        }  
        
        }
       
    }

    private Nodo eliminarNodoRecursivo(Nodo nodo, double valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.valorNumerico) {
            nodo.ramaIzdo = eliminarNodoRecursivo(nodo.ramaIzdo, valor);
        } else if (valor > nodo.valorNumerico) {
            nodo.ramaDcho = eliminarNodoRecursivo(nodo.ramaDcho, valor);
        } else {
            // Nodo encontrado, procedemos a eliminarlo

            // Caso 1: El nodo no tiene hijos
            if (nodo.ramaIzdo == null && nodo.ramaDcho == null) {
                return null;
            }

            // Caso 2: El nodo tiene un solo hijo
            if (nodo.ramaIzdo == null) {
                return nodo.ramaDcho;
            }

            if (nodo.ramaDcho == null) {
                return nodo.ramaIzdo;
            }

            // Caso 3: El nodo tiene dos hijos
            Nodo sucesor = obtenerMayor(nodo.ramaIzdo);
            nodo.valorNumerico = sucesor.valorNumerico;
            nodo.ramaIzdo = eliminarNodoRecursivo(nodo.ramaIzdo, sucesor.valorNumerico);
        }

        return nodo;
    }

    private Nodo obtenerMayor(Nodo nodo) {
        while (nodo.ramaDcho != null) {
            nodo = nodo.ramaDcho;
        }
        return nodo;
    }

    public void mostrarArbol() {
        // Verificar si el árbol no es nulo y contiene nodos
        if (arbol != null && !arbol.esVacio()) {
            String arbolString = mostrarArbolRecursivo(arbol.raizArbol(), 0, "");
            JOptionPane.showMessageDialog(null, arbolString, "Árbol Binario", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El árbol está vacío.", "Árbol Vacío", JOptionPane.WARNING_MESSAGE);
        }
    }

    private String mostrarArbolRecursivo(Nodo nodo, int nivel, String arbolString) {
        if (nodo != null) {
            for (int i = 0; i < nivel; i++) {
                arbolString += "    ";
            }
            arbolString += "└──  " + nodo.valorNumerico + "\n";

            if (nodo.ramaIzdo != null) {
                arbolString = mostrarArbolRecursivo(nodo.ramaIzdo, nivel + 1, arbolString);
            }

            if (nodo.ramaDcho != null) {
                arbolString = mostrarArbolRecursivo(nodo.ramaDcho, nivel + 1, arbolString);
            }
        }
        return arbolString;
    }

}
