package cn.tedu.ssm.spring.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckServlet
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public  void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("checkcodeServlet's service()");
		/**
		 * 1.绘图
		 */
		//创建一个画布(内存映像对象)
		BufferedImage image=new BufferedImage(80, 30,BufferedImage.TYPE_INT_BGR);
		//获得画笔
		Graphics g =image.getGraphics();
		//给画笔设置颜色
		g.setColor(new Color(250,250,250));
		//给画布设置背景颜色
		g.fillRect(0, 0, 80, 30);
		//给画笔设置颜色
		Random r =new Random();
		g.setColor(new Color(r.nextInt(255),
							 r.nextInt(255),
							 r.nextInt(255)));
		//设置字体(字体，风格，大小)
		g.setFont(new Font(null,Font.BOLD,24));
		//在画布上绘图
		String number =getNumber(5);
		//将验证码绑定到session对象上
		HttpSession session=request.getSession();
		session.setAttribute("number",number);
		System.out.println("number:"+number);
		g.drawString(number, 5, 25);
		//加一些干扰线
		for(int i=0;i<8;i++){
			g.setColor(new Color(r.nextInt(255),
					 r.nextInt(255),
					 r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
		}
		/*
		 * 2.将图片压缩，然后输出发送给浏览器
		 */
		//设置content-type
		response.setContentType("image/jpeg");//压缩算法
		//获得字节输出流(图片是一个二进制数据)
			OutputStream os= response.getOutputStream();
			//将原始图片(image)按照指定算法压缩(jpeg)
			//然后将压缩之后得到的字节写入response对象
					javax.imageio.ImageIO.write(image, "jpeg",os );
					os.close();
	}
	public static String getNumber(int size){
		String s ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String n ="";
		for(int i=0;i<size;i++){
			n+=s.charAt(new Random().nextInt(s.length()));
		}
		return n;
	}
}
