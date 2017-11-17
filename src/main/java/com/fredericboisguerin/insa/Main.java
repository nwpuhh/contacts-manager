package com.fredericboisguerin.insa;

import java.util.Scanner;

public class Main  {
        public static void main(String [] args)
                throws InvalidContactNameException, InvalidEmailException, NoContactFoundInList {

            Scanner scan = new Scanner(System.in);

            //define the way of input
            System.out.println("Please enter the name of the ContactManager");
            String name_manager = scan.nextLine();

            System.out.println("Please enter the email of the ContactManager");
            String email_manager = scan.nextLine();

            System.out.println("Please enter the telephone of the ContactManager");
            String telephone_manager = scan.nextLine();

            //contruct a new contactManager
            ContactsManager manager = new ContactsManager(name_manager, email_manager, telephone_manager);

            System.out.println("A contactManager is constructed!!");

            System.out.println("Please enter the command of choosing the actions");
            System.out.println("1: add Contact\n" + "2: Print all the contacts\n"
                    + "3: Change the information of Contacts who are in the list\n"
                    + "4: Delete the Contatc which is chosen\n" + "5: exit\n");
            String command = scan.nextLine();
            while(!command.equals("5")) {
                switch (command) {
                    //define the add action
                    case "1":
                        System.out.println("Please enter the name of Contact");
                        String name = scan.nextLine();
                        System.out.println("Please enter the email of Contact");
                        String email = scan.nextLine();
                        System.out.println("Please enter the telephone of Contact");
                        String telephone = scan.nextLine();
                        try {
                            manager.addContact(name, email, telephone);
                        } catch (InvalidContactNameException e) {
                            e.printStackTrace();
                        } catch (InvalidEmailException e) {
                            e.printStackTrace();
                        }
                        break;

                    //define print all the contact
                    case "2":
                        manager.printAllContacts();
                        break;

                    //the change of information of the contacts
                    case "3":
                        System.out.println("Enter the name of the Contact who you want to change the info");
                        String name_contact = scan.nextLine();
                        System.out.println("Enter the new Email");
                        String email_new = scan.nextLine();
                        System.out.println("Enter the new telephone");
                        String telephone_new = scan.nextLine();

                        try {
                            manager.changeInfoOfContactExist(name_contact, email_new, telephone_new);
                        } catch (NoContactFoundInList e) {
                            e.printStackTrace();
                        } catch (InvalidEmailException e) {
                            e.printStackTrace();
                        } catch (InvalidContactNameException e) {
                            e.printStackTrace();
                        }
                        break;
                    //define the delete action
                    case "4":
                        System.out.println("Enter the name of the Contact who you want to delete");
                        String name_delete = scan.nextLine();
                        try {
                            manager.deleteContact(name_delete);
                        } catch (InvalidContactNameException e) {
                            e.printStackTrace();
                        } catch (NoContactFoundInList e) {
                            e.printStackTrace();
                        }
                        break;

                    case "5":
                        System.out.println("Exit");
                        break;
                }

                System.out.println("Please enter the command of choosing the actions");
                System.out.println("1: add Contact\n" + "2: Print all the contacts\n"
                        + "3: Change the information of Contacts who are in the list\n"
                        + "4: Delete the Contatc which is chosen\n" + "5: exit\n");
                command = scan.nextLine();
            }

            System.out.println("You have exit, Thank you! :D");
        }
}
