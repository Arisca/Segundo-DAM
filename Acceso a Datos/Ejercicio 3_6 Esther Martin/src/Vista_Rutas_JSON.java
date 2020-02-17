
import java.io.FileNotFoundException;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonException;

public class Vista_Rutas_JSON
{
	public static void main(String[] args) throws FileNotFoundException, IOException, JsonException
	{
		Vista_Rutas_JSON_Ventana ventana = new Vista_Rutas_JSON_Pantalla();
		ventana.iniciar();
	}
}
