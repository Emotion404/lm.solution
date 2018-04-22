package lm.solution.service.jaxws.ri;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Service("squareRootServerRI")
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SquareRootServer {

    @WebMethod
    double getSquareRootRI(@WebParam(name = "input") Double input);

    @WebMethod
    String getTimeRI();

}
