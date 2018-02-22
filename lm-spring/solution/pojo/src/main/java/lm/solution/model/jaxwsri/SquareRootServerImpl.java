package lm.solution.model.jaxwsri;


import javax.jws.WebService;
import java.util.Date;

@WebService(endpointInterface = "lm.solution.model.jaxwsri.SquareRootServer")
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
