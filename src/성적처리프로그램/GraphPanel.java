package ����ó�����α׷�;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import frames.DrawingPanel;
import frames.ShapesPanel;

public class GraphFrame extends JFrame{
	private GraphPanel dp;
	JButton btn1 = new JButton("�л��߰�");
	
	JPanel p1 = new JPanel();
	
	
	JLabel jlTot = new JLabel("���� : ");
	JLabel jlTotData = new JLabel("0");

	public GraphFrame(MainFrame mf) {
		this.setTitle("�׷��� ���");
		
//		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
//		
//		p1.add(jlTot);
//		p1.add(jlTotData);
		dp = new GraphPanel(mf);
		
		
//		add(p1, BorderLayout.SOUTH);
		add(dp, BorderLayout.CENTER);
		
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 400);
		this.setVisible(true);
	}
	

}
