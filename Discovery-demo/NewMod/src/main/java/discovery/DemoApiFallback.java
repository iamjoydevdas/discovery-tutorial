package discovery;

import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DemoApiFallback implements FallbackFactory<IDemoAPi> {

    @Override
    public IDemoAPi create(Throwable cause) {
        return new IDemoAPi() {
            @Override
            public ResponseEntity<String> ping() {
                return new ResponseEntity<String>("Demo Module Service is down", HttpStatus.OK);
            }
        };
    }
}
