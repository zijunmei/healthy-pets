package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "records")
public class Record {

	@NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
}
