public class InvalidIDException extends Exception{

	//Clase que se encarga del manejo de ID no válida.
	//
	//Constructor vacío.
	public InvalidExceptionID(){

		super("Error: el ID es inválido.");
	
	}

	//Este constructor recibe un mensaje personalizado, fuera de eso
	//es igual al vacío, hace lo mismo.
	public InvalidIDException(String mensajeError){

		super(mensajeError);

	}

}
