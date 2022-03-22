package camiseta;

public class Camiseta {
    private String name;
    private String link;
    private String price;

    public Camiseta() {
    }

    public Camiseta(String name, String price,String link){
        this.name=name;
        this.price=price;
        this.link=link;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
