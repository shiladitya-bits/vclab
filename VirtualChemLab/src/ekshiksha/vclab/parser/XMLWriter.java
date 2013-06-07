package ekshiksha.vclab.parser;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlWriter;

import ekshiksha.vclab.equipment.Equipment;


public class XMLWriter {
	public static final int TYPE_EQUIPMENT = 1; //for multiplexing different types of reading
	public static final int TYPE_ACTIVITY = 2; //for multiplexing different types of reading
	public static void write(String url,ArrayList list,int type)
	{
		StringWriter writer = new StringWriter();
		XmlWriter xml_writer = new XmlWriter(writer);
		FileHandle writeFile = Gdx.files.local(url);
		//writeFile.mkdirs();
		
		try {
			writeFile.file().createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try
		{
			//Specification
			xml_writer.element("Specification")
				.attribute("SpecificationAuthor", "Shiladitya")
				.attribute("Title", "Virtual Chemistry Lab");
			
			//Header
			xml_writer.element("Header")
					.attribute("Title",2)
					.attribute("Author",2)
					.attribute("Level",2)
					.attribute("Marks",2)
					.attribute("Description",2)
					.attribute("Student",2)
					.attribute("Instruction",2)
					.pop();
			
			//Setup
			xml_writer.element("Setup");
			switch(type)
			{
			case TYPE_EQUIPMENT:
				Iterator<Equipment> iter = list.iterator();
				while(iter.hasNext())
				{
					Equipment tmp_equipment = iter.next();
					String equipment_type = tmp_equipment.getName();
					xml_writer.element("Equipment")  //write the equipment details
						.attribute("Type", equipment_type)
						.pop(); 	
				}
			}
			xml_writer.pop();  //pop setup
			xml_writer.pop();  //pop specification
			
			//writing to file output
			Gdx.app.log("xml write output", writer.toString());
			//writeFile.writeString("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>", false);
			writeFile.writeString(writer.toString(), false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
