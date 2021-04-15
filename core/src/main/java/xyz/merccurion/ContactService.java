package xyz.merccurion;

public class ContactService {
    
    Util util = new Util();

    public Contact addContactDetails() {

        String landline = util.getString("Landline: ");
        String mobile = util.getString("Mobile: ");
        String email = util.getString("email: ");

        // String landline = "375-1495";
        // String mobile = "09152435453";
        // String email = "jlacson@exist.com";

        Contact contact = new Contact(landline,mobile,email);

        return contact;
    }

    public void addContact(Contact contact) {
        ContactDao cDao = new ContactDao();
        cDao.addContact(contact);
    }
}
