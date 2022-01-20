package uz.by.learn.project.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;
}
