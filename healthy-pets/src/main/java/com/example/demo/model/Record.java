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

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
	
	
	@NotBlank(message = "Date is mandatory")
	@Column(name = "Date")
	private Date date;
	
	@NotBlank(message = "Event is mandatory")
	@Column(name = "Event")
	private Event event;
	
	public Record() {}
	
	public Record(String pet, Date date, Event event)
	{
		this.name = pet;
		this.date = date;
		this.event = event;
		
	}
	
	public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

	public void setPetName(String petname)
	{
		name = petname;
	}
	public String getPetName()
	{
		return name;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public Date getDate()
	{
		return date;
	}
	public void setEvent(Event event)
	{
		this.event = event;
	}
	public Event getEvent()
	{
		return event;
	}
}
