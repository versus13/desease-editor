package che.admineditor.domain;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Nullable
    private Long pId;

    private String title;

    private String titleInput;

    private String description;

    private String descriptionInput;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public Long getpId() {
        return pId;
    }

    public void setpId(@Nullable Long pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleInput() {
        return titleInput;
    }

    public void setTitleInput(String titleInput) {
        this.titleInput = titleInput;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionInput() {
        return descriptionInput;
    }

    public void setDescriptionInput(String descriptionInput) {
        this.descriptionInput = descriptionInput;
    }

    public Message(@Nullable Long pId, String title, String titleInput, String description, String descriptionInput) {
        this.pId = pId;
        this.title = title;
        this.titleInput = titleInput;
        this.description = description;
        this.descriptionInput = descriptionInput;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", pId=" + pId +
                ", title='" + title + '\'' +
                ", titleInput='" + titleInput + '\'' +
                ", description='" + description + '\'' +
                ", descriptionInput='" + descriptionInput + '\'' +
                '}';
    }
}
