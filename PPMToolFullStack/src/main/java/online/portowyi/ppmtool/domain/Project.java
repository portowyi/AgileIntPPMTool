package online.portowyi.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity @Getter @Setter @NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя проекта не может быть пустым")
    private String projectName;

    @NotBlank(message = "Идентификатор проекта не может быть пустым")
    @Size(min = 4, max = 7, message = "Длина идентификатора не может быть короче 4-х символов и длиннее 7-ми сиволов")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    @NotBlank(message = "Описание проекта не может быть пустым")
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_at;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_at;

    @PrePersist
    protected void prePersist(){
        this.created_at = new Date();
    }

    @PreUpdate
    protected void preUpdate(){
        this.updated_at = new Date();
    }
}
