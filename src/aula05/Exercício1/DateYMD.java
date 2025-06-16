package aula05.Exercício1;

public class DateYMD {
    private int day, month, year;

    public DateYMD(int day, int month, int year) {
        set(day, month, year);
    }

    public void set(int day, int month, int year) {
        if (!valid(day, month, year)){
            throw new IllegalArgumentException("Data inválida");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    } 

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    

    public static boolean validMonth(int month) {
        return (month > 0) && (month <= 12);
    }

    public static boolean leapYear(int year) {
        return ((year%4==0) && (year%100!=0)) || (year%400==0);
    }

    public static int monthDays(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return leapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }

    public static boolean valid(int day, int month, int year) {
        return validMonth(month) && day >= 1 && day <= monthDays(month, year);
    }

    public void increment() {
        day++;
        if (day>monthDays(month, year)){
            month++;
            day = 1;
            if (month>12) {
                year++;
                month = 1;
            }
        }
    }


    public void decrement() {
        day--;
        if (day < 1){
            month--;
            day = monthDays(month, year);
            if (month < 1) {
                year--;
                month = 12;
                day = monthDays(month, year);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
