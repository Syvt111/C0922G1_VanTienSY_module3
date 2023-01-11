package service;

import model.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> selectAllFacility() ;
    Facility selectFacility(int ma_dich_vu);
    boolean insertFacility(Facility facility);
    boolean updateFacility(Facility facility);
    boolean deleteFacility(int ma_dich_vu);

}
