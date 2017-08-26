package animes.ejb;

import java.util.List;

import javax.ejb.Local;

import animes.model.Anime;

@Local
public interface AnimeEJBLocal {
    public void save(Anime anime);

    public void remove(Anime anime);

    public List<Anime> getAll();

    public Anime getById(long id);
}
