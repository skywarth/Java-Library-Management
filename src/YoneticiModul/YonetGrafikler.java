package YoneticiModul;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.jfree.ui.RefineryUtilities;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import grafikler.*;

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
		frmGrafik.setTitle("Grafikler");
		frmGrafik.setBounds(100, 100, 455, 259);
		frmGrafik.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGrafik.getContentPane().setLayout(null);
		
		JButton btnKategoriIinGrafik = new JButton("Kategori \u0130\u00E7in Grafik");
		btnKategoriIinGrafik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				final pasta demo = new pasta("KATEGORÝ GRAFÝÐÝ");
		        demo.pack();
		        RefineryUtilities.centerFrameOnScreen(demo);
		        demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        demo.setVisible(true);
			}
		});
		btnKategoriIinGrafik.setBounds(10, 79, 203, 56);
		frmGrafik.getContentPane().add(btnKategoriIinGrafik);
		
		JButton btnKitapAlmTarihleri = new JButton("Kitap Al\u0131m Tarihleri \u0130\u00E7in Grafik");
		btnKitapAlmTarihleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				final cizgi demo = new cizgi("Çizgi Grafiði");
		        demo.pack();
		        RefineryUtilities.centerFrameOnScreen(demo);
		        demo.setVisible(true);
			}
		});
		btnKitapAlmTarihleri.setBounds(223, 80, 206, 54);
		frmGrafik.getContentPane().add(btnKitapAlmTarihleri);
	}

}
