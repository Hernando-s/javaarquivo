
package entiti;

public class Produst {
    private String name;
    private Double price;
    private String email;

    public Produst(String name, String email, Double price) {
        this.name = name;
        this.email = email;
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + email + ", " +String.format("%.2f ",price);
    }
    
    
}
