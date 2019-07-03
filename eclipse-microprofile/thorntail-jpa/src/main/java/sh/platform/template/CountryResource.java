package sh.platform.template;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.status;

@Path("countries")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountryResource {

    @Inject
    private CountryService countryService;

    @GET
    public List<Country> doGet() {
        return countryService.findAll();
    }

    @GET
    @Path("{id}")
    public Country findById(@PathParam("id") Integer id) {
        final Optional<Country> conference = countryService.find(id);
        return conference.orElseThrow(this::notFound);
    }

    @PUT
    @Path("{id}")
    public Country update(@PathParam("id") Integer id, Country countryUpdated) {
        final Optional<Country> optional = countryService.find(id);
        final Country country = optional.orElseThrow(() -> notFound());
        country.update(countryUpdated);
        countryService.update(country);
        return country;
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        countryService.delete(id);
        return status(NO_CONTENT).build();
    }

    @POST
    public Country insert(Country country) {
        return countryService.insert(country);
    }

    private WebApplicationException notFound() {
        return new WebApplicationException(Response.Status.NOT_FOUND);
    }

}
