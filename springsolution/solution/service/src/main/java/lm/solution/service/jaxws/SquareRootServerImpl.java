package lm.solution.service.jaxws;

import javax.jws.WebService;
import java.util.Date;

@WebService(endpointInterface = "lm.solution.service.jaxws.SquareRootServer")
public class SquareRootServerImpl implements SquareRootServer {

    @Override
    public double getSquareRoot(double input) {
        return Math.sqrt(input);
    }

    @Override
    public String getTime() {
        Date now=new Date();
        return now.toString();
    }

}
