package QuizMain;

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
	JTextField msg1,msg2;
	JButton PlusBtn,MinusBtn,MultiBtn,DivadBtn;
	JLabel La1,La2;
	
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100,100,500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//JTextField 생성하기
		msg1 = new JTextField(10);
		msg2 = new JTextField(10);
		//JButton 생성하기
		PlusBtn = new JButton("+");
		MinusBtn = new JButton("-");
		MultiBtn = new JButton("*");
		DivadBtn = new JButton("/");
		//JLabel 생성하기
		La1 = new JLabel("=");
		La2 = new JLabel("0");
		
		//UI 프레임에 배치하기
		add(msg1);
		add(PlusBtn);
		add(MinusBtn);
		add(MultiBtn);
		add(DivadBtn);
		add(msg2);
		add(La1);
		add(La2);
		
		//액션 리스너 등록하기
		PlusBtn.addActionListener(this);
		MinusBtn.addActionListener(this);
		MultiBtn.addActionListener(this);
		DivadBtn.addActionListener(this);
		
		//버튼에 액션 커맨드 등록하기
		PlusBtn.setActionCommand("+");
		MinusBtn.setActionCommand("-");
		MultiBtn.setActionCommand("*");
		DivadBtn.setActionCommand("/");
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame("계산기");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//입력한 문자열 읽어오기
		String strNum1 = msg1.getText();
		String strNum2 = msg2.getText();
	try {
		//문자열을 숫자로 변환하기
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		//눌러진 버튼의 command 읽어오기
		String cmd = e.getActionCommand();
		//num1, num2 값의 result 값 을 초기값0 설정해주기
		double result=0;
		//각 상황에 맞게 분기하기
		if(cmd.equals("+")) {
			result=num1+num2;
		}else if(cmd.equals("-")) {
			result=num1-num2;
		}else if(cmd.equals("*")) {
			result=num1*num2;
		}else{
			if(num2==0) {
				JOptionPane.showMessageDialog(this, "어떤수를0으로 나눌수는 없어요!");
				//메소드를 여기서 종료시키기
				return;
			}
			result=num1/num2;
		}
		
		//숫자를 문자열로 바꿔주기
		String resultText = Double.toString(result);
		La2.setText(resultText);
	}catch(NumberFormatException nfe) {
		JOptionPane.showMessageDialog(this,"숫자형식으로 입력해주세요");
	}
	}
}
