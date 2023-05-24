package uniandes.isis2304.alohandes.negocio;

import java.util.LinkedList;
import java.util.List;

public class Reserva implements VOReserva{
	
	/*
	 * Atributos
	 */
	
	private long id;
	private String fechaInicio;
	private String fechaFin;
	private int costoTotal;
	private long idCliente;
	private long idInmueble;
	private List<Object[]> serviciosUsados;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Método constructor por defecto
	 */
	
	public Reserva() {
		this.id=0;
		this.fechaInicio= null;
		this.fechaFin= null;
		this.costoTotal=0;
		this.idCliente=0;
		this.idInmueble=0;	
		serviciosUsados= new LinkedList<Object[]>();
	}
	
	/**
	 * Método constructor con valores
	 */
	 public Reserva(long id, String fechaInicio, String fechaFin, int costoTotal, long idCliente, long idInmueble) {
		 this.id=id;
		 this.fechaInicio=fechaInicio;
		 this.fechaFin=fechaFin;
		 this.costoTotal=costoTotal;
		 this.idCliente=idCliente;
		 this.idInmueble=idInmueble;
		 serviciosUsados= new LinkedList<Object[]>();
	 }

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}

	public String getFechaInicio() {
		return this.fechaInicio;
	}
	
	public void setFechaInicio( String fechaInicio) {
		this.fechaInicio=fechaInicio;
	}

	public String getFechaFin() {
		return this.fechaFin;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaFin=fechaFin;
	}

	public int getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}

	public long getIdCliente() {
		return this.idCliente;
	}
	
	public void setIdCliente(long idCliente) {
		this.idCliente=idCliente;
	}
	
	public long getIdInmueble() {
		return this.idInmueble;
	}
	
	public void setIdInmueble(long idInmueble) {
		this.idInmueble=idInmueble;
	}

	public List<Object[]> getServiciosUsados() {
		return serviciosUsados;
	}

	public void setServiciosUsados(List<Object[]> serviciosUsados) {
		this.serviciosUsados = serviciosUsados;
	}

	public String toString() 
	{
		return "Reserva [id=" + id + ", Fecha inicio="+ fechaInicio + ", Fecha fin="+ fechaFin + ", Costo Total="
				+ costoTotal + ", id cliente=" + idCliente+ ", id inmueble=" + idInmueble +"]";
	}
}
