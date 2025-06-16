package aula07.Exercício2;

public class DateYMD extends Date {

    private int day;
    private int month;
    private int year;

    public DateYMD(int day, int month, int year) {
        setDate(day, month, year);
    }

    private static void validDay(int day, int month, int year) {
        if (day < 1 || day > monthDays(month, year)) {

            throw new IllegalArgumentException("Invalid day");
        }
    }

    private static void validMonth(int month) {
        if (!isMonth(month)) {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    private static void validDate(int day, int month, int year) {
        validDay(day, month, year);
        validMonth(month);
    }

    protected int[] getDate() {
        return new int[]{day, month, year};
    }

    protected void setDate(int day, int month, int year) {
        validDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    protected void incrementDay() {
        day++;
        if (day > monthDays(month, year)) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    protected void decrementDay() {
        day--;
        if (day < 1) {
            month--;
            if (month < 1) {
                month = 12;
                year--;
            }
            day = monthDays(month, year);
        }
    }

    public String toString() {
        return String.format("%02d-%02d-%04d", day, month, year);
    }
}
