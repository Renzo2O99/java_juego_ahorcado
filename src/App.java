import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Inicializamos un scanner para recibir una entrada de datos:
        Scanner scanner = new Scanner(System.in);

        // Inicializamos las variables que utilizaremos:
        String palabra_secreta = "inteligente";
        int intentos_maximos = 10;
        int intentos = 0;
        boolean palabra_adivinada = false;

        // Arreglos:
        char[] letras_adivinadas = new char[palabra_secreta.length()];

        // Estructura de control: iterativa (bucle).
        for (int i = 0; i < letras_adivinadas.length; i++) {
            letras_adivinadas[i] = '_';
        }

        // Estructura de control: iterativa (bucle).

        while (!palabra_adivinada && intentos < intentos_maximos) {
            System.out.println("\nPalabras a adivinar: " + String.valueOf(letras_adivinadas));
        
            System.out.println("Introduzca una letra, por favor: ");
            
            // Utilizamos el scanner que instanciamos.
            char letra = Character.toLowerCase(scanner.nextLine().charAt(0));
        
            boolean letra_correcta = false;

            for (int i = 0; i < palabra_secreta.length(); i++) {
                
                // Estructura de control: condicional.
                if (palabra_secreta.charAt(i) == letra) {
                    letras_adivinadas[i] = letra;
                    letra_correcta = true;
                }
            }

            if(!letra_correcta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentos_maximos - intentos) + " intentos.");
            }

            if(String.valueOf(letras_adivinadas).equals(palabra_secreta)) {
                palabra_adivinada = true;
                System.out.println("\n¡Felicidades! Has adivinado la palabra secreta: " + palabra_secreta);
            }
        }

        if(!palabra_adivinada) {
            System.out.println("\n--> GAME OVER <--\n¡Qué pena! Te has quedado sin intentos...\n");
        }

        // Cerramos el scanner.
        scanner.close();
    }
}
