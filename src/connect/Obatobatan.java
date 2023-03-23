package connect;

public class Obatobatan {
    private String barcode;
    private String sell;
    private String qty;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public Obatobatan(String barcode, String sell, String qty, String name) {
        this.barcode = barcode;
        this.sell = sell;
        this.qty = qty;
        this.name = name;
    }

    public Obatobatan() {
    }
}

