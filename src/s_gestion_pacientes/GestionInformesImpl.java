/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_gestion_pacientes;

import Cliente.sop_rmi.AdminCllbckImpl;
import Cliente.sop_rmi.AdminCllbckInt;
import S_Gestion_Pacientes.dto.FRCP01FormatoDTO;
import S_Gestion_Pacientes.dto.FRCP02FormatoDTO;
import S_Gestion_Pacientes.dto.FRCP03FormatoDTO;
import S_Gestion_Pacientes.dto.PacientesDTO;
import S_Gestion_Pacientes.dto.PersonalDTO;
import S_Gestion_Pacientes.dto.RegistroDTO;
import S_Seguimiento_Pacientes.sop_rmi.GestionNotificacionesInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import S_Gestion_Pacientes.sop_rmi.GestionUsuariosInt;
import S_Gestion_Pacientes.utilidades.UtilidadesRegistroC;
import java.util.Vector;

/**
 *
 * @author Luis Romero - Santiago Cordoba
 */
public class GestionInformesImpl extends UnicastRemoteObject implements GestionInformesInt{
    private ArrayList<FRCP01FormatoDTO> formatoFRCP01;
    private ArrayList<FRCP02FormatoDTO> formatoFRCP02;
    private ArrayList<FRCP03FormatoDTO> formatoFRCP03;
    private ArrayList<PacientesDTO> paciente;
    private Vector<PacientesDTO> listaPaciente;
    private List<Integer> listaPacientes = new ArrayList<>();
    private GestionNotificacionesInt objReferenciaRemota;   
    private ArrayList<RegistroDTO> regPaciente;
    private Vector<RegistroDTO> listaRegPaciente;
    private List<AdminCllbckInt> cllbckPaciente;
    
    private static GestionUsuariosInt objRemotoU1;

    public GestionInformesImpl() throws RemoteException{
        super();
        formatoFRCP01 = new ArrayList();
        formatoFRCP02 = new ArrayList();
        formatoFRCP03 = new ArrayList();
        this.listaRegPaciente = new Vector();
        regPaciente = new ArrayList();
        cllbckPaciente= new ArrayList();
    }
    
    @Override
    public boolean registrarFormatoFRCP01(FRCP01FormatoDTO objFormatoFRCP01) throws RemoteException{
        System.out.println("Entrando a registrar FormatoFRCP-01");
        boolean bandera = formatoFRCP01.add(objFormatoFRCP01);
        System.out.println("Usuario registrado: ID: " + objFormatoFRCP01.getID()+
                           ", Nombre Completo: " + objFormatoFRCP01.getNombreCompleto() +
                           ", Fecha de Ingreso: " + objFormatoFRCP01.getFechaIngreso() +
                           ", Orden de Apoyo: " + objFormatoFRCP01.getOrdenApoyoEPS()+
                           ", Historia Clinica: " + objFormatoFRCP01.getHistoriaClinica()); 
//        objReferenciaRemota.guardarTXT(objFormatoFRCP01);
        return bandera;
    }
    
    @Override
    public boolean registrarFormatoFRCP02(FRCP02FormatoDTO objFormatoFRCP02) throws RemoteException{
        System.out.println("Entrando a registrar FormatoFRCP-02");
        boolean bandera = formatoFRCP02.add(objFormatoFRCP02);
        System.out.println("Usuario registrado: Concepto: " + objFormatoFRCP02.getConcepto()+
                           ", Observaciones: " + objFormatoFRCP02.getObservaciones() +
                           ", Fecha de Valoracion: " + objFormatoFRCP02.getFechaValoracion() +
                           ", Profesion: " + objFormatoFRCP02.getProfesion() +
                           ", Nombre del Profesional: " + objFormatoFRCP02.getNombreProfesional());
        //        objReferenciaRemota.guardarTXT(objFormatoFRCP02);
        return bandera;
    }
    
