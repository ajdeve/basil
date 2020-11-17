package burger.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Feelings { 
	private String feelingName;
	
	private Burger burger;
	
	private Toppings toppings;
	
	private Sidemenu sidemenu;
	
	private Milkshake milkshake;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[지금기분]");
		builder.append(feelingName);
		builder.append(", [기분에 따른 네 버거]");
		builder.append(burger);
		builder.append(", [토핑추가]");
		builder.append(toppings);
		builder.append(", [사이드]");
		builder.append(sidemenu);
		builder.append("[밀크쉐이크]");
		builder.append(milkshake);
		return builder.toString();
	}
}