package discovery;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "demo-module", fallbackFactory = DemoApiFallback.class)
public interface IDemoAPi {

    @RequestMapping(value="/ping", method = RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> ping();
}
