package animes.control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import animes.ejb.AnimeEJBLocal;
import animes.model.Anime;

@ManagedBean(name = "animeControl")
@ViewScoped
public class AnimeControl {
    @EJB
    private AnimeEJBLocal animeEJB;

    private Anime model = new Anime();

    public Anime getModel() {
        return model;
    }

    public void setModel(Anime model) {
        this.model = model;
    }

    public List<Anime> getAll() {
        return animeEJB.getAll();
    }

    public void initModel() {
        model = new Anime();
    }

    public void save() {
        animeEJB.save(model);
    }

    public void remove() {
        if (model != null) {
            animeEJB.remove(model);
        }
    }
}
