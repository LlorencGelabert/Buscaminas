/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author Llorenç
 */
public class Joc{
    private Taula taula;
    boolean fin = false;
    boolean guanyar = false;
    int turn=0;
    
    public Joc(){
        taula = new Taula();
        Jugar(taula);
    }
    
    public void Jugar(Taula taula){
        do{
            turn++;
            System.out.println("Turn "+turn);
            taula.mostrar();
            fin = taula.setPosition();
            
            if(!fin){
                taula.obrirVeinats();
                fin = taula.guanyar();
            }
            
        }while(!fin);
        
        if(taula.guanyar()){
            System.out.println("Enhorabona, has Guanyat "+turn+" turns");
            taula.mostrarMines();
        } else {
            System.out.println("Mina! Perds!");
            taula.mostrarMines();
        }
    }
}
