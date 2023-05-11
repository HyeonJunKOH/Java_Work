package frame04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/*
 * 	일괄 import 하는 방법 ctrl + shift + o
 */

import test.mypac.AnotherThread;
import test.mypac.CountRunnable;

public class MyFrame extends JFrame implements ActionListener {

	 //생성자
	   public MyFrame(String title) {
	      super(title);
	      //프레임의 초기 설정 작업하기 
	      setBounds(100, 100, 500, 500);
	      // 이프레임(MyFrame)의 x 버튼 (close 버튼) 을 눌렀을때 프로세스도 같이 종료 되도록 설정 
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      //레이아웃 설정
	      setLayout(new FlowLayout());
	      
	      JButton startBtn=new JButton("카운트다운");
	      startBtn.addActionListener(this);
	      //프레임에 버튼 추가
	      add(startBtn);
	      
	      JTextField tf=new JTextField(10);
	      //프레임에 JTextField 추가
	      add(tf);
	      
	      // 프레임을 화면상에 실제 보이게 하기( false 하면 화면에 보이지 않는다 )
	      setVisible(true);
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		CountRunnable runnable = new CountRunnable();
		Thread t=new Thread(runnable);
		t.start();
		*/
		//위의 3줄을 줄여서 아래와 같이 사용할 수 있다.
		new Thread(new CountRunnable()).start();
	}
	
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}