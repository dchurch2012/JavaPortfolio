import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class BasicDraftingProgram extends JPanel implements ActionListener
{
    DrawingPanel myDrawingPanel;
    JPanel buttonPanel;
    JButton blackButton;
    JButton clearButton, upSize, downSize;
  
    public /*JPanel*/ BasicDraftingProgram()
    {
        myDrawingPanel = new DrawingPanel();
        myDrawingPanel.setBorder(BorderFactory.createEtchedBorder(Color.black,
                                                                  Color.blue));
        buttonPanel = new JPanel();
        // See last paragraph in GridLayout api comments section
        // for what happens when you specify both rows and columns.
        buttonPanel.setLayout(new GridLayout(0, 4, 2, 2));
        buttonPanel.setBorder(BorderFactory.createEtchedBorder(Color.white,
                                                               Color.blue));
  
        blackButton = addButton(Color.black);
        addButton(Color.red);
        addButton(Color.green.darker());
        addButton(Color.blue);
        clearButton = addButton(null);
        clearButton.setText("New");
        System.out.println(getClass().getSuperclass().getName() +
                           " default layout is " +
                           getLayout().getClass().getName());
        setLayout(new BorderLayout());
        add("Center", myDrawingPanel);
        add("South", buttonPanel);
		//return this;
    }
  
    private JButton addButton(Color color)
    {
        JButton button = new JButton();
        button.setBackground(new Color(230,240,250));
        button.setBorder(BorderFactory.createEtchedBorder());
        if (color != null)
        {
            button.setForeground(Color.white);
            button.setBackground(color);
        }
  
        button.setText("Paint");
        buttonPanel.add(button);
        button.addActionListener(this);
  
        return button;
    }
  
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
  
        if (s.equals("Paint"))
        {
            JButton button = (JButton)e.getSource();
            myDrawingPanel.setPaintColor(button.getBackground());
        }
        if (s.equals("New"))
        {
            myDrawingPanel.clearPaint();
        }
    }
  
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        BasicDraftingProgram basicDrafting = new BasicDraftingProgram();
        // DLOP extends JPanel so an instance of DLOP is (at least) a
        // JPanel. Therefore, we can add an instance of it to our JFrame.
        frame.add(basicDrafting);
        // EXIT_ON_CLOSE is a static constant in the JFrame class. See
        // Field Detail in JFrame class api. If the enclosing class
        // extended JFrame then you could refer to the constant without
        // the "JFrame." prefix, ie, without using static notation.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible( true );
    }
  
    public class DrawingPanel extends JPanel implements MouseListener,
                                                        MouseMotionListener
    {
        Image image;
        Graphics2D g2d;
        int brushSize = 3;
        Point lastPoint = new Point();
        Point dragPoint = new Point();
        boolean dragging = false;
  
        public DrawingPanel()
        {
            setPreferredSize( new Dimension(300, 300) );
            addMouseListener(this);
            addMouseMotionListener(this);
        }
  
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
//        public void mouseReleased(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}
  
        public void mousePressed(MouseEvent e)
        {
            lastPoint = e.getPoint();
            dragging = true;
//            draw( lastPoint );
        }
  
        public void mouseReleased(MouseEvent e)
        {
            draw(e.getPoint());
            dragging = false;
        }
  
        public void mouseDragged(MouseEvent e)
        {
            if(dragging)
            {
                dragPoint = e.getPoint();
                repaint();
            }
        }
  
        private void draw(Point p)
        {
            g2d.setStroke(new BasicStroke(brushSize));
            g2d.drawLine(lastPoint.x, lastPoint.y, p.x, p.y);
            repaint();
        }
  
        public void setPaintColor(Color color)
        {
            g2d.setColor(color);
        }
  
        public void clearPaint()
        {
            g2d.setColor( Color.white );
            g2d.fillRect(0, 0, getWidth(), getHeight());
            repaint();
            g2d.setColor( Color.black );
        }
  
        public void increaseBrushSize()
        {
            brushSize = brushSize + 2;
        }
  
        public void decreaseBrushSize()
        {
            brushSize = brushSize - 2;
  
            if (brushSize <= 0)
                brushSize = 1;
        }
  
//        public void paintComponent(Graphics g)
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
  
            if (image == null)
            {
                image = createImage(getWidth(), getHeight());
                g2d = (Graphics2D)image.getGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                     RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.white);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.setColor(Color.black);
            }
            g.drawImage(image, 0, 0, this);
            if(dragging)
            {
                g.setColor(Color.pink);
                g.drawLine(lastPoint.x, lastPoint.y, dragPoint.x, dragPoint.y);
            }
        }
    }
}