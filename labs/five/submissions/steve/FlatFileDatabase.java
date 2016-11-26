import java.io.*;
import java.util.*;
public class FlatFileDatabase{

private final String PATH = "tables\\";

	public boolean createTable(String fileName, String columnMeta) throws IOException{

		if (!columnMeta.startsWith("#"))
			return false;
		String[] columnData = columnMeta.split("::");
		if (columnData.length < 2)
			return false;

		PrintWriter writer = new PrintWriter(PATH + fileName);
		writer.println(columnMeta);
		writer.flush();
		writer.close();
		return true;
	}

	public boolean destroyTable(String fileName) throws FileNotFoundException{

		File table = new File (PATH+fileName);
		return table.delete();

	}

	public boolean create(String record, String fileName) throws FileNotFoundException, IOException{

		PrintWriter writer = new PrintWriter(new FileWriter(PATH+fileName, true));
		writer.println(record);
		writer.flush();
		writer.close();
		return true;

	}

	public String findOne(String record, String fileName) throws FileNotFoundException, IOException{

		Scanner reader = new Scanner(new File(PATH+fileName));
		String line;
		boolean recordFound = false;
		while (reader.hasNext() && !recordFound){
			line = reader.nextLine();
			String[] recordArray = line.split("::");
			if(recordArray[0].equals(record)){
				recordFound = true;
				reader.close();

				/*
					A "better" style approach would be to set a
					variable to return to null. Then in this loop update it
					as required. At the end, just return the variable. We wouldn't
					have to worry on the return if it updated or not.
				*/
				return line;
			}
		}
		reader.close();
		return null;
	}

	public boolean update(String record, String update, String fileName) throws FileNotFoundException, IOException{

		File oldFile = new File(PATH+fileName);
		Scanner reader = new Scanner(new File(PATH+fileName));
		String contents = "";
		while(reader.hasNext()){
			String line = reader.nextLine();
			String[] recordArray = line.split("::");
			line = recordArray[0].equals(record)? update : line;
			contents += (line == "" || !reader.hasNext())? line : line + "\n";
		}
		/*
			TABS!!!
			-1 pt
		*/
	reader.close();
	oldFile.delete();
	FlatFileDatabase updatedFile = new FlatFileDatabase();
	updatedFile.create(contents, fileName);

	/*
		Since we are returning a boolean, it would make sense we also needed
		to return false where appropriate. An appropriate place would be if
		we never found the record to update.

		-1 pt
	*/
	return true;
	}

	public boolean destroy(String record, String fileName) throws FileNotFoundException, IOException{

		update(record, "", fileName);
		return true;

	}

	/*
	Main initializes a new FlatFileDatabase, and populates it with the metadata followed by four character records.  Then, one of the records,
	Kalen Cook, in this case, is updated, and then destroyed.  Between each step, the record is shown, demonstrating its orignal value, updated
	value, and null value, as the program continues.  Finally, it deletes the entirety of the FlatFileDatabase.
	*/

	public static void main(String[] args) throws IOException, FileNotFoundException{
		FlatFileDatabase database = new FlatFileDatabase();
		database.createTable("Characters", "#Name::Description::Strength::Dexterity::Constitution::Intelligence::Defense");
		database.create("Gabriel Belmont::Human Paladin::26::16::25::12::21", "Characters");
		database.create("Kalen Cook::Miqo'te Scholar::13::15::12::27::16", "Characters");
		database.create("Drake Moonsilver::Elven Bard::12::27::14::23::18", "Characters");
		database.create("Darl Quethos::Schemeing Cleric::17::14::18::25::18", "Characters");
		System.out.println(database.findOne("Kalen Cook", "Characters"));
		database.update("Kalen Cook", "Kalen Cook::Miqo'te Scholar::15::18::14::31::18", "Characters");
		System.out.println(database.findOne("Kalen Cook", "Characters"));
		database.destroy("Kalen Cook", "Characters");
		System.out.println(database.findOne("Kalen Cook", "Characters"));
		//database.destroyTable("Characters");
	}
}
