package business_end;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import Login.LoginFrame;
import data.Evaluate;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class StoreReplyframe {

	public JFrame frame;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreReplyframe window = new StoreReplyframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoreReplyframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7528\u6237\u8BC4\u8BBA:");//�û�����
		frame.setBounds(100, 100, 591, 655);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(35, 38, 399, 531);
		frame.getContentPane().add(scrollPane);
		
		RefreshPanel();
		
		JButton btnNewButton = new JButton("ˢ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshPanel();		
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 14));
		btnNewButton.setBounds(456, 30, 97, 25);
		frame.getContentPane().add(btnNewButton);	
		}
	
public void RefreshPanel() {
	int store_id = LoginFrame.store_id;
	List<Evaluate> evaluatelist=Evaluate.getEvaluate(store_id);//��ȡ�û�����
	int size=evaluatelist.size();
	panel.removeAll();
	for(int i=0;i<size;i++) {
		Evaluate a=evaluatelist.get(i);
		JLabel nickname=new JLabel("�û��ǳƣ�"+Evaluate.getNikename(a.ordernum)+"     ���֣�"+String.valueOf(a.grade));
		nickname.setFont(new Font("����", Font.BOLD, 14));
		
		JLabel pinlun=new JLabel("�û����ۣ�");//����
		pinlun.setFont(new Font("����", Font.BOLD, 14));
		
		JTextArea userremark=new JTextArea(a.comment);//�û�������
		userremark.setFont(new Font("����", Font.BOLD, 14));
		userremark.setBounds(53, 220, 329, 114);
		
		JLabel huifu=new JLabel("�̼һظ���");//����
		huifu.setFont(new Font("����", Font.BOLD, 14));
		
		JTextArea storereply=new JTextArea(a.reply);//�̼һظ�
		storereply.setFont(new Font("����", Font.BOLD, 14));
		storereply.setBounds(53, 220, 329, 114);
		
		JButton commit=new JButton("�ύ");
		commit.setBounds(53, 220, 329, 114);
		commit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    //ȫ����Ʒ
               String reply=storereply.getText();
               try {
				Evaluate.modifyEvaluate(a.ordernum, reply);
				JOptionPane.showMessageDialog(null, "�ظ��ɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "�ظ�ʧ�ܣ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			}
            }
        });		
		JLabel fengexian=new JLabel("______________________________________________________");
		fengexian.setFont(new Font("����", Font.BOLD, 14));
		
		panel.add(nickname);
		panel.add(userremark);
		panel.add(huifu);
		panel.add(storereply);
		panel.add(commit);
		panel.add(fengexian);
		frame.validate();
	}	
}	
}	
		
		
		
	

