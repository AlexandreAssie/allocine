package webx.huceal.controllers;

import webx.huceal.domains.Avis;
import webx.huceal.services.AvisService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Contrôle l'accès aux Avis.
 *
 * /{id} - Récupère un avis via son identifiant
 * /film/{id} - Récupère tous les avis d'un film via son identifiant
 * /add - Ajoute un commentaire à la base de données (note, commentaire)
 * /delete - Supprime les commentaires qui contiennent le mot-clé donné
 *
 */
@Path("/avis")
@Produces({ MediaType.APPLICATION_JSON })
public class AvisController {

    /**
     * Service des Avis.
     */
    private AvisService service = new AvisService();

    /**
     * Récupère tous les avis par film.
     * @param id identifiant du film dont on veut les avis
     * @return Response Json
     */
    @GET
    @Path("/film/{id}")
    public final Response findAvisByFilm(@PathParam("id")
                                         final String id) {
        return service.findAllAvisByFilmID(id);
    }

    /**
     * Récupère un avis grâce à son id.
     * @param id identifiant de l'avis demandé
     * @return Response Json
     */
    @GET
    @Path("/{id}")
    public final Response findAvisByID(@PathParam("id") final long id) {
        return service.findAvisByID(id);
    }

    /**
     * Ajoute un avis à un film donné (note et/ou commentaire).
     * @param avis objet de type Avis (id de film, note et commentaire)
     * @return Response Json avec la location de la ressource
     */
    @POST
    @Path("/add")
    @Consumes({ MediaType.APPLICATION_JSON })
    public final Response addAvis(final Avis avis) {
        return service.addAvis(avis.getFilmID(), avis.getNote(),
               avis.getCommentaire());
    }

    /**
     * Supprime un ou des avis par mot-clé dans les commentaires.
     * @param key le mot-clé
     * @return Response Json
     */
    @DELETE
    @Path("/delete")
    public final Response deleteAvis(@QueryParam("key")
                                     final String key) {
        return service.deleteAvisByKey(key);
    }

}
