package com.example.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExtendedRepository<T, I extends Serializable> 
  extends JpaRepository<T, I> {
  
    public List<T> findByAttributeContainsText(String attributeName, String text);
}