package modelo;

import java.sql.Date;
import java.time.LocalDateTime;

public class Inasistencia {
	private int idInasistencia;
	private	int idDocente;
	private int ciPersona;
	private String gruposAfectados;
	private	String motivoInasistencia;
	private Date fechaRegistro;
	
	
	public Inasistencia() {
		super();
	}
	public int getIdInasistencia() {
		return idInasistencia;
	}
	public void setIdInasistencia(int idInasistencia) {
		this.idInasistencia = idInasistencia;
	}
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public int getCiPersona() {
		return ciPersona;
	}
	public void setCiPersona(int ciPersona) {
		this.ciPersona = ciPersona;
	}
	public String getGruposAfectados() {
		return gruposAfectados;
	}
	public void setGruposAfectados(String gruposAfectados) {
		this.gruposAfectados = gruposAfectados;
	}
	public String getMotivoInasistencia() {
		return motivoInasistencia;
	}
	public void setMotivoInasistencia(String motivoInasistencia) {
		this.motivoInasistencia = motivoInasistencia;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
}
