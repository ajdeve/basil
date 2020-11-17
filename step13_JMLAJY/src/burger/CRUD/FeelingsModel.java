package burger.CRUD;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import burger.model.BurgerModelVirtualDB;
import burger.model.dto.Burger;
import burger.model.dto.Feelings;

public class FeelingsModel {
//	private static FeelingsModel instance = new FeelingsModel();
	private BurgerModelVirtualDB data = BurgerModelVirtualDB.getInstance();
	// virtual 에서 주소값 호출 ox

	public ArrayList<Feelings> getFeelingsList() {
		return data.getFeelingsList();
	}

	public ArrayList<Burger> getBurgerList() {
		return data.getBurgerList();
	}

	// 모든 기분 검색 - 기분에 따른 버거 정보 반환 Happy, Sad, Angry
	public Feelings getFeelings(String feelings) {
		ArrayList<Feelings> feelingsList = data.getFeelingsList();
		for (Feelings f : feelingsList) {
			if (f.getFeelingName().equals(feelings)) {
				return f;
			}
		}
		return null;
	}

	public Burger getBurgers(String burgerName) {
		ArrayList<Burger> burgersList = data.getBurgerList();
		for (Burger b : burgersList) {
			if (b.getBurgerName().equals(burgerName)) {
				return b;
			}
		}
		return null;
	}

//		public int printSum ( ArrayList<Feelings> list ) {
//		int sum = 0;
//		for(int i = 0; i < list.size(); i++ ) {
//			  sum += list[i][1];
//			}
//            System.out.println("총합계는 " + sum + "원 입니다. 정말 구매하실 수 있겠어요?");
//	}
//////for (int j = 0; j <list[i].length;j++) {
////if (j==1) {
////	sum += list[i][j];
////	

	public void feelingsInsert(Feelings newFeelings) throws DuplicateName {
		ArrayList<Feelings> feelingsList = data.getFeelingsList();
		Feelings feeling = getFeelings(newFeelings.getFeelingName());
		if (feeling == null)
			feelingsList.add(newFeelings);
		else {
			throw new DuplicateName("해당 Feeling명과 동일한 이름의 Feeling이 이미 존재하는 문제가 발생했습니다.");
		}
	}

	public boolean burgerUpdate(String BurgerName, String newBurgerName) throws NoSuchElementException {
//		ArrayList<Burger> burgerList = data.getBurgerList();
		boolean result = false;
		Burger b = getBurgers(BurgerName);
		if (b == null) {
			throw new NoSuchElementException("버거 이름을 업데이트 하고자 하는 버거가 미 존재하는 문제가 발생했습니다.");
		} else {
			b.setBurgerName(newBurgerName);
			result = true;
		}
		return result;
	}

	public int delete(String feeling) {
		ArrayList<Feelings> feelingsList = data.getFeelingsList();
		int result = 0;
		Feelings v = getFeelings(feeling);
		if (v != null) {
			if (feelingsList.remove(v) == true) {
				result = 1;
			}
		}
		return result;
	}
	

	public int deleteBurger(String burgerName)  {
		ArrayList<Burger> burgerList = data.getBurgerList();
		int result = 0;
		Burger b = getBurgers(burgerName);
		if (b != null) {
			if (burgerList.remove(b) == true) {
				result = 1;
			}
		}
		return result;
	}

}
