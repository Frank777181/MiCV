package dad.javafx.contacto;

import java.util.ArrayList;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Telefono {
	
	public enum TipoTelefono { DOMICILIO,MOVIL};
	
	private StringProperty telefono = new SimpleStringProperty();
	private ObjectProperty<TipoTelefono> tipo = new SimpleObjectProperty<>();

	
	public Telefono (String telefono,TipoTelefono tipo) {
		
		this.telefono.set(telefono);
		this.tipo.set(tipo);
		
	}

	public final StringProperty telefonoProperty() {
		return this.telefono;
	}
	

	public final String getTelefono() {
		return this.telefonoProperty().get();
	}
	

	public final void setTelefono(final String telefono) {
		this.telefonoProperty().set(telefono);
	}

	public final ObjectProperty<TipoTelefono> tipoProperty() {
		return this.tipo;
	}
	

	public final TipoTelefono getTipo() {
		return this.tipoProperty().get();
	}
	

	public final void setTipo(final TipoTelefono tipo) {
		this.tipoProperty().set(tipo);
	}
	
	public static ObservableList<TipoTelefono> obtenerTipoTelefonos() {
		
		ObservableList<TipoTelefono> type = FXCollections.observableArrayList(new ArrayList<>());
		type.add(TipoTelefono.DOMICILIO);
		type.add(TipoTelefono.MOVIL);
		
		return type;
		
	}
	

}
