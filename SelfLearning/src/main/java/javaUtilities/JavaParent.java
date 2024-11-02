package javaUtilities;

public class JavaParent {
	private Integer length ;
	private Integer width; 
	private Integer hight;
	
	public JavaParent(int length, int width, int hight){
		this.length = length;
		this.width = width;
		this.hight = hight;
	}

	public void VolumeOfObject() {
		System.out.println("Box Dimensions are " + "Length " + length  + "; Width " + width + "; Hight " + hight);
		System.out.println("Volume of Box is " + length * width * hight);
	}

	/*
	 * public String EmpName="Vimlesh"; public int EmpAge= 31; public int EmpNo=
	 * 261303;
	 * 
	 * public static void main (String[] args) { JavaParent obj = new JavaParent();
	 * obj.getdata(); }
	 * 
	 * final public void getdata() { System.out.println(EmpName);
	 * System.out.println(EmpAge); System.out.println(EmpNo); }
	 */
}
