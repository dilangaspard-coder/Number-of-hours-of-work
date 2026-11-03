public class Date {
    int day;
    int month;
    int year;

    public int [] date0 (int d, int m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
        int [] date = new int [3];
        date [0] = d;
        date [1] = m;
        date[2] = y;
        return date;
    }
}