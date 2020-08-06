package files;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JsonPath js=new JsonPath(Payload.CoursePrice());
		//1.Print No of courses returned by API
		//size is used only for array,used to find no. of elements in json path
		int count=	js.getInt("courses.size()");
		System.out.println(count);
		//2.Print Purchase Amount
		int totalAmount= js.getInt("dashboard.purchaseAmount");//path of the json parent.child
		System.out.println(totalAmount);
		//3.Print Title of the first course
		String titleFirstCourse=js.get("courses[0].title");//zero is the index of the json text for first element
		System.out.println(titleFirstCourse);
		  
		  //4.Print All course titles and their respective Prices
		  //use loop to iterate through all items 
		  for(int i=0;i<count;i++)
		  {
			  String courseTitles=js.get("courses["+i+"].title");
			  System.out.println(js.get("courses["+i+"].price").toString());
			  
			  System.out.println(courseTitles);
			  
		  }
		  
		  //5.Print no of copies sold by RPA Course
		  
		  System.out.println("Print no of copies sold by RPA Course");
		  
		  for(int i=0;i<count;i++)
		  {
		 	  String courseTitles=js.get("courses["+i+"].title");
		 	  //check condition for specific title
		 	  if(courseTitles.equalsIgnoreCase("RPA"))
		 	  {
		 		  int copies=js.get("courses["+i+"].copies");
		 		  System.out.println(copies);
		 		  break;
		 	  }
		 	
		 	  
		  }
		  

}
}

