package 성적처리프로그램;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStudent extends JFrame implements ActionListener {
	/**
	 * 
	 */
	int stat = 0;
	String[] atd = {"출석", "지각", "결석"};
	private static final long serialVersionUID = 1L;
	Student  stu;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();

	JLabel JL_name = new JLabel("이름");
	JLabel JL_stuNum = new JLabel("학번");
	JLabel JL_IntGrade = new JLabel("성적");
	JLabel JL_grade = new JLabel("등급");
	JLabel JL_tot = new JLabel("총점");
	JLabel JL_avg = new JLabel("평균");
	JLabel JL_atd = new JLabel("출결");
	JLabel JL_mid = new JLabel("중간");
	JLabel JL_fin = new JLabel("기말");
	JLabel JL_homeWork = new JLabel("과제");
	JLabel JL_PT = new JLabel("발표");
	JLabel JL_quiz = new JLabel("퀴즈");
	JLabel JL_report = new JLabel("보고서");
	JLabel JL_etc = new JLabel("기타");

	JTextField tf = new JTextField(10);
	JTextField tf1 = new JTextField(10);
	JTextField tf2 = new JTextField(10);
	JTextField tf3 = new JTextField(10);
	JTextField tf4 = new JTextField(10);
	JTextField tf5 = new JTextField(10);
	JTextField tf6 = new JTextField(10);
	JTextField tf7 = new JTextField(10);

	JTextField tf8 = new JTextField(10);
	JTextField tf9 = new JTextField(10);
	JTextField tf10 = new JTextField(10);
	JTextField tf11 = new JTextField(9);
	JTextField tf12 = new JTextField(10);
	JButton btn_OK, btn_close, btn_update, btn_delete;
	
	JComboBox<String> Atd1;
	JComboBox<String> Atd2;
	JComboBox<String> Atd3;
	JComboBox<String> Atd4;
	JComboBox<String> Atd5;
	JComboBox<String> Atd6;
	JComboBox<String> Atd7;
	JComboBox<String> Atd8;
	JComboBox<String> Atd9;
	JComboBox<String> Atd10;

	JComboBox<String> Atd11;
	JComboBox<String> Atd12;
	JComboBox<String> Atd13;
	JComboBox<String> Atd14;
	JComboBox<String> Atd15;

	JComboBox<String> Atd16;
	MainFrame mf;
	
	// 추가 
	public AddStudent(MainFrame mf) {
		stat = 0; 
		this.mf = mf;
		DrawFrame(stat);
	}
	// 수정 삭제 
	public AddStudent(int stu_num,MainFrame mf,int stat) {
		this.stat = stat;
		this.mf = mf;
		DrawFrame(stat);
		
		System.out.println("stu_num ="+stu_num);

        DBconnect db = new DBconnect();
        Student vMem = db.getStudent(stu_num);
        viewData(vMem);
        
	}
	private void DrawFrame(int stat){
		this.setTitle("학생 정보");
		this.setLayout(new GridLayout(0, 2));
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
		p1.add(JL_name);
		p1.add(tf);
		p1.add(JL_stuNum);
		p1.add(tf1);
		p1.add(JL_IntGrade);
		p1.add(tf2);
		p1.add(JL_grade);
		p1.add(tf3);
		p1.add(JL_tot);
		p1.add(tf4);
		p1.add(JL_avg);
		p1.add(tf5);

		p1.add(JL_mid);
		p1.add(tf6);
		p1.add(JL_fin);
		p1.add(tf7);
		p1.add(JL_homeWork);
		p1.add(tf8);
		p1.add(JL_PT);
		p1.add(tf9);
		p1.add(JL_quiz);
		p1.add(tf10);
		p1.add(JL_report);
		p1.add(tf11);
		p1.add(JL_etc);
		p1.add(tf12);

		switch(stat){
		case 0: btn_OK = new JButton("저장");
				btn_OK.addActionListener(this);
				p1.add(btn_OK);
			break;
		case 1: 
			btn_update = new JButton("수정");
			btn_delete = new JButton("삭제");
			btn_update.addActionListener(this);
			btn_delete.addActionListener(this);
			p1.add(btn_update);
			p1.add(btn_delete);
			break;
		}
		
		btn_close = new JButton("닫기");
		btn_close.addActionListener(this);
		p1.add(btn_close);
		this.add(p1);

		p2.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
		// p2.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));


		Atd1 = new JComboBox<>(atd);
		Atd2 = new JComboBox<>(atd);
		Atd3 = new JComboBox<>(atd);
		Atd4 = new JComboBox<>(atd);
		Atd5 = new JComboBox<>(atd);
		Atd6 = new JComboBox<>(atd);
		Atd7 = new JComboBox<>(atd);
		Atd8 = new JComboBox<>(atd);
		Atd9 = new JComboBox<>(atd);
		Atd10 = new JComboBox<>(atd);
		Atd11 = new JComboBox<>(atd);
		Atd12 = new JComboBox<>(atd);
		Atd13 = new JComboBox<>(atd);
		Atd14 = new JComboBox<>(atd);
		Atd15 = new JComboBox<>(atd);
		Atd16 = new JComboBox<>(atd);
		JLabel JL_1 = new JLabel(1 + "주");
		JLabel JL_2 = new JLabel(2 + "주");
		JLabel JL_3 = new JLabel(3 + "주");
		JLabel JL_4 = new JLabel(4 + "주");
		JLabel JL_5 = new JLabel(5 + "주");
		JLabel JL_6 = new JLabel(6 + "주");
		JLabel JL_7 = new JLabel(7 + "주");
		JLabel JL_8 = new JLabel(8 + "주");
		JLabel JL_9= new JLabel(9 + "주");
		JLabel JL_10 = new JLabel(10 + "주");
		JLabel JL_11 = new JLabel(11 + "주");
		JLabel JL_12 = new JLabel(12 + "주");
		JLabel JL_13 = new JLabel(13 + "주");
		JLabel JL_14 = new JLabel(14 + "주");
		JLabel JL_15 = new JLabel(15 + "주");
		JLabel JL_16 = new JLabel(16 + "주");
		

		p2.add(JL_1);
		p2.add(Atd1);
		p2.add(JL_2);
		p2.add(Atd3);
		p2.add(JL_4);
		p2.add(Atd4);
		p2.add(JL_5);
		p2.add(Atd5);
		p2.add(JL_6);
		p2.add(Atd6);
		p2.add(JL_7);
		p2.add(Atd7);
		p2.add(JL_8);
		p2.add(Atd8);
		p2.add(JL_9);
		p2.add(Atd9);
		p2.add(JL_10);
		p2.add(Atd10);
		p2.add(JL_11);
		p2.add(Atd11);
		p2.add(JL_12);
		p2.add(Atd12);
		p2.add(JL_13);
		p2.add(Atd13);
		p2.add(JL_14);
		p2.add(Atd14);
		p2.add(JL_15);
		p2.add(Atd15);
		p2.add(JL_16);
		p2.add(Atd16);
		
		this.add(p2);
		
		setSize(750, 400);
		setVisible(true);

	}
	private void viewData(Student vMem) {
		
    	tf.setText(vMem.getName());
    	tf1.setText(vMem.getStu_num()+"");
    	tf2.setText(vMem.getInt_grade()+"");
    	tf3.setText(vMem.getGrade());
    	tf4.setText(vMem.getTot()+"");
    	tf5.setText(vMem.getAve()+"");
    	tf6.setText(vMem.getMid()+"");
    	tf7.setText(vMem.getFin()+"");
    	tf8.setText(vMem.getHomeWork()+"");
    	tf9.setText(vMem.getPT()+"");
    	tf10.setText(vMem.getQuiz()+"");
    	tf11.setText(vMem.getReport()+"");
    	tf12.setText(vMem.getEtc()+"");

    	Atd1.setSelectedItem(vMem.getAtd1());
    	Atd2.setSelectedItem(vMem.getAtd2());
    	Atd3.setSelectedItem(vMem.getAtd3());
    	Atd4.setSelectedItem(vMem.getAtd4());
    	Atd5.setSelectedItem(vMem.getAtd5());
    	Atd6.setSelectedItem(vMem.getAtd6());
    	Atd7.setSelectedItem(vMem.getAtd7());
    	Atd8.setSelectedItem(vMem.getAtd8());
    	Atd9.setSelectedItem(vMem.getAtd9());
    	Atd10.setSelectedItem(vMem.getAtd10());
    	Atd11.setSelectedItem(vMem.getAtd11());
    	Atd12.setSelectedItem(vMem.getAtd12());
    	Atd13.setSelectedItem(vMem.getAtd13());
    	Atd14.setSelectedItem(vMem.getAtd14());
    	Atd15.setSelectedItem(vMem.getAtd15());
    	Atd16.setSelectedItem(vMem.getAtd16());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) { // 메뉴 아이템의 종류 구분
		case "저장":
			insertData();
			dispose();
			break;
		case "수정":
			UpdateData();
			dispose();
			break;
		case "삭제":
			DeleteData();
			dispose();
			break;
		case "닫기":
			dispose();
			break;
		}
		
		mf.JP_studentTable.Refresh(mf);
	}
	
	private void DeleteData() {
        String stu_num = tf1.getText();
        
        //System.out.println(mList);
        DBconnect db = new DBconnect(mf);
        boolean ok = db.deleteStudent(stu_num);
       
        if(ok){
            JOptionPane.showMessageDialog(this, "삭제완료");
            db.RateUpdate();
            dispose();         
           
        }else{
            JOptionPane.showMessageDialog(this, "삭제실패");
           
        }          
       
    }
   
    private void UpdateData() {
       
        Student stu = getStudent();     
        DBconnect db = new DBconnect(mf);
        boolean ok = db.updateStudent(stu);
       
       
        if(ok){
            JOptionPane.showMessageDialog(this, "수정완료");
            db.RateUpdate();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "수정실패");   
        }
    }
	public Student getStudent(){
	       
		Student stu = new Student();

		stu = new Student();
		
		
		if(tf1.getText().isEmpty()){tf1.setText("0");}
		if(tf2.getText().isEmpty()){tf2.setText("0");}
		if(tf3.getText().isEmpty()){tf3.setText("0");}
		if(tf4.getText().isEmpty()){tf4.setText("0");}
		if(tf5.getText().isEmpty()){tf5.setText("0");}
		if(tf6.getText().isEmpty()){tf6.setText("0");}
		if(tf7.getText().isEmpty()){tf7.setText("0");}
		if(tf8.getText().isEmpty()){tf8.setText("0");}
		if(tf9.getText().isEmpty()){tf9.setText("0");}
		if(tf10.getText().isEmpty()){tf10.setText("0");}
		if(tf11.getText().isEmpty()){tf11.setText("0");}
		if(tf12.getText().isEmpty()){tf12.setText("0");}
		
		stu.setName(tf.getText());
		
		stu.setstu_num(Integer.valueOf(tf1.getText()));
		stu.setint_grade(Float.valueOf(tf2.getText()));

		stu.setgrade(tf3.getText());

		stu.setTot(Integer.valueOf(tf4.getText()));
		stu.setAve(Integer.valueOf(tf5.getText()));
		
		stu.setMid(Integer.valueOf(tf6.getText()));
		stu.setFin(Integer.valueOf(tf7.getText()));
		stu.setHomeWork(Integer.valueOf(tf8.getText()));
		stu.setPT(Integer.valueOf(tf9.getText()));
		stu.setQuiz(Integer.valueOf(tf10.getText()));
		stu.setReport(Integer.valueOf(tf11.getText()));
		stu.setEtc(Integer.valueOf(tf12.getText()));
		
		stu.setAtd1(atd[Atd1.getSelectedIndex()]);
		stu.setAtd2(atd[Atd2.getSelectedIndex()]);
		stu.setAtd3(atd[Atd3.getSelectedIndex()]);
		stu.setAtd4(atd[Atd4.getSelectedIndex()]);
		stu.setAtd5(atd[Atd5.getSelectedIndex()]);
		stu.setAtd6(atd[Atd6.getSelectedIndex()]);
		stu.setAtd7(atd[Atd7.getSelectedIndex()]);
		stu.setAtd8(atd[Atd8.getSelectedIndex()]);
		stu.setAtd9(atd[Atd9.getSelectedIndex()]);
		stu.setAtd10(atd[Atd10.getSelectedIndex()]);
		stu.setAtd11(atd[Atd11.getSelectedIndex()]);
		stu.setAtd12(atd[Atd12.getSelectedIndex()]);
		stu.setAtd13(atd[Atd13.getSelectedIndex()]);
		stu.setAtd14(atd[Atd14.getSelectedIndex()]);
		stu.setAtd15(atd[Atd15.getSelectedIndex()]);
		stu.setAtd16(atd[Atd16.getSelectedIndex()]);

        return stu;
    }
	
	private void insertData() {

		Student stu = getStudent();
		DBconnect db = new DBconnect(mf);
		
		boolean ok = db.insertStudent(stu);

		if (ok) {
			db.RateUpdate();
			JOptionPane.showMessageDialog(this, "학생 정보 추가 완료.");
			dispose();

		} else {

			JOptionPane.showMessageDialog(this, "학생 정보 추가 실패");
		}
	}

}
