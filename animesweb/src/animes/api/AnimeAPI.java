package animes.api;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import animes.ejb.AnimeEJBLocal;
import animes.model.Anime;

@Path("/animes")
@RequestScoped
public class AnimeAPI {
    @EJB
    AnimeEJBLocal animeEJB;

    @GET
    @Produces("application/json")
    public List<Anime> getAll() {
        return animeEJB.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Anime get(@PathParam("id") long id) {
        return animeEJB.getById(id);
    }

    @POST
    @Consumes("application/json")
    public void add(Anime anime) {
        anime.setId(0);
        animeEJB.save(anime);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(Anime anime, @PathParam("id") long id) {
        anime.setId(id);
        animeEJB.save(anime);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        Anime anime = animeEJB.getById(id);
        animeEJB.remove(anime);
    }
}
