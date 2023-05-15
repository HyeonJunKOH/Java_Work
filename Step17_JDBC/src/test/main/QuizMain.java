package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class QuizMain extends JFrame implements ActionListener {
		//필드
	JTextField num,name,addr;
	JButton Btn;
	double Num1;
	
	
		//생성자
	public QuizMain (String title) {
		super(title);
			
		setBounds(100, 100, 500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//JTextField3개 만들기
		num=new JTextField(10);
		name=new JTextField(10);
		addr=new JTextField(10);
		//JButton 만들기
		JButton Btn=new JButton("저장");
		//JLabel 만들기
		JLabel num1=new JLabel("번호:");
		JLabel name1=new JLabel("이름:");
		JLabel addr1=new JLabel("주소:");
		//UI를 프레임에 배치하기
		add(num1);
		add(num);
		add(name1);
		add(name);
		add(addr1);
		add(addr);
		add(Btn);
		//버튼의 액션리스너 등록하기
		Btn.addActionListener(this);
		
		
			
		setVisible(true);
	}
	public static void main(String[] args) {
		new QuizMain("회원 정보");
	}
	
	@Override
	public void actionPerformed(ActionEvent e2) {
		//입력한 문자열 읽어오기
		String strNum = num.getText();
		String strName = name.getText();
		String strAddr = addr.getText();
		//번호 문자열 숫자로 전환하기
		Num1 = Double.parseDouble(strNum);
		//DB연결객체를 담을 지역 변수 만들기
		Connection conn=null;
		//입력한 문자열이 곧 member table에 등록되게
		int num=(int) Num1;
		String name=strName;
		String addr=strAddr;
		
		try {
	         //오라클 드라이버 로딩
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         //접속할 DB의 정보@아이피주소 : port번호 :db이름
	         String url="jdbc:oracle:thin:@localhost:1521:xe";
	         conn=DriverManager.getConnection(url, "scott", "tiger");
	         System.out.println("Oracle DB접속 성공");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		//sql 문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
	      PreparedStatement pstmt=null;
	      try {
			//실행할 미완성의 sql문
	    	String sql="insert into member"
	    			+ " (num,name,addr)"
	    			+ " values(?,?,?)";
	    	//미완성의 sql 문을 전달하면서 PreparedStatement 객채의 참조값 얻어내기
	    	pstmt=conn.prepareStatement(sql);
	    	//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(?에 값 바인딩하기)
	    	pstmt.setInt(1, num);//1번째 ?에 숫자 바인딩
	    	pstmt.setString(2, name);//2번째 ?에 문자열 바인딩
	    	pstmt.setString(3, addr);//3번째 ?에 문자열 바인딩
	    	//sql 문 실행하기
	    	pstmt.executeUpdate();
	    	System.out.println("회원 정보를 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "회원정보가 등록되었습니다.");
		}
		
		
	}
}
