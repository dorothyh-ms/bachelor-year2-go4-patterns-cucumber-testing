package hifresh.domain.util;

public record Week(int year, int weekNumber) {
    public Week {
        if (weekNumber < 1 || weekNumber > 53) {
            throw new IllegalArgumentException("Week number must be between 1 and 53 inclusive");
        }
    }
}
