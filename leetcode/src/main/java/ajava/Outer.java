package ajava;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Outer {

	void outMethod(){

		int a =10;
		class Inner {

			void innerMethod(){

				System.out.println(a);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		while (true) {
			Socket clientSocket = serverSocket.accept(); // 阻塞等待客户端连接
			new Thread(() -> {
				try (InputStream input = clientSocket.getInputStream();
					 OutputStream output = clientSocket.getOutputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead = input.read(buffer); // 阻塞等待数据读取
					output.write(buffer, 0, bytesRead);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}