package crudinventario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author abc
 */
public class mClientes {

    public void Insertar(String cadenaCliente) {
        try {
            FileWriter archivo = new FileWriter("listado_clientes.txt", true);
            BufferedWriter buffer = new BufferedWriter(archivo);

            buffer.write(cadenaCliente);
            buffer.newLine();
            buffer.close();

        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public ArrayList<String> Consultar() {
        ArrayList<String> listaRegistros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("listado_clientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                // Formato: No. Cliente: [0]| Nombre: [1]| Tipo: [2]| Razon Social: [3]
                String datoBonito = "No. Cliente: " + datos[0] + "| Nombre: " + datos[1] + "| Tipo: " + datos[2]
                        + "| Razon Social: " + datos[3];

                listaRegistros.add(datoBonito);
            }
        } catch (IOException e) {
            System.err.println("Mensaje de error: " + e.getMessage());
        }

        return listaRegistros;
    }

    public void Update(String lineActual, String lineaNueva, String archivoOriginal) {
        java.io.File fileOriginal = new java.io.File(archivoOriginal);
        java.io.File fileTemporal = new java.io.File("temporal_clientes.txt");

        String lineaLeida;
        Boolean actualizado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal));) {

            while ((lineaLeida = br.readLine()) != null) {
                if (lineaLeida.equals(lineActual)) {
                    bw.write(lineaNueva);
                    bw.newLine();
                    actualizado = true;
                } else {
                    bw.write(lineaLeida);
                    bw.newLine();
                }
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar" + e.getMessage());
        }

        if (actualizado) {
            if (fileOriginal.delete()) {
                fileTemporal.renameTo(fileOriginal);
                System.out.println("Registro Actualizado");
            } else {
                System.out.println("Error: No se pudo borrar el archivo");
            }
        } else {
            fileTemporal.delete();
            System.out.println("No se encuentro el registro");
        }
    }

    public void Delete(String lineActual, String archivoOriginal) {
        java.io.File fileOriginal = new java.io.File(archivoOriginal);
        java.io.File fileTemporal = new java.io.File("temporal_clientes.txt");

        String lineaLeida;
        Boolean eliminado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal));) {

            while ((lineaLeida = br.readLine()) != null) {
                if (lineaLeida.equals(lineActual)) {
                    eliminado = true;
                } else {
                    bw.write(lineaLeida);
                    bw.newLine();
                }
            }

        } catch (Exception e) {
            System.out.println("Error al borrar" + e.getMessage());
        }

        if (eliminado) {
            if (fileOriginal.delete()) {
                fileTemporal.renameTo(fileOriginal);
                System.out.println("Registro Eliminado");
            } else {
                System.out.println("Error: No se pudo borrar el archivo");
            }
        } else {
            fileTemporal.delete();
            System.out.println("No se encuentro el registro");
        }
    }
}
