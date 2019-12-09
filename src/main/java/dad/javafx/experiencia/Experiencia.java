package dad.javafx.experiencia;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Experiencia {
	
	private StringProperty desde = new SimpleStringProperty();
	private StringProperty hasta = new SimpleStringProperty();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty empleador = new SimpleStringProperty();

	
	public Experiencia(String desde,String hasta,String denominacion,String empleador) {
		
		setDesde(desde);
		setHasta(hasta);
		setDenominacion(denominacion);
		setEmpleador(empleador);
		
	}


	public final StringProperty desdeProperty() {
		return this.desde;
	}
	


	public final String getDesde() {
		return this.desdeProperty().get();
	}
	


	public final void setDesde(final String desde) {
		this.desdeProperty().set(desde);
	}
	


	public final StringProperty hastaProperty() {
		return this.hasta;
	}
	


	public final String getHasta() {
		return this.hastaProperty().get();
	}
	


	public final void setHasta(final String hasta) {
		this.hastaProperty().set(hasta);
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
	


	public final StringProperty empleadorProperty() {
		return this.empleador;
	}
	


	public final String getEmpleador() {
		return this.empleadorProperty().get();
	}
	


	public final void setEmpleador(final String empleador) {
		this.empleadorProperty().set(empleador);
	}
	
	
	
}
