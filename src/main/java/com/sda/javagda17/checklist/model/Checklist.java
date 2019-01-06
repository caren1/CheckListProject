package com.sda.javagda17.checklist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(max = 45)
    private String name;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    private LocalDateTime dateCompleted;

    private boolean archived;

    @OneToMany(mappedBy = "checklist", fetch = FetchType.EAGER)
    private Set<ChecklistItem> checklistItemSet;
}
