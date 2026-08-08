import java.time.LocalDate;
class Task{
    
    // object
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean status;
   
   // set
    public void setTittle(String title){
        this.title = title;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setDate(LocalDate dueDate){
        this.dueDate = dueDate;
    
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    
    
    // Get
    public String getTitle(){
        return title;
    }
    
    public String getDesciption(){
        return description;
    } 
    
    public LocalDate getDate(){
        return dueDate;
    }
    
    public boolean getStatus(){
        return status;
    }
    
}