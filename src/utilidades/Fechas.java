package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Fechas {
	public static java.sql.Date stringToDateSql(String fechaStr) {
		System.out.println(fechaStr);
		java.sql.Date fecha = null;
		try {
			java.util.Date parsed = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
			fecha = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {}
		return fecha;
	}
}
