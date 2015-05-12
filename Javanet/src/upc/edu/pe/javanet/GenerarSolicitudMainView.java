package upc.edu.pe.javanet;

import com.vaadin.navigator.View;
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
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextArea;

public class GenerarSolicitudMainView extends CustomComponent implements View {

    public static final String NAME = "";

    Label text = new Label();

    Button logout = new Button("Logout", new Button.ClickListener() {

        @Override
        public void buttonClick(ClickEvent event) {

            // "Logout" the user
            getSession().setAttribute("user", null);

            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
        }
    });

    public GenerarSolicitudMainView() {
       
    	setSizeFull();
    	
    	
    	//VerticalLayout frmSolColabPadre = new VerticalLayout();
		//frmSolColabPadre.setWidth("100%"); 
		//frmSolColabPadre.setMargin(true);
		
		
		//HorizontalLayout frmTitulo = new HorizontalLayout();
		//frmTitulo.setWidth("600px"); // Default
		//frmTitulo.setMargin(true);
		
		VerticalLayout frmDatosCliente = new VerticalLayout();
		frmDatosCliente.setWidth("600px"); // Default
		frmDatosCliente.setMargin(true);
		
		VerticalLayout frmSolicitudConsultores = new VerticalLayout();
		//frmSolicitudConsultores.setSizeUndefined();
		frmSolicitudConsultores.setWidth("600px"); // Default
		frmSolicitudConsultores.setMargin(true);
		
		HorizontalLayout frmSolConBotones = new HorizontalLayout();
		frmSolConBotones.setWidth("600px"); // Default
		frmSolConBotones.setMargin(true);
		
		HorizontalLayout frmMsgError = new HorizontalLayout();
		frmMsgError.setWidth("600px"); // Default
		frmMsgError.setMargin(true);
		
		
		//Label lblTitulo = new Label("Solicitud de Consultores");
		//lblTitulo.setWidth("600px");
		//Panel panelTitulo = new Panel(lblTitulo);
		//panelTitulo.setWidth("670px");
		//panelTitulo.setReadOnly(true);
		//panelTitulo.setEnabled(false);
		//frmTitulo.addComponent(panelTitulo);
		//frmTitulo.setComponentAlignment(panelTitulo, Alignment.MIDDLE_CENTER);
		
		//setContent(frmTitulo);
		
		HorizontalLayout hlCliente = new HorizontalLayout();
		hlCliente.setWidth("100%");
		Label lblCliente = new Label("Cliente");
		lblCliente.setWidth("100%");
		TextField txtNombreCliente = new TextField("");
		txtNombreCliente.setValue("Banco de Credito del Perú");
		txtNombreCliente.setReadOnly(true);
		txtNombreCliente.setWidth("400px");
		hlCliente.addComponent(lblCliente);
		hlCliente.addComponent(txtNombreCliente);
		hlCliente.setComponentAlignment(lblCliente, Alignment.MIDDLE_RIGHT);
		hlCliente.setComponentAlignment(txtNombreCliente, Alignment.MIDDLE_LEFT);
		frmDatosCliente.addComponent(hlCliente);
		frmDatosCliente.setComponentAlignment(hlCliente, Alignment.MIDDLE_CENTER);
		//frmDatosCliente.addComponent(txtNombreCliente);
		
		HorizontalLayout hlProyecto = new HorizontalLayout();
		hlProyecto.setWidth("100%");
		Label lblProyecto = new Label("Nombre Proyecto");
		lblProyecto.setWidth("100%");
		final ComboBox cmbProyecto = new ComboBox("");
		//cmbProyecto.setInvalidAllowed(false);
		cmbProyecto.setNullSelectionAllowed(true);
		cmbProyecto.addItem("-SELECCIONE-");
		cmbProyecto.setNullSelectionItemId("-SELECCIONE-");
        
		cmbProyecto.addItem("Proyecto Home Banking");
		cmbProyecto.addItem("Proyecto Compra Virtual");
		cmbProyecto.addItem("Proyecto Televentas");
		cmbProyecto.setWidth("400px");
		cmbProyecto.setImmediate(true);
		
		HorizontalLayout hlProyectoMsg = new HorizontalLayout();
		hlProyectoMsg.setWidth("100%");
		
		//new Notification("Seleccione un proyecto!",,Type.).show(Page.getCurrent());
		
		
		final Label lblProyectoMsgError = new Label("Seleccione un proyecto!");
		lblProyectoMsgError.setVisible(false);
		lblProyectoMsgError.setWidth("100%");
		hlProyectoMsg.addComponent(new Label(""));
		hlProyectoMsg.addComponent(lblProyectoMsgError);
		hlProyectoMsg.setComponentAlignment(lblProyectoMsgError, Alignment.MIDDLE_LEFT);
		
		hlProyecto.addComponent(lblProyecto);
		hlProyecto.addComponent(cmbProyecto);
		//hlProyecto.addComponent(lblProyectoMsgError);
		hlProyecto.setComponentAlignment(lblProyecto, Alignment.MIDDLE_RIGHT);
		hlProyecto.setComponentAlignment(cmbProyecto, Alignment.MIDDLE_LEFT);
		//hlProyecto.setComponentAlignment(lblProyectoMsgError, Alignment.MIDDLE_LEFT);
		frmDatosCliente.addComponent(hlProyecto);
		frmDatosCliente.setComponentAlignment(hlProyecto, Alignment.MIDDLE_CENTER);
		frmDatosCliente.addComponent(hlProyectoMsg);
		frmDatosCliente.setComponentAlignment(hlProyectoMsg, Alignment.MIDDLE_CENTER);
		//frmDatosCliente.addComponent(cmbProyecto);
		
		
		//setContent(frmDatosCliente);
		
		HorizontalLayout hlCantidadColaboradores = new HorizontalLayout();
		hlCantidadColaboradores.setWidth("100%");
		Label lblCantidadColaboradores = new Label("Cantidad de Colaboradores");
		lblCantidadColaboradores.setWidth("100%");
		//frmSolicitudConsultores.addComponent(lblCantidadColaboradores);
		
		// combobox para cantidad de colaboradores
		final ComboBox cmbCantColab = new ComboBox("");
		cmbCantColab.setWidth("100%");
		cmbCantColab.addItem("1");
		cmbCantColab.addItem("2");
		cmbCantColab.addItem("3");
		cmbCantColab.addItem("4");
		cmbCantColab.addItem("5");
		cmbCantColab.addItem("6");
		
		HorizontalLayout hlCantColabMsg = new HorizontalLayout();
		hlCantColabMsg.setWidth("100%");
		
		final Label lblCantColabMsgError = new Label("Seleccione cantidad de colaboradores!");
		lblCantColabMsgError.setVisible(false);
		lblCantColabMsgError.setWidth("100%");
		
		hlCantColabMsg.addComponent(new Label(""));
		hlCantColabMsg.addComponent(lblCantColabMsgError);
		hlCantColabMsg.setComponentAlignment(lblCantColabMsgError, Alignment.MIDDLE_LEFT);
		
		hlCantidadColaboradores.addComponent(lblCantidadColaboradores);
		hlCantidadColaboradores.addComponent(cmbCantColab);
		//hlCantidadColaboradores.addComponent(lblCantColabMsgError);
		hlCantidadColaboradores.setComponentAlignment(lblCantidadColaboradores, Alignment.MIDDLE_RIGHT);
		hlCantidadColaboradores.setComponentAlignment(cmbCantColab, Alignment.MIDDLE_LEFT);
		//hlCantidadColaboradores.setComponentAlignment(lblCantColabMsgError, Alignment.MIDDLE_LEFT);
		frmSolicitudConsultores.addComponent(hlCantidadColaboradores);
		frmSolicitudConsultores.setComponentAlignment(hlCantidadColaboradores, Alignment.MIDDLE_CENTER);
		frmSolicitudConsultores.addComponent(hlCantColabMsg);
		frmSolicitudConsultores.setComponentAlignment(hlCantColabMsg, Alignment.MIDDLE_CENTER);
		
		HorizontalLayout hlPerfilColaborador = new HorizontalLayout();
		hlPerfilColaborador.setWidth("100%");
		Label lblPerfilColaborador = new Label("Perfil de Colaborador");
		lblPerfilColaborador.setWidth("100%");
		// combobox para perfil
		final ComboBox cmbPerfil = new ComboBox("");
		cmbPerfil.addItem("Junior");
		cmbPerfil.addItem("Semi Senior");
		cmbPerfil.addItem("Senior");
		
		
		HorizontalLayout hlPerfilMsg = new HorizontalLayout();
		hlPerfilMsg.setWidth("100%");
		
		final Label lblPerfilMsgError = new Label("Seleccione un perfil de colaborador!");
		lblPerfilMsgError.setVisible(false);
		lblPerfilMsgError.setWidth("100%");
		
		hlPerfilMsg.addComponent(new Label(""));
		hlPerfilMsg.addComponent(lblPerfilMsgError);
		hlPerfilMsg.setComponentAlignment(lblPerfilMsgError, Alignment.MIDDLE_LEFT);
		
		
		hlPerfilColaborador.addComponent(lblPerfilColaborador);
		hlPerfilColaborador.addComponent(cmbPerfil);
		//hlPerfilColaborador.addComponent(lblPerfilMsgError);
		hlPerfilColaborador.setComponentAlignment(lblPerfilColaborador, Alignment.MIDDLE_RIGHT);
		hlPerfilColaborador.setComponentAlignment(cmbPerfil, Alignment.MIDDLE_LEFT);
		//hlPerfilColaborador.setComponentAlignment(lblPerfilMsgError, Alignment.MIDDLE_LEFT);
		frmSolicitudConsultores.addComponent(hlPerfilColaborador);
		frmSolicitudConsultores.setComponentAlignment(hlPerfilColaborador, Alignment.MIDDLE_CENTER);
		frmSolicitudConsultores.addComponent(hlPerfilMsg);
		frmSolicitudConsultores.setComponentAlignment(hlPerfilMsg, Alignment.MIDDLE_CENTER);
		
		
		HorizontalLayout hlTecnologia = new HorizontalLayout();
		hlTecnologia.setWidth("100%");
		Label lblTecnologia = new Label("Tecnología");
		hlTecnologia.setWidth("100%");
		// combobox para perfil
		final ComboBox cmbTecnologia = new ComboBox("");
		cmbTecnologia.addItem("JAVA");
		cmbTecnologia.addItem("NET");
		cmbTecnologia.addItem("PHP");
		
		HorizontalLayout hlTecnologiaMsg = new HorizontalLayout();
		hlTecnologiaMsg.setWidth("100%");
		
		final Label lblTecnologiaMsgError = new Label("Seleccione una tecnología!");
		lblTecnologiaMsgError.setVisible(false);
		lblTecnologiaMsgError.setWidth("100%");
		
		hlTecnologiaMsg.addComponent(new Label(""));
		hlTecnologiaMsg.addComponent(lblTecnologiaMsgError);
		hlTecnologiaMsg.setComponentAlignment(lblTecnologiaMsgError, Alignment.MIDDLE_LEFT);
		
		
		hlTecnologia.addComponent(lblTecnologia);
		hlTecnologia.addComponent(cmbTecnologia);
		//hlTecnologia.addComponent(lblTecnologiaMsgError);
		hlTecnologia.setComponentAlignment(lblTecnologia, Alignment.MIDDLE_RIGHT);
		hlTecnologia.setComponentAlignment(cmbTecnologia, Alignment.MIDDLE_LEFT);
		//hlTecnologia.setComponentAlignment(lblTecnologiaMsgError, Alignment.MIDDLE_LEFT);
		frmSolicitudConsultores.addComponent(hlTecnologia);
		frmSolicitudConsultores.setComponentAlignment(hlTecnologia, Alignment.MIDDLE_CENTER);
		frmSolicitudConsultores.addComponent(hlTecnologiaMsg);
		frmSolicitudConsultores.setComponentAlignment(hlTecnologiaMsg, Alignment.MIDDLE_CENTER);
		
		
		HorizontalLayout hlExperienciaRubro = new HorizontalLayout();
		hlExperienciaRubro.setWidth("100%");
		Label lblExperienciaRubro = new Label("Experiencia en rubro");
		lblExperienciaRubro.setWidth("100%");
		// combobox para perfil
		final ComboBox cmbExperRubro = new ComboBox("");
		cmbExperRubro.addItem("Financiero");
		cmbExperRubro.addItem("Gobierno");
		cmbExperRubro.addItem("Mineria");
		
		HorizontalLayout hlExperienciaRubroMsg = new HorizontalLayout();
		hlExperienciaRubroMsg.setWidth("100%");
		
		final Label lblExperienciaRubroMsgError = new Label("Seleccione rubro de la experiencia!");
		lblExperienciaRubroMsgError.setVisible(false);
		lblExperienciaRubroMsgError.setWidth("100%");
		
		hlExperienciaRubroMsg.addComponent(new Label(""));
		hlExperienciaRubroMsg.addComponent(lblExperienciaRubroMsgError);
		hlExperienciaRubroMsg.setComponentAlignment(lblExperienciaRubroMsgError, Alignment.MIDDLE_LEFT);
		
		
		hlExperienciaRubro.addComponent(lblExperienciaRubro);
		hlExperienciaRubro.addComponent(cmbExperRubro);
		//hlExperienciaRubro.addComponent(lblExperienciaRubroMsgError);
		hlExperienciaRubro.setComponentAlignment(lblExperienciaRubro, Alignment.MIDDLE_RIGHT);
		hlExperienciaRubro.setComponentAlignment(cmbExperRubro, Alignment.MIDDLE_LEFT);
		//hlExperienciaRubro.setComponentAlignment(lblExperienciaRubroMsgError, Alignment.MIDDLE_LEFT);
		frmSolicitudConsultores.addComponent(hlExperienciaRubro);
		frmSolicitudConsultores.setComponentAlignment(hlExperienciaRubro, Alignment.MIDDLE_CENTER);
		frmSolicitudConsultores.addComponent(hlExperienciaRubroMsg);
		frmSolicitudConsultores.setComponentAlignment(hlExperienciaRubroMsg, Alignment.MIDDLE_CENTER);
		//frmSolicitudConsultores.addComponent(cmxExperRubro);
		
		
		HorizontalLayout hlComentario = new HorizontalLayout();
		hlComentario.setWidth("100%");
		Label lblComentario = new Label("Comentario");
		lblComentario.setWidth("100%");
		final TextArea txtComentario = new TextArea("");
		txtComentario.setWidth("400px");
		hlComentario.addComponent(lblComentario);
		hlComentario.addComponent(txtComentario);
		hlComentario.setComponentAlignment(lblComentario, Alignment.MIDDLE_RIGHT);
		hlComentario.setComponentAlignment(txtComentario, Alignment.MIDDLE_LEFT);
		frmSolicitudConsultores.addComponent(hlComentario);
		frmSolicitudConsultores.setComponentAlignment(hlComentario, Alignment.MIDDLE_CENTER);
		
		//frmSolicitudConsultores.addComponent(area);
		
		
		//setContent(frmSolicitudConsultores);
		final Label lblMsgError = new Label("La Solicitud se creó con éxito");
		lblMsgError.setWidth("100%");
		lblMsgError.setVisible(false);
		
		Button btnAceptar = new Button("Aceptar");
		//frmSolicitarConsultor.addComponent(btnAceptar);

		btnAceptar.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		        //Notification.show("La cotización se creó con éxito");
		    	int verifica = 0;
		    	if( cmbProyecto.getNullSelectionItemId() ==  ("-SELECCIONE-")){
		    		lblProyectoMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblProyectoMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbCantColab.isNullSelectionAllowed()){
		    		lblCantColabMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblCantColabMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbPerfil.isNullSelectionAllowed()){
		    		lblPerfilMsgError.setVisible(true);
		    		verifica++;
		    		lblMsgError.setVisible(false);
		    	}else{
		    		lblPerfilMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbTecnologia.isNullSelectionAllowed()){
		    		lblTecnologiaMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblTecnologiaMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbExperRubro.isNullSelectionAllowed()){
		    		lblExperienciaRubroMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblExperienciaRubroMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(verifica == 0){
		    		lblMsgError.setVisible(true);
		    	}else{
		    		lblMsgError.setVisible(false);
		    	}
		    	
		    }
		});
		
		Button btnCancelar = new Button("Cancelar");
		//frmSolicitarConsultor.addComponent(btnCancelar);

		btnCancelar.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	cmbProyecto.select(null);
		    	cmbCantColab.select(null);
		    	cmbPerfil.select(null);
		    	cmbTecnologia.select(null);
		    	cmbExperRubro.select(null);
		    	txtComentario.setValue("");
		    	lblProyectoMsgError.setVisible(false);
		    	lblCantColabMsgError.setVisible(false);
		    	lblPerfilMsgError.setVisible(false);
		    	lblTecnologiaMsgError.setVisible(false);
		    	lblExperienciaRubroMsgError.setVisible(false);
		    	lblMsgError.setVisible(false);
		    }
		});
		
		//HorizontalLayout fittingLayout = new HorizontalLayout();
		//fittingLayout.setWidth(Sizeable.SIZE_UNDEFINED, 0); // Default
		frmSolConBotones.setWidth("600px");
		frmSolConBotones.addComponent(btnAceptar);
		frmSolConBotones.addComponent(btnCancelar);
		frmMsgError.addComponent(lblMsgError);
		//fittingLayout.addComponent(new Button("Quite a big component"));
		//frmSolicitarConsultor.addComponent(fittingLayout);

		// Set the second field straing to error state with a message.
		//tf2.setComponentError(new UserError("This is the error indicator of a Field."));
		
		//frmSolColabPadre.addComponent(frmTitulo);
		//frmSolColabPadre.setComponentAlignment(frmTitulo, Alignment.MIDDLE_LEFT);
		//frmSolColabPadre.addComponent(frmDatosCliente);
		//frmSolColabPadre.addComponent(frmSolicitudConsultores);
		//frmSolColabPadre.addComponent(frmSolConBotones);
		//frmSolColabPadre.addComponent(frmMsgError);
		//frmSolColabPadre.setComponentAlignment(frmSolConBotones, Alignment.MIDDLE_CENTER);
		//setContent(frmSolColabPadre);

    	
    	
		VerticalLayout frmSolColabPadre = new VerticalLayout(frmDatosCliente,frmSolicitudConsultores, frmSolConBotones, frmMsgError);
		frmSolColabPadre.setSpacing(true);
		frmSolColabPadre.setCaption("Solicitud de consultores");
		frmSolColabPadre.setSpacing(true);
		frmSolColabPadre.setMargin(new MarginInfo(true, true, true, false));
		frmSolColabPadre.setSizeUndefined();

        VerticalLayout viewLayout = new VerticalLayout(frmSolColabPadre);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(frmSolColabPadre, Alignment.MIDDLE_CENTER);
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