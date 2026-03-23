package crudinventario;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dogza
 */
public class mArticulo {
    
    public void insertar(String cadenaArticulo){
        
        try {
            FileWriter archivo = new FileWriter("listado_articulos.txt" , true);
            BufferedWriter buffer = new BufferedWriter(archivo);
            buffer.write(cadenaArticulo); 
            buffer.newLine(); 
            buffer.close();

        } catch (IOException e) {
        }
    }
    
    public ArrayList<String> consultar(){
        ArrayList<String> listaRegistros = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader( new FileReader("listado_articulos.txt"))) {
            String linea;
            while((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                String datoBonito = "Codigo: " + datos[0] + "| Descripcion: " + datos[1] + "| Precio: " + datos[2];
                listaRegistros.add(datoBonito);
            }
        } catch (IOException e) {
            System.out.println("Mensaje de error" + e.getMessage());
            listaRegistros.add("Error al cargar los datos");
        }
        return listaRegistros;
        
    }
    
    public void update(String lineaActual, String lineaNueva, 
            String archivoOriginal){
        
        //Declaramos los archivos original(lectura) temporal(escritura)
        java.io.File fileOriginal = new java.io.File(archivoOriginal);
        java.io.File fileTemporal = new java.io.File("temporal.txt");
        
        String lineaLeida;
        Boolean actualizado = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal));){
            
            while((lineaLeida = br.readLine()) != null){
                if(lineaLeida.equals(lineaActual)){
                    bw.write(lineaNueva);
                    actualizado = true;
                } else {
                    bw.write(lineaLeida);
                }
                bw.newLine();
            }
        }catch(Exception e){
            System.out.println("Error al actualizar" + e.getMessage());
        }
        
        // Eliminación de archivo original y renombre de temporal
        if(actualizado){
            if(fileOriginal.delete()){
                fileTemporal.renameTo(fileOriginal);
                System.out.println("Registro Actualizado");
            } else {
                System.out.println("Error: No se pudo borrar el archivo");
            }
        }else{
            fileTemporal.delete();
            System.out.println("No se encontró el registro");
        }
        
        
    }
        
    
}
