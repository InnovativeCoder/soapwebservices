package dev.jerry.soapwebservices.soap;

import jakarta.servlet.ServletRegistration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

//Enable Spring Web services
@EnableWs
//Spring Configuration
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    //MessageDispatcherServlet
        //ApplicationContext
    // url-> /ws/*

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
        //map servlet to the url; url mapping
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    // /ws/courses.wsdl
    // course-details.xsd
    @Bean(name = "courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("CoursePort");
        definition.setTargetNamespace("http://javacourses.com/courses");
        definition.setLocationUri("/ws");
        definition.setSchema(courseSchema);

        return definition;
    }

    @Bean
    public XsdSchema courseSchema(){
        return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
    }


    @Bean
    public Wss4jSecurityInterceptor securityInterceptor() {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setSecurementActions("UsernameToken");
        securityInterceptor.setSecurementUsername("user");
        securityInterceptor.setSecurementPassword("password");

        return securityInterceptor;
    }

    // Interceptors.add -> XwsSecurityInterceptor
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }
}
