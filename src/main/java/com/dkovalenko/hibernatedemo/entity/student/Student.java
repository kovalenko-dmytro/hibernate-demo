package com.dkovalenko.hibernatedemo.entity.student;

import com.dkovalenko.hibernatedemo.entity.AbstractEntity;
import com.dkovalenko.hibernatedemo.entity.address.Address;
import com.dkovalenko.hibernatedemo.entity.exam.Exam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Component("student")
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student extends AbstractEntity {


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private Set<Exam> exams;
}
