package ����ó�����α׷�;

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
		// String colNames[] = { "�л���", "���", "�й�", "����", "����", "���", "�߰�",
		// "�⸻", "����", "��ǥ", "����", "����", "��Ÿ", "�⼮",
		// "1����", "2����", "3����", "4����", "5����", "6����", "7����", "8����", "9����",
		// "10����", "11����", "12����", "13����", "14����",
		// "14����", "15����", "16����" };
		db = new DBconnect();

		Vector v = db.getStudentList();

		cols = getColumn();
		DefaultTableModel model = new DefaultTableModel(v, cols);

		
		table = new JTable(model);
		table.addMouseListener(new JTableMouseListener());
		scrollPane = new JScrollPane(table); // ���̺� ��ũ�� ����� �ϱ�
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
			AddStudent addStu = new AddStudent(stu_num, mf, 1); // ���̵� ���ڷ� ����â ����

			// JTable jtable = (JTable) e.getSource();
			// int row = jtable.getSelectedRow();
			// int col = jtable.getSelectedColumn();
			// DefaultTableModel model = (DefaultTableModel) table.getModel();
			//
			// System.out.println(model.getValueAt(row, 0)); // ������ ���� �κп��� 0��°
			// ����
			// // ���
			// System.out.println(model.getValueAt(row, col)); // ������ ��� ���� �ش��ϴ�
			// ���õ� ������ �ϳ� ���
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
		col.add("�л���");
		col.add("���");
		col.add("�й�");
		col.add("����");
		col.add("����");
		col.add("���");
		col.add("�߰�");
		col.add("�⸻");
		col.add("����");
		col.add("��ǥ");
		col.add("����");
		col.add("����");
		col.add("��Ÿ");
		col.add("�⼮");

		col.add("1����");
		col.add("2����");
		col.add("3����");
		col.add("4����");
		col.add("5����");
		col.add("6����");
		col.add("7����");
		col.add("8����");
		col.add("9����");
		col.add("10����");
		col.add("11����");
		col.add("12����");
		col.add("13����");
		col.add("14����");
		col.add("15����");
		col.add("16����");
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
