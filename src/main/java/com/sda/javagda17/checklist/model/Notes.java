package com.sda.javagda17.checklist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notes {

    @Id
    @GeneratedValue
    private Long id;

    @Length(max = 500)
    private String noteContent;

    @ManyToOne(fetch = FetchType.EAGER)
    private ChecklistItem checklistItem;
}
