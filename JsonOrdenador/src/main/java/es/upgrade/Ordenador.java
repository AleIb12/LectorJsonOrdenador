package es.upgrade;

import com.google.gson.annotations.SerializedName;
import java.util.List;

class Ordenador {
    String nombre;
    int precio;
    List<Procesador> procesador;
    List<PlacaBase> placaBase;
    List<Ram> ram;
    List<DiscoDuro> discoDuro;
    List<FuenteAlimentacion> fuenteAlimentacion;
    List<TarjetaGrafica> tarjetaGrafica;
    List<Periferico> perifericos;
}

class Procesador {
    String marca;
    String modelo;
    int hz;
}

class PlacaBase {
    String modelo;
    String marca;
    int slotsRam;
}

class Ram {
    String marca;
    String tipo;
    String capacidad;
    int hz;
    int cl;
}

class DiscoDuro {
    String tipo;
    String capacidad;
    String marca;
}

class FuenteAlimentacion {
    String marca;
    String modelo;
    @SerializedName("Potencia")
    int potencia;
}

class TarjetaGrafica {
    String marca;
    String modelo;
    int cudas;
}

class Periferico {
    Teclado teclado;
    Raton raton;
    Monitor monitor;
}

class Teclado {
    String marca;
    String nombre;
    String tipo;
}

class Raton {
    String marca;
    String nombre;
    String tipo;
}

class Monitor {
    String tipo;
    String marca;
    String nombre;
}
