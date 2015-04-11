package com.sunny4fun.google.codejam2015.standingovation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("A-large.in"));
        PrintWriter pw = new PrintWriter("A-large.out");

        int caseTotal = sc.nextInt();
        for(int caseNum = 0; caseNum < caseTotal; caseNum++) {
            int smax = sc.nextInt();
            String si = sc.next();
            int result = solve(smax, si);
            pw.printf("Case #%d: %d\n", caseNum+1, result);
        }

        pw.flush();
        pw.close();
        sc.close();
    }

    public static int solve(int smax, String si) {
        int invites = 0;
        int activation = 0;
        for(int i=0; i<=smax; i++) {
            int missing = i - activation;
            if (missing < 0) {
                missing = 0;
            }
            invites += missing;
            activation += si.charAt(i) - '0' + missing;
        }
        return invites;
    }
}
