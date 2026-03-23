/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;


public class clsCliente {
    
    private Integer Nocliente;
    private String Nombre;
    private String Tipo;
    private String Razon;
    
    public clsCliente(Integer nocliente , String nombre, String precio , String razon){
        this.Nocliente = nocliente;
        this.Nombre = nombre;
        this.Tipo = precio;
        this.Razon = razon;
    }

    public clsCliente(){

    }
    
    public String aTexto(){
        String cliente = this.Nocliente + "|" + this.Nombre + "|" + this.Tipo + "|" + this.Razon;
        return cliente;
    }
    
    public void guardar() {
        
        mCliente cliente = new mCliente();
        // Enviamos la cadena de texto
        cliente.insertar(this.aTexto());
        
        System.out.println(this.aTexto());
    }
    
    public DefaultListModel<String> LlenarLista(){
    //Instancia desde el modelo
    mCliente mClient = new mCliente();
    //Llenamos la variable con los datos del modelo
    ArrayList<String> datos = mClient.consultar();
    // Creamos la plantilla en blanco para el modelo
    DefaultListModel<String> modelLista = new DefaultListModel();
    // Llenamos la plantilla con los datos del modelo
    for ( String registro: datos){
        modelLista.addElement(registro);
    }
    // Devuelve los datos cargados en el modelo de lsita
    return modelLista;
    }
    
        public void actualizar(String newNoCliente , String newNombre , String newRazonSocial , String newTipoCliente) {
        
        String nuevaLinea = newNoCliente + "|" + newNombre + "|" + newRazonSocial + "|" + newTipoCliente;
        String lineaOriginal = this.Nocliente + "|" + this.Nombre + "|" + this.Razon + "|" + this.Tipo;
        
        //Imprimir los nuevos valores 
        System.out.println("Valores nuevos" + nuevaLinea);
        System.out.println("Valores originales" + lineaOriginal);
        
        //Solicita la actualizacion del registro
        mCliente mClient = new mCliente();
        
        mClient.update(lineaOriginal, nuevaLinea , "listado_articulos.txt");
    }
}
