package ch12.sec03.exam05;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class member {
	private String id;
//	private String name;
	@NonNull private String name;
	private int age;
}
