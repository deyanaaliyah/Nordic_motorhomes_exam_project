package motorhome.demo.models;

//DA

public class Rental {

    private int rental_id;
    private int customer_id;
    private int motorhome_id;
    private int employee_id;
    private String date_start;
    private String date_end;
    private String total;
    private String valuta;
    private boolean paid;
    private String comments;

    public Rental(int rental_id, int customer_id, int motorhome_id, int employee_id, String date_start, String date_end, String total, String valuta, boolean paid, String comments) {
        this.rental_id = rental_id;
        this.customer_id = customer_id;
        this.motorhome_id = motorhome_id;
        this.employee_id = employee_id;
        this.date_start = date_start;
        this.date_end = date_end;
        this.total = total;
        this.valuta = valuta;
        this.paid = paid;
        this.comments = comments;
    }

    public Rental(){}

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rental_id=" + rental_id +
                ", customer_id=" + customer_id +
                ", motorhome_id=" + motorhome_id +
                ", employee_id=" + employee_id +
                ", date_start='" + date_start + '\'' +
                ", date_end='" + date_end + '\'' +
                ", total='" + total + '\'' +
                ", valuta='" + valuta + '\'' +
                ", paid=" + paid +
                ", comments='" + comments + '\'' +
                '}';
    }
}