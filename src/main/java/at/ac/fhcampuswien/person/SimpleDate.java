package at.ac.fhcampuswien.person;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public boolean equals(Object o) {
        if( this == o) {
            return true;
        }
        if( !(o instanceof SimpleDate)) {
            return false;
        }
        SimpleDate other = (SimpleDate) o;
        if (year == other.year && month == other.month && day == other.day)
            return true;

        else return false;
    }

    public SimpleDate(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public SimpleDate(SimpleDate simpleDate) {
        this.year = simpleDate.year;
        this.month = simpleDate.month;
        this.day = simpleDate.day;
    }

    public String toString() {
        return day + "." + month + "." + year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
