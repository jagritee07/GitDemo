package files;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;



import io.restassured.RestAssured;



import io.restassured.path.json.JsonPath;



import io.restassured.response.Response;



import files.ReUsableMethods;

import files.Payload;





public class DynamicJson {



/*single parameter
 * @Test

public void addBook()



{



RestAssured.baseURI="http://216.10.245.166";

String resp=given().

header("Content-Type","application/json").

body(Payload.Addbook("asd","233")).

when().

post("/Library/Addbook.php").

then().assertThat().statusCode(200).

extract().response().asString();

JsonPath js= ReUsableMethods.rawToJson(resp);

   String id=js.get("ID");

   System.out.println(id);

   


}*/
	//multiple parameter
	@Test(dataProvider="BooksData")

	public void addBook(String isbn, String aisle){
		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().header("Content-Type","application/json").
				body(Payload.Addbook(isbn,aisle)).when().post("/Library/Addbook.php").
				then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= ReUsableMethods.rawToJson(resp);
		String id=js.get("ID");
		System.out.println(id);
		
	}
}

	
	
