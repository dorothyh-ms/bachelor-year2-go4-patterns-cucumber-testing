package hifresh.domain.util;

public record IBAN(String BIC, String country, int accountNumber, int check) {
    public IBAN{
        if (country.length() != 2) {
            throw new IllegalArgumentException("Country code must be 2 characters");
        }
        if ((check < 0) || (check >99)){
            throw new IllegalArgumentException("Check value must be between 0 and 99");
        }
    }

}
