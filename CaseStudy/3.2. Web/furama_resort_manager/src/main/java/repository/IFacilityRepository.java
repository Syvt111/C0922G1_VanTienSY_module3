package repository;

import model.CustomerType;
import model.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> selectAllFacility() ;
    Facility selectFacility(int ma_dich_vu);
    boolean insertFacility(Facility facility);
    boolean updateFacility(Facility facility);
    boolean deleteFacility(int ma_dich_vu);

}
