package upc.edu.pe.javanet;

import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

public class PreGenerarSolicitudView extends CustomComponent implements View {

      
	public static final String NAME = "PreGenerarSolicitud";
	private final Label text = new Label();
    
	 Button logout = new Button("Logout", new Button.ClickListener() {

	        @Override
	        public void buttonClick(ClickEvent event) {

	            // "Logout" the user
	            getSession().setAttribute("user", null);

	            // Refresh this view, should redirect to login view
	            getUI().getNavigator().navigateTo("");
	        }
	    });
	    
	
	
    public PreGenerarSolicitudView() {
    	setSizeFull();
        
    	final Table table = new Table();
    	table.addStyleName("components-inside");
    	
    	table.addContainerProperty("Cliente",            Label.class,     null);
    	table.addContainerProperty("Ruc", Label.class,  null);
    	table.addContainerProperty("Respresentante Legal",       Label.class, null);
    	table.addContainerProperty("Solicitud",        Button.class,    null);

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
           	    		//getUI().getNavigator().navigateTo(PreGenerarSolicitudMainView.NAME);
           	    	    Navigator navigator = getUI().getNavigator();
		    		    navigator.addView(GenerarSolicitudView.NAME, GenerarSolicitudView.class);
		    		    //navigator.addView(PreGenerarSolicitudMainView.NAME,PreGenerarSolicitudMainView.class);
		   	        
		    		    navigator.navigateTo(GenerarSolicitudView.NAME);
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
        vlClientes.setComponentAlignment(table, Alignment.MIDDLE_CENTER);
        vlClientes.setMargin(new MarginInfo(true, true, true, true));
        vlClientes.setSizeUndefined();

        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(vlClientes);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(vlClientes, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        //setCompositionRoot(new CssLayout(text, logout, viewLayout));
        //setCompositionRoot(new CssLayout(text, viewLayout));
        
        
        
        
        VerticalLayout bienvenido = new VerticalLayout(text);
		bienvenido.setSpacing(true);
		bienvenido.setCaption(text.getValue());
	    bienvenido.setMargin(new MarginInfo(true, true, false, true));
		//bienvenido.setSizeUndefined();
	       
	    VerticalLayout salir = new VerticalLayout(logout);
	    salir.setSpacing(true);
		salir.setMargin(new MarginInfo  (true, true, true, true));
		 		   
	    /*Panel panelMenu = new Panel("");
	    panelMenu.addStyleName("mypanel");
	    panelMenu.setSizeFull();
	    panelMenu.setContent(menuPrincipal);*/
	               
	       
	   /* VerticalLayout viewLayout = new VerticalLayout(panelMenu);
		viewLayout.setSizeFull();
		viewLayout.setSpacing(true);
		viewLayout.setComponentAlignment(panelMenu, Alignment.TOP_LEFT);
		viewLayout.setMargin(new MarginInfo  (true, true, true, true));*/
		setCompositionRoot(new CssLayout(bienvenido, viewLayout, salir));
        
   }

       
   @Override
   public void enter(ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));

        // And show the username
        text.setValue("BIENVENIDO " + username);
        text.addStyleName("bienvenido"); 
        
    }


   
}