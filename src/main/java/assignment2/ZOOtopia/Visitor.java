package assignment2.ZOOtopia;

import java.util.Scanner;
import java.util.Vector;

import static assignment2.ZOOtopia.Admin.viewAnimals;
import static java.lang.Math.max;
import static java.lang.Math.min;

class Visitor
{
    private String name;
    private Integer age;
    private String phone_number ;
    private Integer balance ;
    private String email_id ;
    private String password ;
    private Zoo zoo ;
    private Boolean BasicMembership = false ;
    private Boolean PremiumMembership = false ;
    private Vector<Discount> discounts ;
    private Vector<Ticket> tickets ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Vector<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Vector<Discount> discounts) {
        this.discounts = discounts;
    }

    public Vector<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Vector<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Visitor(String name, Integer age, String phone_number, Integer balance, String email_id, String password, Zoo zoo)
    {
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.balance = balance;
        this.email_id = email_id;
        this.password = password;
        this.zoo = zoo;
        this.zoo.setRevenue(this.zoo.getRevenue() + balance);
        this.discounts = new Vector<>() ;
        this.tickets = new Vector<>() ;
        if (this.age < 18)
        {
            this.discounts.add(new Discount("Minor Discount", 10, "MINOR10")) ;
        }
        else if (this.age > 60)
        {
            this.discounts.add(new Discount("Senior Citizen Discount", 20, "SENIOR20")) ;
        }
    }

    public Boolean authenticate(String email_id, String password)
    {
        return this.email_id.equals(email_id) && this.password.equals(password) ;
    }

    public void buyMembership()
    {
        Scanner sc = new Scanner(System.in) ;
        System.out.print("""
                Buy Membership:
                1. Basic Membership (₹20)
                2. Premium Membership (₹50)
                Enter your choice:""");
        int choice = sc.nextInt() ;
        if (choice == 1)
        {
            System.out.print("Apply discount code: ");
            String code = sc.next() ;
            int valid = 0 ;
            Integer cost = 20 ;
            for (Discount discount : this.discounts)
            {
                if (discount.getDiscount_code().equals(code))
                {
                    cost -= 20*discount.getDiscount_percentage()/100 ;
                    System.out.println("Discount applied successfully. Ticket now costs ₹" + cost + ".") ;
                    valid = 1 ;
                    break ;
                }
            }
            if (valid == 0)
            {
                System.out.println("Invalid Discount Code") ;
            }
            if (this.balance >= cost)
            {
                this.balance -= cost ;
                this.BasicMembership = true ;
                this.zoo.setRevenue(this.zoo.getRevenue() + cost);
                System.out.println("Basic Membership bought successfully. Your balance is now " + this.balance + ".") ;
            }
            else
            {
                System.out.println("Insufficient Balance") ;
            }
        }
        else if (choice == 2)
        {
            System.out.println("Enter discount code: ");
            String code = sc.next() ;
            int valid = 0 ;
            Integer cost = 50 ;
            for (Discount discount : this.discounts)
            {
                if (discount.getDiscount_code().equals(code))
                {
                    cost -= 50*discount.getDiscount_percentage()/100 ;
                    System.out.println("Discount applied successfully. Ticket now costs ₹" + cost + ".") ;
                    valid = 1 ;
                    break ;
                }
            }
            if (valid == 0)
            {
                System.out.println("Invalid Discount Code") ;
            }
            if (this.balance >= cost)
            {
                this.balance -= cost ;
                this.PremiumMembership = true ;
                this.zoo.setRevenue(this.zoo.getRevenue() + cost);
                System.out.println("Premium Membership bought successfully. Your balance is now " + this.balance + ".") ;
            }
            else
            {
                System.out.println("Insufficient Balance") ;
            }
        }
        else
        {
            System.out.println("Invalid Choice") ;
        }
    }

    public void buyTickets()
    {
        if (!this.BasicMembership && !this.PremiumMembership)
        {
            System.out.println(this.zoo.getName() + " offers various attractions that allows you to explore unexplored trails. Buy your membership now!");
            return ;
        }
        if (this.PremiumMembership)
        {
            System.out.println("You have a Premium Membership. You can explore all the attractions for free!") ;
            return ;
        }
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Select an attraction to but Ticket for:");

        Integer i = 1 ;
        for (Attraction attraction : this.zoo.getAttractions())
        {
            if (attraction.getStatus())
            {
                System.out.println(i + ". " + attraction.getName() + " (₹" + attraction.getPrice() + ")");
                i++;
            }
        }
        System.out.println(i + ". Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt() ;

        if (i.equals(choice))
        {
            return ;
        }
        else if (choice <= 0 || choice > i)
        {
            System.out.println("Invalid Choice") ;
            return ;
        }
        else
        {
            i = 1 ;
            for (Attraction attraction : this.zoo.getAttractions())
            {
                if (choice == i)
                {
                    System.out.println("How many tickets would you like to buy?");

                    Integer choice2 = sc.nextInt() ;

                    if (choice2 > 0)
                    {
                        Integer cost = choice2*attraction.getPrice() ;
                        Integer special_deal = 0 ;
                        for (SpecialDeal spd : this.zoo.getSpecial_deals())
                        {
                            if (choice2 >= spd.getThreshold_number())
                            {
                                special_deal = max(special_deal, spd.getDiscount_percentage()) ;
                            }
                        }
                        if (special_deal != 0)
                        {
                            cost -= min((choice2*attraction.getPrice()*special_deal/100), cost) ;
                            System.out.println("Congratulations! Special Deal Applied! Ticket cost reduced from ₹" + choice2* attraction.getPrice()+ " to ₹" + cost + ".") ;
                        }
                        System.out.println("Total cost of " + choice2 + " tickets is ₹" + cost + ".") ;
                        System.out.println("Enter discount code: ");
                        String code = sc.next() ;
                        int valid = 0 ;
                        for (Discount discount : this.discounts)
                        {
                            if (discount.getDiscount_code().equals(code))
                            {
                                cost -= min(cost, (choice2*attraction.getPrice()*discount.getDiscount_percentage()/100)) ;
                                System.out.println("Discount applied successfully. Ticket now costs ₹" + cost + ".") ;
                                valid = 1 ;
                                break ;
                            }
                        }
                        if (valid == 0)
                        {
                            System.out.println("Invalid Discount Code") ;
                        }
                        if (this.balance >= cost)
                        {
                            this.balance -= cost ;
                            for (int j = 0; j < choice2 ; j ++) {
                                this.tickets.add(new Ticket(attraction));
                            }
                            this.zoo.setRevenue(this.zoo.getRevenue() + cost);
                            System.out.println("Ticket bought successfully. Your balance is now " + this.balance + ".") ;
                        }
                        else
                        {
                            System.out.println("Insufficient Balance") ;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid Choice") ;
                    }
                }
                i ++ ;
            }
        }
    }

    public void visitAttractionsUser()
    {
        Scanner sc = new Scanner(System.in) ;
        if (this.getZoo().getAttractions().isEmpty())
        {
            System.out.println("No attractions in the Zoo");
            return ;
        }
        System.out.println("Attractions in the Zoo: ");
        int i = 1 ;
        for (Attraction attraction : zoo.getAttractions())
        {
            if (attraction.getStatus()) {
                System.out.println(i + ". " + attraction.getName());
                i++;
            }
        }
        System.out.println(i + ". Exit");
        System.out.print("Enter your choice: ");
        int choice2 = sc.nextInt() ;
        if (i == choice2)
        {
            return ;
        }
        else if (choice2 <= 0 || choice2 > i)
        {
            System.out.println("Invalid Choice") ;
            return ;
        }
        else if (!this.BasicMembership && !this.PremiumMembership)
        {
            System.out.println(this.zoo.getName() + " offers various attractions that allows you to explore unexplored trails. Buy your ticket now!");
        }
        else if (this.PremiumMembership)
        {
            i = 1 ;
            for (Attraction attraction : this.zoo.getAttractions())
            {
                if (choice2 == i)
                {
                    System.out.println("You have a Premium Membership. You can explore the " + attraction.getName() + " for free!") ;
                    attraction.addVisitor();
                    return ;
                }
                i ++ ;
            }
        }
        else if (this.BasicMembership)
        {
            i = 1 ;
            for (Attraction attraction : this.zoo.getAttractions())
            {
                if (choice2 == i)
                {
                    int fl = 0 ;
                    for (Ticket ticket : this.tickets)
                    {
                        if (ticket.getAttraction().equals(attraction))
                        {
                            System.out.println("1 Ticket Used.\n" + "Thank you for visiting" + attraction.getName() + ". Hope you enjoyed the attraction.") ;
                            attraction.addVisitor();
                            this.tickets.remove(ticket) ;
                            fl = 1 ;
                            break ;
                        }
                    }
                    if (fl == 0)
                    {
                        System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                    }
                    break ;
                }
                i ++ ;
            }
        }
        else
        {
            System.out.println("Invalid Choice") ;
        }
    }

    public void visitAnimalsUser()
    {
        Scanner sc = new Scanner(System.in);
        viewAnimals(this.getZoo()) ;
        int i = this.zoo.getAnimals().size() + 1 ;
        System.out.print("Enter your choice: ");
        int choice2 = sc.nextInt();
        if (i == choice2)
        {
            return;
        }
        else if (choice2 <= 0 || choice2 > i)
        {
            System.out.println("Invalid Choice");
            return;
        }
        else
        {
            i = 1 ;
            for (Animal animal : this.zoo.getAnimals())
            {
                if (choice2 == i)
                {
                    System.out.println("1. Feed " + animal.getName());
                    System.out.println("2. View History of " + animal.getName());
                    choice2 = sc.nextInt() ;
                    if (choice2 == 1)
                    {
                        try
                        {
                            animal.feed();
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    else if (choice2 == 2)
                    {
                        System.out.println(animal.getHistory());
                    }
                    else
                    {
                        System.out.println("Invalid Choice");
                    }
                    break ;
                }
                i ++ ;
            }
        }
    }

    public void viewDiscounts()
    {
        if (this.discounts.isEmpty())
        {
            System.out.println("No discounts available");
            return ;
        }
        System.out.println("Discounts available: ");
        for (Discount discount : this.discounts)
        {
            System.out.println(discount.getDiscount_category() + " (" + discount.getDiscount_percentage() + "% off) - " + discount.getDiscount_code());
        }
    }

    public void viewSpecialDeals()
    {
        if (this.zoo.getSpecial_deals().isEmpty())
        {
            System.out.println("No special deals available");
            return ;
        }
        System.out.println("Special Deals available: ");
        for (SpecialDeal specialDeal : this.zoo.getSpecial_deals())
        {
            System.out.println(specialDeal.getThreshold_number() + " tickets - " + specialDeal.getDiscount_percentage() + "% off");
        }
    }

    public void leaveFeedback()
    {
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter your feedback: ");
        String feedback = sc.nextLine() ;
        this.zoo.getFeedbacks().add(new FeedBack(feedback)) ;
        System.out.println("Thank you for your feedback!") ;
    }
}