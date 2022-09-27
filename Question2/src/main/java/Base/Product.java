package Base;

public class Product {
    private String name;
    private double price;
    private String link;

    private String webSite;

    public Product() {
        this.name = name;
        this.price = price;
        this.link = link;
        this.webSite = webSite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getWebSite() {
        return webSite;
    }
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public void Show(){
        System.out.println("=========================");
        System.out.println("Name product: " + this.name);
        System.out.println("Price product: " + (double) Math.round(this.price * 100)/100);
        System.out.println("Link product: " + this.link);
        System.out.println("WebSite product: " + this.webSite);
    }
}
