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
		builder.append("[���ݱ��]");
		builder.append(feelingName);
		builder.append(", [��п� ���� �� ����]");
		builder.append(burger);
		builder.append(", [�����߰�]");
		builder.append(toppings);
		builder.append(", [���̵�]");
		builder.append(sidemenu);
		builder.append("[��ũ����ũ]");
		builder.append(milkshake);
		return builder.toString();
	}
}