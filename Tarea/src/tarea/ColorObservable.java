package tarea;

import java.awt.Color;
import java.util.ArrayList;

public class ColorObservable {
    private ArrayList<ColorObserver> observadores = new ArrayList<>();
    
    public void añadirObservador(ColorObserver observador) {
        observadores.add(observador);
    }
    
    private void notificarAObservadores(Color color) {
        for (ColorObserver observador : observadores) {
            observador.actualizarColor(color);
        }
    }

    public void setColor(Color color) {
        notificarAObservadores(color);
    }
}
