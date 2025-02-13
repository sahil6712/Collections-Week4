package org.example.votingsystem;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voting System - Enter votes (type 'exit' to stop):");

        while (true) {
            System.out.print("Vote for: ");
            String candidate = scanner.nextLine();

            if (candidate.equalsIgnoreCase("exit")) break;

            votingSystem.vote(candidate);
        }

        scanner.close();

        // Display results
        System.out.println("\n--- Voting Results (Sorted) ---");
        for (Map.Entry<String, Integer> entry : votingSystem.getSortedResults().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

        System.out.println("\n--- Voting History (In Order Cast) ---");
        for (Map.Entry<String, Integer> entry : votingSystem.getVoteHistory().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

        System.out.println("\nWinner: " + votingSystem.getWinner());
    }
}

