package Hospital.Management.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Patient {
    public Patient(String username, int age, Gender gender) {
        this.username = username;
        this.age = age;
        this.gender = gender;
    }

    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long id;

    private String username;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public enum Gender {Male, Female}


    @OneToMany(mappedBy = "patient")
    private List<Reserve> reserveList = new ArrayList<>();

}