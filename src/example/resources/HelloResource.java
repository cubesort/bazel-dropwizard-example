package example.resources;

import example.dtos.Saying;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private final String defaultName;
    private final AtomicLong idCounter;

    public HelloResource(String defaultName) {
        this.defaultName = defaultName;
        this.idCounter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        return new Saying(idCounter.incrementAndGet(), name.orElse(defaultName));
    }
}
