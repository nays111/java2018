package 성적처리프로그램;

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
	JButton btn1 = new JButton("학생추가");
	JButton btn2 = new JButton("그래프 출력");
	JButton btn5 = new JButton("등급비율설정");
	JButton btn6 = new JButton("종료");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JTextArea ta = new JTextArea(15, 15);
	StudentTable JP_studentTable;
	
	JLabel jlAvg = new JLabel("평균 : ");
	JLabel jlAvgData = new JLabel("0");
	JLabel jlstuNum = new JLabel("학생수 : ");
	JLabel jlStuNumData = new JLabel("0");
	
	private JOptionPane AddStudent;
	static RateItem rateItem;
	public static void main(String[] args) {

		new MainFrame();

	}
	
	public MainFrame() {
		
		//default 등급비율 
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
		
		setTitle("성적관리 프로그램");
		createMenu(); // 메뉴 생성, 프레임에 삽입
		setSize(1550, 400);

		this.setVisible(true);
		
		System.out.println("MainFrame()");
		DBconnect db = new DBconnect(this);
		db.RateUpdate();
//		JP_studentTable.Refresh(this);
	}

	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("파일");

		JMenuItem item = new JMenuItem("파일출력");
		item.addActionListener(this); // 메뉴아이템에 Action 리스너 설

		screenMenu.add(new JMenuItem("파일출력"));
		screenMenu.add(new JMenuItem("그래프출력"));
		screenMenu.add(new JMenuItem("저장"));
		screenMenu.add(new JMenuItem("불러오기"));
		screenMenu.addSeparator();
		screenMenu.add(new JMenuItem("종료"));

		mb.add(screenMenu);
		mb.add(new JMenu("실행"));
		setJMenuBar(mb);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		
		System.out.println("MainFrame.actionPerformed.e : "+cmd	);
		switch (cmd) { // 메뉴 아이템의 종류 구분
		case "학생추가":

			
			new AddStudent(this);
			
			break;
		case "등급비율설정":
			 new rateGrade(this);
			break;
		case "그래프 출력":
			new GraphFrame(this);
			break;

		case "파일출력":

			break;
		case "그래프출력":
			break;
		case "저장":
			break;
		case "불러오기":
			break;
		case "종료":
			System.exit(0);
			break;

		}
	}

	
}
