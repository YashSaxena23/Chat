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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;//(name of choice)
    @Column(unique = true)
    private String mobile;
    @Column(unique = true)
    private String email;
    private String profilePic;
    private Boolean isActive;
    private String userGender;
    private String firstName;
    private String middleName;
    private String lastName;
    private String countryCode;
    private String info;
    private Long creationTime;
    private Long updateTime;

    @OneToOne
    private Address address;

    @OneToMany(targetEntity = UserAdminMsgs.class)
    private List userAdminMessages;

    @OneToMany(targetEntity = UserUserMsgs.class)
    private List userUserMessages;

}
