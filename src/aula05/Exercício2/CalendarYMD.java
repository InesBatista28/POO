package aula05.Exercício2;
import aula05.Exercício1.DateYMD;

public class CalendarYMD {
    private int year;
    private int dayOfWeek;
    private int[][] events;

    public CalendarYMD(int year, int dayOfWeek) {
        this.year = year;
        this.dayOfWeek = dayOfWeek;
        this.events = new int [13][32]; //12 meses e, no máximo, 31 dias
    }

    public int getYear() {
        return year;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int firstWeekdayOfMonth(int month) {
        int weekday = dayOfWeek;
        for (int m = 1; m < month; m++) {
            weekday = (weekday + DateYMD.monthDays(m, year)) % 7;
            if(weekday == 0) weekday = 7;
        }
        
        return weekday;
    } 

    public void addEvent(DateYMD date) {
        if (date.getYear() == year) {
            events[date.getMonth()][date.getDay()]++;
        }
    } 

    public void removeEvent(DateYMD date) {
        if (date.getYear() == year && events[date.getMonth()][date.getDay()] > 0) {
            events[date.getMonth()][date.getDay()]--;
        }
    }

    public String printMonth(int month) {
        StringBuilder sb = new StringBuilder();
        String[] monthNames = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        sb.append(String.format("     %s %d\n", monthNames[month], year));
        sb.append("Su Mo Tu We Th Fr Sa\n");

        int firstDay = firstWeekdayOfMonth(month);
        int daysInMonth = DateYMD.monthDays(month, year);

        int currentDay = 1;

        for (int i = 1; i < firstDay; i++) {
            sb.append("   ");
        }

        for (int i = firstDay; currentDay <= daysInMonth; i++) {
            String prefix = events[month][currentDay] > 0 ? "*" : " ";
            sb.append(String.format("%s%2d", prefix, currentDay));

            if (i % 7 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
            currentDay++;
        }

        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int m = 1; m <= 12; m++) {
            sb.append(printMonth(m)).append("\n");
        }
        return sb.toString();
    }
}
