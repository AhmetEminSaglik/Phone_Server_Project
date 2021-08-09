package date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class TimeAtThatMoment {
    LocalDateTime time = LocalDateTime.now();
    int year, dayOfMonth, hour, minute, second;
    DayOfWeek dayOfWeek;
    Month month;


    public TimeAtThatMoment() {
        dayOfWeek = time.getDayOfWeek();
        year = time.getYear();
        hour = time.getHour();
        minute = time.getMinute();
        second = time.getSecond();
        month = time.getMonth();
        dayOfMonth = time.getDayOfMonth();
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public String getHourString() {
        return getVariableInString(hour);
    }

    public String getMinuteString() {
        return getVariableInString(minute);
    }

    public String getSecondString() {
        return getVariableInString(second);
    }

    public String getCallTimeInString() {
        return month + " " + dayOfMonth + ", " + getHourString() + ":" + getMinuteString() + ":" + getSecondString();
    }

    String getVariableInString(int var) {
        if (var / 10 > 0) {
            return var + "";
        }
        return "0" + var;
    }


}
