
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Image;
import java.util.List;

public interface ImageDAO {
    Image getImageById(int id);
    void addImage(Image image);
    void updateImage(Image image);
    void deleteImage(Integer image_id);
    List<Image> getAllImages();
    
    List<Image> getImagesByRow(String row, String operand, String stringArray);
    void updateMultipleImage(List<Image> images);
}
