package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private int codigo;
    private String nombrePaciente;
    private long cedulaPaciente;
    private long telefonoPaciente;
    private String nombreMedico;
    private String especialidadMedico;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivoConsulta;
    private String estado;

    public Cita(int codigo, String nombrePaciente, long cedulaPaciente, long telefonoPaciente, String nombreMedico, String especialidadMedico, LocalDate fecha, LocalTime hora, String motivoConsulta, String estado) {

        setCodigo(codigo);
        setNombrePaciente(nombrePaciente);
        setCedulaPaciente(cedulaPaciente);
        setTelefonoPaciente(telefonoPaciente);
        setNombreMedico(nombreMedico);
        setEspecialidadMedico(especialidadMedico);
        setFecha(fecha);
        setHora(hora);
        setMotivoConsulta(motivoConsulta);
        setEstado(estado);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public long getCedulaPaciente() {
        return cedulaPaciente;
    }

    public long getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public String getEspecialidadMedico() {
        return especialidadMedico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setCedulaPaciente(long cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public void setTelefonoPaciente(long telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public void setEspecialidadMedico(String especialidadMedico) {
        this.especialidadMedico = especialidadMedico;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }  
}