package assignment2.ZOOtopia;

class Attraction
{
    private String name ;
    private String description ;
    public String uid ;
    private Integer price ;

    private Integer visitors_count ;
    private Boolean status ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getVisitors_count() {
        return visitors_count;
    }

    public void setVisitors_count(Integer visitors_count) {
        this.visitors_count = visitors_count;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Attraction(String name, String description, String uid, Integer price) {
        this.name = name;
        this.description = description;
        this.uid = uid;
        this.price = price;
        this.visitors_count = 0;
        this.status = true ;
    }

    public void addVisitor()
    {
        this.visitors_count += 1 ;
    }
}
