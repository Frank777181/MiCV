package dad.javafx.formacion;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Titulo {
	
	private ObjectProperty<LocalDate> desde = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<LocalDate> hasta = new SimpleObjectProperty<LocalDate>();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty organizador = new SimpleStringProperty();
	
	public Titulo(LocalDate desde,LocalDate hasta,String denominacion,String organizador) {
		
		this.desde.set(desde);
		this.hasta.set(hasta);
		this.denominacion.set(denominacion);
		this.organizador.set(organizador);
		
	}
	
	
	
	
	
	
}
