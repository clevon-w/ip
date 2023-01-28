package storage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents the Deadline task
 */
public class Deadline extends Task {

    protected LocalDate by;

    /**
     * Creates a new deadline with the specified description
     *
     * @param description The specified description
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), by.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
    }

    @Override
    public String toData() {
        return String.format("D | %s | %s", super.toData(), by);
    }
}
