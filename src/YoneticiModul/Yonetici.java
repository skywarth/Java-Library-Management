package YoneticiModul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Yonetici {

	public JFrame frameYonetici;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yonetici window = new Yonetici();
					window.frameYonetici.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Yonetici() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameYonetici = new JFrame();
		frameYonetici.setBounds(100, 100, 450, 300);
		frameYonetici.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameYonetici.getContentPane().setLayout(null);
		
		JButton btnKutuphane = new JButton("K\u00FCt\u00FCphane \u0130\u015Flemleri");
		btnKutuphane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YonetKutuphane kutuphane=new YonetKutuphane();
				kutuphane.frameKutuphane.setVisible(true);
				
			}
		});
		btnKutuphane.setBounds(10, 68, 166, 41);
		frameYonetici.getContentPane().add(btnKutuphane);
		
		JButton btnUye = new JButton("Uye \u0130\u015Flemleri");
		btnUye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YonetUye uye=new YonetUye();
				uye.frameUye.setVisible(true);
			}
		});
		btnUye.setBounds(231, 68, 166, 41);
		frameYonetici.getContentPane().add(btnUye);
		
		JButton btnIstatistik = new JButton("Grafik");
		btnIstatistik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YonetGrafikler grafik=new YonetGrafikler();
				grafik.frmGrafik.setVisible(true);
			}
		});
		btnIstatistik.setBounds(128, 147, 166, 41);
		frameYonetici.getContentPane().add(btnIstatistik);
	}
}
