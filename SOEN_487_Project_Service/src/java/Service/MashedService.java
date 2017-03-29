/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.MashedNode;
import Entities.Tweet;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * REST Web Service
 *
 * @author Mouad
 */
@Path("mashedservice")
public class MashedService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public MashedService() {
    }

    /**
     * Retrieves representation of an instance of Entities.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{twitter}/{spofity}")

    public MashedNode getJson(@PathParam("twitter") String twitter,
                          @PathParam("spotify") String spotify) {
        //TODO return proper representation object
        MashedNode mn = new MashedNode();
        mn.LoadData(twitter , spotify);
        System.out.println(mn.twiits.username);
        
        return mn;
        //throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update")
    public MashedNode putJson(postdata) {
        MashedNode mn = new MashedNode();
        mn.UpdateData(postdata.authUrl[0], postdata.status[0]);
        
        return mn;
    }
}
