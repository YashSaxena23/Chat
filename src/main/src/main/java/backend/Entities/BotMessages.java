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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bot_messages")
public class BotMessages {

    @Id
    @GeneratedValue
    private Long id;
    private String message;
    private Long creationTime;
    private Long updateTime;
    private Boolean isDeleted;
    private Boolean isChildMessage;
    private Long parentId;
    private String messageType; //text, image, document, voice etc.
}
