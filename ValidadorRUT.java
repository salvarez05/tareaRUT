import java.util.Scanner;
public class ValidadorRUT {
    public static void main(String[] args) {
        String rut= ingresoRUT();
        String rutInvertido=invertirRUT(rut);
        int resta=multiplicarCadena(rutInvertido);
        String digito=digitoVerificador(resta);

        System.out.println("El digito verificador es: "+digito);

    }

    private static String digitoVerificador(int resta) {
        String digito="";
        int resultado=0;
        if(11-resta==10){
            digito="k";
        } else if (11-resta==11) {
            digito="0";

        } else{
            digito+=resultado;
        }

        return digito;
    }

    private static int multiplicarCadena(String rutInvertido) {
        int suma=0;
        int digito=0;
        for (int i = 0; i < rutInvertido.length(); i++) {
            if (i <6 ) {
                digito= (2+i)*Integer.parseInt(String.valueOf(rutInvertido.charAt(i)));
                suma=suma +digito;
            }else {
                digito= (2+i-6)*Integer.parseInt(String.valueOf(rutInvertido.charAt(i)));
                suma=suma +digito;
            }

        }
        System.out.println(suma);
        int resultado1= ((int)suma/11)*11;
        System.out.println(resultado1);
        int resta= Math.abs(suma-resultado1);
        return resta;
    }

    public static String invertirRUT(String rut) {
        String rutInvertido="";
        for (int i = 0; i < rut.length(); i++) {
            rutInvertido+= rut.charAt(rut.length()-1-i);
        }
        return rutInvertido;
    }

    public static String ingresoRUT() {
        String rut="";
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el rut sin digito verificador y sin puntos");
        while ( 7> rut.length() || rut.length() > 8) {
            rut= teclado.next();
            if (rut.length()<7||rut.length()>8){
                System.out.println("Ingrese un rut valido");
            }
        }
        return rut;
    }
}
