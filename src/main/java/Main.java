import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        iniciarPrograma();










    }
    public static void iniciarPrograma()throws IOException{
        ArrayList<String> lista = new ArrayList<>();
        String ruta = leerRuta();
        String contenido = leerArchivo(ruta);
        añadirArray(lista,contenido);
        mostrarLista(lista);
        int total = sumarPrecios(lista);
        System.out.println("el total de precios es: "+total);
        String opcion = ingresarOpcion();
        String ingresado = opcionIngresada(opcion,lista);
        if(ingresado!=""){
            System.out.println("producto seleccionado: "+ingresado);

        }


    }
    public static String leerRuta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese ruta del archivo");
        String ruta = sc.nextLine();
        return ruta;


    }
    public static String leerArchivo(String ruta) throws IOException {
        if(validarRuta(ruta)){
            Path archivo = Paths.get(ruta);
            String contenido = "";
            boolean validarCont = validarContenido(contenido,archivo);
            if (validarCont){
                contenido = new String(Files.readAllBytes(archivo));
                return contenido;

            }


        }
        return "";


    }
    public static boolean validarRuta(String ruta){
        if(ruta.contains(".txt")){
            System.out.println("ruta correcta");
            return true;
        }else{
            System.out.println("ruta incorrecta");
            return false;
        }

    }
    public static boolean validarContenido(String contenido,Path archivo){
        try {
            contenido = new String(Files.readAllBytes(archivo));

        } catch (IOException e) {
            System.out.println("error lectura archivo");
            return false;
        }
        return true;




    }
    public static ArrayList<String>  añadirArray(ArrayList<String>lista,String contenido){
        Object[] lines = contenido.lines().toArray();
        for (int i=0;i<lines.length;i++){
            lista.add(lines[i].toString());

        }
        return lista;



    }

    public static void mostrarLista(ArrayList<String>lista){
        for (int i=0;i< lista.size();i++){
            System.out.println(lista.get(i));
        }


    }
    public static boolean validarPrecios(String dato){
        if((dato.split(";")).length!=2){
            return false;
        }
        try{
            Integer.parseInt((dato.split(";")[1]));
            return true;

        }catch (NumberFormatException e){
            System.out.println("error de formato de numero");
            return false;
        }


    }

    public static int sumarPrecios(ArrayList<String>lista){
        int ac = 0;
        for (int i=0;i<lista.size();i++){
            String dato = lista.get(i);
            var validacion =validarPrecios(dato);
            if(validacion){
                int precio = Integer.parseInt((dato.split(";")[1]));
                ac += precio;

            }
        }
        return ac;



    }
    public static String ingresarOpcion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("elija que producto ver, por medio de numero de fila ");
        return sc.next();
    }
    public static String opcionIngresada (String opcion,ArrayList<String>lista){
        if(Integer.parseInt(opcion)>lista.size()){
            System.out.println("No existe un producto en esa fila");
            return "";

        }
        return lista.get(Integer.parseInt(opcion)-1);


    }

}
