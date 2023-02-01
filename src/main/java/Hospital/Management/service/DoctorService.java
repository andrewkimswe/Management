package Hospital.Management.service;

import Hospital.Management.domain.Department;
import Hospital.Management.domain.Doctor;
import Hospital.Management.repository.DepartmentRepository;
import Hospital.Management.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional
    public Doctor MakeDocter(Long doctorid, Department department){
        Doctor doctor = doctorRepository.findById(doctorid);
        doctor.setDepartment(department);
        department.getDoctorList().add(doctor);
        doctorRepository.save(doctor);
        departmentRepository.save(department);
        return doctor;
    }
}
