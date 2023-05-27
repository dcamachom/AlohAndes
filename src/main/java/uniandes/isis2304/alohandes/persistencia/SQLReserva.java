package uniandes.isis2304.alohandes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Reserva;

public class SQLReserva {
	
	/*
	 * Constantes
	 */
	private final static String SQL = PersistenciaAlohAndes.SQL;
	
	/*
	 * Atributos
	 */
	private PersistenciaAlohAndes pa;
	
	/*
	 * Métodos
	 */
	
	public SQLReserva (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarReserva(PersistenceManager pm, long id, long cliente, long inmueble, Timestamp fechaInicio, Timestamp fechaFin, String cancelado, long reservaColectiva) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaReserva () + "(id, cliente, inmueble, fechaInicio, fechaFin, cancelado, reservaColectiva) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, cliente, inmueble, fechaInicio, fechaFin, cancelado, reservaColectiva);
        return (long) q.executeUnique();
	}
	
	public long eliminarReservaPorId(PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaReserva () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}

	public long eliminarReservaPorReservaColectiva (PersistenceManager pm, long reservaColectiva)
	{
		Query q= pm.newQuery(SQL, "UPTimestamp" + pa.darTablaReserva() + "SET CANCELADO='True' WHERE RESERVACOLECTIVA=?");
		q.setParameters(reservaColectiva);
		return (long) q.executeUnique();
	}
	
	public Reserva darReservaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaReserva () + " WHERE id = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(id);
		return (Reserva) q.executeUnique();
	}
	
	public List<Reserva> darReservas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaReserva ());
		q.setResultClass(Reserva.class);
		return (List<Reserva>) q.executeList();
	}

}
