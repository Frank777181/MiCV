package dad.javafx.conocimiento;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idioma extends Conocimiento {
	
	private StringProperty idioma = new SimpleStringProperty();

	public Idioma(String denominacion,String idioma) {
		super(denominacion);
		setIdioma(idioma);
		
	}

	public final StringProperty idiomaProperty() {
		return this.idioma;
	}
	

	public final String getIdioma() {
		return this.idiomaProperty().get();
	}
	

	public final void setIdioma(final String idioma) {
		this.idiomaProperty().set(idioma);
	}
	
	
	

}
