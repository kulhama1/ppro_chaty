package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Cottage;
import java.util.List;

public interface CottageDAO {
    Cottage getCottageById(int id);
    void addCottage(Cottage cottage);
    void updateCottage(Cottage cottage);
    List<Cottage> getAllCottages();
    void deleteCottage(Integer cottage_id);
}
