package wangyi;
import java.util.ArrayList;
import java.util.HashMap;

public class ex {
		public static void main(String[] args) {
			ArrayList<String> list =new ArrayList<String>();
//			list.add("A");
//			list.add("A");
//			list.add("A");
//			list.add("A");
//			list.add("A");
			for(int i=0;i<1000;i++) {
				if(i%2==0)
					//list.add(i+"");
					list.add(String.valueOf(i));
				
			}
			System.out.println(list);
			
			HashMap<String, Object> row= new HashMap<String,Object>();
			row.put("name","杨会");
			row.put("age",18);
			row.put("sex","famale");
			row.put("university","青岛大学");
			Object value =row.get("name");
			System.out.println(value.toString());
			
			
			
		}
				
}

