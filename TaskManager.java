import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TaskManager
{ 
   static ArrayList<Task> tasks = new ArrayList<>();
   static ArrayList<Task> completedTasks = new ArrayList<>();
    
    // Method 

    // ADDTASK
    public static void addTask(String title, String description, boolean status, LocalDate date){
        Task task = new Task();
        task.setTittle(title);
        task.setDescription(description);
        task.setDate(date);
        task.setStatus(status);
        
        tasks.add(task);
        
        System.out.println(" ");
        System.out.println("Task added");
        System.out.println("Task: " + task.getTitle());
        System.out.println("Description: " + task.getDesciption());
        System.out.println("Status: " + task.getStatus());
        System.out.println("Due Date: " + task.getDate());
    }

    // VIEWTASK
    public static void viewTask(){
        
        for(int i = 0; i < tasks.size(); i++){
        Task task = tasks.get(i);
        System.out.println("Task: " + task.getTitle());
        System.out.println("Description: " + task.getDesciption());
        System.out.println("Status: " + task.getStatus());
        System.out.println("Due Date: " + task.getDate());
        }
    
    }

    //COMPLETETASK
    public static void completeTask(ArrayList<Task>task, String taskToComplete){
    System.out.println("Tasks need that to be completed");
    
    if(tasks.isEmpty()){
    System.out.println("No current tasks");
    }else{
        viewTask(); 
    }
    
    boolean Complete = false;
    for(Task tempTask : tasks){
        
        if(tempTask.getTitle().equalsIgnoreCase(taskToComplete)){
            
        Complete = true;   
        tempTask.setStatus(Complete);
        System.out.println("Task: " + tempTask.getTitle());
        System.out.println("Description: " + tempTask.getDesciption());
       if(temptask.getstatus() == true){
        System.out.println("Status: Completed");}
        System.out.println("Due Date: " + tempTask.getDate());
        completedTasks.add(tempTask);

        break;

        }

       if(!Complete){
           System.out.println(" No match task ");
       } 
        
    }
    
    }
    
    // DELETETASK
    public static void deleteTask(ArrayList<Task> task, String taskToDelete){
        if(tasks.isEmpty()){
        System.out.println("No current tasks");
        }else{
        viewTask(); 
        }

        for(Task tempDelete : tasks){
            if(taskToDelete.equalsIgnoreCase(tempDelete.getTitle())){
                tasks.remove(tempDelete);
                System.out.println(" ");
                System.out.println("Task: " + tempDelete.getTitle() + " has been deleted");

            }
        }
    }


// editTask
    public static void editTask(ArrayList<Task> task, String taskToEdit, String newTitle, String newDescription, LocalDate newDate){
        if(tasks.isEmpty()){
        System.out.println("No current tasks");
        }else{
        viewTask(); 
        }

        for(Task tempEdit : tasks){
            if(taskToEdit.equalsIgnoreCase(tempEdit.getTitle())){
                tempEdit.setTittle(newTitle);
                tempEdit.setDescription(newDescription);
                tempEdit.setDate(newDate);
                
                System.out.println(" ");
                System.out.println("Task: " + tempEdit.getTitle() + " has been updated");
                System.out.println("New Description: " + tempEdit.getDesciption());
                System.out.println("New Due Date: " + tempEdit.getDate());
            }
        }
    }

    //EXIT
    public static void exit(){
        System.out.println(" ");
        System.out.println("Exiting Task Manager...");
        return;

    }

   
    
    public static void main(String []args){
	Scanner scan = new Scanner(System.in);
	
	
	String exit = " ";
	
	do{
	    System.out.println("Remaining Task");
	    System.out.println(" ");
	    
	    if(tasks.isEmpty()){
	        System.out.println("No Current Task");
	    }else{
	        viewTask();
	    } 
	    
	    String choises = " ";
	    System.out.println(" ");
	    System.out.println(" Add - To create task  "); 
	    System.out.println(" Complete - Mark task as done ");
	    System.out.println(" Delete - Remove a task ");
	    System.out.println(" Edit - Modify task details");
	    System.out.println(" Exit ");
	  
        

	   
	    
	    exit = scan.nextLine();
	   
	    
	    
	}while(!exit.equalsIgnoreCase("Exit"));



}
}
