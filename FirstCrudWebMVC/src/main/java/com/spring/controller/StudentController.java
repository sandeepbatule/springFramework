package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.StudentDAO;
import com.spring.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentDAO dao;
	
	@RequestMapping(value="/view")
	public String showForm(Model m)
	{
		m.addAttribute("command", new Student());
		return "welcome";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("student") Student student)
	{
		dao.save(student);
	    return "redirect:/viewstudent";
	}
	
	@RequestMapping(value="/editForm/{id}",method=RequestMethod.GET)
	public String editForm(@PathVariable int id,Model m)
	{
		Student student=dao.editForm(id);
		m.addAttribute("command", student);
	    return "editstudent";
	}
	
	 @RequestMapping("/viewstudent")    
	    public String viewemp(Model m){  
		 List<Student> list=dao.fetchList();
		    m.addAttribute("list", list);
	        return "viewstudent";    
	    }
	 
	 @RequestMapping(value="/update",method=RequestMethod.POST)
		public String update(@ModelAttribute("student") Student student)
		{
			dao.update(student);
		    return "redirect:/viewstudent";
		}
	 
	 @RequestMapping(value="/deleteForm/{id}",method=RequestMethod.GET)
		public String delete(@PathVariable int id)
		{
			dao.delete(id);
		    return "redirect:/viewstudent";
		}
	 
	 
}
