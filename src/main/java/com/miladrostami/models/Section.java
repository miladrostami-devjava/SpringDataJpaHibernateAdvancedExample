package com.miladrostami.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@Table(name = "Author_TBL")

public class Section extends BaseEntity{

 /*   @Id
    @GeneratedValue
    private Integer id;*/


    private String name;
    private int sectionOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;



}
