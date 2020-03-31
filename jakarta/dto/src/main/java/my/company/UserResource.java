package my.company;

import org.modelmapper.ModelMapper;

import javax.inject.Inject;
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
import java.util.stream.Stream;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserRepository repository;

    @Inject
    private ModelMapper mapper;

    @GET
    public List<UserDTO> getAll() {
        Stream<User> users = repository.findAll();
        return users.map(u -> mapper.map(u, UserDTO.class))
                .collect(Collectors.toList());
    }

    @POST
    public void insert(UserDTO dto) {
        User map = mapper.map(dto, User.class);
        repository.save(map);

    }

    @POST
    @Path("id")
    public void update(@PathParam("id") String id, UserDTO dto) {
        User user = repository.findById(id).orElseThrow(() ->
                new WebApplicationException(Response.Status.NOT_FOUND));
        User map = mapper.map(dto, User.class);
        user.update(map);
        repository.save(map);
    }

    @DELETE
    @Path("id")
    public void delete(@PathParam("id") String id) {
       repository.deleteById(id);
    }
}
