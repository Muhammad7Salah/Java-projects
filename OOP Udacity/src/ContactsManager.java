
public class ContactsManager {

	Contact[] contactList;
	int count;
	
	public ContactsManager() {
		this.contactList = new Contact[500];
		this.count = 0;
	}
	
	public Boolean addContact(Contact contact) {
		try {
			contactList[count]=contact;
			count++;	
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Contact searchContact(String name) {
		for (int i=0;i<count; i++) {
			if(name.equals(contactList[i].Name)) {
				return contactList[i];
			}
		}
		Contact emerg = new Contact();
		emerg.Name="No Contact";
		return emerg;
	}
	
}
