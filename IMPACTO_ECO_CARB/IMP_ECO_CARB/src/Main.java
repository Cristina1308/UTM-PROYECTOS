// Programa para calcular impacto ecológico de la huella de carbono
// María Cristina Obregón Vásquez - 2do Semestre B - Tecnologías de la Información - UTM Online
import java.util.ArrayList;

// Interfaz para calcular el impacto ecológico
interface ImpactoEcologico {
    double obtenerImpactoEcologico();
}

// Clase Edificio que implementa ImpactoEcologico
class Edificio implements ImpactoEcologico {
    private String nombre;
    private double emisionesCO2PorMetroCuadrado;

    public Edificio(String nombre, double emisionesCO2PorMetroCuadrado) {
        this.nombre = nombre;
        this.emisionesCO2PorMetroCuadrado = emisionesCO2PorMetroCuadrado;
    }

    @Override
    public double obtenerImpactoEcologico() {
        // Supongamos un edificio de 1000 metros cuadrados
        double areaEdificio = 1000.0;
        return emisionesCO2PorMetroCuadrado * areaEdificio;
    }

    public String toString() {
        return "Edificio: " + nombre;
    }
}

// Clase Auto que implementa ImpactoEcologico
class Auto implements ImpactoEcologico {
    private String modelo;
    private double emisionesCO2PorKilometro;

    public Auto(String modelo, double emisionesCO2PorKilometro) {
        this.modelo = modelo;
        this.emisionesCO2PorKilometro = emisionesCO2PorKilometro;
    }

    @Override
    public double obtenerImpactoEcologico() {
        // Supongamos que un auto recorre 10,000 kilómetros al año
        double kilometrosPorAnio = 10000.0;
        return emisionesCO2PorKilometro * kilometrosPorAnio;
    }

    public String toString() {
        return "Auto: " + modelo;
    }
}

// Clase Bicicleta que implementa ImpactoEcologico
class Bicicleta implements ImpactoEcologico {
    private String tipo;
    // Supongamos un impacto ecológico bajo para las bicicletas
    private static final double IMPACTO_ECOLOGICO_BICICLETA_POR_KILOMETRO = 0.01;

    public Bicicleta(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public double obtenerImpactoEcologico() {
        // Supongamos que una bicicleta recorre 5000 kilómetros al año
        double kilometrosPorAnio = 5000.0;
        return IMPACTO_ECOLOGICO_BICICLETA_POR_KILOMETRO * kilometrosPorAnio;
    }

    public String toString() {
        return "Bicicleta: " + tipo;
    }
}

// Clase principal que crea objetos de cada clase y los almacena en un ArrayList<ImpactoEcologico>
public class Main {
    public static void main(String[] args) {
        ArrayList<ImpactoEcologico> listaImpactoEcologico = new ArrayList<>();

        Edificio edificio = new Edificio("Edificio de Oficinas", 0.2); // 0.2 kg CO2 por metro cuadrado
        Auto auto = new Auto("Sedán", 0.12); // 0.12 kg CO2 por kilómetro
        Bicicleta bicicleta = new Bicicleta("De montaña"); // Baja emisión de CO2

        listaImpactoEcologico.add(edificio);
        listaImpactoEcologico.add(auto);
        listaImpactoEcologico.add(bicicleta);

        // Iterar a través del ArrayList e invocar polimórficamente el método obtenerImpactoEcologico
        for (ImpactoEcologico elemento : listaImpactoEcologico) {
            System.out.println(elemento + " - Impacto Ecológico: " + elemento.obtenerImpactoEcologico() + " kg CO2");
        }
    }
}