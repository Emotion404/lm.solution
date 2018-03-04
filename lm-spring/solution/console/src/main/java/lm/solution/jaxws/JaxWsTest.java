package lm.solution.jaxws;

import lm.solution.model.jaxws.SquareRootServer;
import lm.solution.model.jaxws.SquareRootServerImpl;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class JaxWsTest {

    public void publishAndClient(){

        // publish
        SquareRootServerImpl srsi=new SquareRootServerImpl();
        Endpoint.publish("http://127.0.0.1:8082/service",srsi);

        //
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){}

        // wsdl
        System.out.println("http://127.0.0.1:8082/service?wsdl");

        // client
        try {
            //
            URL url = new URL("http://127.0.0.1:8082/service?wsdl");
            QName qName=new QName("http://jaxws.model.solution.lm/","SquareRootServerImplService");
            Service service = Service.create(url,qName);

            //
            SquareRootServer srs=service.getPort(SquareRootServer.class);
            System.out.println(srs.getTime());
            System.out.println(srs.getSquareRoot(1000D));
        }catch (MalformedURLException e){}
    }

}
