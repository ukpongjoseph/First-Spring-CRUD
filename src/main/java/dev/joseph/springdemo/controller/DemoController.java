package dev.joseph.springdemo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.joseph.springdemo.model.*;
import dev.joseph.springdemo.repository.DemoCollectionRepository;

@RestController
@RequestMapping(path = "/api/demo")
@CrossOrigin
public class DemoController {

    private final DemoCollectionRepository demoCollectionRepository;

    
    public DemoController(DemoCollectionRepository repository){
        this.demoCollectionRepository = repository;
    }


    @RequestMapping("/welcome")
    public String greeting(){
        return "Hello user";
    }

    @GetMapping(value = "/all")
    public List<demoModel> findAllDemo(){
        return demoCollectionRepository.findAll();
    }

    // Using Custom error handling if resource not found
    @GetMapping("/{id}")
    public demoModel findDemoById(@PathVariable Integer id){
      demoModel demoItem = demoCollectionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));
      return demoItem;
    }

    // Here with the Optional keyword, we use built in error handling mechanism
    @GetMapping("/title/search")
    public Optional<demoModel> findDemoByTitle(@RequestParam("title") String title){
        Optional<demoModel> demoItem = demoCollectionRepository.findByTitle(title);
        return demoItem;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDemo(@PathVariable Integer id){
        boolean itemToBeDeletded = demoCollectionRepository.deleteById(id);
        if(itemToBeDeletded){
          return "deleted";
        }else{
            return "item not found";
        }
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createdDemo(@RequestBody demoModel item){
        demoCollectionRepository.createDemo(item);
    }

    @PutMapping("/update/{id}")
    public void updateDemo(@RequestBody demoModel item, @PathVariable Integer id){
        demoCollectionRepository.updateDemo(item, id);
    }
}