    @Override
    public boolean registrarFormatoFRCP03(FRCP03FormatoDTO objFormatoFRCP03) throws RemoteException{
        System.out.println("Entrando a registrar FormatoFRCP-03");
        boolean bandera = formatoFRCP03.add(objFormatoFRCP03);
        System.out.println("Usuario registrado: id Paciente: " + objFormatoFRCP03.getIDPaciente() +
                           ", Numero de Fase: " + objFormatoFRCP03.getNumeroFase() +
                           ", Fecha de Sesion: " + objFormatoFRCP03.getFechaSesion() +
                           ", Numero de Sesion: " + objFormatoFRCP03.getNumeroSesion() +
                           ", Presion Arterial: " + objFormatoFRCP03.getPresionArterial() +
                           ", Frecuencia Cardiaca Inicial: " + objFormatoFRCP03.getFrecuenciaCardiacaInicial() +
                           ", Frecuencia Cardiaca Final: " + objFormatoFRCP03.getFrecuenciaCardiacaFinal() + 
                           ", Saturacion Oxigeno: " + objFormatoFRCP03.getSaturacionOxigeno() + 
                           ", Estado del Paciente: " + objFormatoFRCP03.getEstadoPaciente() +
                           ", Observaciones: " + objFormatoFRCP03.getObservaciones());
        //        objReferenciaRemota.guardarTXT(objFormatoFRCP03);
        return bandera;
    }
    
    @Override
    public int validarIdPaciente(int idPaciente) throws RemoteException {
        System.out.println("Entrando a validar ID del paciente.");
        if (this.formatoFRCP01.size() != 0 ) {
            for (int i = 0; i < this.formatoFRCP01.size(); i++) {
                if (formatoFRCP01.get(i).getID() == idPaciente) {
                    return idPaciente;
                }else{
                    return 0;
                }
            }
        }
        return 0;
    }
    
    @Override
    public boolean validarPacienteRegistrado(int idPaciente) throws RemoteException {
        System.out.println("Entrando a verificar callback");
        for (int i = 0; i < formatoFRCP01.size(); i++) {
            if (idPaciente == formatoFRCP01.get(i).getID()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public FRCP01FormatoDTO consultarPersonalFRCP01(int identificacion) throws RemoteException {
        System.out.println("Entrando a consultar personal FRCP01");
        
        FRCP01FormatoDTO objPacientes01=null;
        
        for (int i = 0; i < this.formatoFRCP01.size(); i++) {
            if(this.formatoFRCP01.get(i).getID()==identificacion)
            {
                objPacientes01=this.formatoFRCP01.get(i);
                break;
            }
        }
        return objPacientes01;    
    }
    
    @Override
    public FRCP02FormatoDTO consultarPersonalFRCP02(int identificacion) throws RemoteException {
        
        System.out.println("Entrando a consultar personal FRCP02");
        
        FRCP02FormatoDTO objPacientes02=null;
        
        for (int i = 0; i < this.formatoFRCP02.size(); i++) {
            if(this.formatoFRCP02.get(i).getIDPaciente()==identificacion)
            {
                objPacientes02=this.formatoFRCP02.get(i);
                break;
            }
        }
        return objPacientes02;    
    }
    
    @Override
    public FRCP03FormatoDTO consultarPersonalFRCP03(int identificacion) throws RemoteException {
        
        System.out.println("Entrando a consultar personal FRCP03");
        
        FRCP03FormatoDTO objPacientes03=null;
        
        for (int i = 0; i < this.formatoFRCP03.size(); i++) {
            if(this.formatoFRCP03.get(i).getIDPaciente()==identificacion)
            {
                objPacientes03=this.formatoFRCP03.get(i);
                break;
            }
        }
        return objPacientes03;    
    }
    
    public String consultarReferenciaRemota(String direccionIpRMIRegistry, int numPuertoRMIRegistry) {
        System.out.println("Entrando a Consultar Referencia Remota ");
        String cadena = "Desde consultarReferenciaRemota()...";
        this.objReferenciaRemota = (GestionNotificacionesInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,
                numPuertoRMIRegistry, "ObjetoRemotoNotificacion");
        return cadena;
    }
    
    @Override
    public boolean registrarCallback(AdminCllbckInt objCllback) throws RemoteException {
        System.out.println("Entrando a registrar callback desde el servidor.");
        boolean bandera=false;
        if (!cllbckPaciente.contains(objCllback))
        {
            bandera=cllbckPaciente.add(objCllback);  
        }        
        return bandera; 
    }
    
    @Override
    public void enviarMensaje(String mensaje)throws RemoteException
    {
        System.out.println("Entrando a enviar Mensaje.");
        notificarPacientes(mensaje);
    }
    
    private void notificarPacientes(String nombreCompleto) throws RemoteException {
        
        System.out.println("Entrando a notificar Pacientes.");
        for(AdminCllbckInt objUsuario: cllbckPaciente)
        {
            objUsuario.InformarIngreso(nombreCompleto, cllbckPaciente.size());//el servidor hace el callback
            
        }
    }
}
