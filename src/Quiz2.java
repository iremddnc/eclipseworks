import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;

public class Quiz2 {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   
		        Map<String, ArrayList<String>> courses = new HashMap<>();
		        courses.put("Cse1", new ArrayList<>(Arrays.asList("123", "234", "456")));
		        courses.put("Cse2", new ArrayList<>(Arrays.asList("456", "567")));
		        
		        System.out.println(courses);
		        System.out.println(switchMap(courses));
		        System.out.println(switchMap(switchMap(courses)));
		    }

		    public static Map<String, ArrayList<String>> switchMap(Map<String, ArrayList<String>> courses) {
		        Map<String, ArrayList<String>> switchedMap = new HashMap<>();

		        for (Map.Entry<String, ArrayList<String>> entry : courses.entrySet()) {
		            String key = entry.getKey();
		            List<String> values = entry.getValue();

		            for (String value : values) {
		                List<String> currentList = switchedMap.getOrDefault(value, new ArrayList<>());
		                currentList.add(key);
		                switchedMap.put(value, (ArrayList<String>) currentList);
		            }
		        }

		        return switchedMap;
		    }
		}



