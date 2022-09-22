package maria.pikus.consumerrabbitmq.excluded;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Component
@RequestMapping("/error-excluded-package")
@ApiIgnore
public class ErrorControllerExcludedForPackage extends BasicErrorController {

    public ErrorControllerExcludedForPackage(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        super(errorAttributes, serverProperties.getError());
    }

}