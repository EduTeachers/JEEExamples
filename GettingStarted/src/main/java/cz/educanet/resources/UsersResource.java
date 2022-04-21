package cz.educanet.resources;

import cz.educanet.models.Gender;
import cz.educanet.models.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @GET
    public Response getUsers() {
        List<User> users = Arrays.asList(
                new User("Martin", "M.", "martin.m@gmail.com", Gender.MALE),
                new User("Karel", "K.", "karel.k@gmail.com", Gender.MALE),
                new User("Pavel", "P.", "pavel.p@gmail.com", Gender.MALE),
                new User("Lucie", "L.", "lucie.l@gmail.com", Gender.FEMALE)
        );

        return Response.ok(users).build();
    }

}
