package ru.ilia.rest.client;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.logging.LoggingFeature;
import ru.ilia.rest.data.Chapter;
import ru.ilia.rest.data.Document;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ILIA on 12.04.2017.
 */
public class Main {

    private static String urlService="http://localhost:9999/cxf-rest/cxf/";

    public static void main(String[] args) {

        System.out.println("getDocument");
        Document document=getDocument(0);
        document.printDocument();

        System.out.println("\n\nupdateDocument: new name OneNew");
        document.setName("OneNew");
        updateDocument(document);
        document=getDocument(0);
        document.printDocument();

        System.out.println("\n\nCreate document");
        Document document1=new Document();
        document1.getChapters().add(new Chapter(1,7,1));
        document1.getChapters().add(new Chapter(2,4,9));
        document1.setName("Two");
        createDocument(document1);

        System.out.println("\n\nAll documents");
        ArrayList<Document> documents=readAllDocuments();
        for (Document doc : documents){
            doc.printDocument();
        }

        System.out.println("\n\nDocumentShortestChapter");
        Document document2=getDocumentShortestChapter();
        document2.printDocument();

        System.out.println("\n\nDelete document");
        deleteDocument(1);

        System.out.println("\n\ngetDocumentChapters with 501");
        getDocumentChapters();
    }

    private static Document getDocument(long id){
        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(urlService).path("documents/"+id);

        Builder builder =  webTarget.request(MediaType.APPLICATION_XML);
        Response response = builder.get();

        return response.readEntity(Document.class);
    }

    private static void createDocument(Document document){
        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(urlService).path("documents");

        Builder builder=webTarget.request();
        Response response=builder.post(Entity.entity(document, MediaType.APPLICATION_JSON));

        System.out.println("Code: "+response.getStatus());
    }

    private static void updateDocument(Document document){
        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(urlService).path("documents");

        Builder builder=webTarget.request();
        Response response=builder.put(Entity.entity(document, MediaType.APPLICATION_JSON));

        System.out.println("Code: "+response.getStatus());
    }

    private static void deleteDocument(long id){
        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(urlService).path("documents/"+id);

        Builder builder =  webTarget.request();
        Response response = builder.delete();

        System.out.println("Code: "+response.getStatus());
    }

    private static ArrayList<Document> readAllDocuments(){
        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(urlService).path("documents");

        Builder builder =  webTarget.request(MediaType.APPLICATION_XML);
        Response response = builder.get();

        return response.readEntity(new GenericType<ArrayList<Document>>(){});
    }

    private static Document getDocumentShortestChapter(){
        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(urlService).path("documents/short");

        Builder builder =  webTarget.request(MediaType.APPLICATION_XML);
        Response response = builder.get();

        return response.readEntity(Document.class);
    }

    private static void getDocumentChapters() {
        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(urlService).path("documents/0/chapters");

        Builder builder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = builder.get();

        System.out.println("Code: "+response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
}
