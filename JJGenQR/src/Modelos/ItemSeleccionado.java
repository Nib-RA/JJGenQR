/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author toshiba
 */
public class ItemSeleccionado {
    public static String idUsuario;
    public static String rol;
    public static Boolean estado;
    public static String accionBoton;
    public static String idCategoria;
    public static String idArticulo;
    public static String idVisitante;
    public static String idVisitanteDispositivo;
    public static String fechaInicio;
    public static String fechaFinal;

     //Seleccionar el Id de los usuarios en el jtable 
    public String getIdUsuario(){
        return idUsuario;
    }
    
     public void setIdUsuario(String idUsuario){
        this.idUsuario=idUsuario;
    }
     
    public String getAccionBoton(){
        return accionBoton;
    }
    
     public void setAccionBoton(String accionBoton){
        this.accionBoton=accionBoton;
    }
     
    public String getRol(){
        return rol;
    }
    
     public void setRol(String rol){
        this.rol=rol;
    }
     
     
      //Seleccionar el Id del estado en el jtable 
    public Boolean getEstado(){
        return estado;
    }
    
     public void setEstado(String estado){
        if(estado.contains("Activo")) this.estado = true;
        else this.estado = false;
    }
     
     //Seleccionar el Id de las categorias en el jtable 
     public String getIdCategoria(){
        return idCategoria;
    }
    
     public void setIdCategoria(String idCategoria){
        this.idCategoria=idCategoria;
    }
     
      //Seleccionar el Id de los articulos en el jtable 
    
       public String getIdArticulo(){
        return idArticulo;
    }
    
     public void setIdArticulo(String idArticulo){
        this.idArticulo=idArticulo;
    }

    public static String getIdVisitante() {
        return idVisitante;
    }

    public static void setIdVisitante(String idVisitante) {
        ItemSeleccionado.idVisitante = idVisitante;
    }
     
     //Seleccionar los Dispositivos conectados

    public static String getIdVisitanteDispositivo() {
        return idVisitanteDispositivo;
    }

    public static void setIdVisitanteDispositivo(String idVisitanteDispositivo) {
        ItemSeleccionado.idVisitanteDispositivo = idVisitanteDispositivo;
    }

    public static String getFechaInicio() {
        return fechaInicio;
    }

    public static void setFechaInicio(String fechaInicio) {
        ItemSeleccionado.fechaInicio = fechaInicio;
    }

    public static String getFechaFinal() {
        return fechaFinal;
    }

    public static void setFechaFinal(String fechaFinal) {
        ItemSeleccionado.fechaFinal = fechaFinal;
    }
    
    
    
}
