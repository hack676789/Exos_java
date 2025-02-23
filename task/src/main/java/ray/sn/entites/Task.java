package ray.sn.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;;

@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private boolean accomplished;

    public Task(String title, String description, boolean accomplished) {
        this.title = title;
        this.description = description;
        this.accomplished = accomplished;
    }

    public Task(){}


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Boolean isAccomplished(){
        return accomplished;
    }
    
    public Boolean getAccomplished(){
        return accomplished;
    }
    public void setAccomplished(Boolean accomplished){
        this.accomplished = accomplished;
    }
}



