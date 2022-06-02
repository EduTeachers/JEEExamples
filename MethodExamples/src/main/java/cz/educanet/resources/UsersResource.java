package cz.educanet.resources;

import cz.educanet.models.User;
import cz.educanet.models.UserCreationModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    private static final List<User> userList = new ArrayList<>(Arrays.asList(
            new User("Samuel", "Kodytek"),
            new User("Martin", "Macura"),
            new User("Karel", "Nový")
    ));

    @GET
    public Response getAll() {
        return Response.ok(userList).build();
    }

    @POST
    public Response createUser(UserCreationModel newUser) {
        User user = new User(newUser.getFirstName(), newUser.getLastName());
        userList.add(user);

        return Response.ok(user).build();
    }

    @PUT
    @Path("{id}")
    // popř. @QueryParam("id")
    public Response updateUser(UserCreationModel newUser, @PathParam("id") String id) {
        User user = userList.stream().filter(i -> i.getUuid().equals(id)).findFirst().orElse(null);
        if (user == null) return Response.status(Response.Status.NOT_FOUND).build();

        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        return Response.ok(user).build();
    }

}
