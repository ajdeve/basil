package burger.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Customer {
	private String id; // 객체 생성시에 객체의 실제 메모리 내부에 생성 및 구성 -> 멤버 변수
	private int password;
	private String grade;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[고객ID]");
		builder.append(id);
		builder.append(", [고객등급]");
		builder.append(grade + " 등급입니다.");
		return builder.toString();
	}
}
