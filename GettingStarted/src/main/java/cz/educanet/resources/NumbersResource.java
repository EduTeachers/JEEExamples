package cz.educanet.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("numbers")
@Produces(MediaType.APPLICATION_JSON)
public class NumbersResource {

    @GET
    public Response getNumbers() {
        List<Integer> numbers = Arrays.asList(101, 200, 301, 100);
        return Response.ok(numbers).build();
    }

    @GET
    @Path("even")
    public Response getEvenNumbers() {
        List<Integer> numbers = Stream.of(101, 200, 301, 100).filter(i -> i % 2 == 0).collect(Collectors.toList());
        return Response.ok(numbers).build();
    }

    @GET
    @Path("odd")
    public Response getOddNumbers() {
        List<Integer> numbers = Stream.of(101, 200, 301, 100).filter(i -> i % 2 == 1).collect(Collectors.toList());
        return Response.ok(numbers).build();
    }

}
