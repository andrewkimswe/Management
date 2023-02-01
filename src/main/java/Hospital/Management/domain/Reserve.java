package Hospital.Management.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter @Setter
public class Reserve {

    @Id @GeneratedValue
    @Column(name = "reserve_id")
    private Long id;

    @ManyToOne(fetch = LAZY,cascade =  CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = LAZY,cascade =  CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private ReserveStatus reserveStatus;

    private LocalDateTime reserveTime;


    public static Reserve createReserve(Patient patient, Doctor doctor) {
        Reserve reserve = new Reserve();
        reserve.setReserveStatus(ReserveStatus.RESERVE);
        reserve.reserveTime = LocalDateTime.now();
        reserve.setPatient(patient);
        reserve.setDoctor(doctor);
        return reserve;
    }

    private void setPatient(Patient patient){
        this.patient = patient;
        patient.getReserveList().add(this);
    }

    private void setDoctor(Doctor doctor){
        this.doctor = doctor;
        doctor.getReserveList().add(this);
    }

    public void cancel() {
        this.setReserveStatus(ReserveStatus.CANCEL);
        this.reserveTime = null;
        patient.getReserveList().remove(this);
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", reserveStatus=" + reserveStatus +
                ", reserveTime=" + reserveTime +
                '}';
    }
}