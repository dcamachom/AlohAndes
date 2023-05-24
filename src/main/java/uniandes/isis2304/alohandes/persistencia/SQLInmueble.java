package uniandes.isis2304.alohandes.persistencia;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Inmueble;

public class SQLInmueble {

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
	
	public SQLInmueble (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarInmueble(PersistenceManager pm, long id,int costoBase, long idOperador, String estado, String tipo) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaInmueble () + "(id, costoBase, idOperador, estado, tipo) values (?, ?, ?, ?, ?)");
        q.setParameters(id, costoBase, idOperador, estado, tipo);
        return (long) q.executeUnique();
	}
	
	public long eliminarInmueblePorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaInmueble () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public Inmueble darInmueblePorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaInmueble () + " WHERE id = ?");
		q.setResultClass(Inmueble.class);
		q.setParameters(id);
		return (Inmueble) q.executeUnique();
	}
	
	public List<Inmueble> darInmuebles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaInmueble ());
		q.setResultClass(Inmueble.class);
		return (List<Inmueble>) q.executeList();
	}

	public List<Inmueble> darInmueblesDisponibles (PersistenceManager pm, String tipo, Date fechaInicio, Date fechaFin, String servicioDeseado)
	{
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
		String fInicial=formato.format(fechaInicio);
		String fFinal=formato.format(fechaFin);
		Query q = pm.newQuery(SQL, "SELECT I.* FROM (SELECT * FROM "+ pa.darTablaServicioInmueble()+" LEFT OUTER JOIN "+ 
			pa.darTablaServicio()+" ON SERVICIO=SERVICIO.ID WHERE LOWER(NOMBRE)=LOWER('"+ servicioDeseado +"')) S INNER JOIN (SELECT INMUEBLE.* FROM "+ 
			pa.darTablaInmueble() +" LEFT OUTER JOIN "+ 
			pa.darTablaReserva() + " ON RESERVA.INMUEBLE=INMUEBLE.ID WHERE (FECHAINICIO>'"+ fInicial +"' OR FECHAFIN<'"+ fFinal +"' OR FECHAINICIO IS NULL) AND TIPO ='"+ tipo +"' AND ESTADO='Habilitada')I ON S.INMUEBLE=I.ID ORDER BY S.INMUEBLE;");
		q.setResultClass(Inmueble.class);
		return (List<Inmueble>) q.executeList();
		
	}

	public long rehabilitarInmueble (PersistenceManager pm, long id)
	{
		Query q= pm.newQuery(SQL, "UPDATE "+pa.darTablaInmueble()+" SET ESTADO='Habilitada' WHERE ID=?");
		q.setParameters(id);
		return (long) q.executeUnique();  
	}
	
}
