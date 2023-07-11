package agenda_telefonica;

public class Contacto {

    String Telefono, Nombre, Domicilio;

    public Contacto(String Telefono, String Nombre, String Domicilio) {

        this.Telefono = Telefono;
        this.Nombre = Nombre;
        this.Domicilio = Domicilio;
    }

    public String verTelefono() {
        return Telefono;
    }

    public String verNombre() {
        return Nombre;
    }

    public String verDomicilio() {
        return Domicilio;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

}
