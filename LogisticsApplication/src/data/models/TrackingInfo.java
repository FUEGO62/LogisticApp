package data.models;

import java.time.LocalDateTime;

public class TrackingInfo {

    private int id;
    private int itemId;
    private String info;
    private LocalDateTime time;


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(int year, int month, int day , int hour, int minute, int second) {

        this.time = LocalDateTime.of(year, month, day, hour, minute, second);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getTrackingInfoId() {
        return id;
    }

    public void setTrackingInfoId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s for package: %d%n",info,itemId);
    }

}
