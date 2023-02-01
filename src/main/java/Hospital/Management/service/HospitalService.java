package Hospital.Management.service;

import Hospital.Management.domain.All;
import Hospital.Management.domain.Doctor;
import Hospital.Management.domain.Reserve;
import Hospital.Management.repository.AllRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class HospitalService {

    private final AllRepository allRepository;

    @Transactional
    public void create(Reserve reserve, Doctor doctor){
        All all = new All();
        all.setTime(reserve.getReserveTime());
        all.setPatientName(reserve.getPatient().getUsername());
        all.setDoctor(doctor.getDoctorname());
        all.setDepartment(doctor.getDepartment().getDepartmentname());
        all.setHospital(doctor.getDepartment().getHospital().getHosName());
        allRepository.save(all);
    }
}
