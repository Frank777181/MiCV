package dad.javafx.personal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nacionalidad {
	
	private StringProperty denominacion = new SimpleStringProperty();
	
	public Nacionalidad(String nacion) {
		
		setDenominacion(nacion);
		
	}

	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	

	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	

	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	
	public String toString() {
		
		return getDenominacion();
	}
	
	
	

}
