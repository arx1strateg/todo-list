package com.bohush.config;

import com.bohush.filter.RequestLoggingFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Date 07/16/2019.
 *
 * @author Raman_Bohush
 */
public class ApplicationInitializer extends AbstractDispatcherServletInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        servletContext.addFilter("requestLoggingFilter", RequestLoggingFilter.class)
                .addMappingForServletNames(null, false, "dispatcher");
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext rootApplicationContext = new AnnotationConfigWebApplicationContext();
        rootApplicationContext.register(DaoContext.class, ServiceContext.class);

        return rootApplicationContext;
    }

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(MvcConfig.class);

        return webCtx;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
