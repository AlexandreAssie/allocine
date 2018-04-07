package webx.huceal.controllers;

import webx.huceal.domains.Avis;
import webx.huceal.services.AvisService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/avis")
public class AvisController {

	private AvisService service = new AvisService();

	/*@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Avis> findAllAvisByFilmId(@PathParam("id") String id) {
		return dao.findAllAvisByFilmId(id);
	}*/

	@POST
	@Path("/add")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addAvis(Avis avis) {
		return service.addAvis(avis.getFilmID(), avis.getNote(), avis.getCommentaire());
	}

}
