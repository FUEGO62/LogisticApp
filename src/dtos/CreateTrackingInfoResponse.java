package dtos;

public class CreateTrackingInfoResponse {

    private int itemId;
    private String info;
    private int trackingInfoId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getTrackingInfoId() {
        return trackingInfoId;
    }

    public void setTrackingInfoId(int trackingInfoId) {
        this.trackingInfoId = trackingInfoId;
    }
}
