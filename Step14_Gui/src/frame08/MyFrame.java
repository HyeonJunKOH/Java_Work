package frame08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	//필드
	JTextField inputMsg;
	JLabel label;
	
	//생성자
	public MyFrame(String title) {
		super(title);
		//초기 위치와 크기 설정
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//문자열을 한줄 입력 할 수 있는 JTextField 객체 생성
		inputMsg=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		JButton sendBtn2=new JButton("전송2");
		//UI 자체에 문자열이 출력되도록 하는 JLabel 객체 생성
		label=new JLabel("...");
		
				
		//프레임 UI를 추가한다.
			add(inputMsg);
			add(sendBtn);
			add(sendBtn2);
			add(label);
		
		//UI를 모두 배치하고 나중에 호출하는 것이 원칙이다.
		setVisible(true);
		
		//MyFrame 을 액션 리스너로 등록을 한다.
		sendBtn.addActionListener(this);
		
		//함수 형태로 액션 리스너를 등록 할 수도 있다.
		sendBtn2.addActionListener((e)->{
			String msg=inputMsg.getText();
			JOptionPane.showMessageDialog(this, msg);
			label.setText(msg);
		});
		
	}
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//1. JTextField에 입력한 문자열을 읽어 온다.
		String msg=inputMsg.getText();
		//2. 읽어온 문자를 출력한다.
		JOptionPane.showMessageDialog(this, msg);
		//3. 읽어온 문자열얼 JLabel 에 출력하기
		label.setText(msg);
	}
	
}
