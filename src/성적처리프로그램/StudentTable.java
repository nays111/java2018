package 성적처리프로그램;

import java.awt.Color;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Rectangle;
import java.awt.event.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentTable extends JPanel {
	Vector cols;
	DBconnect db;
	MainFrame mf;

	private static final long serialVersionUID = 1L;
	private JButton jBtnAddRow = null;
	private JButton jBtnDelRow = null;
	 JTable table;
	private JScrollPane scrollPane;

	public StudentTable(MainFrame mf) {
		// TODO Auto-generated constructor stub
		this.mf = mf;
		setLayout(null);
		// String colNames[] = { "학생명", "등급", "학번", "성적", "총점", "평균", "중간",
		// "기말", "과제", "발표", "퀴즈", "보고서", "기타", "출석",
		// "1주차", "2주차", "3주차", "4주차", "5주차", "6주차", "7주차", "8주차", "9주차",
		// "10주차", "11주차", "12주차", "13주차", "14주차",
		// "14주차", "15주차", "16주차" };
		db = new DBconnect();

		Vector v = db.getStudentList();

		cols = getColumn();
		DefaultTableModel model = new DefaultTableModel(v, cols);

		
		table = new JTable(model);
		table.addMouseListener(new JTableMouseListener());
		scrollPane = new JScrollPane(table); // 테이블에 스크롤 생기게 하기
		scrollPane.setSize(1500, 400);
		add(scrollPane);
		// initialize();
	}

	private class JTableMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {

			int r = table.getSelectedRow();
			int stu_num = (int)table.getValueAt(r, 2);
			// System.out.println("id="+id);
			AddStudent addStu = new AddStudent(stu_num, mf, 1); // 아이디를 인자로 수정창 생성

			// JTable jtable = (JTable) e.getSource();
			// int row = jtable.getSelectedRow();
			// int col = jtable.getSelectedColumn();
			// DefaultTableModel model = (DefaultTableModel) table.getModel();
			//
			// System.out.println(model.getValueAt(row, 0)); // 눌려진 행의 부분에서 0번째
			// 값을
			// // 출력
			// System.out.println(model.getValueAt(row, col)); // 눌려진 행과 열에 해당하는
			// 선택된 데이터 하나 출력
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}

	public Vector getColumn() {

		Vector col = new Vector();
		col.add("학생명");
		col.add("등급");
		col.add("학번");
		col.add("성적");
		col.add("총점");
		col.add("평균");
		col.add("중간");
		col.add("기말");
		col.add("과제");
		col.add("발표");
		col.add("퀴즈");
		col.add("보고서");
		col.add("기타");
		col.add("출석");

		col.add("1주차");
		col.add("2주차");
		col.add("3주차");
		col.add("4주차");
		col.add("5주차");
		col.add("6주차");
		col.add("7주차");
		col.add("8주차");
		col.add("9주차");
		col.add("10주차");
		col.add("11주차");
		col.add("12주차");
		col.add("13주차");
		col.add("14주차");
		col.add("15주차");
		col.add("16주차");
		return col;
	}// getColumn

	public void Refresh(MainFrame mf) {

		if (db == null)
			db = new DBconnect();
		DefaultTableModel model = new DefaultTableModel(db.getStudentList(), getColumn());
		
		
		table.setModel(model);

		mf.jlStuNumData.setText(db.getCount() + "");
		mf.jlAvgData.setText(db.getAvg() + "");
//		db.RateUpdate();
	}

	public int getCount() {
		return db.stuCount;
	}

}
