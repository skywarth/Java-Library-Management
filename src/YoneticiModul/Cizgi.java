package YoneticiModul;
import javax.swing.*;
import java.awt.*;

public class Cizgi extends JPanel
{
	
	//NOT: Grafiði çizebilmek için kendimizin deðerler üretmesi lazým o deðerlere göre de çizgi grafiði oluþturacaðýz
	//Ben kendim oluþturamadým birlikt incelememiz lazým internete java ile istatistiksel çizgi grafikleri çizimine bakmamýz lazým.
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawLine(20,100,380,100);
        g.drawLine(200,20,200,180);

        g.drawString("TARÝH",360,80);
        g.drawString("KÝTAP SAYISI",220,40);

        Polygon polySin=new Polygon();
        Polygon parabol=new Polygon();
        Polygon polyCos=new Polygon();
        for (int x=-170;x<=170;x++)
        {
            polySin.addPoint(x + 200, 100 - (int)(50 * Math.sin((x / 100.0) * 2 * Math.PI)));
            parabol.addPoint(x+200,100-(int)(0.05*Math.pow(x-0,2)));
            polyCos.addPoint(x+200,100-(int)(50*Math.cos((x/100.0)*2*Math.PI)));
        }
        g.setColor(Color.black);
        g.drawString("0",200,115);
        g.drawString("- Taraf",95,115);
        g.drawString("+ Taraf",305,115);

        g.setColor(Color.red);
        g.drawPolyline(polySin.xpoints,polySin.ypoints,polySin.npoints);
        g.setColor(Color.green);
        g.drawPolyline(parabol.xpoints,parabol.ypoints,parabol.npoints);
        g.setColor(Color.blue);
        g.drawPolyline(polyCos.xpoints,polyCos.ypoints,polyCos.npoints);

    }
}
