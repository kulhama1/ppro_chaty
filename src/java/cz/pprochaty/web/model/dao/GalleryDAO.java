
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Gallery;
import java.util.List;

public interface GalleryDAO {
    Gallery getGalleryById(int id);
    void addGallery(Gallery gallery);
    void updateGallery(Gallery gallery);
    void deleteGallery(Integer gallery_id);
    List<Gallery> getAllGalleries();
}
