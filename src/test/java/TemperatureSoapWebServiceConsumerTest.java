import org.imt.nordeurope.j2ee.webservices.nickler.client.TemperatureSoapWebService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class TemperatureSoapWebServiceConsumerTest {
    @Test
    public void getTemperatureTest1() throws Exception {
        URL url = new URL("http://localhost:9000/TemperatureSoapWebService?wsdl");
        QName qname = new QName("http://nickler.webservices.j2ee.nordeurope.imt.org/", "TemperatureSoapWebService");
        Service service = Service.create(url, qname);
        TemperatureSoapWebService temperatureSoapWebService = service.getPort(TemperatureSoapWebService.class);

        XMLGregorianCalendar today = DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString());

        Integer temperature = temperatureSoapWebService.getTemperature("France", today);
        Assertions.assertEquals(1, temperature);
        System.out.println("TEMPERATURE_SOAP_CLIENT : Response from Server : getTemperature");
    }
}
