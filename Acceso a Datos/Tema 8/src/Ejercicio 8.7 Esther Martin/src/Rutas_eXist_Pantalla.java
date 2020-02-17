import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQConstants;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import javax.xml.xquery.XQStaticContext;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList; 
import net.xqj.exist.ExistXQDataSource;

public class Rutas_eXist_Pantalla extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	XQDataSource s;
	XQConnection conn;
	XQResultSequence rs;

	int num_actual=1;
	int totalRutes;
	 
	JLabel etiqueta = new JLabel("");
	JLabel etNom = new JLabel("Ruta:");
	JTextField qNom = new JTextField(15);
	JLabel etDesn = new JLabel("Desnivell:");
	JTextField qDesn = new JTextField(5);
	JLabel etDesnAcum = new JLabel("Desnivell acumulat:");
	JTextField qDesnAcum = new JTextField(5);
	JLabel etPunts = new JLabel("Punts:");
	JTable punts = new JTable(1,3);
	JButton primer = new JButton("<<");
	JButton anterior = new JButton("<");
	JButton seguent = new JButton(">");
	JButton ultim = new JButton(">>");
	JButton tancar = new JButton("Tancar");
	
	public void iniciar() throws XQException
	{
		getContentPane().setLayout(new GridLayout(0,1));
		JPanel p_prin = new JPanel();
		p_prin.setLayout(new BoxLayout(p_prin, BoxLayout.Y_AXIS));
		JPanel panell1 = new JPanel(new GridLayout(0,2));
		panell1.add(etNom);
		qNom.setEditable(false);
		panell1.add(qNom);
		panell1.add(etDesn);
		qDesn.setEditable(false);
		panell1.add(qDesn);
		panell1.add(etDesnAcum);
		qDesnAcum.setEditable(false);
		panell1.add(qDesnAcum);
		panell1.add(etPunts);
		 
		JPanel panell2 = new JPanel(new GridLayout(0,1));
		punts.setEnabled(false);
		JScrollPane scroll = new JScrollPane(punts);
		panell2.add(scroll, null);
		 
		JPanel panell5 = new JPanel(new FlowLayout());
		panell5.add(primer);
		panell5.add(anterior);
		panell5.add(seguent);
		panell5.add(ultim);
		panell5.add(tancar);
		 
		getContentPane().add(p_prin);
		p_prin.add(panell1);
		p_prin.add(panell2);
		p_prin.add(panell5);
		 
		setVisible(true);
		pack();
		primer.addActionListener(this);
		anterior.addActionListener(this);
		seguent.addActionListener(this);
		ultim.addActionListener(this);
		tancar.addActionListener(this);
		 
		inicialitzar();
		VisRuta();
	}
	
	private void plenar_taula(Element e_punts)
	{
		NodeList ll_punts = e_punts.getElementsByTagName("punt");
		 
		Object[][] ll= new Object[ll_punts.getLength()][3];
		for (int i=0;i<ll_punts.getLength();i++)
		{
			Element p=(Element) ll_punts.item(i);
			ll[i][0]=p.getElementsByTagName("nom").item(0).getFirstChild().getNodeValue();
			ll[i][1]=p.getElementsByTagName("latitud").item(0).getFirstChild().getNodeValue();
			ll[i][2]=p.getElementsByTagName("longitud").item(0).getFirstChild().getNodeValue();
		}
		String[] caps = {"Nom punt","Latitud","Longitud"};
		punts.setModel(new javax.swing.table.DefaultTableModel(ll,caps));
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if (e.getSource() == primer) 
				this.num_actual = 1;
					 
			else if (e.getSource() == anterior) 
				this.num_actual = Math.max(this.num_actual-1,1);
						 
			else if (e.getSource() == seguent ) 
				this.num_actual = Math.min(this.num_actual+1, totalRutes);
						 
			else if (e.getSource() == ultim) 
				this.num_actual = totalRutes;
				
		VisRuta();
			
		}
		catch (XQException e1)
		{
			e1.printStackTrace();
		}
		 
		if (e.getSource() == tancar)
		{
			try
			{
				conn.close();
			}
			catch (XQException e1)
			{
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	private void inicialitzar() throws XQException
	{
		s = new ExistXQDataSource();
		s.setProperty("serverName", "localhost");
		s.setProperty("port", "8080");
		s.setProperty("user", "admin");
		s.setProperty("password", "ATWA");

		conn = s.getConnection();

		String sent = "for $rutes in //ruta/nom return $rutes";
		
		XQStaticContext cntxt = conn.getStaticContext();
		cntxt.setScrollability( XQConstants.SCROLLTYPE_SCROLLABLE);
		conn.setStaticContext(cntxt);

		XQPreparedExpression cons = conn.prepareExpression(sent);
		rs = cons.executeQuery();
		
		totalRutes=rs.count();
		
		VisRuta();
	}
	
	private void VisRuta() throws XQException
	{
		String sent = "for $ruta in //ruta[" + num_actual + "] return $ruta";

		XQPreparedExpression cons = conn.prepareExpression(sent);
		rs = cons.executeQuery();

		while (rs.next())
		{
			Element el = (Element) rs.getObject();
			qNom.setText(el.getElementsByTagName("nom").item(0).getFirstChild().getNodeValue());
			qDesn.setText(el.getElementsByTagName("desnivell").item(0).getFirstChild().getNodeValue());
			qDesnAcum.setText(el.getElementsByTagName("desnivellAcumulat").item(0).getFirstChild().getNodeValue());
			plenar_taula(el);
		}		
	}
}
