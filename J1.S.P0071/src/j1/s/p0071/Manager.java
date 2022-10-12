/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Admin MSI
 */
public class Manager {
    
    public static void addTask(ArrayList<Task> lt, int id) throws ParseException {
        System.out.print("Enter Requirement Name: ");
        String requirementName = Validation.checkInputString();
        System.out.print("Type\n1.Code\n2.Test\n3.Manager\n4.Learn\n");
        System.out.print("Enter Task Type: ");
        String taskTypeId = Validation.checkInputTaskTypeId();
        System.out.print("Enter Date: ");
        String date = Validation.checkInputDate();
        System.out.print("Enter From: ");
        String planFrom = Validation.checkInputPlan();
        System.out.print("Enter To: ");
        String planTo = Validation.checkInputPlan();
        System.out.print("Enter Assignee: ");
        String assign = Validation.checkInputString();
        System.out.print("Enter Reviewer: ");
        String reviewer = Validation.checkInputString();
        lt.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));
        System.out.println("Add Task Success.");
    }

    private static void deleteTask(ArrayList<Task> lt, int id) {
        if (lt.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        int findId = findTaskExist(lt);
        if (findId != -1) {
            lt.remove(findId);
//            for (int i = findId; i < lt.size(); i++) {
//                lt.get(i).setId(lt.get(i).getId() - 1);
//            }
            System.err.println("Delete success.");
        }
    }

    private static int findTaskExist(ArrayList<Task> lt) {
        System.out.print("Enter id: ");
        int id = Validation.checkInputInt();
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }

    private static void print(ArrayList<Task> lt) {
        double time;
        
        if (lt.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequirementName(),
                    lt.get(i).getTaskTypeId(),
                    lt.get(i).getDate(),
                    time = Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom()),
                    lt.get(i).getassign(),
                    lt.get(i).getreviewer()
            );
        }
    }
    
    public static void sortTime(ArrayList<Task> lt){
        Collections.sort(lt, new Comparator<Task>() {
            @Override
            public int compare(Task t, Task t1) {
                double time1 = Double.parseDouble(t.getPlanTo())- Double.parseDouble(t.getPlanFrom());
                double time2 = Double.parseDouble(t1.getPlanTo())- Double.parseDouble(t1.getPlanFrom());
                if(time1>time2){
                    return -1;
                }else if(time1<time2){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });
    }

    public static void display() throws ParseException {
        ArrayList<Task> lt = new ArrayList<>();
        int choice;
        int id = 1;
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
//            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = Validation.checkInputLimit(1, 5);
            switch (choice) {
                case 1:
                    addTask(lt, id);
                    id++;
                    break;
                case 2:
                    deleteTask(lt, id);
//                    id--;
                    break;
                case 3:
                    print(lt);
                    break;
                case 5: 
                    sortTime(lt);
                    break;
                case 4:
                    return;

            }
        }
    }
}
