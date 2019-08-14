package utilidades;

import java.text.DecimalFormat;

public class Formatos {
	public static String formatoInt(int valor, String formato) {
		DecimalFormat df = new DecimalFormat(formato);
		return df.format(valor);
	}
	
	public static String formatoDouble(double valor, String formato) {
		DecimalFormat df = new DecimalFormat(formato);
		return df.format(valor);
	}
}
