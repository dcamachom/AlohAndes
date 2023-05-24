package uniandes.isis2304.alohandes.negocio;

import java.util.List;

public interface VOReserva {

	/*
	 * Métodos
	 */
	public long getId();	
	
	public String getFechaInicio();
	
	public String getFechaFin();
	
	public int getCostoTotal();
	
	public long getIdCliente();
	
	public long getIdInmueble();
	
	public List<Object[]> getServiciosUsados();
	
	public String toString();
}
