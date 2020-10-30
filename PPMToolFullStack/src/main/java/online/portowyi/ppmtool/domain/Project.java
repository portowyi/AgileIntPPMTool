package online.portowyi.ppmtool.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity @Getter @Setter @NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String projectIdentifier;
    private String description;
    private Date start_date;
    private Date end_date;
    private Date created_at;
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
