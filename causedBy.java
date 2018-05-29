import java.io.IOException;

public class causedBy {

	public static void main(String[] args)

	{
		try {
			meth();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void meth() throws IOException {

		meth1();
	}

	public static void meth1() throws IOException {

		meth2();
	}

	public static void meth2() throws IOException {

		for (int i = 0; i < 300000; i++) {
			try {
				System.out.println("iteration " + i);
				try {
					System.out.println("rethrow Exception");
					try {
						System.out.println("new Exception");
						String s = null;
						s.equals("");
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}
	}
}
