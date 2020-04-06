package sh.platform.template;

import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("trips")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TripResource {

    @Inject
    private TripRepository repository;

    @Inject
    private ModelMapper mapper;

    @GET
    public List<TripDTO> findAll() {
        return repository.findAll()
                .map(t -> mapper.map(t, TripDTO.class))
                .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    public TripDTO findById(@PathParam("id") String id) {
        return repository.findById(id)
                .map(d -> mapper.map(d, TripDTO.class))
                .orElseThrow(
                        () -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @POST
    public TripDTO insert(@Valid TripDTO tripDTO) {
        final Trip trip = mapper.map(tripDTO, Trip.class);
        return mapper.map(repository.save(trip), TripDTO.class);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") String id) {
        repository.deleteById(id);
    }

}
