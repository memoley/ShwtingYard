/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

/**
 *
 * @author memol
 */
public interface TecladoListener {
    void enviarDato(String dato);
    void mostrarResultado();
    void borrarPantalla();
    void borrarEntrada();
    void borrarUltimoDigito();
}
