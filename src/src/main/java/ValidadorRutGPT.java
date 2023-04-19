import java.util.Scanner;
public class ValidadorRutGPT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedirle al usuario que ingrese su número de RUT
        System.out.print("Ingrese su número de RUT sin dígito verificador: ");
        String rutString = scanner.nextLine();

        // Validar que el número de RUT sea válido
        if (!rutString.matches("[0-9]+")) {
            System.out.println("El número de RUT debe contener sólo números.");
            return;
        }

        int rut = Integer.parseInt(rutString);

        // Calcular el dígito verificador
        char dv = calcularDV(rut);

        // Mostrar el número de RUT completo con el dígito verificador
        System.out.println("Su número de RUT completo es: " + rut + "-" + dv);
    }

    public static char calcularDV(int rut) {
        int suma = 0;
        int multiplicador = 2;

        // Invertir los dígitos del RUT
        String rutInvertido = new StringBuilder(String.valueOf(rut)).reverse().toString();

        // Multiplicar cada dígito por una serie de números y sumarlos
        for (int i = 0; i < rutInvertido.length(); i++) {
            int digito = Character.getNumericValue(rutInvertido.charAt(i));
            suma += digito * multiplicador;
            multiplicador++;
            if (multiplicador > 7) {
                multiplicador = 2;
            }
        }

        // Obtener el dígito verificador
        int resto = suma % 11;
        char dv;
        if (resto == 0) {
            dv = '0';
        } else if (resto == 1) {
            dv = 'K';
        } else {
            dv = (char) ((11 - resto) + '0');
        }

        return dv;
    }
}