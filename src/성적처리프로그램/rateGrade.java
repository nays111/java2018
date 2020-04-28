package ����ó�����α׷�;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class rateGrade extends JFrame implements ActionListener {

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	// A+, A0, B+, B0, C+, C0, D, F
	JLabel jl_A1 = new JLabel("A+");
	JTextField tf_A1 = new JTextField(10);
	JLabel jl_A0 = new JLabel("A0");
	JTextField tf_A0 = new JTextField(10);
	JLabel jl_B1 = new JLabel("B+");
	JTextField tf_B1 = new JTextField(10);
	JLabel jl_B0 = new JLabel("B+");
	JTextField tf_B0 = new JTextField(10);
	JLabel jl_C1 = new JLabel("C0");
	JTextField tf_C1 = new JTextField(10);
	JLabel jl_C0 = new JLabel("C+");
	JTextField tf_C0 = new JTextField(10);
	JLabel jl_D = new JLabel("D");
	JTextField tf_D = new JTextField(10);
	JLabel jl_F = new JLabel("F");
	JTextField tf_F = new JTextField(10);
	// �л��� ��������� �⼮����, �߰� �� �⸻���� ����,
	// ���� ����, ���� ����, ��ǥ ����, ���� ����,
	// ��Ÿ ������ ������ �ݿ� ������ ���� �ջ��� ������ ���� �����ȴ�

	JLabel JL_atd = new JLabel("���");
	JTextField tf_atd = new JTextField(10);
	JLabel JL_mid = new JLabel("�߰�");
	JTextField tf_mid = new JTextField(10);
	JLabel JL_fin = new JLabel("�⸻");
	JTextField tf_fin = new JTextField(10);
	JLabel JL_homeWork = new JLabel("����");
	JTextField tf_homeWork = new JTextField(10);
	JLabel JL_PT = new JLabel("��ǥ");
	JTextField tf_PT = new JTextField(10);
	JLabel JL_quiz = new JLabel("����");
	JTextField tf_quiz = new JTextField(10);
	JLabel JL_report = new JLabel("����");
	JTextField tf_report = new JTextField(10);
	JLabel JL_etc = new JLabel("��Ÿ");
	JTextField tf_etc = new JTextField(10);

	JButton btn_close = new JButton("�ݱ�");
	JButton btn_ok = new JButton("Ȯ��");
	MainFrame mf;
	public rateGrade(MainFrame mf) {
		this.mf= mf ;
		this.setTitle("��� ���� ����");

		this.setLayout(new GridLayout(0, 2));
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
		p1.add(jl_A1);
		p1.add(tf_A1);
		p1.add(jl_A0);
		p1.add(tf_A0);
		p1.add(jl_B1);
		p1.add(tf_B0);
		p1.add(jl_B1);
		p1.add(tf_B0);
		p1.add(jl_C1);
		p1.add(tf_C0);
		p1.add(jl_C1);
		p1.add(tf_C0);
		p1.add(jl_D);
		p1.add(tf_D);
		p1.add(jl_F);
		p1.add(tf_F);
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
		p2.add(JL_atd);
		p2.add(tf_atd);
		p2.add(JL_mid);
		p2.add(tf_mid);
		p2.add(JL_fin);
		p2.add(tf_fin);
		p2.add(JL_homeWork);
		p2.add(tf_homeWork);
		p2.add(JL_PT);
		p2.add(tf_PT);
		p2.add(JL_quiz);
		p2.add(tf_quiz);
		p2.add(JL_report);
		p2.add(tf_report);
		p2.add(JL_etc);
		p2.add(tf_etc);

		btn_ok = new JButton("Ȯ��");
		btn_ok.addActionListener(this);
		btn_close = new JButton("�ݱ�");
		btn_close.addActionListener(this);
		p2.add(btn_ok);
		p2.add(btn_close);
		this.add(p1);
		this.add(p2);

		setSize(330, 800);
		setVisible(true);
		 setView(); // ��޺���������
	}

	void setView(){
		tf_atd.setText(mf.rateItem.getAtd()+"");
		tf_etc.setText(mf.rateItem.getEtc()+"");
		tf_fin.setText(mf.rateItem.getFin()+"");
		tf_homeWork.setText(mf.rateItem.getHomeWork()+"");
		tf_mid.setText(mf.rateItem.getMid()+"");
		tf_PT.setText(mf.rateItem.getPT()+"");
		tf_quiz.setText(mf.rateItem.getQuiz()+"");
		tf_report.setText(mf.rateItem.getReport()+"");
		
		tf_A1.setText(mf.rateItem.getRateA1()+"");
		tf_A0.setText(mf.rateItem.getRateA0()+"");
		tf_B1.setText(mf.rateItem.getRateB1()+"");
		tf_B0.setText(mf.rateItem.getRateB0()+"");
		tf_C1.setText(mf.rateItem.getRateC1()+"");
		tf_C0.setText(mf.rateItem.getRateC0()+"");
		tf_D.setText(mf.rateItem.getRateD()+"");
		tf_F.setText(mf.rateItem.getRateF()+"");
	}

	void SaveRateItem(){
		mf.rateItem.setAtd(Integer.valueOf(tf_atd.getText()));
		mf.rateItem.setEtc(Integer.valueOf(tf_etc.getText()));
		mf.rateItem.setFin(Integer.valueOf(tf_fin.getText()));
		mf.rateItem.setHomeWork(Integer.valueOf(tf_homeWork.getText()));
		mf.rateItem.setMid(Integer.valueOf(tf_mid.getText()));
		mf.rateItem.setPT(Integer.valueOf(tf_PT.getText()));
		mf.rateItem.setQuiz(Integer.valueOf(tf_quiz.getText()));
		mf.rateItem.setReport(Integer.valueOf(tf_report.getText()));
		
		mf.rateItem.setRateA1(Integer.valueOf(tf_A1.getText()));
		mf.rateItem.setRateA0(Integer.valueOf(tf_A0.getText()));
		mf.rateItem.setRateB1(Integer.valueOf(tf_B1.getText()));
		mf.rateItem.setRateB0(Integer.valueOf(tf_B0.getText()));
		mf.rateItem.setRateC1(Integer.valueOf(tf_C1.getText()));
		mf.rateItem.setRateC0(Integer.valueOf(tf_C0.getText()));
		mf.rateItem.setRateD(Integer.valueOf(tf_D.getText()));
		mf.rateItem.setRateF(Integer.valueOf(tf_F.getText()));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch (cmd) { // �޴� �������� ���� ����
		
		case "Ȯ��":
			SaveRateItem();
			DBconnect db = new DBconnect(mf);
			db.RateUpdate();
			JOptionPane.showMessageDialog(this, "��޼����Ϸ�");
			dispose();
			break;
		case "�ݱ�":
			dispose();
			break;
		}
	}
	

}
