# ZOOtopia Application

ZOOtopia is a virtual zoo management application that simulates the operation of a zoo. This application is designed to manage attractions, animals, events, discounts, special deals, and provide a platform for visitors to explore the virtual zoo.

## Table of Contents
1. [Introduction](#introduction)
2. [How to Run the Application](#how-to-run-the-application)
3. [Code Structure](#code-structure)
4. [Animal Interface and Subclasses](#animal-interface-and-subclasses)
5. [Classes](#classes)
   - [Attraction](#attraction)
   - [Discount](#discount)
   - [FeedBack](#feedback)
   - [SpecialDeal](#specialdeal)
   - [Ticket](#ticket)
   - [Admin](#admin)
   - [Visitor](#visitor)
   - [Zoo](#zoo)
   - [Main](#main)

## Introduction

ZOOtopia is a virtual zoo management application that allows administrators to manage various aspects of a zoo, including attractions, animals, events, discounts, special deals, and visitor statistics. Visitors can explore the zoo, purchase tickets, buy memberships, and leave feedback.

## How to Run the Application

To run the ZOOtopia application using Maven on PowerShell or cmd, follow these steps:

1. Clone the ZOOtopia repository to your local machine.
2. Open your terminal (PowerShell or cmd) and navigate to the project directory.
3. Build the application using Maven by running the following command:
```bash
  mvn install
```

4. After the build is successful, you can run the application with the following command:
```bash
  mvn exec:java
```

5. Follow the on-screen instructions to interact with the application as an administrator or visitor.
6. To delete the jar files, run the following command:
```bash
  mvn clean
```

## Code Structure

The ZOOtopia application is organized into several classes and interfaces to manage the zoo efficiently.

### Animal Interface and Subclasses

The `Animal` interface serves as a base for animal-related classes, and it has the following subclasses:

1. `Mammal`: Represents mammals in the zoo.
2. `Amphibian`: Represents amphibians in the zoo.
3. `Reptile`: Represents reptiles in the zoo.

For each animal subclass, you can find attributes and methods that describe the animals' characteristics and details.

### Classes

The following classes are the core components of the ZOOtopia application:

#### Attraction

- Manages attractions in the zoo.
- Allows administrators to add, view, modify, and remove attractions.
- Stores attraction information, such as name, description, UID, and price.

#### Discount

- Manages discounts that visitors can apply to their purchases.
- Allows administrators to add, modify, and remove discounts.
- Stores discount details, including category, percentage, and code.

#### FeedBack

- Represents visitor feedback.
- Stores visitor comments and feedback.

#### SpecialDeal

- Manages special deals for visitors.
- Allows administrators to add, modify, and remove special deals.
- Stores information about the threshold number and discount percentage.

#### Ticket

- Handles visitor tickets.
- Manages ticket purchases and memberships.

#### Admin

- The `Admin` class represents an administrator of the virtual zoo.
- Administrators have the authority to manage various aspects of the zoo, making it a pivotal role in the application.
- Functionalities of the `Admin` class include:
   - Managing attractions by adding, viewing, modifying, or removing them.
   - Handling animals by adding, viewing, modifying, or removing them.
   - Scheduling events, changing attraction statuses, and updating ticket prices.
   - Managing discounts by adding, modifying, or removing them.
   - Handling special deals, modifying them, and removing them.
   - Tracking visitor statistics, such as the total number of visitors and revenue.
   - Viewing and managing visitor feedback.

#### Visitor

- The `Visitor` class represents visitors to the virtual zoo.
- Visitors can explore the virtual zoo, purchase tickets, buy memberships, and provide feedback.
- Functionalities of the `Visitor` class include:
   - Exploring the zoo, including viewing attractions and animals.
   - Purchasing tickets and memberships for zoo access.
   - Providing feedback on their zoo experience.

#### Zoo

- The `Zoo` class is a fundamental component that represents the virtual zoo itself.
- The `Zoo` class is responsible for managing various aspects of the zoo, including its administrators, animals, attractions, discounts, special deals, visitor statistics, and feedback.
- It oversees the operation and coordination of all zoo components.
- The `Zoo` class is the central hub for data and functionality within the application.

#### Main

- The `Main` class is the entry point of the ZOOtopia application.
- It provides a user-friendly menu-based interface for users to interact with the application.
- Users can log in as administrators or visitors and access the functionalities of the application.
- This class coordinates and initiates the operation of ZOOtopia.

The interaction between the `Admin`, `Visitor`, and `Zoo` classes, facilitated by the `Main` class, forms the backbone of the ZOOtopia application. Administrators control the zoo's operations, while visitors engage with the virtual zoo, all orchestrated by the `Zoo` class's overarching management.

This code structure empowers the efficient management and operation of the virtual zoo, offering a rich and engaging experience to both administrators and visitors.

For detailed information on each class and its functionalities, refer to the class descriptions within the source code.

If you have any questions or need further assistance, feel free to reach out to me at [yash22586@iiitd.ac.in](mailto:yash22586@iiitd.ac.in).

Happy zoo management in ZOOtopia!
