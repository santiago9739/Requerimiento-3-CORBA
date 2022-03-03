/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_seguimiento_pacientes;

import S_Gestion_Pacientes.dto.FRCP01FormatoDTO;
import S_Gestion_Pacientes.dto.FRCP02FormatoDTO;
import S_Seguimiento_Pacientes.dto.DocumentoFinalDTO;
import S_Seguimiento_Pacientes.dto.FRCP01FormatoSMDTO;
import S_Seguimiento_Pacientes.dto.FormatoPaciente;
import S_Seguimiento_Pacientes.dto.NotificacionDTO;
import S_Seguimiento_Pacientes.utilidades.Txt;
import S_Seguimiento_Pacientes.utilidades.UtilidadesObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Luis Romero - Santiago Cordoba
 */
public class GestionNotificacionesImpl1 extends UnicastRemoteObject implements GestionNotificacionesInt {
    int codigoHistoriaPaciente = 0;
    private final ArrayList<Integer> documentoFinal;
    private final Txt objArchivoHistorial ;
    
    public GestionNotificacionesImpl1() throws RemoteException {
        super();
        documentoFinal = new ArrayList();
        this.objArchivoHistorial = new Txt("historialPacientes.txt");
    }
    
    @Override
    public boolean enviarNotificacion(NotificacionDTO objNotificacion) throws RemoteException{
        System.out.println("Entrando a enviar Notificacion.");
        if (objNotificacion != null)
       {
           System.out.println(objNotificacion.getNombreCompleto());
           return true; 
       }
      return false; 
    }
    
    @Override
    public boolean registrarHistorialPacientes(FRCP01FormatoDTO objTxtFormato01)throws RemoteException, IOException{
        System.out.println("Entrando a registrar Documento Final en el aarchivo TXT.");
        String ruta = "src\\informes\\historialPacientes.txt";
        
        if (existeArchivo(ruta)) {
            try{
                FileOutputStream rt = new FileOutputStream(ruta);
                ObjectOutputStream oos = new ObjectOutputStream(rt);
                oos.writeObject(objTxtFormato01);
                oos.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        } else {
            try{
                FileOutputStream rt = new FileOutputStream(ruta, true);
                UtilidadesObjectOutputStream pr = new UtilidadesObjectOutputStream(rt);
                pr.writeUnshared(objTxtFormato01);
                pr.close();
            }catch (IOException e){
                System.out.println("Error");
            }
        }
        documentoFinal.add(objTxtFormato01.getID());
        return true;
    }
    
    @Override
    public boolean registrarlistadoSesionesPacienteId(FormatoPaciente objPaciente) throws RemoteException, FileNotFoundException, IOException{
        System.out.println("Entrando a registrar Listado de sesiones de pacientes en el TXT.");
        String ruta = "src\\informes\\listadoSesionesPacientesId.txt";
        if (existeArchivo(ruta)) {
            try{
                FileOutputStream rt = new FileOutputStream(ruta);
                ObjectOutputStream oos = new ObjectOutputStream(rt);
                oos.writeObject(objPaciente);
                oos.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        } else {
            try{
                FileOutputStream rt = new FileOutputStream(ruta, true);
                UtilidadesObjectOutputStream pr = new UtilidadesObjectOutputStream(rt);
                pr.writeUnshared(objPaciente);
                pr.close();
            }catch (IOException e){
                System.out.println("Error");
            }
        }
        documentoFinal.add(objPaciente.getIDPaciente());
        return true;
    }
    
    @Override
    public ArrayList<FRCP01FormatoDTO> traerDatosDocumentoFinalTXT() throws RemoteException, IOException{
        System.out.println("Entrando a capturar datos del historial del TXT.");
        ArrayList<FRCP01FormatoDTO> listaRetornar = new ArrayList();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\informes\\historialPacientes.txt"));
            Object aux = ois.readObject();
            while (aux != null) {
                listaRetornar.add((FRCP01FormatoDTO) aux);
                aux = ois.readObject();
            }
            ois.close();
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Error al recuperar historialPacientes. Retornando lista vacia.");
            return listaRetornar;
        }
        return listaRetornar;
    }
    
    @Override
    public ArrayList<FormatoPaciente> traerDatosFormatoPacienteTXT() throws RemoteException, IOException{
        System.out.println("Entrando a capturar datos del Id del listado de Sesiones de Pacientes del TXT.");
        ArrayList<FormatoPaciente> listaRetornar = new ArrayList();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\informes\\listadoSesionesPacientesId.txt"));
            Object aux = ois.readObject();
            while (aux != null) {
                listaRetornar.add((FormatoPaciente) aux);
                aux = ois.readObject();
            }
            ois.close();
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Error al recuperar listadoSesionesPacientesId. Retornando lista vacia.");
            return listaRetornar;
        }
        return listaRetornar;
    }
    
    public boolean existeArchivo(String direccion) throws IOException {
        System.out.println("Entrando a existe Archivo.");
        boolean bandera = false;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(direccion));
            Object obj = ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException i) {
            System.out.println("Creando Archivo");
            bandera = true;
        }
        return bandera;
    }
    
    @Override
    public boolean guardarTXT(FRCP01FormatoDTO formato01) throws RemoteException {
        System.out.println("Entrando a guardar TXT.");
        return escribirTXT(formato01);
    }
    
    public boolean escribirTXT (FRCP01FormatoDTO formato01)
    {
        System.out.println("Entrando a escribir TXT.");
        String linea = organizarTXT(formato01);
        return this.objArchivoHistorial.escribirLinea(linea);
    }
        
    private String organizarTXT(FRCP01FormatoDTO formato01)
    {
        System.out.println("Entrando a organizar TXT.");
        String obsConsecuencia1="",obsConsecuencia2="";
       
        String linea = "";
        linea += formato01.getID()+ ",";
        linea += formato01.getNombreCompleto()+",";
        linea += formato01.getFechaIngreso()+ ",";
        linea += formato01.getOrdenApoyoEPS()+ ",";
        linea += formato01.getHistoriaClinica()+ ",";
        return linea;
    }
}
