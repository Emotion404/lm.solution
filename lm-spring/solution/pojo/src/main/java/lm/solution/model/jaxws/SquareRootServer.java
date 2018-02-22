package lm.solution.model.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SquareRootServer {

    @WebMethod
    double getSquareRoot(double input);

    @WebMethod
    String getTime();

}
