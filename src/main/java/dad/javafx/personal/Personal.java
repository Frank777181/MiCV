package dad.javafx.personal;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Personal {
	
	private StringProperty dni = new SimpleStringProperty();
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty apellidos = new SimpleStringProperty();
	private StringProperty direccion = new SimpleStringProperty();
	private StringProperty codigoPostal = new SimpleStringProperty();
	private StringProperty localidad = new SimpleStringProperty();
	private ObjectProperty<LocalDate> fechaNacimiento = new SimpleObjectProperty<LocalDate>(LocalDate.now());
	private StringProperty pais = new SimpleStringProperty();
	
	private ListProperty<Nacionalidad> nacionList =  new SimpleListProperty<>(FXCollections.observableArrayList(new ArrayList<Nacionalidad>()));
	
	
	public Personal() {}
	
	public Personal(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,String direccion, String codigoPostal, String localidad,String pais, ArrayList<Nacionalidad> nacionalidades) {
		
		setDni(dni);
		setNombre(nombre);
		setApellidos(apellidos);
		setDireccion(direccion);
		setCodigoPostal(codigoPostal);
		setLocalidad(localidad);
		setPais(pais);
		this.fechaNacimiento.set(fechaNacimiento);
		this.nacionList.addAll(nacionalidades);
		
		
	}

	public final StringProperty dniProperty() {
		return this.dni;
	}
	

	public final String getDni() {
		return this.dniProperty().get();
	}
	

	public final void setDni(final String dni) {
		this.dniProperty().set(dni);
	}
	

	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	

	public final String getNombre() {
		return this.nombreProperty().get();
	}
	

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	

	public final StringProperty apellidosProperty() {
		return this.apellidos;
	}
	

	public final String getApellidos() {
		return this.apellidosProperty().get();
	}
	

	public final void setApellidos(final String apellidos) {
		this.apellidosProperty().set(apellidos);
	}
	

	public final StringProperty direccionProperty() {
		return this.direccion;
	}
	

	public final String getDireccion() {
		return this.direccionProperty().get();
	}
	

	public final void setDireccion(final String direccion) {
		this.direccionProperty().set(direccion);
	}
	

	public final StringProperty codigoPostalProperty() {
		return this.codigoPostal;
	}
	

	public final String getCodigoPostal() {
		return this.codigoPostalProperty().get();
	}
	

	public final void setCodigoPostal(final String codigoPostal) {
		this.codigoPostalProperty().set(codigoPostal);
	}
	

	public final StringProperty localidadProperty() {
		return this.localidad;
	}
	

	public final String getLocalidad() {
		return this.localidadProperty().get();
	}
	

	public final void setLocalidad(final String localidad) {
		this.localidadProperty().set(localidad);
	}
	

	public final ObjectProperty<LocalDate> fechaNacimientoProperty() {
		return this.fechaNacimiento;
	}
	

	public final LocalDate getFechaNacimiento() {
		return this.fechaNacimientoProperty().get();
	}
	

	public final void setFechaNacimiento(final LocalDate fechanacimiento) {
		this.fechaNacimientoProperty().set(fechanacimiento);
	}
	

	public final StringProperty paisProperty() {
		return this.pais;
	}
	

	public final String getPais() {
		return this.paisProperty().get();
	}
	

	public final void setPais(final String pais) {
		this.paisProperty().set(pais);
	}
	

	public final ListProperty<Nacionalidad> nacionListProperty() {
		return this.nacionList;
	}
	
	@XmlElement(name = "nacionalidades")
	public final ObservableList<Nacionalidad> getNacionList() {
		return this.nacionListProperty().get();
	}
	

	public final void setNacionList(final ObservableList<Nacionalidad> nacionList) {
		this.nacionListProperty().set(nacionList);
	}
	
	
	
	
	
}
