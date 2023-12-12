package hifresh.domain.util;

public record Duration(int hours, int minutes) {
    public Duration{
        if (hours < 0){
            throw new IllegalArgumentException("Hours may not be negative");
        }
        if ((minutes < 1) || (minutes > 59)){
            throw new IllegalArgumentException("Minutes must be between 1 and 59");
        }
    }
}
