package upc.edu.pe.javanet;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;


@SuppressWarnings("serial")
@Theme("javanet")
public class LogeoUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = LogeoUI.class)
	public static class Servlet extends VaadinServlet {
	}

	 @Override
	    protected void init(VaadinRequest request) {

	       
		 
		 /*
	         * Create a new instance of the navigator. The navigator will attach
	         * itself automatically to this view.
	         */
	        new Navigator(this, this);
	          
	    
	        getNavigator().addView(SimpleLoginView.NAME, SimpleLoginView.class);
	       
	        getNavigator().addView(SimpleLoginMainView.NAME,
	                SimpleLoginMainView.class);
	        
	       
	        /*
	         * We use a view change handler to ensure the user is always redirected
	         * to the login view if the user is not logged in.
	         */
	        getNavigator().addViewChangeListener(new ViewChangeListener() {

	            @Override
	            public boolean beforeViewChange(ViewChangeEvent event) {

	                // Check if a user has logged in
	                boolean isLoggedIn = getSession().getAttribute("user") != null;
	                boolean isLoginView = event.getNewView() instanceof SimpleLoginView;
	                

	                if (!isLoggedIn && !isLoginView) {
	                    // Redirect to login view always if a user has not yet
	                    // logged in
	                    getNavigator().navigateTo(SimpleLoginView.NAME);
	                    return false;

	                } else if (isLoggedIn && isLoginView) {
	                    // If someone tries to access to login view while logged in,
	                    // then cancel
	                    return false;
	                    
	                }

	                return true;
	            }

	            @Override
	            public void afterViewChange(ViewChangeEvent event) {

	            }
	        });
	    }


}