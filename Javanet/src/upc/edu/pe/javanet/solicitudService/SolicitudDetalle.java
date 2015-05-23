package upc.edu.pe.javanet.solicitudService;

//import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.util.Date;

public class SolicitudDetalle  implements Serializable, Cloneable {
	
	private int id;

	private int cantidad ;
    private int perfil;
    private int tecnologia;
    private int experRubro;
    private String comentario="";
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPerfil() {
		return perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	public int getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(int tecnologia) {
		this.tecnologia = tecnologia;
	}
	public int getExperRubro() {
		return experRubro;
	}
	public void setExperRubro(int experRubro) {
		this.experRubro = experRubro;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

        

   /* @Override
    public Contact clone() throws CloneNotSupportedException {
        try {
            return (Contact) BeanUtils.cloneBean(this);
        } catch (Exception ex) {
            throw new CloneNotSupportedException();
        }
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", phone=" + phone + ", email="
                + email + ", birthDate=" + birthDate + '}';
    }*/

	
	
}
