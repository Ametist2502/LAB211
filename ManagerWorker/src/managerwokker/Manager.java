/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerwokker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Manager {

    ArrayList<Worker> workers = new ArrayList<>();
    ArrayList<History> history = new ArrayList<>();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date now = new Date();
    String date = df.format(now);
    Validation validate = new Validation();

    public Worker getWorkerByCode(String id) {
        for (Worker worker : workers) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    public void addWorker() {
        String id;
        while (true) {
            System.out.println("-------- Add Worker --------");
            id = validate.inputString("Enter code: ");
            Worker worker = getWorkerByCode(id);
            if (worker == null) {
                break;
            } else {
                System.out.println("This code is existed");
            }
        }
        String name = validate.inputString("Enter name: ");
        int age = validate.inputInt("Enter age: ", 18, 50);
        double salary = validate.inputDouble("Enter salary: ", 1, Double.MAX_VALUE);
        String workLocation = validate.inputString("Enter work location: ");
        workers.add(new Worker(id, name, age, salary, workLocation));

    }

    public void changeSalary(String status) {
        System.out.println("-------- Up/Down Salary --------");
        String id = validate.inputString("Enter code: ");
        Worker worker = getWorkerByCode(id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            if (worker.getSalary() == 1 && status.equals("DOWN")) {
                System.out.println("Can't down this worker salary anymore");
            } else if (worker.getSalary() == Double.MAX_VALUE && status.equals("UP")) {
                System.out.println("Can't up this worker salary anymore");
            } else {
                double salaryCurrent = worker.getSalary();
                double salaryUpdate;
                while (true) {
                    double salary = validate.inputDouble("Enter salary: ", 1, Double.MAX_VALUE);
                    if (status.equals("UP")) {
                        salaryUpdate = salaryCurrent + salary;
                        break;
                    } else {
                        if (salary > salaryCurrent) {
                            System.out.println("You should input smaller than current salary(" + salaryCurrent + ").");
                        } else {
                            salaryUpdate = salaryCurrent - salary;
                            break;
                        }
                    }
                }
                history.add(new History(status, date, worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
                worker.setSalary(salaryUpdate);
                System.err.println("Update success");
            }

        }
    }

    public void printListHistory() {
        if (history.isEmpty()) {
            System.out.println("-------- Display Information Salary --------");
            System.out.println("No history");
            return;
        }

        System.out.println("-------- Display Information Salary --------");
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        for (History history : history) {
            System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", history.getId(),
                    history.getName(), history.getAge(), history.getSalary(),
                    history.getStatus(), history.getDate());
        }
    }

    void sort() {
        Collections.sort(history, new Comparator<History>() {
            @Override
            public int compare(History t, History t1) {
                return t.getId().compareToIgnoreCase(t1.getId());
            }
        });
    }
}
