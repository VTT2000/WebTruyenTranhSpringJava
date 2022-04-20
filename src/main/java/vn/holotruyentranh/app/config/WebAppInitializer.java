package vn.holotruyentranh.app.config;
/*
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;*/
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(WebMvcConfig.class);
          
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    
        
        servletContext.addListener(new ContextLoaderListener(appContext));
        //addSitemeshFilterToServletContext(servletContext);    
    }
    /*
    private void addSitemeshFilterToServletContext(ServletContext servletContext) {
        FilterRegistration.Dynamic sitemesh = servletContext.addFilter("sitemesh", new MySitemeshFilter());    
        EnumSet<DispatcherType> sitemeshDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        sitemesh.addMappingForUrlPatterns(sitemeshDispatcherTypes, true, "/*");
    }
    
    public class MySitemeshFilter extends ConfigurableSiteMeshFilter {	 
        @Override
        protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
            builder.addDecoratorPath("/*", "/decorators/decorator.html").addExcludedPath("/excluded/*")
                    .addExcludedPath("/resources/*").addExcludedPath("/decorators/*");
        }
    }
    */
}
