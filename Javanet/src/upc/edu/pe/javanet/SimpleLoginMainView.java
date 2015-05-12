package upc.edu.pe.javanet;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class SimpleLoginMainView extends CustomComponent implements View {

    public static final String NAME = "";
    public static final String GENERAR_SOLICITUD_NAME = "/GenerarSolicitudMainView.java";

    Label text = new Label();
    //private final Button generarSolicitudField;
    
    //getUI().getNavigator().addView(GenerarSolicitudView.NAME, GenerarSolicitudView.class);

    /*
     * Add the main view of the application
     */
    //getUI().getNavigator().addView(GenerarSolicitudMainView.NAME,
    //		GenerarSolicitudMainView.class);
    

    Button logout = new Button("Logout", new Button.ClickListener() {

        @Override
        public void buttonClick(ClickEvent event) {

            // "Logout" the user
            getSession().setAttribute("user", null);

            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
        }
    });

    public SimpleLoginMainView() {
        //setCompositionRoot(new CssLayout(text, logout));
    	
    	setSizeFull();
      
    	final Table table = new Table();
    	table.addStyleName("components-inside");
    	
    	table.addContainerProperty("Cliente",            Label.class,     null);
    	table.addContainerProperty("Ruc", Label.class,  null);
    	table.addContainerProperty("Respresentante Legal",       Label.class, null);
    	table.addContainerProperty("Solicitud",        Button.class,    null);

    	/* Add a few items in the table. */
    	for (int i=0; i<3; i++) {
    	   if(i == 0){
    		    Label clienteField = new Label("Banco de Crédito del Perú");
       	    	Label rucField = new Label("20154785481");
       	    	Label representanteLegalField = new Label("Erika Abregu");
       	      	    
           	    Integer itemId = new Integer(i);
           	    
           	  
           	    Button generarSolicitudField = new Button("Generar Solicitud");
           	    generarSolicitudField.setData(itemId);
           	    generarSolicitudField.addClickListener(new Button.ClickListener() {
           	    	
					private static final long serialVersionUID = 1L;
					
					@Override
					public void buttonClick(ClickEvent event) {
           	    		Integer iid = (Integer)event.getButton().getData();
           	    		//Notification.show("Link " + iid.intValue() + " clicked.");
           	    		getUI().getNavigator().navigateTo(GENERAR_SOLICITUD_NAME);
           	    	} 
           	    });
           	    generarSolicitudField.addStyleName("link");
       	    
           	    table.addItem(new Object[] {clienteField, rucField,
       	    		representanteLegalField, generarSolicitudField},
       	                  itemId);
    	   }
    	   
    	   if(i == 1){
   		    Label clienteField = new Label("Supermercados Tottus");
      	    	Label rucField = new Label("20584785412");
      	    	Label representanteLegalField = new Label("Mercedes Alzugaray");
      	      	    
          	    Integer itemId = new Integer(i);
      	      	   
          	    Button generarSolicitudField = new Button("Generar Solicitud");
          	    generarSolicitudField.setData(itemId);
          	    generarSolicitudField.addClickListener(new Button.ClickListener() {
          	    	public void buttonClick(ClickEvent event) {
          	    		Integer iid = (Integer)event.getButton().getData();
          	    		Notification.show("Link " +
      	                              iid.intValue() + " clicked.");
          	    	} 
          	    });
          	    generarSolicitudField.addStyleName("link");
      	    
          	    table.addItem(new Object[] {clienteField, rucField,
      	    		representanteLegalField, generarSolicitudField},
      	                  itemId);
    	   }
    	   
    	   if(i == 2){
      		    Label clienteField = new Label("Unique");
         	    	Label rucField = new Label("20876585214");
         	    	Label representanteLegalField = new Label("Eduardo Diaz");
         	      	    
             	    Integer itemId = new Integer(i);
         	      	   
             	    Button generarSolicitudField = new Button("Generar Solicitud");
             	    generarSolicitudField.setData(itemId);
             	    generarSolicitudField.addClickListener(new Button.ClickListener() {
             	    	public void buttonClick(ClickEvent event) {
             	    		Integer iid = (Integer)event.getButton().getData();
             	    		Notification.show("Link " +
         	                              iid.intValue() + " clicked.");
             	    	} 
             	    });
             	    generarSolicitudField.addStyleName("link");
         	    
             	    table.addItem(new Object[] {clienteField, rucField,
         	    		representanteLegalField, generarSolicitudField},
         	                  itemId);
       	   }
    	    
    	}


    	// Show just three rows because they are so high.
    	table.setPageLength(3);
    	

        // Add both to a panel
        VerticalLayout vlClientes = new VerticalLayout(table);
        vlClientes.setSpacing(true);
        vlClientes.setCaption("Solicitud de consultores");
        vlClientes.setSpacing(true);
        vlClientes.setMargin(new MarginInfo(true, true, true, false));
        vlClientes.setSizeUndefined();

        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(vlClientes);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(vlClientes, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setCompositionRoot(new CssLayout(text, logout, viewLayout));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));

        // And show the username
        text.setValue("Bienvenido " + username);
    }
    
    
}