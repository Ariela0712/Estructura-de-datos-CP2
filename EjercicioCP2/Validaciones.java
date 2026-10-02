import java.util.Scanner;

public class Validaciones {
    Scanner in = new Scanner(System.in);

    public int validarEntero(String mensaje, int min, int max) {
        int num = min - 1;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String entrada = in.nextLine().trim();
            try {
                num = Integer.parseInt(entrada);
                if (num >= min && num <= max) {
                    valido = true;
                } else {
                    System.out.println("Debe estar entre "+min+" y " +max+".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: escribe un número entero.");
            }
        }
        return num;
    }

    public String validarTexto(String mensaje) {
        String texto = "";
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            texto = in.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El texto no puede estar vacío.");
            } else if (!soloLetrasYNum(texto)) {
                System.out.println("Solo se permiten letras y numeros(sin espacios,guiones ni simbolos).");
            } else {
                valido = true;
            }
        }
        return texto;
    }

    private boolean soloLetrasYNum(String texto) {
        boolean val = true;
        for (int i=0;i<texto.length();i++) {
            if (!Character.isLetterOrDigit(texto.charAt(i))) {
                val = false;
            }
        }
        return val;
    }
}