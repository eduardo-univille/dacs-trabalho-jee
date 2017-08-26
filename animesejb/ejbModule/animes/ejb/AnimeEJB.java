package animes.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import animes.model.Anime;

@Stateless
@LocalBean
public class AnimeEJB implements AnimeEJBLocal {
    @PersistenceContext(name = "animescontext")
    private EntityManager em;

    @Override
    public void save(Anime anime) {
        if (em.find(Anime.class, anime.getId()) == null) {
            em.persist(anime);
        } else {
            em.merge(anime);
        }
    }

    @Override
    public void remove(Anime anime) {
        anime = em.find(Anime.class, anime.getId());
        em.remove(anime);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Anime> getAll() {
        Query q = em.createNamedQuery("getall");
        return q.getResultList();
    }

    @Override
    public Anime getById(long id) {
        return em.find(Anime.class, id);
    }
}
