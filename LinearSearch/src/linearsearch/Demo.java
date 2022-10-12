/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.ArrayList;

/**
 *
 * @author Admin MSI
 */
public class Demo {
    
    //        searcher.linerSearch(array, search);
    
    public void linerSearch(int[] arr, int key) {
        ArrayList<Integer> ls = new ArrayList<>();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                ls.add(i);
            }
        }
        if (ls.isEmpty()) {
            System.out.println("-1");
        } else {
            for (Integer l : ls) {
                System.out.println("Index: " + l + " ");
            }
        }
    }
}
