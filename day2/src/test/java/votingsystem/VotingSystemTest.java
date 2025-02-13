package votingsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

import org.example.votingsystem.VotingSystem;

public class VotingSystemTest {
    private VotingSystem votingSystem;

    @BeforeEach
    void setUp() {
        votingSystem = new VotingSystem();
    }

    @Test
    void testVoting() {
        votingSystem.vote("Alice");
        votingSystem.vote("Bob");
        votingSystem.vote("Alice");

        assertEquals(2, votingSystem.getSortedResults().get("Alice"));
        assertEquals(1, votingSystem.getSortedResults().get("Bob"));
    }

    @Test
    void testSortedResults() {
        votingSystem.vote("Charlie");
        votingSystem.vote("Alice");
        votingSystem.vote("Bob");

        Map<String, Integer> sortedResults = votingSystem.getSortedResults();
        String[] expectedOrder = {"Alice", "Bob", "Charlie"};
        assertArrayEquals(expectedOrder, sortedResults.keySet().toArray());
    }

    @Test
    void testVoteHistoryOrder() {
        votingSystem.vote("Alice");
        votingSystem.vote("Bob");
        votingSystem.vote("Charlie");

        String[] expectedOrder = {"Alice", "Bob", "Charlie"};
        assertArrayEquals(expectedOrder, votingSystem.getVoteHistory().keySet().toArray());
    }

    @Test
    void testWinner() {
        votingSystem.vote("Alice");
        votingSystem.vote("Alice");
        votingSystem.vote("Bob");

        assertEquals("Alice", votingSystem.getWinner());
    }

    @Test
    void testNoVotes() {
        assertEquals("No votes cast", votingSystem.getWinner());
    }
}
