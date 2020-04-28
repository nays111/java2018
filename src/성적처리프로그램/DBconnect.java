package 성적처리프로그램;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

//DB 처리
public class DBconnect {
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cal_grade?characterEncoding=UTF-8&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "0307";

	static final String DEFAULT_QUERY = "SELECT * FROM stu";
	MainFrame mf;
	int stuCount = 0;
	long totAvg = 0;
	int tot = 0;
	Vector studentList;
	List<Student> stuList = new ArrayList<>();

	public DBconnect() {

	}

	public DBconnect(MainFrame mf) {
		this.mf = mf;
		System.out.println("mf =>" + mf);
	}

	public Connection getConn() {
		Connection con = null;

		try {
			Class.forName(DRIVER); // 1. 드라이버 로딩
			con = DriverManager.getConnection(DATABASE_URL, USER, PASS); // 2.
																			// 드라이버
																			// 연결

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public Student getStudent(int stu_num) {

		Student stu = new Student();
		//
		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			String sql = "select * from stu where stu_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, stu_num + "");

			rs = ps.executeQuery();

			if (rs.next()) {
				stu.setName(rs.getString("name"));
				stu.setGrade(rs.getString("grade"));
				stu.setstu_num(rs.getInt("stu_num"));
				stu.setInt_grade(rs.getInt("int_grade"));
				stu.setTot(rs.getInt("tot"));
				stu.setAve(rs.getInt("ave"));
				stu.setMid(rs.getInt("mid"));
				stu.setFin(rs.getInt("fin"));
				stu.setHomeWork(rs.getInt("homeWork"));
				stu.setPT(rs.getInt("PT"));
				stu.setQuiz(rs.getInt("quiz"));
				stu.setReport(rs.getInt("report"));
				stu.setEtc(rs.getInt("etc"));

				stu.setAtd(rs.getInt("atd"));
				stu.setAtd1(rs.getString("atd1"));
				stu.setAtd2(rs.getString("atd2"));
				stu.setAtd3(rs.getString("atd3"));
				stu.setAtd4(rs.getString("atd4"));
				stu.setAtd5(rs.getString("atd5"));
				stu.setAtd6(rs.getString("atd6"));
				stu.setAtd7(rs.getString("atd7"));
				stu.setAtd8(rs.getString("atd8"));
				stu.setAtd9(rs.getString("atd9"));
				stu.setAtd10(rs.getString("atd10"));
				stu.setAtd11(rs.getString("atd11"));
				stu.setAtd12(rs.getString("atd12"));
				stu.setAtd13(rs.getString("atd13"));
				stu.setAtd14(rs.getString("atd14"));
				stu.setAtd15(rs.getString("atd15"));
				stu.setAtd16(rs.getString("atd16"));
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stu;
	}

	// select
	public Vector getStudentList() {
		tot = 0;
		studentList = new Vector();
		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			// String sql = "select * from tb_member order by name asc";
			String sql = "select * from stu";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Student stu = new Student();
				Vector row = new Vector();
				row.add(rs.getString("name"));
				row.add(rs.getString("grade"));
				row.add(rs.getInt("stu_num"));
				row.add(rs.getInt("int_grade"));
				row.add(rs.getInt("tot"));
				row.add(rs.getInt("ave"));
				row.add(rs.getInt("mid"));
				row.add(rs.getInt("fin"));
				row.add(rs.getInt("homeWork"));
				row.add(rs.getInt("PT"));
				row.add(rs.getInt("quiz"));
				row.add(rs.getInt("report"));
				row.add(rs.getInt("etc"));

				row.add(rs.getInt("atd"));
				row.add(rs.getString("atd1"));
				row.add(rs.getString("atd2"));
				row.add(rs.getString("atd3"));
				row.add(rs.getString("atd4"));
				row.add(rs.getString("atd5"));
				row.add(rs.getString("atd6"));
				row.add(rs.getString("atd7"));
				row.add(rs.getString("atd8"));
				row.add(rs.getString("atd9"));
				row.add(rs.getString("atd10"));
				row.add(rs.getString("atd11"));
				row.add(rs.getString("atd12"));
				row.add(rs.getString("atd13"));
				row.add(rs.getString("atd14"));
				row.add(rs.getString("atd15"));
				row.add(rs.getString("atd16"));

				stu.setName(rs.getString("name"));
				stu.setGrade(rs.getString("grade"));
				stu.setstu_num(rs.getInt("stu_num"));
				stu.setInt_grade(rs.getInt("int_grade"));
				stu.setTot(rs.getInt("tot"));
				stu.setAve(rs.getInt("ave"));
				stu.setMid(rs.getInt("mid"));
				stu.setFin(rs.getInt("fin"));
				stu.setHomeWork(rs.getInt("homeWork"));
				stu.setPT(rs.getInt("PT"));
				stu.setQuiz(rs.getInt("quiz"));
				stu.setReport(rs.getInt("report"));
				stu.setEtc(rs.getInt("etc"));

				stu.setAtd(rs.getInt("atd"));
				stu.setAtd1(rs.getString("atd1"));
				stu.setAtd2(rs.getString("atd2"));
				stu.setAtd3(rs.getString("atd3"));
				stu.setAtd4(rs.getString("atd4"));
				stu.setAtd5(rs.getString("atd5"));
				stu.setAtd6(rs.getString("atd6"));
				stu.setAtd7(rs.getString("atd7"));
				stu.setAtd8(rs.getString("atd8"));
				stu.setAtd9(rs.getString("atd9"));
				stu.setAtd10(rs.getString("atd10"));
				stu.setAtd11(rs.getString("atd11"));
				stu.setAtd12(rs.getString("atd12"));
				stu.setAtd13(rs.getString("atd13"));
				stu.setAtd14(rs.getString("atd14"));
				stu.setAtd15(rs.getString("atd15"));
				stu.setAtd16(rs.getString("atd16"));
				//
				studentList.add(row);
				stuList.add(stu);
				tot += rs.getInt("tot");
//				
			}

			rs.last();
			stuCount = rs.getRow();
			totAvg = tot / stuCount;
			System.out.println("DBconnect.stuCount : " + stuCount);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentList;

	}

	int getCount() {
		return stuCount;
	}

	long getAvg() {
		return totAvg;
	}

	int getTot(Student stu) {
		// 총점 계산
		float tot = (float) stu.getAtd() / 100 * mf.rateItem.getAtd()
				+ (float) stu.getMid() / 100 * mf.rateItem.getMid() + (float) stu.getFin() / 100 * mf.rateItem.getFin()
				+ (float) stu.getHomeWork() / 100 * mf.rateItem.getHomeWork()
				+ (float) stu.getPT() / 100 * mf.rateItem.getPT() + (float) stu.getQuiz() / 100 * mf.rateItem.getQuiz()
				+ (float) stu.getReport() / 100 * mf.rateItem.getReport()
				+ (float) stu.getEtc() / 100 * mf.rateItem.getEtc();
		return (int) tot;
	}

	int[] setStuToResultSet(ResultSet rs) {
		Student stu = new Student();
		int[] stuNumArr = new int[stuCount];
		int i=0;
		try {
			while (rs.next()) {
				
				stu.setName(rs.getString("name"));
				stu.setGrade(rs.getString("grade"));
				stu.setstu_num(rs.getInt("stu_num"));
				stu.setInt_grade(rs.getInt("int_grade"));
				stu.setTot(rs.getInt("tot"));
				stu.setAve(rs.getInt("ave"));
				stu.setMid(rs.getInt("mid"));
				stu.setFin(rs.getInt("fin"));
				stu.setHomeWork(rs.getInt("homeWork"));
				stu.setPT(rs.getInt("PT"));
				stu.setQuiz(rs.getInt("quiz"));
				stu.setReport(rs.getInt("report"));
				stu.setEtc(rs.getInt("etc"));

				stu.setAtd(rs.getInt("atd"));
				stu.setAtd1(rs.getString("atd1"));
				stu.setAtd2(rs.getString("atd2"));
				stu.setAtd3(rs.getString("atd3"));
				stu.setAtd4(rs.getString("atd4"));
				stu.setAtd5(rs.getString("atd5"));
				stu.setAtd6(rs.getString("atd6"));
				stu.setAtd7(rs.getString("atd7"));
				stu.setAtd8(rs.getString("atd8"));
				stu.setAtd9(rs.getString("atd9"));
				stu.setAtd10(rs.getString("atd10"));
				stu.setAtd11(rs.getString("atd11"));
				stu.setAtd12(rs.getString("atd12"));
				stu.setAtd13(rs.getString("atd13"));
				stu.setAtd14(rs.getString("atd14"));
				stu.setAtd15(rs.getString("atd15"));
				stu.setAtd16(rs.getString("atd16"));
				stuNumArr[i] = stu.getstu_num();
				System.out.println("setStuToResultSet.stuNumArr : "+stuNumArr[i]);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stuNumArr;
	}

	int[] queryAndResult(String sql) {
		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		int[] stuNumArr = new int[stuCount];
		Student stu = new Student();
		try {

			con = getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			stuNumArr = setStuToResultSet(rs);
			System.out.println("queryAndResult.stuList : "+stuList.get(0).getstu_num());
			System.out.println("queryAndResult.stuList : "+stuList.get(1).getstu_num());
			System.out.println("queryAndResult.stuList : "+stuList.get(2).getstu_num());
			System.out.println("queryAndResult.stuList : "+stuList.get(3).getstu_num());
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stuNumArr;
	}

	void RateUpdate() {

		// 총점 업데이트
		getStudentList();// 전체조회
		for (Student stu : stuList) {
			stu.setTot(getTot(stu));
			updateStudent(stu);
		}

		// 성적, 등급 업데이트
		// 각 등급 학생수
		float a1 = (float) getCount() / (float)100* mf.rateItem.getRateA1() + 1;
		float a0 = (float) getCount() / (float)100* mf.rateItem.getRateA0() + 1;
		float b1 = (float) getCount() / (float)100* mf.rateItem.getRateB1() + 1;
		float b0 = (float) getCount() / (float)100* mf.rateItem.getRateB0() + 1;
		float c1 = (float) getCount() / (float)100* mf.rateItem.getRateC1() + 1;
		float c0 = (float) getCount() / (float)100* mf.rateItem.getRateC0() + 1;
		float d = (float) getCount() / (float)100* mf.rateItem.getRateD() + 1;
		float f = (float) getCount() / (float)100* mf.rateItem.getRateF() + 1;
		// 총점으로 정렬 후 stuList 리턴
		String sql = " select * from stu order by tot DESC;";
		int[] stuNumArr = new int[stuCount];
		stuNumArr = queryAndResult(sql);
		int i=0;

		System.out.println(
				" a1 : " + a1 +" a0 : " + a0 +" b1 : " + b1+" b0 : " + b0
				+" c1 : " + c1+" c0 : " + c0+" d : " + d+" f : " + f);

		
		// for (int i = 0; i < stuCount; i++) {
		for (int stuNum  : stuNumArr) {
			
			Student stu = getStudent(stuNum);
			
			
			if (i < a1) { // 0 ~ a1
				stu.setGrade("A+");
				stu.setInt_grade(4.5f);
			} else if (a1 <= i && i < a1 + a0) { // a1 ~ a1+A0
				stu.setGrade("A0");
				stu.setInt_grade(4.0f);
			} else if (a1 + a0 <= i && i < a1 + a0 + b1) {
				stu.setGrade("B+");
				stu.setInt_grade(3.5f);
			} else if (a1 + a0 + b1 <= i && i < a1 + a0 + b1 + b0) {
				stu.setGrade("B0");
				stu.setInt_grade(3.0f);
			} else if (a1 + a0 + b1 + b0 <= i && i < a1 + a0 + b1 + b0 + c1) {
				stu.setGrade("C+");
				stu.setInt_grade(2.5f);
			} else if (a1 + a0 + b1 + b0 + c1 <= i && i < a1 + a0 + b1 + b0 + c1 + c0) {
				stu.setGrade("C0");
				stu.setInt_grade(2.0f);
			} else if (a1 + a0 + b1 + b0 + c1 + c0 <= i && i < a1 + a0 + b1 + b0 + c1 + c0 + d) {
				stu.setGrade("D");
				stu.setInt_grade(1.5f);
			} else {
				stu.setGrade("F");
				stu.setInt_grade(1.0f);
			}
			i++;
			updateStudent(stu);
		}

		// 테이블 업데이트
		mf.JP_studentTable.Refresh(mf);

	}

	public boolean insertStudent(Student stu) {

		boolean ok = false;

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령

		try {

			con = getConn();
			String sql = "insert into stu(" + "name,grade,stu_num, int_grade, tot, ave, mid, "
					+ "fin, homeWork, PT, quiz, report, etc, atd," + "atd1, atd2, atd3, atd4, atd5, atd6, atd7, "
					+ "atd8, atd9, atd10, atd11, atd12, atd13, " + "atd14,atd15, atd16) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);

			ps.setString(1, stu.getName());
			ps.setString(2, stu.getgrade());
			ps.setInt(3, stu.getStu_num());
			ps.setFloat(4, stu.getInt_grade());
			ps.setInt(5, getTot(stu));
			ps.setInt(6, stu.getAve());
			ps.setInt(7, stu.getMid());
			ps.setInt(8, stu.getFin());
			ps.setInt(9, stu.getHomeWork());
			ps.setInt(10, stu.getPT());
			ps.setInt(11, stu.getQuiz());
			ps.setInt(12, stu.getReport());
			ps.setInt(13, stu.getEtc());
			ps.setInt(14, stu.getAtd());
			ps.setString(15, stu.getAtd1());
			ps.setString(16, stu.getAtd2());
			ps.setString(17, stu.getAtd3());
			ps.setString(18, stu.getAtd4());
			ps.setString(19, stu.getAtd5());
			ps.setString(20, stu.getAtd6());
			ps.setString(21, stu.getAtd7());
			ps.setString(22, stu.getAtd8());
			ps.setString(23, stu.getAtd9());
			ps.setString(24, stu.getAtd10());
			ps.setString(25, stu.getAtd11());
			ps.setString(26, stu.getAtd12());
			ps.setString(27, stu.getAtd13());
			ps.setString(28, stu.getAtd14());
			ps.setString(29, stu.getAtd15());
			ps.setString(30, stu.getAtd16());

			int r = ps.executeUpdate(); // 실행 -> 저장

			if (r > 0) {
				System.out.println("가입 성공");
				ok = true;
			} else {
				System.out.println("가입 실패");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}// insertMmeber

	public boolean updateStudent(Student stu) {
		System.out.println("stu =" + stu.toString());
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = getConn();
			String sql = "update stu set name=?, grade=?, int_grade=?, tot=?, ave=?,"
					+ "mid=?,fin=?,homeWork=?,PT=?,quiz=?,report=?,etc=?,atd=?,"
					+ "atd1=?, atd2=?, atd3=?, atd4=?, atd5=?, atd6=?, atd7=?, "
					+ "atd8=?, atd9=?, atd10=?, atd11=?, atd12=?, atd13=?, " + "atd14=?,atd15=?, atd16=? "
					+ "where stu_num=? ";

			ps = con.prepareStatement(sql);

			ps.setString(1, stu.getName());
			ps.setString(2, stu.getgrade());
			ps.setFloat(3, stu.getInt_grade());
			ps.setInt(4, getTot(stu));
			ps.setInt(5, stu.getAve());
			ps.setInt(6, stu.getMid());
			ps.setInt(7, stu.getFin());
			ps.setInt(8, stu.getHomeWork());
			ps.setInt(9, stu.getPT());
			ps.setInt(10, stu.getQuiz());
			ps.setInt(11, stu.getReport());
			ps.setInt(12, stu.getEtc());
			ps.setInt(13, stu.getAtd());
			ps.setString(14, stu.getAtd1());
			ps.setString(15, stu.getAtd2());
			ps.setString(16, stu.getAtd3());
			ps.setString(17, stu.getAtd4());
			ps.setString(18, stu.getAtd5());
			ps.setString(19, stu.getAtd6());
			ps.setString(20, stu.getAtd7());
			ps.setString(21, stu.getAtd8());
			ps.setString(22, stu.getAtd9());
			ps.setString(23, stu.getAtd10());
			ps.setString(24, stu.getAtd11());
			ps.setString(25, stu.getAtd12());
			ps.setString(26, stu.getAtd13());
			ps.setString(27, stu.getAtd14());
			ps.setString(28, stu.getAtd15());
			ps.setString(29, stu.getAtd16());
			ps.setInt(30, stu.getStu_num());

			int r = ps.executeUpdate(); // 실행 -> 수정
			// 1~n: 성공 , 0 : 실패

			if (r > 0)
				ok = true; // 수정이 성공되면 ok값을 true로 변경
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean deleteStudent(String stu_num) {

		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConn();
			String sql = "delete from stu where stu_num =? ";

			ps = con.prepareStatement(sql);
			ps.setString(1, stu_num);
			int r = ps.executeUpdate(); // 실행 -> 삭제

			if (r > 0)
				ok = true; // 삭제됨;
			con.close();
		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}
		return ok;
	}

}