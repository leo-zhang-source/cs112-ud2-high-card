package cs112.ud2;

/**
 * Stores a card-game player's nonblank name and nonnegative score.
 *
 * @author Leo Zhang
 * @version 1.0
 */
public class Player {
    private String name;
    private int score;

    /** Creates a player named Player with a score of zero. */
    public Player() {
        name = "Player";
        score = 0;
    }

    /**
     * Creates a player with a nonblank name and a nonnegative score.
     * @param name the player's name, trimmed before storage
     * @param score the player's nonnegative score
     * @throws IllegalArgumentException if the name or score is invalid
     */
    public Player(String name, int score) {
        if (!setAll(name, score)) {
            throw new IllegalArgumentException(
                    "Name must not be blank and score must be nonnegative.");
        }
    }

    /**
     * Copies another player's values into an independent player.
     * @param original the player to copy
     * @throws IllegalArgumentException if the source is null
     */
    public Player(Player original) {
        if (original == null) {
            throw new IllegalArgumentException("Cannot copy a null Player.");
        }
        name = original.name;
        score = original.score;
    }

    /**
     * Changes the name only when it is non-null and nonblank after trimming.
     * @param name the new name
     * @return true if the name was changed, or false if it was invalid
     */
    public boolean setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        this.name = name.trim();
        return true;
    }

    /**
     * Changes the score only when it is nonnegative.
     * @param score the new score
     * @return true if the score was changed, or false if it was invalid
     */
    public boolean setScore(int score) {
        if (score < 0) {
            return false;
        }
        this.score = score;
        return true;
    }

    /**
     * Changes both fields only when both inputs are valid.
     * @param name the new name, trimmed before storage
     * @param score the new nonnegative score
     * @return true on success, or false without changes if either input is invalid
     */
    public boolean setAll(String name, int score) {
        if (name == null || name.trim().isEmpty() || score < 0) {
            return false;
        }
        this.name = name.trim();
        this.score = score;
        return true;
    }

    /**
     * Gets the player's name.
     * @return the stored name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's score.
     * @return the current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Adds one point unless the score is already the largest possible int.
     * @return true if a point was added, or false without changes at the limit
     */
    public boolean addPoint() {
        if (score == Integer.MAX_VALUE) {
            return false;
        }
        score++;
        return true;
    }

    /** Resets the score to zero while keeping the player's name. */
    public void resetScore() {
        score = 0;
    }

    /**
     * Compares the name and score of another Player.
     * @param other the player to compare with this player
     * @return true if both fields match, or false for null or different values
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Player)) {
            return false;
        }
        Player otherPlayer = (Player) other;
        return name.equals(otherPlayer.name) && score == otherPlayer.score;
    }

    /**
     * Returns a hash value based on the same fields used by equals.
     * @return the hash value for the name and score
     */
    @Override
    public int hashCode() {
        return 31 * name.hashCode() + score;
    }

    /**
     * Creates a readable name and score summary.
     * @return a string such as Leo: 3 points
     */
    @Override
    public String toString() {
        return name + ": " + score + " points";
    }
}
