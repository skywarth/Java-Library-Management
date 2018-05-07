package YoneticiModul;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class Pasta extends JPanel
{
		
    public static JFrame frame;
    
    private int originX, originY;
    private int radius;
    private static double d2r = Math.PI / 180.0;
    //ÖNEMLÝ NOT RENK KÝTAP TÜRÜ KAÇ TANE ÝSE O KADAR SAYIDA RENT ATAMASI YAPILMASI GEREK Color DÝZÝSÝNE
    private Color colors[] = new Color[] { Color.gray,
            Color.green, Color.blue, Color.pink,Color.yellow,Color.LIGHT_GRAY};
    private double values[] = {10.0,20.0,40.0,15.0,15.0,20.0 };
    private String labels[] = { "Tarih","Bilim-Kurgu","Edebiyat","Fantastik","Saðlýk","Felsefe" };

    public Pasta() {
        super();
        
    }
    
	public Pasta(Color[] colors, double[] values,String[] labels)
	{
	    super();
	    this.colors = colors;
	    this.values = values;
	    this.labels = labels;
	}

	public void paintComponent(Graphics g) {
		
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	    Dimension size = this.getSize();
	    originX = size.width / 2;
	    originY = size.height / 2;
	    int diameter = (originX < originY ?size.width - 40 : size.height - 40);
	    radius = (diameter / 2) + 1;
	    int cornerX = (originX - (diameter / 2));
	    int cornerY = (originY - (diameter / 2));
	    int startAngle = 0;
	    double endAngle = 0.0;
	    int arcAngle = 0;
	
	    double sum = 0;
	
	    for (int i = 0; i < values.length; i++)
	        sum += values[i];
	
	    for (int i = 0; i < values.length; i++) {
	        startAngle = (int) (endAngle * 360 / sum);
	        arcAngle = (int) (values[i] * 360 / sum);
	        g.setColor(colors[i % colors.length]);
	        Shape s = new Arc2D.Double(cornerX, cornerY, diameter,diameter, startAngle, arcAngle, Arc2D.PIE);
	        RadialGradientPaint rgp =
	                new RadialGradientPaint(new Point(getWidth() / 2, getHeight() / 2),
	                        diameter, new float[] {0f, 1f },
	                        new Color[] { colors[i], Color.gray });
	        g2d.setPaint(rgp);
	        g2d.fill(s);
	        drawLabel(g2d, labels[i], startAngle + (arcAngle / 2));
	        endAngle += values[i];
	    }
	    g.setColor(Color.gray);
	    g.drawOval(cornerX, cornerY, diameter, diameter);
	}
	
	public void drawLabel(Graphics g, String text, double angle) {
	    g.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
	    g.setColor(Color.black);
	    double radians = angle * d2r;
	    int x = (int) ((radius - 60) * Math.cos(radians));
	    int y = (int) ((radius - 60) * Math.sin(radians));
	    if (x < 0) {
	        x -= SwingUtilities.computeStringWidth(g.getFontMetrics(), text);
	    }
	    if (y < 0) {
	        y -= g.getFontMetrics().getHeight();
	    }
	    g.drawString(text, x + originX, originY - y);
	}
	
}
