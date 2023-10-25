package assignment2.ZOOtopia;

import java.util.* ;

import static assignment2.ZOOtopia.Admin.viewAnimals;
import static assignment2.ZOOtopia.Admin.viewAttractions;
import static java.lang.Thread.sleep;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc = new Scanner(System.in) ;

        Zoo Zootopia = new Zoo("ZOOtopia") ;
        Zootopia.setAdmin(new Admin("admin", "admin")) ;
        Admin admin = Zootopia.getAdmin() ;

        // Hard-coded 6 animals
        Zootopia.getAnimals().add(new Mammal("Simba (Lion)", "Roar", "Simba was born in a wildlife sanctuary and later brought to the zoo to raise awareness about the conservation of these magnificent big cats.")) ;
        Zootopia.getAnimals().add(new Mammal("Dumbo (Elephant)", "Trumpet", "Dumbo was rescued from a circus and found a new home in the zoo where he enjoys a spacious habitat and serves as an ambassador for the protection of elephants.")) ;

        Zootopia.getAnimals().add(new Reptile("Kaa (Python)", "Hiss", "Kaa was rescued from a snake charmer and found a new home in the zoo where he enjoys a spacious habitat and serves as an ambassador for the protection of snakes.")) ;
        Zootopia.getAnimals().add(new Reptile("Rango (Chameleon)", "Squeak", "Rango was rescued from a circus and found a new home in the zoo where he enjoys a spacious habitat and serves as an ambassador for the protection of chameleons.")) ;

        Zootopia.getAnimals().add(new Amphibian("Kermit (Frog)", "Ribbit", "Kermit was rescued from a circus and found a new home in the zoo where he enjoys a spacious habitat and serves as an ambassador for the protection of frogs.")) ;
        Zootopia.getAnimals().add(new Amphibian("Mr. Toad (Toad)", "Croak", "Mr. Toad was rescued from a circus and found a new home in the zoo where he enjoys a spacious habitat and serves as an ambassador for the protection of toads.")) ;

        int flag = 0 ;
        while (true)
        {
            if (flag == 0)
            {
                System.out.print("""
                        Welcome to ZOOtopia!
                        1. Enter as Admin
                        2. Enter as a Visitor
                        3. View Special Deals
                        4. Exit
                        """);
                System.out.print("Enter your choice");
                flag = sc.nextInt() ;
            }

            else if (flag == 1)
            {
                System.out.print("Enter admin username: ");
                String username = sc.next() ;

                System.out.print("Enter admin password: ");
                String password = sc.next() ;

                if (Zootopia.getAdmin().authenticate(username, password))
                {
                    System.out.println("Logged in as admin.\n");
                    while (true)
                    {
                        System.out.println("""
                                Admin Menu:
                                1. Manage Attractions
                                2. Manage Animals
                                3. Schedule Events
                                4. Set Discounts
                                5. Set Special Deal
                                6. View Visitor Stats
                                7. View Feedback
                                8. Exit
                                """);
                        System.out.print("Enter your choice: ");
                        int choice = sc.nextInt();
                        if (choice == 1)
                        {
                            System.out.println("""
                                    Manage Attractions:
                                    1. Add Attraction
                                    2. View Attractions
                                    3. Modify Attraction
                                    4. Remove Attraction
                                    5. Exit
                                    """);
                            System.out.print("Enter your choice: ");
                            int choice2 = sc.nextInt();
                            if (choice2 == 1)
                            {
                                admin.addAttraction(Zootopia);
                            }
                            else if (choice2 == 2)
                            {
                                viewAttractions(Zootopia);
                            }
                            else if (choice2 == 3)
                            {
                                admin.modifyAttraction(Zootopia);
                            }
                            else if (choice2 == 4)
                            {
                                admin.removeAttraction(Zootopia);
                            }
                            else if (choice2 == 5)
                            {
                                break ;
                            }
                            else
                            {
                                System.out.println("Invalid choice.\n");
                            }
                        }
                        else if (choice == 2)
                        {
                            System.out.println("""
                                    Manage Animals:
                                    1. Add Animal
                                    2. Update Animal Details
                                    3. Remove Animal
                                    4. Exit
                                    """);
                            System.out.print("Enter your choice: ");
                            int choice2 = sc.nextInt();
                            if (choice2 == 1)
                            {
                                admin.addAnimal(Zootopia);
                            }
                            else if (choice2 == 2)
                            {
                                admin.modifyAnimal(Zootopia);
                            }
                            else if (choice2 == 3)
                            {
                                admin.removeAnimal(Zootopia);
                            }
                            else if (choice2 == 4)
                            {
                                break ;
                            }
                            else
                            {
                                System.out.println("Invalid choice.\n");
                            }
                        }
                        else if (choice == 3)
                        {
                            admin.scheduleEvent(Zootopia);
                        }
                        else if (choice == 4)
                        {
                            System.out.println("""
                                    Set Discounts:
                                    1. Add Discount
                                    2. Modify Discount
                                    3. Remove Discount
                                    4. Exit
                                    """);
                            System.out.print("Enter your choice: ");
                            int choice2 = sc.nextInt();
                            if (choice2 == 1)
                            {
                                admin.addDiscount(Zootopia);
                            }
                            else if (choice2 == 2)
                            {
                                admin.modifyDiscount(Zootopia);
                            }
                            else if (choice2 == 3)
                            {
                                admin.removeDiscount(Zootopia);
                            }
                            else if (choice2 == 4)
                            {
                                break ;
                            }
                            else
                            {
                                System.out.println("Invalid choice.\n");
                            }
                        }
                        else if (choice == 5)
                        {
                            System.out.println("""
                                    Set Special Deal:
                                    1. Add Special Deal
                                    2. Modify Special Deal
                                    3. Remove Special Deal
                                    4. Exit
                                    """);
                            System.out.print("Enter your choice: ");
                            int choice2 = sc.nextInt();
                            if (choice2 == 1)
                            {
                                admin.addSpecialDeal(Zootopia);
                            }
                            else if (choice2 == 2)
                            {
                                admin.modifySpecialDeal(Zootopia);
                            }
                            else if (choice2 == 3)
                            {
                                admin.removeSpecialDeal(Zootopia);
                            }
                            else if (choice2 == 4)
                            {
                                break ;
                            }
                            else
                            {
                                System.out.println("Invalid choice.\n");
                            }
                        }
                        else if (choice == 6)
                        {
                            admin.visitorStats(Zootopia);
                        }
                        else if (choice == 7)
                        {
                            admin.viewFeedback(Zootopia);
                        }
                        else if (choice == 8)
                        {
                            flag = 0 ;
                            System.out.println("Logging out...\n");
                            sleep(500) ;
                            System.out.println("Logged out.\n");
                            break ;
                        }
                        else
                        {
                            System.out.println("Invalid choice.\nExiting...\n");
                            flag = 0 ;
                            break ;
                        }
                    }
                }
                else
                {
                    System.out.print("Invalid credentials. Try again.\n");
                    flag = 0 ;
                }
            }

            else if (flag == 2)
            {
                Visitor current_Visitor = null ;
                System.out.println("""
                        1. Register
                        2. Login
                        3. Exit
                        """);
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                if (choice == 1)
                {
                    System.out.print("Enter your name: ");
                    String name = sc.next() ;

                    System.out.print("Enter your age: ");
                    int age = sc.nextInt() ;

                    System.out.print("Enter your phone number: ");
                    String phone = sc.next() ;

                    System.out.print("Enter visitor balance: ");
                    int balance = sc.nextInt() ;

                    System.out.print("Enter visitor email: ");
                    String email = sc.next() ;

                    System.out.print("Enter visitor password: ");
                    String password = sc.next() ;

                    Zootopia.getVisitors().add(new Visitor(name, age, phone, balance, email, password, Zootopia)) ;
                    System.out.println("\nRegistered successfully.\n");
                }
                else if (choice == 2)
                {
                    System.out.print("Enter visitor email: ");
                    String email = sc.next() ;

                    System.out.print("Enter visitor password: ");
                    String password = sc.next() ;

                    for (int i = 0 ; i < Zootopia.getVisitors().size() ; i++)
                    {
                        if (Zootopia.getVisitors().get(i).authenticate(email, password))
                        {
                            System.out.println("Logged in as visitor.\n");
                            current_Visitor = Zootopia.getVisitors().get(i) ;
                            break ;
                        }
                    }
                    if (current_Visitor == null)
                    {
                        System.out.println("Invalid credentials. Try again.\n");
                        flag = 0 ;
                    }
                    else
                    {
                        while (true)
                        {
                            System.out.println("""
                                    Visitor Menu:
                                    1. Explore the Zoo
                                    2. Buy Membership
                                    3. Buy Tickets
                                    4. View Discounts
                                    5. View Special Deals
                                    6. Visit Animals
                                    7. Visit Attractions
                                    8. Leave Feedback
                                    9. Log Out
                                    """);
                            System.out.print("Enter your choice: ");
                            int choice2 = sc.nextInt();
                            if (choice2 == 1)
                            {
                                System.out.println("""
                                        Explore the Zoo:
                                        1. View Attractions
                                        2. View Animals
                                        3. Exit
                                        """);
                                System.out.print("Enter your choice: ");
                                int choice3 = sc.nextInt();
                                if (choice3 == 1)
                                {
                                    viewAttractions(Zootopia);
                                }
                                else if (choice3 == 2)
                                {
                                    viewAnimals(Zootopia);
                                }
                                else if (choice3 == 3)
                                {
                                    break ;
                                }
                                else
                                {
                                    System.out.println("Invalid choice.\n");
                                }
                            }
                            else if (choice2 == 2)
                            {
                                current_Visitor.buyMembership();
                            }
                            else if (choice2 == 3)
                            {
                                current_Visitor.buyTickets();
                            }
                            else if (choice2 == 4)
                            {
                                current_Visitor.viewDiscounts();
                            }
                            else if (choice2 == 5)
                            {
                                current_Visitor.viewSpecialDeals();
                            }
                            else if (choice2 == 6)
                            {
                                current_Visitor.visitAnimalsUser() ;
                            }
                            else if (choice2 == 7)
                            {
                                current_Visitor.visitAttractionsUser();
                            }
                            else if (choice2 == 8)
                            {
                                current_Visitor.leaveFeedback();
                            }
                            else if (choice2 == 9)
                            {
                                flag = 0 ;
                                System.out.println("Logging out...\n");
                                sleep(500) ;
                                System.out.println("Logged out.\n");
                                current_Visitor = null ;
                                break ;
                            }
                            else
                            {
                                System.out.println("Invalid choice.\nExiting...\n");
                                current_Visitor = null ;
                                flag = 0 ;
                                break ;
                            }
                        }
                    }
                }
                else if (choice == 3)
                {
                    current_Visitor = null ;
                    flag = 0 ;
                }
                else
                {
                    System.out.println("Invalid choice.\n");
                    flag = 0 ;
                }
            }
            else if (flag == 3)
            {
                System.out.println("Special Deals:\n") ;
                for (int i = 0 ; i < Zootopia.getSpecial_deals().size() ; i++)
                {
                    System.out.println(i + ". Buy " + Zootopia.getSpecial_deals().get(i).getThreshold_number() + " tickets to get " + Zootopia.getSpecial_deals().get(i).getDiscount_percentage() + "% discount on your purchase!\n");
                }
                flag = 0 ;
            }
            else if (flag == 4)
            {
                System.out.println("Exiting...\n");
                sleep(500) ;
                System.out.println("Exited.\n");
                break ;
            }
            else
            {
                System.out.println("Invalid choice.\n");
                flag = 0 ;
            }
        }
    }
}