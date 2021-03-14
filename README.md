# Trippable - Ironhack Final project

Welcome to tripable! An application created to simplify the management of trips between groups of friends, family and couples. No more manual accounting!

This first version includes an expense, task and calendar manager, where you can create new trips, add participants and manage trip-related expenses. 
At the end of the trip you can check the balance to settle the accounts.

In future versions, you will be able to manage flight search, check the weather at destination, and even verify the restrictions related to COVID19.

## Instalation

1. Download the project from the repository. 

2. Create your database using the tables provided.

3. Run backend (`mvn spring-boot:run`)

4. Set up Angular Material by running the following command: `ng add @angular/material` 

5. Run frontend (`ng serve -o`). 

6. Start planning trips with your friends!

## Functionalities

- **Create a new user**: Fill the field form to create as many users as you want
- **Add users to a group**: When the users are created, you can add them to a group, where you will need to set a description
- **Add expenses**: Each time a group member makes a payment for the group, add it to the Expenses tab, indicating the amount paid, a brief description of the transaction and who paid for it
- **Check balance**: You can check the status of your accounts at any time through the Balance tab, where you can see who owes whom and how much money.
- **Add tasks**: There is also the possibility of creating tasks, which can be monitored through the calendar.
