package frame01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	//필드
	JTextArea ta;
   public MyFrame(String title) {
      super(title);
      
      setBounds(100, 100, 500, 500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //BorderLayout 으로 설정 
      setLayout(new BorderLayout());
      
      //UI 를 감쌀 페널
      JPanel p1=new JPanel();
      
      JTextField inputText=new JTextField(20);
      JButton saveBtn=new JButton("저장");
      
      //페널에 UI 를 추가
      p1.add(inputText);
      p1.add(saveBtn);
      //페널을 프레임의 북쪽에 배치
      add(p1, BorderLayout.NORTH);
      //페널의 배경색
      p1.setBackground(Color.YELLOW);
      /*
       *  읽어오기 버튼을 누르면 diary.txt 에 있는 모든 문자열을 읽어와서 
       *  JTextArea 에 출력해 보세요.
       *  
       *  - hint 
       *  FileReader 객체를 활용하면 파일에서 문자열을 읽어 낼수 있습니다.
       */
      
      ta=new JTextArea();
      add(ta, BorderLayout.CENTER);
      
      JButton readBtn=new JButton("읽어오기");
      p1.add(readBtn);
      
      setVisible(true);
      
      File f=new File("C:\\acorn202304\\myFolder\\diary.txt");
      //버튼에 리스너 등록
      saveBtn.addActionListener((e2)->{
         //입력한 문자열 읽어오기
         String msg=inputText.getText(); //바깥 영역에 정의된 지역변수 참조 가능!
         //File 객체
         try {
            if(!f.exists()) {
               f.createNewFile();
            }
            //파일에 문자열을 출력할 객체
            FileWriter fw=new FileWriter(f, true);
            fw.write(msg);
            fw.write("\r\n"); //개행기호
            fw.flush();
            fw.close();
            JOptionPane.showMessageDialog(this, "저장 했습니다");
         }catch(Exception e) {
            e.printStackTrace();
         }
         
      });
      
      //읽어오기 버튼에 리스너 등록
      readBtn.addActionListener((e3)->{
    	  try {
    		  //diary에 있는 문자열 읽어오기
			FileReader fr= new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			//반복문 돌면서
			while(true) {
				//문자열을 한줄씩 읽어낸다
				String line=br.readLine();
				//만일 더이상 읽을 문자열이 없다면
				if(line==null)break; //반복문 탈출
				//읽어낸 문자열을 JTextArea에 출력하기
				ta.append(line);//개행기호는 제외된 상태로 읽어내기 때문에
				ta.append("\r\n");//개행기호를 따로 추가해준다.
				
			}
			//사용했던 스트림은 닫아주는 것이 좋다.
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
    	  System.out.println("읽어오기가 종료 됩니다.");
      });
      
   }
   
   public static void main(String[] args) {
      new MyFrame("나의 프레임");
   }
}








