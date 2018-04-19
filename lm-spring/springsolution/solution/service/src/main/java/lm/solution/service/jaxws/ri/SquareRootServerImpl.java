package lm.solution.service.jaxws.ri;


import javax.jws.WebService;
import java.util.Date;

@WebService(endpointInterface = "lm.solution.service.jaxws.ri.SquareRootServer")
public class SquareRootServerImpl implements SquareRootServer {


    @Override
    public double getSquareRootRI(Double input) {
        return Math.sqrt(input);
    }

    @Override
    public String getTimeRI() {
        Date now= new Date();
        return now.toString();
    }
}
