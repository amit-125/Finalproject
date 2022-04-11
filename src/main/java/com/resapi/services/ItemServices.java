package com.resapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resapi.dao.ItemRepo;
import com.resapi.entity.Item;

@Component
public class ItemServices {

	@Autowired
	ItemRepo obj;
	
	
	public void saveItem(Item it)
	{
		obj.save(it);
	}
	
	public List<Item> showData()
	{
		return obj.findAll();
	}
	public List<Item> delete()
	{
		return obj.findAll();
	}
	public void deleteItem(int id)
	{
		obj.deleteById(id);
	}
}
