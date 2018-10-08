package com.dkovalenko.hibernatedemo.entity.subject;

import com.dkovalenko.hibernatedemo.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subject extends AbstractEntity {

    private String name;
}
