package my.company;

import javax.inject.Inject;
import javax.ws.rs.*;
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
    private UserMapper mapper;

    @GET
    public List<UserDTO> getAll() {
        Stream<User> users = repository.findAll();
        return users.map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    public UserDTO findById(@PathParam("id") String id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(
                        () -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @POST
    public void insert(UserDTO dto) {
        User map = mapper.toEntity(dto);
        repository.save(map);
    }

    @POST
    @Path("{id}")
    public void update(@PathParam("id") String id, UserDTO dto) {
        User user = repository.findById(id).orElseThrow(() ->
                new WebApplicationException(Response.Status.NOT_FOUND));
        repository.save(mapper.toEntity(dto));
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        repository.deleteById(id);
    }
}
