package Hospital.Management.service;

import Hospital.Management.domain.*;
import Hospital.Management.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class HospitalService {

    private final DepartmentRepository departmentRepository;

    private final DoctorRepository doctorRepository;

    private final HospitalRepository hospitalRepository;

    private final PatientRepository patientRepository;

    private final ReserveRepository reserveRepository;

    @Transactional
    public void create(Reserve reserve, Doctor doctor){

        Reserve reserve1 = new Reserve();
        Patient patient = new Patient();
        Doctor doctor1 = new Doctor();
        Department department = new Department();
        Hospital hospital = new Hospital();

        reserve1.getReserveTime();
        patient.getUsername();
        doctor1.getDoctorname();
        department.getDepartmentname();
        hospital.getHosName();

        reserveRepository.save(reserve1);
        patientRepository.save(patient);
        doctorRepository.save(doctor);
        departmentRepository.save(department);
        hospitalRepository.save(hospital);
    }
}
