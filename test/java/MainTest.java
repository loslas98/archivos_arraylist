import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void validarRutaTest() {
        String ruta = "archivo.txt";
        String noRuta = "ajsnajsj";
        assertTrue(Main.validarRuta(ruta));
        assertFalse(Main.validarRuta(noRuta));
    }

    @Test
    void validarContenidoTest(){
        String contenido = "";
        Path archivo = Paths.get("archivo.txt");
        assertTrue(Main.validarContenido(contenido,archivo));


    }

    @Test
    void validarPreciosTest() {
        String dato = "cocacola;2000";
        String dato2 = "jajsjajs";
        assertTrue(Main.validarPrecios(dato));
        assertFalse(Main.validarPrecios(dato2));

    }


    @Test
    void opcionIngresadaTest() {
        ArrayList<String> lista = new ArrayList<>(5);
        String opcion = "6";
        assertEquals("",Main.opcionIngresada(opcion,lista));
    }

    @Test
    void validarRuta() {
        String ruta = "hola.txt";
        assertTrue(Main.validarRuta(ruta));
    }

    @Test
    void leerRuta() {
        var text = "archivo.txt";
        var input = new ByteArrayInputStream(text.getBytes());
        System.setIn(input);
        assertEquals(text,Main.leerRuta());
    }

    @Test
    void ingresarOpcion() {
        var text = "1";
        var input = new ByteArrayInputStream(text.getBytes());
        System.setIn(input);
        assertEquals(text,Main.ingresarOpcion());

    }


}