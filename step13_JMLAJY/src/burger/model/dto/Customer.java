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
	private String id; // ��ü �����ÿ� ��ü�� ���� �޸� ���ο� ���� �� ���� -> ��� ����
	private int password;
	private String grade;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[��ID]");
		builder.append(id);
		builder.append(", [�����]");
		builder.append(grade + " ����Դϴ�.");
		return builder.toString();
	}
}
