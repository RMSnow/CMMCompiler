package demo.org.cmm.interpreter;

import java.util.HashMap;
import java.util.Map;

public class VarMap{
	private Map<String , VarMapItem> indexMap;
	
	public VarMap(){
		this.indexMap = new HashMap<String , VarMapItem>();
	}
	
	public void put(String name,String type,String value){
		this.indexMap.put(name, new VarMapItem(type,value));
	}
	
	public boolean remove(String name){
		if(!this.indexMap.containsKey(name))return false;
		this.indexMap.remove(name);
		return true;
	}
	
	public boolean contains(String name){
		return this.indexMap.containsKey(name);
	}
	
	public String getType(String name){
		return this.indexMap.get(name).type;
	}
	
	public String getValue(String name){
		return this.indexMap.get(name).value;
	}
	
	public boolean setValue(String name,String value){
		if(!this.indexMap.containsKey(name))return false;
		this.indexMap.get(name).value=value;
		//System.out.println("set "+name+" to "+this.indexMap.get(name).value);
		return true;
	}
	
	private class VarMapItem{
		private String type;
		private String value;
		
		private VarMapItem(String type,String value){
			this.type = type;
			this.value = value;
		}
	}
	
	public void outputVar(String name){
		System.out.println("Type:"+this.getType(name)+",Name:"+name+",Value:"+this.getValue(name));
	}
	
	public static void main(String[] args){
		VarMap m = new VarMap();
		m.put("name", "type", "value");
		m.remove("name"); 
		System.out.println(m.contains("name"));
	}
}
