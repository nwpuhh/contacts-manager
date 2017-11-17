package com.fredericboisguerin.insa;

import com.sun.deploy.util.SyncFileAccess;

import java.util.ArrayList;

/*
* @author nwpuhh
* The class of ContactManager, which contains the list of Contacts and it also has some attributes
* */
public class ContactsManager {
    private static final String FIELD_SEPARATOR = ", ";

    private String name;
    private String email;
    private String phoneNumber;

    //That is the list of the contacts
    private ArrayList<Contact> contacts;

    /**
     * The void Constructor of the ContactManager class
     */
    public ContactsManager() {
        this.name = "";
        this.email = "";
        this.phoneNumber = "";
        this.contacts = new ArrayList<Contact>();
    }

    /**
     * *The Constructor with arguements
     *
     * @param name
     * @param email
     * @param phoneNumber
     */
    public ContactsManager(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contacts = new ArrayList<Contact>();
    }

    /**
     * define the function of addContact in the list of the Contact
     *
     * @throws InvalidContactNameException: "" or null in the name
     * @throws InvalidEmailException:       which does not contain '@'
     * @input: name:String, email:String, phoneNumber: String
     * @output: void, but change the contacts
     */
    public void addContact(String name, String email, String phoneNumber)
            throws InvalidContactNameException, InvalidEmailException {
        if ((name == null) || (name.equals(""))) {
            throw new InvalidContactNameException();
        } else if ((email != null) && (!email.contains("@"))){
            throw new InvalidEmailException();
        } else {
            Contact c_temp = new Contact(name, email, phoneNumber);
            contacts.add(c_temp);
        }
    }

    public void printAllContacts() {
        String contact_info = "";



        for (int i = 0; i < contacts.size(); i++) {
            Contact c_temp = contacts.get(i);
            contact_info += c_temp.getName();

            if (c_temp.getEmail() != null) {
                contact_info += FIELD_SEPARATOR + c_temp.getEmail();
            }
            if (c_temp.getPhoneNumber() != null) {
                contact_info += FIELD_SEPARATOR + c_temp.getPhoneNumber() + "\n";
            }
        }

        System.out.println(contact_info);
    }

    /**
     * Search the contact by the name
     *
     * @param name
     */
    public void searchContactByName(String name) {
        for (Contact c : contacts) {
            String c_name = c.getName();
            String contact_info = "";
            if (c_name.toLowerCase().contains(name)) {
                contact_info += c_name;
                if (c.getEmail() != null) {
                    contact_info += FIELD_SEPARATOR + c.getEmail();
                }
                if (c.getPhoneNumber() != null) {
                    contact_info += FIELD_SEPARATOR + c.getPhoneNumber();
                }
                System.out.println(contact_info);
                break;
            }
        }
    }

    public void changeInfoOfContactExist(String name, String email_change, String telephone_change)
        throws NoContactFoundInList, InvalidContactNameException, InvalidEmailException {

        int i = 0;

        if(name == null || name.equals("")) {
            throw new InvalidContactNameException();
        }

        for(; i < contacts.size(); i++) {
            Contact c_temp = contacts.get(i);

            if(c_temp.getName().contains(name)) {
                if(!email.contains("@") || email == null) {
                    throw new InvalidEmailException();
                }
                else {
                    contacts.get(i).setEmail(email_change);
                }
                contacts.get(i).setPhoneNumber(telephone_change);
            }
        }

        if(i == contacts.size()) {
            throw new NoContactFoundInList();
        }
    }

    public void deleteContact(String name) throws InvalidContactNameException, NoContactFoundInList {
        if(name == null || name.equals("")) {
            throw new InvalidContactNameException();
        }

        int i = 0;
        boolean flag = false;

        for(; i < contacts.size(); i++) {
            if(contacts.get(i).getName().contains(name)) {
                contacts.remove(i);
                flag = true;
            }
        }

        if( !flag ) {
            throw new NoContactFoundInList();
        }
    }


}
