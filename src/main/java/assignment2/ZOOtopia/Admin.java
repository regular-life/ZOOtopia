package assignment2.ZOOtopia;

import java.io.* ;
import java.util.* ;

class Admin
{
    private String username ;
    private String password ;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Boolean authenticate(String username, String password)
    {
        return this.username.equals(username) && this.password.equals(password);
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addAttraction(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter attraction name: ");
        String name = sc.nextLine() ;

        System.out.print("Enter Attraction Description: ");
        String description = sc.nextLine() ;

        System.out.print("Enter Attraction Price: ");
        Integer price = sc.nextInt() ;

        String uid = UUID.randomUUID().toString() ;

        zoo.getAttractions().add(new Attraction(name, description, uid, price)) ;
        System.out.println("Attraction added successfully") ;
    }

    public static void viewAttractions(Zoo zoo)
    {
        if (zoo.getAttractions().isEmpty())
        {
            System.out.println("No attractions in the Zoo");
            return ;
        }
        System.out.println("Attractions in the Zoo: ");
        int i = 1 ;
        for (Attraction attraction : zoo.getAttractions())
        {
            System.out.println(i + ". " + attraction.getName() + " - UID: " + attraction.getUid() + " - Status: " + (attraction.getStatus() ? "Open" : "Closed") );
            i ++ ;
        }
        System.out.println(i + ". Exit");
    }

    public void modifyAttraction(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter Attraction UID: ") ;
        String uid = sc.nextLine() ;

        for (Attraction attraction : zoo.getAttractions())
        {
            if (attraction.getUid().equals(uid))
            {
                System.out.print("Enter new name: ");
                String name = sc.nextLine() ;

                System.out.print("Enter new description: ");
                String description = sc.nextLine() ;

                System.out.print("Enter new price: ");
                Integer price = sc.nextInt() ;

                attraction.setName(name);
                attraction.setDescription(description);
                attraction.setPrice(price);

                System.out.println("Attraction modified successfully") ;
                return ;
            }
        }
    }

    public void removeAttraction(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter Attraction UID: ") ;
        String uid = sc.nextLine() ;

        for (Attraction attraction : zoo.getAttractions())
        {
            if (attraction.getUid().equals(uid))
            {
                zoo.getAttractions().remove(attraction) ;
                System.out.println("Attraction removed successfully") ;
                return ;
            }
        }
        System.out.println("Attraction not found");
    }

    public static void viewAnimals(Zoo zoo)
    {
        Vector<Animal> animals = zoo.getAnimals();
        if (animals.isEmpty())
        {
            System.out.println("No animals in the Zoo");
            return ;
        }
        System.out.println("Animals in the Zoo: ");
        int i = 1 ;
        for (Animal animal : animals)
        {
            System.out.println(i + ". " + animal.getName());
            i ++ ;
        }
        System.out.println(i + ". Exit");
    }

    public void addAnimal(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter animal name: ");
        String name = sc.nextLine() ;

        System.out.println("Enter animal type: ");
        String type = sc.nextLine() ;

        System.out.print("Enter animal sound: ");
        String sound = sc.nextLine() ;

        System.out.println("Enter animal history: ");
        String history = sc.nextLine() ;

        switch (type) {
            case "Mammal" -> zoo.getAnimals().add(new Mammal(name, sound, history));
            case "Reptile" -> zoo.getAnimals().add(new Reptile(name, sound, history));
            case "Amphibian" -> zoo.getAnimals().add(new Amphibian(name, sound, history));
            case null, default -> System.out.println("Invalid Animal Type");
        }
    }

    public void modifyAnimal(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter Animal Name: ") ;
        String name = sc.nextLine() ;

        for (Animal animal : zoo.getAnimals())
        {
            if (animal.getName().equals(name))
            {
                System.out.print("Enter new name: ");
                String new_name = sc.nextLine() ;

                System.out.print("Enter new sound: ");
                String sound = sc.nextLine() ;

                System.out.print("Enter new history: ");
                String history = sc.nextLine() ;

                animal.setName(new_name);
                animal.setSound(sound);
                animal.setHistory(history);

                System.out.println("Animal modified successfully") ;
                return ;
            }
        }
    }

    public void removeAnimal(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter Animal Name: ") ;
        String name = sc.nextLine() ;

        for (Animal animal : zoo.getAnimals())
        {
            if (animal.getName().equals(name))
            {
                zoo.getAnimals().remove(animal) ;
                System.out.println("Animal removed successfully") ;
                return ;
            }
        }
    }

    public void scheduleEvent(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter Attraction UID:");
        String uid = sc.nextLine() ;

        for (Attraction attraction : zoo.getAttractions())
        {
            if (attraction.getUid().equals(uid))
            {
                System.out.print("Current status: " + (attraction.getStatus() ? "Open." : "Closed.") + " Do you wish to change the status? (y/n): ") ;
                String choice = sc.nextLine() ;
                if (choice.startsWith("y"))
                {
                    attraction.setStatus( (!attraction.getStatus())) ;
                    System.out.println("Status changed successfully") ;
                }
                else
                {
                    System.out.println("Status not changed.") ;
                }

                System.out.print("Current ticket price: " + attraction.getPrice() + ". Do you wish to change the price? (y/n): ") ;
                choice = sc.nextLine() ;
                if (choice.startsWith("y"))
                {
                    System.out.print("Enter new price: ");
                    Integer price = sc.nextInt() ;
                    attraction.setPrice(price);
                    System.out.println("Price changed successfully") ;
                }
                else
                {
                    System.out.println("Price not changed.") ;
                }
            }
        }
    }

    public void addDiscount(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter Discount Category: ");
        String category = sc.nextLine() ;

        System.out.print("Enter Discount Percentage: ");
        Integer percentage = sc.nextInt() ;

        System.out.print("Enter Discount Code: ");
        String code = sc.nextLine() ;

        zoo.getDiscounts().add(new Discount(category, percentage, code)) ;
    }

    public void modifyDiscount(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter Discount Code: ");
        String code = sc.nextLine() ;

        for (Discount discount : zoo.getDiscounts())
        {
            if (discount.getDiscount_code().equals(code))
            {
                System.out.print("Enter new category: ");
                String category = sc.nextLine() ;

                System.out.print("Enter new percentage: ");
                Integer percentage = sc.nextInt() ;

                discount.setDiscount_category(category);
                discount.setDiscount_percentage(percentage);

                System.out.println("Discount modified successfully") ;
                return ;
            }
        }
    }

    public void removeDiscount(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter Discount Code: ");
        String code = sc.nextLine() ;

        for (Discount discount : zoo.getDiscounts())
        {
            if (discount.getDiscount_code().equals(code))
            {
                zoo.getDiscounts().remove(discount) ;
                System.out.println("Discount removed successfully") ;
                return ;
            }
        }
    }

    public void addSpecialDeal(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter minimum coupons needed to but to avail:");
        Integer threshold_number = sc.nextInt() ;

        System.out.print("Enter discount percentage:");
        Integer discount_percentage = sc.nextInt() ;

        zoo.getSpecial_deals().add(new SpecialDeal(threshold_number, discount_percentage)) ;
    }
    public void modifySpecialDeal(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter minimum coupons needed to but to avail:");
        Integer threshold_number = sc.nextInt() ;

        for (SpecialDeal specialDeal : zoo.getSpecial_deals())
        {
            if (specialDeal.getThreshold_number().equals(threshold_number))
            {
                System.out.print("Enter new discount percentage:");
                Integer discount_percentage = sc.nextInt() ;

                specialDeal.setDiscount_percentage(discount_percentage);

                System.out.println("Special Deal modified successfully") ;
                return ;
            }
        }
    }

    public void removeSpecialDeal(Zoo zoo)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter minimum coupons needed to but to avail:");
        Integer threshold_number = sc.nextInt() ;

        for (SpecialDeal specialDeal : zoo.getSpecial_deals())
        {
            if (specialDeal.getThreshold_number().equals(threshold_number))
            {
                zoo.getSpecial_deals().remove(specialDeal) ;
                System.out.println("Special Deal removed successfully") ;
                return ;
            }
        }
    }

    public void visitorStats(Zoo zoo)
    {
        System.out.println("Visitor Stats: ");
        System.out.println("Total Visitors: " + zoo.getVisitors().size()) ;
        System.out.println("Total Revenue: " + zoo.getRevenue()) ;
        int mx = 0 ;
        Attraction attr = null ;
        for (Attraction attraction : zoo.getAttractions())
        {
            if (attraction.getVisitors_count() > mx)
            {
                mx = attraction.getVisitors_count() ;
                attr = attraction ;
            }
        }
        if (mx > 0)
        {
            System.out.println("Most visited attraction: " + attr.getName()) ;
        }
        else
        {
            System.out.println("No attractions visited yet") ;
        }
    }

    public void viewFeedback(Zoo zoo)
    {
        if (zoo.getFeedbacks().isEmpty())
        {
            System.out.println("No feedbacks in the Zoo");
            return ;
        }
        System.out.println("Feedbacks in the Zoo: ");
        int i = 1 ;
        for (FeedBack feedback : zoo.getFeedbacks())
        {
            System.out.println(i + ". " + feedback.getComment());
            i ++ ;
        }
    }

}
