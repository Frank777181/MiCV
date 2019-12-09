package dad.javafx.conocimiento;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conocimiento {
	
	public enum Nivel {BASICO,MEDIO,AVANZADO}
	
	private StringProperty denominacion = new SimpleStringProperty();
	
	public Conocimiento (String denominacion) {
		
		setDenominacion(denominacion);
		
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

}
