package org.openapitools.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;

@RestController
@RequestMapping("${openapi.openAPIPetstore.base-path:/}")
public class PetApiController implements PetApi {

    private final NativeWebRequest request;

    @Autowired
    public PetApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
