package com.sda.javagda17.checklist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Checklist checklist;

    private LocalDateTime itemDateCompleted;

    private ItemStatus itemStatus;

    @Column(unique = true)
    private String name;

    @Length(max = 200)
    private String content;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Notes> notesSet;


}
