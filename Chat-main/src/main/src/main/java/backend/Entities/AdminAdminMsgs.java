package backend.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin_admin_messages")
public class AdminAdminMsgs {
    @Id
    @GeneratedValue
    private Long id;

    private String sentBy;
    private String sentTo;
    private String senderId;
    private String receiverId;
    private String message;
    private Long creationTime;
    private Long updateTime;
    private Boolean isDeleted;
    private Boolean isChildMessage;
    private Long parentId;
    private String messageType; //text, image, document, voice etc.
}
