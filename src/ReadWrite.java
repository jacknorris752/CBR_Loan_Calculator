import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadWrite {

	//create methods for reading and writing Person's to local file
	//read must have a return type of "Person"
	
	
	public void save(Person person) {
		String fileName;
		//String fileName = person.name;
		fileName = person.name + ".bin";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("cases/"+fileName));
			//person.os = os;
			os.writeObject(person);
			os.close();
			load();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Person> load() {	//void needs to become List<Person>
		
		List<String> peoplePath = null;

		//creates list of all files, used this tutorial to help (https://www.mkyong.com/java/java-how-to-list-all-files-in-a-directory/)
		try (Stream<Path> walk = Files.walk(Paths.get("cases/"))) {

			peoplePath = walk.filter(Files::isRegularFile)
					.map(x -> x.toString()).collect(Collectors.toList());

			//peoplePath.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//for each file in people add a person to this list below
		ArrayList<Person> people = new ArrayList<Person>();
		
		for(String s : peoplePath) {
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(s));
				Person temp = new Person();
				try {
					temp = (Person) is.readObject();
					//System.out.println("temp has person: " + temp.name);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					//System.out.println("Person was not found");
					e.printStackTrace();
				}
				people.add(temp);
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return people;
	}
	
	public Person loadSpecific(String name) {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("cases/"+name+".bin"));
			Person temp = new Person();
			try {
				temp = (Person) is.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			is.close();
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
