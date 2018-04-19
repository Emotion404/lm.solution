package lm.solution.service.jaxws;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Service("squareRootServerConsole")
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SquareRootServer {

    @WebMethod
    double getSquareRoot(double input);

    @WebMethod
    String getTime();

}
