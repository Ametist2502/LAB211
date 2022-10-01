/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expenses;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Admin MSI
 */
public class Manager {

    Validation validation = new Validation();

    public void addExpense(ArrayList<Expenses> list, int id) throws IOException {
        System.out.print("Enter Date: ");
        String date = validation.checkInputDate();
        System.out.print("Enter Amount: ");
        double amount = validation.checkInputDouble();
        System.out.print("Enter Content: ");
        String content = validation.checkInputString();
        list.add(new Expenses(id, date, amount, content));
    }

    public void displayExpense(ArrayList<Expenses> list) {
        if (list.size() == 0) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", list.get(i).getId(), list.get(i).getDate(),
                    list.get(i).getAmount(), list.get(i).getContent());
            total += list.get(i).getAmount();
        }
        System.out.printf("Total: %-20.0f\n", total);
    }

    public int checkIdExist(ArrayList<Expenses> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void deleteExpense(ArrayList<Expenses> list) {
        System.out.print("Enter id: ");
        int id = validation.checkInputInt();
        int checkIdExist = checkIdExist(list, id);
        if (checkIdExist != -1) {
            list.remove(checkIdExist);
            System.out.println("Delete an expense successful");
            for (int i = id - 1; i < list.size(); i++) {
                list.get(i).setId(list.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }

    public void display() throws IOException {
        ArrayList<Expenses> le = new ArrayList<>();
        int id = 0;
        while (true) {
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = validation.checkInputLimit(1, 4);
            switch (choice) {
                case 1:
                    addExpense(le, ++id);
                    break;
                case 2:
                    displayExpense(le);
                    break;
                case 3:
                    deleteExpense(le);
                    id--;
                    break;
                case 4:
                    return;
            }
        }
    }
}
