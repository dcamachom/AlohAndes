package uniandes.isis2304.alohandes.negocio;

import java.util.Date;
import java.util.List;

public interface VOReserva {

	/*
	 * Métodos
	 */
	public long getId();	

	public long getIdCliente();

	public long getIdInmueble();
	
	public Date getFechaInicio();
	
	public Date getFechaFin();
	
	public String getCancelado();

	public long getReservaColectiva();
	
	public List<Object[]> getServiciosUsados();
	
	public String toString();
}
