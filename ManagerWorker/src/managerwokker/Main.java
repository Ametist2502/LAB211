/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerwokker;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Manager Manager = new Manager();
        Validation validate = new Validation();
        while (true) {
            System.out.println("======== Mananger Worker ========");
            System.out.println("1. Add Worker.");
            System.out.println("2. Up salary.");
            System.out.println("3. Down salary.");
            System.out.println("4. Display information salary.");
            System.out.println("5. Exist");
            System.out.print("Enter your choice: ");
            int choice = validate.inputInt("", 1, 6);
            switch (choice) {
                case 1:
                    Manager.addWorker();
                    break;
                case 2:
                    Manager.changeSalary("UP");
                    break;
                case 3:
                    Manager.changeSalary("DOWN");
                    break;
                case 4:
                    Manager.printListHistory();
                    break;
                case 5:
                    return;
                case 6:
                    Manager.sort();
                    break;
            }
        }
    }
}
