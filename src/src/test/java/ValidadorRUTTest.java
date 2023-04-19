import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorRUTTest {


    @BeforeEach
    public void setUptest() {

    }
    @AfterEach
    public void tearDownTest(){

    }

    @Test
    void testDigitoVerificador() {
        String resultadoesperado1="7";
        assertEquals(resultadoesperado1,ValidadorRUT.digitoVerificador(4));
        String resultadoesperado2="9";
        assertEquals(resultadoesperado2,ValidadorRUT.digitoVerificador(2));
    }

    @Test
    void testMultiplicarCadena() {
        int resultadoesperado1=4;
        assertEquals(resultadoesperado1,ValidadorRUT.multiplicarCadena("57677551"));
        int resultadoesperado2=2;
        assertEquals(resultadoesperado2,ValidadorRUT.multiplicarCadena("70667712"));
    }

    @Test
    void invertirRUT() {
        String resultadoesperado1 = "57677551";
        assertEquals(resultadoesperado1,ValidadorRUT.invertirRUT("15577675"));
        String resultadoesperado2 = "70667712";
        assertEquals(resultadoesperado2,ValidadorRUT.invertirRUT("21776607"));
    }

}