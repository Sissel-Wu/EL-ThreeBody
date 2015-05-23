package ui.lobby;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.FrameUtil;
import ui.component.SquareButton;
import control.LobbyControl;
import control.MainControl;

public class CreateRoomPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private LobbyControl lobbyControl;
	private JFrame createRoomFrame;
	private JLabel idLabel;
	private JLabel numLabel;
	private JTextField idField;
	private JComboBox<String> select;
	private JButton btnOk;
	private JButton btnCancel;
	private LobbyPanel lobbyPanel;
	
	MainControl mainControl;

	public CreateRoomPanel(LobbyPanel lobbyPanel, JFrame createRoomFrame,LobbyControl lobbyControl,MainControl mainControl) {
		this.lobbyControl = lobbyControl;
		this.createRoomFrame = createRoomFrame;
		this.mainControl = mainControl;
		this.lobbyPanel = lobbyPanel;
		
		this.setLayout(null);
		this.initComonent();
	}

	private void initComonent() {
		idLabel = new JLabel();
		idLabel.setBounds(30,60,60,30);
		idLabel.setIcon(new ImageIcon("images/roomname.png"));
		this.add(idLabel);
		
		numLabel = new JLabel();
		numLabel.setBounds(20,120,80,30);
		numLabel.setIcon(new ImageIcon("images/roomnumber.png"));
		this.add(numLabel);
		
		idField = new JTextField();
		idField.setBounds(100,60,240,30);
		this.add(idField);
		
		select = new JComboBox<String>();
		select.setBounds(140,120,100,40);
		select.addItem("3人房间");
		select.addItem("6人房间");
		select.addItem("8人房间");
		this.add(select);
		
		this.btnOk = new JButton(new ImageIcon("images/roomcreate.png"));
		this.btnOk.setBounds(100, 220, 80, 40);
		btnOk.setContentAreaFilled(false);
		btnOk.addMouseListener(new CreateListener());
		btnOk.setBorderPainted(false);
		this.add(btnOk);
		
		this.btnCancel = new JButton(new ImageIcon("images/roomcancel.png"));
		this.btnCancel.setBounds(220, 220, 80, 40);
		btnCancel.setContentAreaFilled(false);
		btnCancel.addMouseListener(new CancelListener());
		btnCancel.setBorderPainted(false);
		this.add(btnCancel);
		
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("images/img1.jpg").getImage();
		g.drawImage(img, 0, 0, null);
	}

	class CreateListener extends MouseAdapter {
		
		
		@Override
		public void mouseEntered(MouseEvent e) {
			btnOk.setIcon(new ImageIcon("images/roomcreate2.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnOk.setIcon(new ImageIcon("images/roomcreate.png"));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// 选择的房间人数
			int size = 0;
			switch(select.getSelectedIndex()){
			case 0:
				size = 3;
				break;
			case 1:
				size = 6;
				break;
			case 2:
				size = 8;
				break;
			}
			// 房间名不为空
			if(idField.getText().equals("")){
				FrameUtil.sendMessageByPullDown(lobbyPanel, "房间名不能为空");
				return;
			}
			// 创建房间
			switch(lobbyControl.createRoom(idField.getText(), size)){
			case ALREADY_EXISTED:
				FrameUtil.sendMessageByPullDown(lobbyPanel, "房间名已使用");
				break;
			case SUCCESS:
				createRoomFrame.setVisible(false);
				lobbyControl.changeEntered();
				mainControl.toRoom(idField.getText());
				break;
			default:
				break;
			}
		}
	}
	
	class CancelListener extends MouseAdapter {
		
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCancel.setIcon(new ImageIcon("images/roomcancel2.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnCancel.setIcon(new ImageIcon("images/roomcancel.png"));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			createRoomFrame.setVisible(false);
		}
	}
}
