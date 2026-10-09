package ru.perm.v.cxf.jaxrs;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MovieServer {
    public static void main(String[] args) throws InterruptedException {
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setResourceClasses(MovieService.class);
        factory.setResourceProvider(MovieService.class, new SingletonResourceProvider(new MovieService()));
        factory.setAddress("http://localhost:5000/");

        Map<Object, Object> extensionMappings = new HashMap<Object, Object>();
//        extensionMappings.put("xml", MediaType.APPLICATION_XML);
        extensionMappings.put("json", MediaType.APPLICATION_JSON);
        factory.setExtensionMappings(extensionMappings);

        List<Object> providers = new ArrayList<Object>();
//        providers.add(new JAXBElementProvider());
        providers.add(new JacksonJsonProvider());
        factory.setProviders(providers);

        factory.create();

        System.out.println("Server start");
        TimeUnit.SECONDS.sleep(50L);
        System.out.println("Server finish");
        System.exit(0);

    }
}
