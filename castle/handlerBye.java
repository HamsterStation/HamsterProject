package castle;

public class handlerBye extends Handler {

	
	@Override
	public boolean isBye() {
		
		return true;
	}

	@Override
	public void doCmd(String dir) {
		// TODO Auto-generated method stub
		System.out.println("感谢您的光临。再见！");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
