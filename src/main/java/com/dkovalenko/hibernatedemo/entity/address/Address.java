package com.dkovalenko.hibernatedemo.entity.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    private String country;
    private String city;
    private String street;
}
