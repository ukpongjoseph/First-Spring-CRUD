package dev.joseph.springdemo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.joseph.springdemo.model.Status;
import dev.joseph.springdemo.model.Type;
import dev.joseph.springdemo.model.demoModel;
import jakarta.annotation.PostConstruct;

@Repository
public class DemoCollectionRepository {
    private List<demoModel> demoList = new ArrayList<>();

    public DemoCollectionRepository(){

    }

    // Method to find all resources
    public List<demoModel> findAll(){
        return demoList;
    }

    // Method to find a resource by its id
    public Optional<demoModel> findById(Integer id){
        Optional<demoModel> demoItem = demoList.stream().filter(item -> item.id().equals(id)).findFirst();
        return demoItem;
    }

    // Method to find a resource by its title
    public Optional<demoModel> findByTitle(String title){
        Optional<demoModel> demoItem = demoList.stream().filter(item -> item.title().equals(title)).findFirst();
        return demoItem;
    }

    @PostConstruct
    private void initDemo(){
        demoModel initModel = new demoModel(
            1,
            "First record", 
            "This is the first record of the demo Model",
             LocalDateTime.now(), 
            null, 
            null, 
            Status.IDEA, 
            Type.ARTICLE
    );
        System.out.println(initModel);
        demoList.add(initModel);
        
    }

    // Method to delete a resource
    public boolean deleteById(Integer id) {
      return demoList.removeIf(item -> item.id().equals(id));
    }

    // Method to create a resource
    public void createDemo(demoModel resourceModel){
        demoList.add(resourceModel);
    }

    // Method to find by Id and update
    public String updateDemo(demoModel resourcModel, Integer id) {
        boolean itemExists = demoList.removeIf(item -> item.id().equals(id));
        if(itemExists){
            demoList.add(resourcModel);
            return "Item updated";
        }else{
            return "Item not found";
        }
    }
}
