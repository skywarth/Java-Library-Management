package grafikler;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;
import siniflar.Admin;


public class pasta extends ApplicationFrame 
{
	
	 	private Admin admin =new Admin();
	    private ArrayList<String> category=admin.getCategoryNames();
	    private String[]  labels= category.toArray(new String[category.size()]);

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public pasta(final String title) 
    {

        super(title);

        // create a dataset...
        
        
        final DefaultPieDataset data = new DefaultPieDataset();
        
        for(int i=0;i<labels.length;i++)
        {
        	data.setValue(labels[i], new Double(admin.categoryKitapSayi(labels[i])));
        }
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createPieChart3D(
            "Kategori Pasta Grafiði",  // chart title
            data,                   // data
            true,                   // include legend
            true,
            false
        );

        chart.setBackgroundPaint(Color.yellow);
        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(270);
        plot.setDirection(Rotation.ANTICLOCKWISE);
        plot.setForegroundAlpha(0.60f);
        plot.setInteriorGap(0.33);
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(900, 650));
        setContentPane(chartPanel);

        final Rotator rotator = new Rotator(plot);
        rotator.start();

    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    
    /*public static void main(final String[] args) {

        final pasta demo = new pasta("Pie Chart 3D Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }*/

}

// ****************************************************************************
// * JFREECHART DEVELOPER GUIDE                                               *
// * The JFreeChart Developer Guide, written by David Gilbert, is available   *
// * to purchase from Object Refinery Limited:                                *
// *                                                                          *
// * http://www.object-refinery.com/jfreechart/guide.html                     *
// *                                                                          *
// * Sales are used to provide funding for the JFreeChart project - please    * 
// * support us so that we can continue developing free software.             *
// ****************************************************************************

/**
 * The rotator.
 *
 */
class Rotator extends Timer implements ActionListener {

    /** The plot. */
    private PiePlot3D plot;

    /** The angle. */
    private int angle = 270;

    /**
     * Constructor.
     *
     * @param plot  the plot.
     */
    Rotator(final PiePlot3D plot) {
        super(100, null);
        this.plot = plot;
        addActionListener(this);
    }

    /**
     * Modifies the starting angle.
     *
     * @param event  the action event.
     */
    public void actionPerformed(final ActionEvent event) {
        this.plot.setStartAngle(this.angle);
        this.angle = this.angle + 1;
        if (this.angle == 360) {
            this.angle = 0;
        }
    }

}
