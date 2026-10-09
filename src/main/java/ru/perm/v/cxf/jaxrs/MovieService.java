package ru.perm.v.cxf.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/movieservice/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieService {
    Map<Long, Movie> movies = new HashMap<>();

    public MovieService() {
        Movie c1 = new Movie(1001L, "Aquaman");
        movies.put(c1.getId(), c1);

        Movie c2 = new Movie(1002L, "Mission Imposssible");
        movies.put(c2.getId(), c2);

        Movie c3 = new Movie(1003L, "Black Panther");
        movies.put(c3.getId(), c3);

        Movie c4 = new Movie(1004L, "A Star is Born");
        movies.put(c4.getId(), c4);

        Movie c5 = new Movie(1005L, "The Meg");
        movies.put(c5.getId(), c5);
    }

    @GET
    @Path("/movie/{id}/")
    public Movie getById(@PathParam("id") String id) {
        return movies.getOrDefault(Long.valueOf(id),new Movie(0L,""));
    }
}
