package ui.login;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.AccountControl;

public class LoginPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnlogin;
	private JButton btnlogup;
	private JFrame loginFrame;
	private JTextField idField;
	private JPasswordField passwordField;
	private JLabel idLabel;
	private JLabel passwordLabel;
	
	public JFrame getLoginFrame() {
		return loginFrame;
	}
	private AccountControl accountControl;
	private JPanel panelLogup;
	public LoginPanel(JFrame loginFrame,AccountControl accountControl) {
		this.accountControl = accountControl;
		
		this.setLayout(null);
		this.loginFrame=loginFrame;
		panelLogup = new LogupPanel(this,accountControl);
		this.initComonent();
	}
	private void initComonent() {
		this.btnlogin = new JButton(new ImageIcon("login.png"));
		this.btnlogin.setBounds(220, 220, 80, 40);
		btnlogin.setContentAreaFilled(false);
		btnlogin.addMouseListener(new LoginListener());
		this.add(btnlogin);
		
		this.btnlogup = new JButton(new ImageIcon("logup.png"));
		this.btnlogup.setBounds(100, 220, 80, 40);
		btnlogup.setContentAreaFilled(false);
		btnlogup.addMouseListener(new LogupListener());
		this.add(btnlogup);
		
		idField = new JTextField();
		idField.setBounds(100,60,240,30);
		this.add(idField);
		
		passwordField =new JPasswordField();
		passwordField.setBounds(100,110,240,30);
		this.add(passwordField);
		
		idLabel = new JLabel();
		idLabel.setBounds(30,60,60,30);
		idLabel.setIcon(new ImageIcon("logid.png"));
		this.add(idLabel);
		
		passwordLabel = new JLabel();
		passwordLabel.setBounds(30,110,60,30);
		passwordLabel.setIcon(new ImageIcon("logpassword.png"));
		this.add(passwordLabel);
	}
	class LoginListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			String id = idField.getText();
			String password = passwordField.getText();
			
			System.out.println(id);
			System.out.println(password);
			
			// TODO 消息窗口
			switch(accountControl.login(id, password)){
			case SUCCESS:
				System.out.println("login success");
				break;
			case ALREADY_IN:
				System.out.println("already log in");
				break;
			case INVALID:
				System.out.println("wrong password");
				break;
			case NOT_EXISTED:
				System.out.println("account not existed");
				break;
			}
			
			loginFrame.setVisible(false);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	}
	
	class LogupListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			setVisible(false);
			panelLogup.setVisible(true);
			loginFrame.setContentPane(panelLogup);
			repaint();
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	}
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("img1.jpg").getImage();
		g.drawImage(img, 0, 0, null);
		}
}