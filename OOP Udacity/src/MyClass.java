
public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContactsManager contactManager = new ContactsManager();
		System.out.println("created contact manager");
		Contact contact = new Contact();
		contact.Name = "Muhammad Salah";
		contact.Telephone = "00201127313125";

		contactManager.addContact(contact);
		
		contact.Name = "Ostaz Salah";
		contact.Telephone = "00201127313125";

		contactManager.addContact(contact);

		contact.Name = "Muhammad Salah El-Okda";
		contact.Telephone = "00201015005231";

		contactManager.addContact(contact);

		contact.Name = "3m salah";
		contact.Telephone = "00201127313263";
		
		contactManager.addContact(contact);
		
		String res = contactManager.searchContact("3m salahh").Name;
		
		System.out.println(res);
	}

}
