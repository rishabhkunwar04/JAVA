package org.example.InMemoryDB;

import org.example.InMemoryDB.Service.*;

import java.util.Scanner;

public abstract class InmemoryDbHelper {

    private static InMemoryDb inMemoryDb = new InMemoryDb();

    public static void InitOperations() {
        while (true) {
            System.out.println("Enter operation to perform - Enter EXIT to end program");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            inMemoryDb.action(input);
        }
    }
}
