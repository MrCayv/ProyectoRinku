package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	public static String getPrimerDiaMes(int mes, int year) {
		return year + "-" + Formatos.formatoInt(mes, "00") + "-01 00:00";
	}
	
	public static String getUltimoDiaMes(int mes, int year) {
		Date date = new Date();
		date.setMonth(mes-1);
		date.setYear(year-1900);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dia = cal.getActualMaximum(Calendar.DATE);
		
		return year + "-" + Formatos.formatoInt(mes, "00") + "-" + Formatos.formatoInt(dia, "00") + " 23:59";
	}
}
