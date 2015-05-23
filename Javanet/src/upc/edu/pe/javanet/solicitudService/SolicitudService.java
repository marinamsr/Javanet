package upc.edu.pe.javanet.solicitudService;

//import org.apache.commons.beanutils.BeanUtils;

import java.util.*;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;

public class SolicitudService {
	
	// Create dummy data by randomly combining first and last names
	static String[] cant = { "2", "1", "3"};
	static String[] perfil = { "SEMI SENIOR", "JUNIOR", "SENIOR"};
    static String[] tecnologia = { "JAVA", "JAVA", "NET"};
    static String[] expRubro = { "BANCA", "BANCA", "GOBIERNO"};

    private static SolicitudService instance;

    public static SolicitudService createDemoService() {
        if (instance == null) {

            final SolicitudService solicitudService = new SolicitudService();

            Random r = new Random(0);
            Calendar cal = Calendar.getInstance();
            for (int i = 0; i < 100; i++) {
                SolicitudDetalle solicitud = new SolicitudDetalle();
               // solicitud.setCantidad(cant[r.nextInt(cant.length)]);
               // solicitud.setPerfil(perfil[r.nextInt(perfil.length)]);
               // solicitud.setTecnologia(tecnologia[r.nextInt(tecnologia.length)]);
               // solicitud.setExperRubro(expRubro[r.nextInt(expRubro.length)]);
                                
                solicitudService.save(solicitud);
            }
            instance = solicitudService;
        }

        return instance;
    }

    private HashMap<Long, SolicitudDetalle> solicitudes = new HashMap<Long, SolicitudDetalle>();
    private long nextId = 0;

    public synchronized List<SolicitudDetalle> findAll(String stringFilter) {
        ArrayList arrayList = new ArrayList();
        for (SolicitudDetalle solicitud : solicitudes.values()) {
            try {
                boolean passesFilter = (stringFilter == null || stringFilter
                        .isEmpty())
                        || solicitud.toString().toLowerCase()
                                .contains(stringFilter.toLowerCase());
                if (passesFilter) {
                    //arrayList.add(solicitud.clone());
                }
            } catch (Exception ex) {  
            //} catch (CloneNotSupportedException ex) {
            	ex.printStackTrace();
            	//ex.getMessage("ERROR : " + SolicitudService.class.getName());
                //Logger.getLogger(ContactService.class.getName()).log(
                //        Level.SEVERE, null, ex);
            }
        }
        Collections.sort(arrayList, new Comparator<SolicitudDetalle>() {

            @Override
            public int compare(SolicitudDetalle o1, SolicitudDetalle o2) {
                return (int) (o2.getId() - o1.getId());
            }
        });
        return arrayList;
    }

    public synchronized long count() {
        return solicitudes.size();
    }

    public synchronized void delete(SolicitudDetalle value) {
    	solicitudes.remove(value.getId());
    }

    public synchronized void save(SolicitudDetalle entry) {
        //if (entry.getId() == null) {
       //     entry.setId(nextId++);
       // }
        try {
            //entry = (Solicitud) BeanUtils.cloneBean(entry);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        //solicitudes.put(entry.getId(), entry);
    }
    
    public int grabar(Table tableDetalle) {
		ArrayList arrayList = new ArrayList();
		Solicitud solicitud = new Solicitud();
		solicitud.setId(1);
		solicitud.setCodProyecto(1);
		Notification.show("datos " + tableDetalle.getItem(1).getItemProperty(1));
		
		for(int i=0; i< tableDetalle.size(); i++){
			SolicitudDetalle solicitudDetalle = new SolicitudDetalle();
			solicitudDetalle.setId(1);
			//solicitudDetalle.setCantidad(tableDetalle.getItem(new Integer(i));
			
		}
		return 1;
	}

}
