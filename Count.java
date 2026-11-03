public class Count {
    String name;
    int hours;
    int objectif;

    public Count (String name , int h, int obj){
        this.name = name;
        this.hours = h;
        this.objectif = obj;
    }

    public int todayHours (int hour, Count count){
        count.hours += hour;
        return count.hours;
    }
}