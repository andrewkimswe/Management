package Hospital.Management.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
public class Hospital {
    public Hospital(String hosName, Address address) {
        this.HosName = hosName;
        this.address = address;
    }
    @Id @GeneratedValue
    @Column(name = "hospital_id")
    private Long id;

    private String HosName;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "hospital")
    List<Department> departmentList = new ArrayList<>();

    public Hospital() {
    }
}