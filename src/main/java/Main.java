import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lista = new ArrayList<>();
        String ruta = leerRuta();
        String contenido = leerArchivo(ruta);
        añadirArray(lista,contenido);
        mostrarLista(lista);






    }
    public static String leerRuta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese ruta del archivo");
        String ruta = sc.nextLine();
        return ruta;


    }
    public static String leerArchivo(String ruta) throws IOException {
        Path archivo = Paths.get(ruta);
        String contenido = "";
        contenido = new String(Files.readAllBytes(archivo));
        return contenido;
    }
    public static ArrayList<String>  añadirArray(ArrayList<String>lista,String contenido){
        String[] lines = contenido.split("\n");
        for (int i=0;i<lines.length;i++){
            lista.add(lines[i]);

        }
        return lista;


    }

    public static void mostrarLista(ArrayList<String>lista){
        for (int i=0;i< lista.size();i++){
            System.out.println(lista.get(i));
        }


    }

}
