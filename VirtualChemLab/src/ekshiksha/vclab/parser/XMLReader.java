package ekshiksha.vclab.parser;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;

import ekshiksha.vclab.equipment.Equipment;

public class XMLReader {
	public static final int TYPE_EQUIPMENT = 1; //for multiplexing different types of reading
	public static final int TYPE_ACTIVITY = 2;   //for multiplexing different types of reading
	Iterator<XmlReader.Element> iterator;
	public XMLReader(String url,int type)
	{
		XmlReader xml = new XmlReader();
		try 
		{
			XmlReader.Element xml_element = xml.parse(Gdx.files.internal(url));
			XmlReader.Element xml_setup = xml_element.getChildByName("Setup");
		    iterator = xml_setup.getChildrenByName("Equipment").iterator();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ArrayList getArrayListComponents()
	{
		ArrayList<Equipment> list_components = new ArrayList<Equipment>();		
		while(iterator.hasNext())
		{
			XmlReader.Element tmp_element = iterator.next();
			String tmp_equipment_type = tmp_element.getAttribute("Type");
			Equipment tmp_equipment = new Equipment(tmp_equipment_type);
			list_components.add(tmp_equipment);
			Gdx.app.log("equipment xml","type="+tmp_equipment_type);
		}
		return list_components;
	}
}
