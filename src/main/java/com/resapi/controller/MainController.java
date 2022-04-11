package com.resapi.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.resapi.entity.Item;
import com.resapi.services.ItemServices;

@Controller

public class MainController {

	@Autowired
	ItemServices its;
	
	
	/* This method will be called when we have to make a choice and also i have used  required value = false in requestParam because of optional parameter in url .
	 * When we will save or delete any item we will just redirect itto the this method only and with a success message*/
	@RequestMapping("/showView")
	public String showView(@RequestParam(value= "message",required = false)String attr,Model m)
	{
		if(attr!=null)
		{
		  m.addAttribute("msg",attr);
		}
		
		return "choice";
	}
	
	
	/* This method will handle the post request of our dropdown and will  call the particular url on the basis of our request
	 * if we enter 1 we will list the records of the data 
	 * if we enter 2 we will add a new item 
	 * if we enter 3 we will delete one particular item from the list */
	@RequestMapping("/submit")
	public String submitChoice(@RequestParam("choice") int choice) {
		if(choice==1)
		{
		    return "redirect:/showData";
		}
		else if(choice==2)
		{
			return "add";
		}
		else
		{
			return  "redirect:/delete";
		}
	}
	
	
	/* This method will save the item in the database and i have used RedirectAttributes to set the message in out attribute while redirecting and then handle it using @RequesParam  */
	@RequestMapping("/saveitem")
	public String saveItem(@RequestParam("name") String name,@RequestParam("quantity") int quantity,@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date, RedirectAttributes redirectAttrs)
	{
		Item it = new Item();
		
	      
	    System.out.print(date+" ");
	     it.setDate(date);
		it.setName(name);
		it.setQuantity(quantity);
		
	     its.saveItem(it);
	     redirectAttrs.addAttribute("message", "New Item Saved Successfully");
	     return "redirect:/showView";
	}
	
/* This  method  will show list of items we are having in our database we use findAll method of jpa repsoitry to get the all the data */	
	@RequestMapping("/showData")
	public String showData(Model m)
	{
		

		List<Item> list = its.showData();
				//System.out.print(e);
		m.addAttribute("list",list);
		
		return "list";
	}
	

	
/* This will  show  the delete page where delete option will be there in the list*/	
	@RequestMapping("/delete")
	public String delete(Model m)
	{
		 
		List<Item> list = its.delete();
		
        m.addAttribute("list",list);
        
        return "delete";
		
	}
/* This will delete the that particular item from thew list on the basis of id and to set the message i have used RedirectAttributes  */
	
	@RequestMapping("/deleteItem/{id}")
	public String deleteItem(@PathVariable int id,RedirectAttributes ra)
	{
		its.deleteItem(id);
		//  attributes.addFlashAttribute("success", "Object has been removed successfully.");
		  ra.addAttribute("message", "Item Deleted Successfully");
		 
		  return "redirect:/showView";
		
	}	

}
