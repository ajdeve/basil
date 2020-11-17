/* client가 
 * 1. 선택시 모든 고객 보기
 * 2. 선택시 한명의 고객 보기
 * 3. 선택 - 수정
 * 4. 선택 - 삭제 
 * 5. 선택 - 저장
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
	private static FeelingsModel fm = new FeelingsModel(); // static이여만 함, 제한해서 보호

	public static void reqProcess(int reqNo) {
		if (reqNo == 1) {// 모든 검색
			EndView.viewAllFeelings(fm.getFeelingsList());
		} else if (reqNo == 2) {
			Feelings feeling = fm.getFeelings("Happy");
			if (feeling != null) {
				EndView.viewFeeling(feeling);
				EndView.messageView("오더를 준비하는 중입니다.");
			} else {
				EndView.validateReq("세가지 옵션에서만 선택할 수 있습니다.");
			}
		} else if (reqNo == 3) {
			Feelings feeling = fm.getFeelings("Angry");
			if (feeling != null) {
				EndView.viewFeeling(feeling);
			} else {
				EndView.validateReq("세가지 옵션에서만 선택할 수 있습니다.");
			}
		} else if (reqNo == 4) {
			Feelings feeling = fm.getFeelings("Sad");
			if (feeling != null) {
				EndView.viewFeeling(feeling);
			} else {
				EndView.validateReq("세가지 옵션에서만 선택할 수 있습니다.");

		} }else if (reqNo == 5) {
			boolean result = fm.burgerUpdate("Bacon Cheese Burger", "Cheese Burger");
			if (result == true) {
				EndView.validateReq("버거 이름 수정 완료");
			} else {
				EndView.validateReq("버거 이름이 미 존재해서 수정 실패");
			}
			} else if (reqNo == 6) {
			int result = fm.delete("Happy");// method의 반환 결과가 int 이기에 맞춤
			if (result == 1) {
				EndView.validateReq("기분 삭제 완료");
			} else {
				EndView.validateReq("삭제하려는 기분이 없습니다");
			}
		} else if (reqNo == 7) {
			int result = fm.deleteBurger("Baconburger");// method의 반환 결과가 int 이기에 맞춤
			if (result == 1) {
				EndView.validateReq("버거 삭제 완료");
			} else {
				EndView.validateReq("삭제하려는 버거가 없습니다");
			}
		} else if (reqNo == 8) {
			try {
				fm.feelingsInsert(new Feelings("Gloomy", new Burger("Hell Poktan Burger", 100000, "This burger will make you forget everything else."),
						new Toppings("Hot Sauce", 1000, "premium"), new Sidemenu("Italian Sandwich", 10000, "Sandwich"),
						new Milkshake("Strawberry", 9800)));
				EndView.validateReq("새로운 기분및 버거 콤비네이션 등록 완료");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("중복 기분, 재 시도 하세요");
			}
		} else {
			EndView.invalidateReq("요청에 부합되는 서비스가 없다");
		}
	}
}
