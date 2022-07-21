package discovery.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoApiCachingService {

    @Cacheable(value = "message")
    public String getMessage() {
        System.out.println("Hey I have called before caching. I will not be called again.");
        return "Hello World";
    }
}
