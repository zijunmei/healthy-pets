package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "records")
public class Record {

	@NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@NotBlank(message = "Date is mandatory")
	@Column(name = "date")
	private String date;
	
	@NotBlank(message = "Event is mandatory")
	@Column(name = "event")
	private String event;
	
	public Record() {}
	
	public Record(String name, String date, String event)
	{
		this.name = name;
		this.date = date;
		this.event = event;
		
	}
	
	public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public String getDate()
	{
		return date;
	}
	public void setEvent(String event)
	{
		this.event = event;
	}
	public String getEvent()
	{
		return event;
	}
}
