/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_gestion_pacientes;

import Cliente.sop_rmi.AdminCllbckInt;
import S_Gestion_Pacientes.dto.CredencialDTO;
import S_Gestion_Pacientes.dto.PersonalDTO;
import S_Gestion_Pacientes.utilidades.UtilidadesRegistroC;
import S_Seguimiento_Pacientes.sop_rmi.GestionNotificacionesInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Luis Romero - Santiago Cordoba
 */
public class GestionUsuariosImpl extends UnicastRemoteObject implements GestionUsuariosInt{
    private ArrayList<PersonalDTO> personal;
    private int bandera = 0;
    private int contador = 0;
    private GestionNotificacionesInt objReferenciaRemota;
    private int siAdmin = 0;
    
    private AdminCllbckInt objCallback;
    
    static int AdmRecep=0;
    static int Fisios=0;
    static int Medicos=0;
    static int Psicologos=0;

    public GestionUsuariosImpl() throws RemoteException
    {
        super(); //invoca al constructor de la clase base    //asigna un puerto de escucha al OR   
        this.personal = new ArrayList();
    }

    @Override
    public boolean registrarPersonal(PersonalDTO objUsuario) throws RemoteException
    {
        System.out.println("Entrando a registrar personal");
        
        boolean bandera=false;
        
        if(personal.size() < 7)
        {            
            bandera=personal.add(objUsuario);
            System.out.println("Usuario registrado: tipo Id: " +objUsuario.getTipoIdentificacion()+
                               ", Id: " + objUsuario.getID()+ 
                               ", nombreCompleto: " +objUsuario.getNombreCompleto()+ 
                               ", fechaIngreso: " +objUsuario.getFechaIngreso()+
                               ", rol: " +objUsuario.getTipoRol()+
                               ", usuario: " +objUsuario.getUsuario()+
                               ", clave" +objUsuario.getClave());
        }
        
        return bandera;
    }
    
//    @Override
//    public int consultarCantidadUsuarios() throws RemoteException
//    {
//        System.out.println("Entrando a Cantidad");
//        return misUsuarios.size();
//    }

    @Override
    public PersonalDTO consultarPersonal(int identificacion) throws RemoteException {
        
        System.out.println("Entrando a consultar personal");
        
        PersonalDTO objUsuario=null;
        
        for (int i = 0; i < this.personal.size(); i++) {
            if(this.personal.get(i).getID()==identificacion)
            {
                objUsuario=this.personal.get(i);
                break;
            }
        }
        return objUsuario;    
    }
    
    @Override
    public boolean consultarIDPersonal(int identificacion)throws RemoteException{
        
        System.out.println("Entrando a consultar clave de personal");
        
        if (this.personal.size() == 0) {
            System.out.println("El id es correcto "); 
            return true; 
        }else{
            for (int i = 0; i < this.personal.size(); i++) {
                if(this.personal.get(i).getID()==identificacion){
                    System.out.println("El id ya existe. "); 
                    return false; 
                }else  {
                    System.out.println("El id es correcto "); 
                    return true; 
                }
            }
        }
        return false; 
    }
    
    @Override
    public boolean validarId(int id) throws RemoteException {
        System.out.println("Entrando a Validar ID.");
        for (int i = 0; i < personal.size(); i++) {
            if (personal.get(i).getID() == id) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean validarUsuario(String user, String psw) throws RemoteException {
        System.out.println("Entrando a validar Usuario");
        for (int i = 0; i < personal.size(); i++) {
            if (personal.get(i).getUsuario().equals(user) && personal.get(i).getClave().equals(psw)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean validarLimitePersonal(String rol) throws RemoteException {  
        System.out.println("Entrando a validar limite personal");
        if (rol.equals("Medico Especialista")) {
            if (Medicos == 2) {
                return false;
            }else{
                Medicos = Medicos + 1; 
                return true;
            }
        }
        
        if (rol.equals("Psicologo")) {
            if (Psicologos == 1) {
                return false;
            }else{
                Psicologos = Psicologos + 1; 
                return true;
            }
        }
        
        if (rol.equals("Fisioterapeuta")) {
            if (Fisios == 2) {
                return false;
            }else{
                Fisios = Fisios + 1; 
                return true;
            }
        }
        
        if (rol.equals("Recepcionista-Admin")) {
            if (AdmRecep == 1) {
                return false;
            }else{
                AdmRecep = AdmRecep + 1; 
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int consultarId(String usuario, String clave) throws RemoteException {
        System.out.println("Entrando a saber ID");
        for (int i = 0; i < this.personal.size(); i++) {
            if (personal.get(i).getUsuario().equals(usuario) && personal.get(i).getClave().equals(clave)) {
                return personal.get(i).getID();
            }
        }
        return 0;
    }
    
    @Override
    public String consultarNombreCompleto(String usuario, String clave) throws RemoteException {
        System.out.println("Entrando a saber ID");
        String cadena = "Prueba";
        for (int i = 0; i < this.personal.size(); i++) {
            if (personal.get(i).getUsuario().equals(usuario) && personal.get(i).getClave().equals(clave)) {
                return personal.get(i).getNombreCompleto();
            }
        }
        return cadena;
    }
    
    public String consultarReferenciaRemota(String direccionIpRMIRegistry, int numPuertoRMIRegistry) {
        System.out.println("Entrando a Consultar Referencia Remota ");
        String cadena = "Desde consultarReferenciaRemota()...";
        this.objReferenciaRemota = (GestionNotificacionesInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,
                numPuertoRMIRegistry, "ObjetoRemotoNotificacion");
        return cadena;
    }
    
    @Override
    public int consultarRol(String usuario, String contrasena) throws RemoteException {
        
        System.out.println("Entrando a abrir sesion");
        
        int result = 0;
        
        for (int i = 0; i < this.personal.size(); i++) {

            if (personal.get(i).getUsuario().equals(usuario)&&
                personal.get(i).getClave().equals(contrasena)&&
                personal.get(i).getTipoRol().equals("Medico Especialista")) {
                
                result = 1;
                return result;
            }
            
            if (personal.get(i).getUsuario().equals(usuario)&&
                personal.get(i).getClave().equals(contrasena)&&
                personal.get(i).getTipoRol().equals("Psicologo")) {
                
                result = 1;
                return result;
            }
            
            if (personal.get(i).getUsuario().equals(usuario)&&
                personal.get(i).getClave().equals(contrasena)&&
                personal.get(i).getTipoRol().equals("Fisioterapeuta")) {
                
                result = 2;
                return result;
            }
            
            if (personal.get(i).getUsuario().equals(usuario)&&
                personal.get(i).getClave().equals(contrasena)&&
                personal.get(i).getTipoRol().equals("Recepcionista-Admin")) {
                
                result = 3;
                return result;
            }
            
            bandera = 1;
        }
        if (bandera == 1) {
            result = 0;
            return result;
        }
        return result;
    }
    
    @Override
    public int comprobarId(String usuario, String contrasena) throws RemoteException {
        System.out.println("Entrando a comprobar ID");
        for (int i = 0; i < this.personal.size(); i++) {
            if (personal.get(i).getUsuario().equals(usuario) && personal.get(i).getClave().equals(contrasena)) {
                return personal.get(i).getID();
            }
        }
        return 0;
    }
    
    @Override
    public void registrarCallback(AdminCllbckInt objCallback) throws RemoteException {
        System.out.println("Entrando a registrar Callback");
        this.objCallback =  objCallback;
    }
}
