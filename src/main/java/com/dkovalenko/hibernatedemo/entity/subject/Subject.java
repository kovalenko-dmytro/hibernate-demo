package com.dkovalenko.hibernatedemo.entity.subject;

import com.dkovalenko.hibernatedemo.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Component("subject")
@Table(name = "subjects")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class Subject extends AbstractEntity {

    private String name;
}
