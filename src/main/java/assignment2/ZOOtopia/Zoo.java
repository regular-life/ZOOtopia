package assignment2.ZOOtopia;

import java.io.* ;
import java.util.* ;

public class Zoo
{
    private String name ;
    private Admin admin ;
    private Vector<Animal> animals ;
    private Vector<Visitor> visitors ;
    private Vector<Attraction> attractions ;
    private Vector<Discount> discounts ;
    private Vector<SpecialDeal> special_deals ;
    private Vector<FeedBack> feedbacks ;
    private Integer revenue ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Vector<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Vector<Animal> animals) {
        this.animals = animals;
    }

    public Vector<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(Vector<Visitor> visitors) {
        this.visitors = visitors;
    }

    public Vector<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(Vector<Attraction> attractions) {
        this.attractions = attractions;
    }

    public Vector<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Vector<Discount> discounts) {
        this.discounts = discounts;
    }

    public Vector<SpecialDeal> getSpecial_deals() {
        return special_deals;
    }

    public void setSpecial_deals(Vector<SpecialDeal> special_deals) {
        this.special_deals = special_deals;
    }

    public Vector<FeedBack> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Vector<FeedBack> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Zoo(String name) {
        this.name = name;
        this.admin = null;
        this.animals = new Vector<Animal>();
        this.visitors = new Vector<Visitor>();
        this.attractions = new Vector<Attraction>();
        this.discounts = new Vector<Discount>();
        this.special_deals = new Vector<SpecialDeal>();
        this.feedbacks = new Vector<FeedBack>();
        this.revenue = 0 ;
    }
}
