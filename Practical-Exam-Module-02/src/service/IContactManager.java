package service;

public interface IContactManager {
    void displayContacts();

    void addContact();

    void updateContact();

    void deleteContact();

    void search();

    void loadFromFile();

    void saveToFile();
}
