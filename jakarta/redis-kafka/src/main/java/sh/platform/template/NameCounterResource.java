package sh.platform.template;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("names")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NameCounterResource {

    @Inject
    private NameCounter counter;

    @Inject
    private NameCounterPublisher publisher;

    @GET
    public Map<String, Long> getResult() {
        return counter.getResult();
    }

    @POST
    public void count(String name) {
        publisher.sendMessage(name);
    }

}
