package upc.edu.pe.javanet.solicitudService;

//import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.util.Date;

public class Solicitud  implements Serializable, Cloneable {
	
	private int id;

	private int codProyecto ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodProyecto() {
		return codProyecto;
	}

	public void setCodProyecto(int codProyecto) {
		this.codProyecto = codProyecto;
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
