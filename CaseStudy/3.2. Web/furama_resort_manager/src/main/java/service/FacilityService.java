package service;

import model.Facility;
import repository.FacilityRepository;
import repository.IFacilityRepository;

import java.util.List;

public class FacilityService implements IFacilityService {
    IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public List<Facility> selectAllFacility() {
        return facilityRepository.selectAllFacility();
    }

    @Override
    public Facility selectFacility(int ma_dich_vu) {
        return facilityRepository.selectFacility(ma_dich_vu);
    }

    @Override
    public boolean insertFacility(Facility facility) {
        return facilityRepository.insertFacility(facility);
    }

    @Override
    public boolean updateFacility(Facility facility) {
        return facilityRepository.updateFacility(facility);
    }

    @Override
    public boolean deleteFacility(int ma_dich_vu) {
        return facilityRepository.deleteFacility(ma_dich_vu);
    }
}
