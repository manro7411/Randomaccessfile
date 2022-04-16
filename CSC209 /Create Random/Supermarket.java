// Spermarket 
// Int  >> id name 
// String >> type 
// String >> product 
// double >> price 
class Supermarket {
    int id;
    String type;
    String product;
    double price;

    public Supermarket(int id, String type, String product, double price) {
        this.id = id;
        this.type = type;
        this.product = product;
        this.price = price;
    }

    public Supermarket(String type, String product, double price) {
        this.type = type;
        this.product = product;
        this.price = price;
    }

    public Supermarket(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}