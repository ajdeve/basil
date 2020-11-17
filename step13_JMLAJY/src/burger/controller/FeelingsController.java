/* client�� 
 * 1. ���ý� ��� �� ����
 * 2. ���ý� �Ѹ��� �� ����
 * 3. ���� - ����
 * 4. ���� - ���� 
 * 5. ���� - ����
 */

package burger.controller;

import burger.CRUD.FeelingsModel;
import burger.model.dto.Burger;
import burger.model.dto.Feelings;
import burger.model.dto.Milkshake;
import burger.model.dto.Sidemenu;
import burger.model.dto.Toppings;
import burger.view.EndView;

public class FeelingsController {
	private static FeelingsModel fm = new FeelingsModel(); // static�̿��� ��, �����ؼ� ��ȣ

	public static void reqProcess(int reqNo) {
		if (reqNo == 1) {// ��� �˻�
			EndView.viewAllFeelings(fm.getFeelingsList());
		} else if (reqNo == 2) {
			Feelings feeling = fm.getFeelings("Happy");
			if (feeling != null) {
				EndView.viewFeeling(feeling);
				EndView.messageView("������ �غ��ϴ� ���Դϴ�.");
			} else {
				EndView.validateReq("������ �ɼǿ����� ������ �� �ֽ��ϴ�.");
			}
		} else if (reqNo == 3) {
			Feelings feeling = fm.getFeelings("Angry");
			if (feeling != null) {
				EndView.viewFeeling(feeling);
			} else {
				EndView.validateReq("������ �ɼǿ����� ������ �� �ֽ��ϴ�.");
			}
		} else if (reqNo == 4) {
			Feelings feeling = fm.getFeelings("Sad");
			if (feeling != null) {
				EndView.viewFeeling(feeling);
			} else {
				EndView.validateReq("������ �ɼǿ����� ������ �� �ֽ��ϴ�.");

		} }else if (reqNo == 5) {
			boolean result = fm.burgerUpdate("Bacon Cheese Burger", "Cheese Burger");
			if (result == true) {
				EndView.validateReq("���� �̸� ���� �Ϸ�");
			} else {
				EndView.validateReq("���� �̸��� �� �����ؼ� ���� ����");
			}
			} else if (reqNo == 6) {
			int result = fm.delete("Happy");// method�� ��ȯ ����� int �̱⿡ ����
			if (result == 1) {
				EndView.validateReq("��� ���� �Ϸ�");
			} else {
				EndView.validateReq("�����Ϸ��� ����� �����ϴ�");
			}
		} else if (reqNo == 7) {
			int result = fm.deleteBurger("Baconburger");// method�� ��ȯ ����� int �̱⿡ ����
			if (result == 1) {
				EndView.validateReq("���� ���� �Ϸ�");
			} else {
				EndView.validateReq("�����Ϸ��� ���Ű� �����ϴ�");
			}
		} else if (reqNo == 8) {
			try {
				fm.feelingsInsert(new Feelings("Gloomy", new Burger("Hell Poktan Burger", 100000, "This burger will make you forget everything else."),
						new Toppings("Hot Sauce", 1000, "premium"), new Sidemenu("Italian Sandwich", 10000, "Sandwich"),
						new Milkshake("Strawberry", 9800)));
				EndView.validateReq("���ο� ��й� ���� �޺���̼� ��� �Ϸ�");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("�ߺ� ���, �� �õ� �ϼ���");
			}
		} else {
			EndView.invalidateReq("��û�� ���յǴ� ���񽺰� ����");
		}
	}
}
