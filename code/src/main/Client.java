package main;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *${Generate graphical interface}
 */
public class Client extends JFrame{
	final int MAXN = 2000010;
	
	JPanel jp1, jp2, jp3, jp4, jp5, jp6;
    JLabel jlb1, jlb2, jlb3, jlb4, jlb5, jlb6;
    JButton jb1, jb2;
    JComboBox<String> jcb1;
    JTextField jtf1, jtf2, jtf3;
    JTextArea jta1;
	double sum = 0;
	VIP[] vipList = new VIP[MAXN];
	
    Client() {
    	this.setBounds(200, 80, 640, 610);
    	this.setTitle("Store cashier system");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(new FlowLayout(FlowLayout.LEFT, 90, 20));
    	
    	jp1 = new JPanel();
    	jp2 = new JPanel();
    	jp3 = new JPanel();
    	jp4 = new JPanel();
    	jp5 = new JPanel();
    	jp6 = new JPanel();
    	
    	jlb1 = new JLabel("the unit price");
    	jlb2 = new JLabel("the number   ");
    	jlb3 = new JLabel("type                 ");
    	jlb4 = new JLabel("VIP ID              ");
    	jlb5 = new JLabel("Sum:       ");
    	jlb6 = new JLabel("0");
    	
    	
    	jb1 = new JButton("   reset    ");
    	jb2 = new JButton("caculate");
    	
    	jtf1 = new JTextField(20);
    	jtf2 = new JTextField(20);
    	jtf3 = new JTextField(20);
    	
    	String[] opt = {"normal", "employee discount 8", "VIP discount 6", "student full 100 minus 10"};
    	jcb1 = new JComboBox<String>(opt);
    	
    	jta1 = new JTextArea(15, 40);
    	
    	jb2.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					//cal
					String oP = jtf1.getText();
					String num = jtf2.getText();
					double originalPrice = Double.parseDouble(oP) * Double.parseDouble(num);
					String typeNow = (String)jcb1.getSelectedItem();
					double currentPrice = 0.0;
					MarketAccounts now = new MarketAccounts(typeNow);
					currentPrice = now.getPrice(originalPrice);
					if(typeNow.equals("VIP discount 6")) {
						int vipID = -1;
						try {
							String id = jtf3.getText();
							vipID = Integer.parseInt(id);
						} catch(Exception ep) {
							jta1.append("Please input the VIP ID or check the limit of ID.\n");
							return;
						}
						if(vipList[vipID] == null) vipList[vipID] = new VIP();
						String res = "VIP ID is " + vipID + "\n" + "Unit price: " + oP + " the number: " + num + " " + typeNow + " sum: " + String.format("%.2f", currentPrice) + "\n";
						jta1.append(res);
						
						vipList[vipID].addScore((int)currentPrice);
						String res2 = "";
						res2 = "now score is " + vipList[vipID].getScore() + "\n";
						jta1.append(res2);
						
					} else {
						String res = "Unit price: " + oP + " the number: " + num + " " + typeNow + " sum: " + String.format("%.2f", currentPrice) + "\n";
						jta1.append(res);
					}
					sum += currentPrice;
					jlb6.setText(String.format("%.2f", sum));
				}
			}
		});
    	
    	jb1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 1) {
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jta1.setText("");
					jcb1.setSelectedItem("normal");
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
    		
    	});
    	
    	jp1.add(jlb1);
    	jp1.add(jtf1);
    	jp1.add(jb1);
    	
    	jp2.add(jlb2);
    	jp2.add(jtf2);
    	jp2.add(jb2);
    	
    	jp3.add(jlb3);
    	jp3.add(jcb1);
    	
    	jp4.add(jlb4);
    	jp4.add(jtf3);
    	
    	jp5.add(jta1);
    	
    	jp6.add(jlb5);
    	jp6.add(jlb6);
    	
    	this.add(jp1);
    	this.add(jp2);
    	this.add(jp3);
    	this.add(jp4);
    	this.add(jp5);
    	this.add(jp6);
    	
    	this.setVisible(true);
    }
	
	public static void main(String args[]) {
		new Client();
	}
}
