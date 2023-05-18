package test.main;

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

import dao.FriendDao;
import dto.FriendDto;

public class MainFrame extends JFrame implements ActionListener {
	public static void main(String[] args) {
		MainFrame f=new MainFrame("친구목록");
		f.setBounds(100, 100, 900, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	//필요한 필드 생성
	DefaultTableModel model,model2;
	JTable table,table2;
	JTextField num,name,job,sal;
	JButton addBtn,updateBtn,deleteBtn;
	JScrollPane scroll,scroll2;
	//생성자
	public MainFrame(String title) {
		super(title);
		//레이아웃 설정
		setLayout(new BorderLayout());
		//JLabel 4개 생성
		JLabel la1=new JLabel("번호");
		JLabel la2=new JLabel("이름");
		JLabel la3=new JLabel("직업");
		JLabel la4=new JLabel("연봉");
		//JTextField 4개 생성
		num=new JTextField(10);
		name=new JTextField(10);
		job=new JTextField(10);
		sal=new JTextField(10);
		//JButton 3개 생성
		addBtn=new JButton("추가");
		updateBtn=new JButton("수정");
		deleteBtn=new JButton("삭제");
		//프레임에 ui 배치
		JPanel panel=new JPanel();
		panel.add(la1);
		panel.add(num);
		panel.add(la2);
		panel.add(name);
		panel.add(la3);
		panel.add(job);
		panel.add(la4);
		panel.add(sal);
		panel.add(addBtn);
		panel.add(updateBtn);
		panel.add(deleteBtn);
		//JPanel panel2=new JPanel();
		//panel2.add(panel2);
		//패널을 위쪽에 고정하기
		add(panel,BorderLayout.NORTH);
		//패널2를 아래쪽에 고정하기
		//add(panel2,BorderLayout.SOUTH);
		//패널 배경 설정하기
		panel.setBackground(Color.yellow);
		//panel2.setBackground(Color.GRAY);
		//테이블 생성하기
		table=new JTable();
		String[]list= {"번호","이름","직업","연봉","연봉합계"};
		//테이블에 연결할 모델 생성
		model=new DefaultTableModel(list,0);
		//모델을 테이블에 연결한다.
		table.setModel(model);
		//스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
		scroll=new JScrollPane(table);
		//JScrollPane  을 프레임의 가운데에 배치하기 
		add(scroll,BorderLayout.CENTER);
		//추가 버튼 액션 리스너,커맨드 등록하기
		addBtn.addActionListener(this);
		addBtn.setActionCommand("add");
		//수정 버튼 액션 리스너,커맨드 등록하기
		updateBtn.addActionListener(this);
		updateBtn.setActionCommand("update");
		//삭제 버튼 액션 리스너,커맨드 등록하기
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete");
		
		//회원정보 출력하기
		displayFriend();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼들의 액션 커맨드 읽어오기
		String cmd=e.getActionCommand();
		//추가 버튼 실행
		if(cmd.equals("add")) {
			//1.JTextField 입력한 문자열 읽어오기
			String strName= name.getText();
			String strJob= job.getText();
			String strSal= sal.getText();
			//2.int 타입 num,sal 문자열로 변환시켜주기
			int Sal=Integer.parseInt(strSal);
			//3.입력한 문자열 FriendDto 객체 생성해서 담기
			FriendDto dto=new FriendDto();
			dto.setName(strName);
			dto.setJob(strJob);
			dto.setSal(Sal);
			//4.FriendDao 객체의 insert() 메소드를 이용해서 DB 에 실제 저장하고
			boolean isinsert=new FriendDao().insert(dto);
			//5. 등록성공이면 "등록했습니다" 를 알림에 띄우고
			if(isinsert) {
				JOptionPane.showMessageDialog(this, "추가 했습니다.");
				//6.추가된 회원정보 업데이트해서 다시 재출력
				displayFriend();
			}
		}else if(cmd.equals("update")) {
			//1.JTextField 입력한 문자열 읽어오기
			String strNum=num.getText();
			String strName= name.getText();
			String strJob= job.getText();
			String strSal= sal.getText();
			//2.int 타입 num,sal 문자열로 변환시켜주기
			int Num=Integer.parseInt(strNum);
			int Sal=Integer.parseInt(strSal);
			//3.입력한 문자열 FriendDto 객체 생성해서 담기
			FriendDto dto=new FriendDto();
			dto.setName(strName);
			dto.setJob(strJob);
			dto.setSal(Sal);
			dto.setNum(Num);
			boolean isupdate=new FriendDao().update(dto);
			if(isupdate) {
				JOptionPane.showMessageDialog(this, "수정 했습니다.");
				//6.추가된 회원정보 업데이트해서 다시 재출력
				displayFriend();
			}
		}else if(cmd.equals("delete")) {
			//JTable 로 부터 선택된 row 의 인덱스를 얻어낸다 
			int selectedRow=table.getSelectedRow();
			if(selectedRow== -1) {
				JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요.");
				return;
			}
			int result=JOptionPane.showConfirmDialog(this, "삭제하시겠습니까?");
			System.out.println(result);
			// 예 버튼을 눌렀을때만 실제 삭제하기
			if(result==JOptionPane.YES_OPTION) {
				//선택된 row 에 해당하는 회원번호(PK) 를 얻어낸다 
				int num=(int)model.getValueAt(selectedRow, 0);
				//MemberDao 객체를 이용해서 회원 정보를 삭제한다.
				new FriendDao().delete(num);
				displayFriend();
			}
		}
	}
	
	//TestFrame 에 메소드 추가
	public void displayFriend() {
		//기존에 출력된 내용을 모두 삭제후 다시 출력
		model.setRowCount(0);
		//회원목록을 얻어오기
		List<FriendDto> list=new FriendDao().getList();
		      
		//반복문 돌면서
		for(FriendDto tmp:list) {
		    //MemberDto 객체 하나당 Object[] 을 하나씩 만들어내서 
		    Object[] row= {tmp.getNum(), tmp.getName(), tmp.getJob(),tmp.getSal()};
		    //모델에 추가하기
		    model.addRow(row);
		}
	}
}
