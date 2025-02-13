package org.example.votingsystem;

import java.util.*;

public class VotingSystem {
    private final HashMap<String, Integer> voteCount; // Stores candidate votes
    private final LinkedHashMap<String, Integer> voteHistory; // Maintains voting order

    public VotingSystem() {
        this.voteCount = new HashMap<>();
        this.voteHistory = new LinkedHashMap<>();
    }

    // Casts a vote for a candidate
    public void vote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteHistory.put(candidate, voteHistory.getOrDefault(candidate, 0) + 1);
    }

    // Returns results sorted alphabetically
    public Map<String, Integer> getSortedResults() {
        return new TreeMap<>(voteCount);
    }

    // Returns vote history in the order they were cast
    public Map<String, Integer> getVoteHistory() {
        return new LinkedHashMap<>(voteHistory);
    }

    // Returns the winner (candidate with the most votes)
    public String getWinner() {
        return voteCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No votes cast");
    }
}

