package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Toys;
import com.example.springboot.repository.ToysRepo;

@Service
public class ToysService {
    
    @Autowired
    ToysRepo ur;
    
    public Toys create(Toys uu)
    {
        return ur.save(uu);
    }

    public List <Toys> getAlldetails()
    {
        return ur.findAll();
    }
    public Toys getUserById(int id)
    {
        return ur.findById(id).orElse(null);
    }

    public boolean updateDetails(int id,Toys u)
    {
        if(this.getUserById(id)==null)
        {
            return false;
        }
        try{
            ur.save(u);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean deleteUser(int id)
    {
        if(this.getUserById(id) == null)
        {
            return false;
        }
        ur.deleteById(id);
        return true;
    }   

}