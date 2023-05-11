package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class QuizMain extends JFrame implements ActionListener {
	//필드
	JButton Btn;
	
	//생성자
	public QuizMain(String title) {
		super(title);
		
		setBounds(100, 100, 500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//JTextField,JButton 생성하기
		JTextField msg = new JTextField(10);
		Btn = new JButton("저장");
		//UI 프레임에 배치하기
		add(msg);
		add(Btn);
		//액션 리스너 등록하기
		Btn.addActionListener(this);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new QuizMain("나의 프레임");
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
