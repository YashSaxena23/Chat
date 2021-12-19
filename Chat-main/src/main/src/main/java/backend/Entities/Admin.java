package backend.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    @Column(unique = true)
    private String mobile;
    @Column(unique = true)
    private String email;
    private String countryCode;
    private String profilePic;
    private String info;
    private String status;
    private Boolean isActive;
    private Long creationTime;
    private Long updateTime;

    @OneToOne
    private Address address;

    @OneToMany(targetEntity = UserAdminMsgs.class)
    private List userAdminMessages;

    @OneToMany(targetEntity = AdminAdminMsgs.class)
    private List adminAdminMessages;

}
