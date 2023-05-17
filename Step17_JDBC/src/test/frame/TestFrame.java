package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class TestFrame extends JFrame implements ActionListener{
	//필드
	JTextField inputName,inputAddr;
	DefaultTableModel model;
	
	//생성자
	public TestFrame(String title) {
		super(title);
		
		//레이아웃 매니저 설정
		setLayout(new BorderLayout());
		
		JLabel label1=new JLabel("이름");
		inputName=new JTextField(10);
		
		JLabel label2=new JLabel("주소");
		inputAddr=new JTextField(10);
		
		JButton addBtn=new JButton("추가");
		addBtn.addActionListener(this);
		addBtn.setActionCommand("add");
		
		//패널에 ui를 배치
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(addBtn);
		
		//패널째로 프레임의 북쪽에 배치
		add(panel,BorderLayout.NORTH);
		
		panel.setBackground(Color.yellow);
		
		
		JTable table=new JTable();
		
		String[] colNames={"번호","이름","주소"};
		//테이블에 연결할 모델객체 생성(테이블에 출력할 데이터를 여기에 추가하면 테이블에 출력된다)
		model=new DefaultTableModel(colNames,0);
		//모델을 테이블에 연결한다.
		table.setModel(model);
		//스크롤이 가능 하도록 테이블을 JScrollPane에 감싼다.
		JScrollPane scroll=new JScrollPane(table);
		//JScrollPane 을 프레임 가운데 배치하기
		add(scroll,BorderLayout.CENTER);
		
		//모든 회원 정보를 얻어온다. 
		List<MemberDto>list=new MemberDao().getList();
		//얻어온 회원 정보를 for문을 통해 활용
		for(MemberDto tmp:list) {
			//회원 정보를 Object 배열에 각각 담는다
			Object[]row= {tmp.getNum(),tmp.getName(),tmp.getAddr()};
			//배열에 담은 회원 정보를 model에 추가하기
			model.addRow(row);
		}
		
		//부모의 메소드를 마음대로 호출할 수 있음, this 생략 가능
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setBounds(100, 100, 800, 500);
		//this.setVisible(true);
	}
	
	//run 했을때 실행의 흐름이 시작되는 main 메소드
	public static void main(String[] args) {
		TestFrame f=new TestFrame("테스트 프레임");
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼의 액션 커맨드 읽어오기
		String cmd=e.getActionCommand();
		if(cmd.equals("add")) {
			//1. 입력한 이름과 주소를 읽어와서
			String name=inputName.getText();
			String addr=inputAddr.getText();
			//2. MemberDto 객체에 담고
			MemberDto dto=new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			//3. MemberDao 객체의 insert() 메소드 이용해서 DB에 저장
			boolean isinsert=new MemberDao().insert(dto);
			if(isinsert) {
				JOptionPane.showMessageDialog(this, "추가했습니니다.");
				//4 추가한 회원 목록이 바로 다시 출력 되도록
				//기존에 출력된 내용을 모두 삭제후 다시 출력 
				model.setRowCount(0);
				//회원목록 얻어오기
				List<MemberDto>list=new MemberDao().getList();
				//얻어온 회원 정보를 for문을 통해 활용
				for(MemberDto tmp:list) {
					//회원 정보를 Object 배열에 각각 담는다
					Object[]row= {tmp.getNum(),tmp.getName(),tmp.getAddr()};
					//배열에 담은 회원 정보를 model에 추가하기
					model.addRow(row);
				}
			}
		}
		
	}
}
