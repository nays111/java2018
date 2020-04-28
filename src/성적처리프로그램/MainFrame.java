package ����ó�����α׷�;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame implements ActionListener {

	private ArrayList<Student> stu_list = new ArrayList<>();
	Student stu;
	JButton btn1 = new JButton("�л��߰�");
	JButton btn2 = new JButton("�׷��� ���");
	JButton btn5 = new JButton("��޺�������");
	JButton btn6 = new JButton("����");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JTextArea ta = new JTextArea(15, 15);
	StudentTable JP_studentTable;
	
	JLabel jlAvg = new JLabel("��� : ");
	JLabel jlAvgData = new JLabel("0");
	JLabel jlstuNum = new JLabel("�л��� : ");
	JLabel jlStuNumData = new JLabel("0");
	
	private JOptionPane AddStudent;
	static RateItem rateItem;
	public static void main(String[] args) {

		new MainFrame();

	}
	
	public MainFrame() {
		
		//default ��޺��� 
		rateItem = new RateItem();
		rateItem.setAtd(10);
		rateItem.setEtc(0);
		rateItem.setFin(40);
		rateItem.setHomeWork(0);
		rateItem.setMid(30);
		rateItem.setPT(0);
		rateItem.setQuiz(10);
		rateItem.setReport(10);
		
		rateItem.setRateA1(10);
		rateItem.setRateA0(20);
		rateItem.setRateB1(10);
		rateItem.setRateB0(20);
		rateItem.setRateC1(10);
		rateItem.setRateC0(10);
		rateItem.setRateD(10);
		rateItem.setRateF(10);
		
		p2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn5);
		p2.add(btn6);
		p2.add(jlAvg);
		p2.add(jlAvgData);
		p2.add(jlstuNum);
		p2.add(jlStuNumData);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);

		JP_studentTable = new StudentTable(this);
		
		JP_studentTable.setSize(1500,400);
//		JP_studentTable.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(JP_studentTable);
		
		
		
		add(p2, "South");
		
		setTitle("�������� ���α׷�");
		createMenu(); // �޴� ����, �����ӿ� ����
		setSize(1550, 400);

		this.setVisible(true);
		
		System.out.println("MainFrame()");
		DBconnect db = new DBconnect(this);
		db.RateUpdate();
//		JP_studentTable.Refresh(this);
	}

	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("����");

		JMenuItem item = new JMenuItem("�������");
		item.addActionListener(this); // �޴������ۿ� Action ������ ��

		screenMenu.add(new JMenuItem("�������"));
		screenMenu.add(new JMenuItem("�׷������"));
		screenMenu.add(new JMenuItem("����"));
		screenMenu.add(new JMenuItem("�ҷ�����"));
		screenMenu.addSeparator();
		screenMenu.add(new JMenuItem("����"));

		mb.add(screenMenu);
		mb.add(new JMenu("����"));
		setJMenuBar(mb);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		
		System.out.println("MainFrame.actionPerformed.e : "+cmd	);
		switch (cmd) { // �޴� �������� ���� ����
		case "�л��߰�":

			
			new AddStudent(this);
			
			break;
		case "��޺�������":
			 new rateGrade(this);
			break;
		case "�׷��� ���":
			new GraphFrame(this);
			break;

		case "�������":

			break;
		case "�׷������":
			break;
		case "����":
			break;
		case "�ҷ�����":
			break;
		case "����":
			System.exit(0);
			break;

		}
	}

	
}
