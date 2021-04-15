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

    public Contact getContact(int id) {
        ContactDao cDao = new ContactDao();
        Contact contact = cDao.getContact(id);
        return contact;
    }

    public void deleteContact(int id) {
        ContactDao cDao = new ContactDao();
        Contact contact = cDao.getContact(id);
        cDao.deleteContact(contact);
    }

    public Contact updateContactDetails(Contact contact, int id) {
        String update;
        
        switch(id) {
            case 1: // landline
                update = util.getString("Updated landline: ");
                contact.setLandline(update);
                break;
            
            case 2: // mobile
                update = util.getString("Updated mobile: ");
                contact.setMobile(update);
                break;

            case 3: // email
                update = util.getString("Updated email: ");
                contact.setEmail(update);
                break;

        }
        ContactDao cDao = new ContactDao();
        cDao.updateContact(contact);
        return contact;
    }

    
}
