package ru.ilia.rest.webservice;

import ru.ilia.rest.data.Chapter;
import ru.ilia.rest.data.Document;
import ru.ilia.rest.exception.NotImplementedException;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by ILIA on 11.04.2017.
 */
@Path("/documents/")
public interface DocumentService {


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    void create(Document document);

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    Document read(@PathParam("id") long id);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    void update(Document document);

    @DELETE
    @Path("{id}")
    void delete(@PathParam("id") long id);

    @GET
    @Produces({MediaType.APPLICATION_XML})
    Collection<Document> readAll();

    @GET
    @Path("/short")
    @Produces({MediaType.APPLICATION_XML})
    Document getDocumentShortestChapter();

    @GET
    @Path("{id}/chapters")
    @Produces({MediaType.APPLICATION_XML})
    Collection<Chapter> getDocumentChapters() throws NotImplementedException;

}
