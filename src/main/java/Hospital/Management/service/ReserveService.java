package Hospital.Management.service;

import Hospital.Management.domain.Doctor;
import Hospital.Management.domain.Patient;
import Hospital.Management.domain.Reserve;
import Hospital.Management.repository.DoctorRepository;
import Hospital.Management.repository.PatientRepository;
import Hospital.Management.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReserveService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final ReserveRepository reserveRepository;


    public Long Reserve(Long Patientid, Long Doctorid){
        Patient patient = patientRepository.findById(Patientid);
        Doctor doctor = doctorRepository.findById(Doctorid);
        return reserveRepository.save(Reserve.createReserve(patient, doctor));
    }

    public void cancel(Long reserveId){
        Reserve reserve = reserveRepository.findById(reserveId);
        reserve.cancel();
        System.out.println("캔슬완료!");
    }
}