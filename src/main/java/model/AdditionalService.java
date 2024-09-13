package model;

public class AdditionalService extends Service{
    private String reservation;

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public AdditionalService(String name, String description, double price, String reservation) {
        super(name, description, price);
        this.reservation = reservation;
    }
}
