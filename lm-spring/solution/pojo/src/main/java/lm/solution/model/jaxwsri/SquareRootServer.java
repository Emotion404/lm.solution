package lm.solution.model.jaxwsri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SquareRootServer {

    @WebMethod
    double getSquareRootRI(@WebParam(name = "input") Double input);

    @WebMethod
    String getTimeRI();

}
