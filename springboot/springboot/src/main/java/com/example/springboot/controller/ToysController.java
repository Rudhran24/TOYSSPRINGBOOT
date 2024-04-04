package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.springboot.model.Toys;
import com.example.springboot.service.ToysService;

@RestController
public class ToysController {
    @Autowired
    ToysService us;

    @PostMapping("/post")
    public ResponseEntity<Toys> add(@RequestBody Toys u)
    {
        Toys newuser = us.create(u);
        return new ResponseEntity<>(newuser,HttpStatus.CREATED);
    }
    @GetMapping("/getdetails")
    
    public ResponseEntity <List<Toys>> getAllUsers()
    {
        List<Toys>obj = us.getAlldetails();
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PutMapping("/api/user/{userId}")
    public ResponseEntity<Toys> putMethodName(@PathVariable("userId") int id, @RequestBody Toys employee) {
        if(us.updateDetails(id,employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/user/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable("userId") int id)
    {
        if(us.deleteUser(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}