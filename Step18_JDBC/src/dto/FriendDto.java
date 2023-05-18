package dto;

public class FriendDto {
	//필드의 접근 지정자를 private로
	private int num;
	private String name;
	private String job;
	private int sal;
	
	//디폴트 생성자
	public FriendDto() {};
	
	//생성자
	public FriendDto(int num,String name,String job,int sal) {
		super();
		this.num=num;
		this.name=name;
		this.job=job;
		this.sal=sal;
	}
	//생성자2 getter,setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num=num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job=job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal=sal;
	}
	
}
