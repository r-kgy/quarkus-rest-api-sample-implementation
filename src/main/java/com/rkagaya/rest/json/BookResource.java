package com.rkagaya.rest.json;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    private Set<Book> list =
            Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
    public BookResource() {
        list.add(new Book(1, "name1", "description1"));
        list.add(new Book(2, "name2", "description2"));
    }

    @GET
    public Response getList() {
        return Response.ok(list).build();
    }

    @GET
    @Path(value = "/{bookId}")
    public Response get(
            @PathParam(value = "bookId") int booKId
    ) {
        System.out.println(booKId);
        List<Book> result = list.stream()
                .filter(book -> book.getId() == booKId)
                .collect(Collectors.toList());
        return Response.ok(result).build();
    }
}