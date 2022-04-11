package com.resapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resapi.entity.Item;



public interface ItemRepo extends JpaRepository<Item,Integer> {

}
