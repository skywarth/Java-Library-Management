package YoneticiModul;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YonetGrafikler 
{

	public JFrame frmGrafik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YonetGrafikler window = new YonetGrafikler();
					window.frmGrafik.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public YonetGrafikler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrafik = new JFrame();
		frmGrafik.setBounds(100, 100, 395, 139);
		frmGrafik.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGrafik.getContentPane().setLayout(null);
		
		JButton btnKategoriIinGrafik = new JButton("Kategori \u0130\u00E7in Grafik");
		btnKategoriIinGrafik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmGrafik=new JFrame("Pasta Grafik");
				frmGrafik.setSize(500,500);
				frmGrafik.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        GridLayout layout=new GridLayout(0,1);
		        frmGrafik.getContentPane().setLayout(layout);
		        frmGrafik.getContentPane().add(new Pasta());
		        frmGrafik.setVisible(true);
			}
		});
		btnKategoriIinGrafik.setBounds(10, 23, 178, 56);
		frmGrafik.getContentPane().add(btnKategoriIinGrafik);
		
		JButton btnKitapAlmTarihleri = new JButton("Kitap Al\u0131m Tarihleri \u0130\u00E7in Grafik");
		btnKitapAlmTarihleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmGrafik=new JFrame("Çizgi Grafiði");
				frmGrafik.setSize(600,600);
				frmGrafik.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				GridLayout layout=new GridLayout(0,1);
				frmGrafik.getContentPane().setLayout(layout);
				frmGrafik.getContentPane().add(new Cizgi());
				frmGrafik.setVisible(true);
			}
		});
		btnKitapAlmTarihleri.setBounds(198, 25, 171, 54);
		frmGrafik.getContentPane().add(btnKitapAlmTarihleri);
	}

}
