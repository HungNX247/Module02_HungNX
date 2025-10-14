package main.com.excercise;

public class NextDayCalculator {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public String getNextDay(int day, int month, int year) {
        int daysInMonth = getDaysInMonth(month, year);
        return caculatorNextDay(day, month, year, daysInMonth);
    }

    private String caculatorNextDay(int day, int month, int year, int daysInMonth) {
        if (day == daysInMonth) {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        } else {
            day++;
        }
        return String.format("%02d/%02d/%04d", day, month, year);
    }

}
