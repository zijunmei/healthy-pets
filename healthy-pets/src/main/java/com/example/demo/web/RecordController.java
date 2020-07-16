package com.example.demo.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Record;
import com.example.demo.repository.RecordsRepository;

@Controller
@RequestMapping("/records/")
public class RecordController {
	
	private final RecordsRepository recordsRepository;
	
	@Autowired
    public RecordController(RecordsRepository recordsRepository) {
        this.recordsRepository = recordsRepository;
    }
	
	@GetMapping("record-form")
	public String showAddRecordForm(Record record)
	{
		return "add-record";
	}
	
	@GetMapping("records-list")
	public String recordsList(Model model)
	{
		model.addAttribute("records", recordsRepository.findAll());
		return "index";
	}
	
	@PostMapping("add")
	public String addRecord(@Valid Record record, BindingResult result, Model model)
	{
		if (result.hasErrors())
		{
			return "add-record";
		}
		recordsRepository.save(record);
		return "redirect:records-list";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) 
	{
		Record record = recordsRepository.findById(id).orElseThrow(() 
				-> new IllegalArgumentException("Invalid record Id:" + id));
		model.addAttribute("record", record);
		return "update-record";
	}
	@PostMapping("update/{id}")
    public String updateRecord(@PathVariable("id") long id, @Valid Record record, 
    		BindingResult result, Model model) {
		if (result.hasErrors())
		{
			record.setId(id);
			return "update-record";
		}
		recordsRepository.save(record);
		model.addAttribute("records", recordsRepository.findAll());
		return "index";
	}
	
	 @GetMapping("delete/{id}")
	 public String deleteRecord(@PathVariable("id") long id, Model model)
	 {
		 Record record = recordsRepository.findById(id).orElseThrow(() 
				 -> new IllegalArgumentException("Invalid record Id:" + id));
		 recordsRepository.delete(record);
		 model.addAttribute("records", recordsRepository.findAll());
		 return "index";
	 }
}
