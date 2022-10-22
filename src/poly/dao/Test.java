package poly.dao;

import java.util.List;

import poly.model.AnConmment;

public class Test {
public static void main(String[] args) {
	
	AnCommentDao commentAnDao = new AnCommentDao();
	List<AnConmment> anCommnetList = commentAnDao.getAllCommmentByVideoIDAndCommentID(1032, 1013);
	System.out.println("anCommnetList test:" + anCommnetList);
	
	
}
}
//RateDao dao = new RateDao();
//double pointString = dao.getTotalUserRated(1016);
//
//System.out.println("test point: " + String.format("%.0f", pointString));
//System.out.println("test point: " + pointString);