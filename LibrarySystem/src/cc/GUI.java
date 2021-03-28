package cc;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import aa.ConnectDB;
import bb.Book;
import bb.Employee;
import bb.Record;
import bb.User;


public class GUI extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	DefaultListModel<Object> model = null;
	JList<Object> jlist = null;
	
	public GUI() {
		// TODO Auto-generated constructor stub
		this.setTitle("library system");
		Container con = getContentPane();
		this.setLayout(null);
		
		//
		this.model = new DefaultListModel<Object>();
//		Iterator<Object> it = ConnectDB.reading("users").iterator();
//		while(it.hasNext()){
//			Object ob = it.next();
//			model.addElement(ob);
//		}
		
		this.jlist = new JList<Object>(model);
		this.jlist.setFont(new Font("Helvetica",Font.BOLD+Font.ITALIC,18));
		JScrollPane jsp = new JScrollPane(jlist);
		con.add(jsp);
		jsp.setBounds(100, 200, 400, 300);
		
		//
		JButton jb_user = new JButton("users");
		con.add(jb_user);
		jb_user.setBounds(100, 90, 100, 30);
		
		JButton jb_emp = new JButton("employees");
		con.add(jb_emp);
		jb_emp.setBounds(200, 90, 100, 30);
		
		JButton jb_book = new JButton("books");
		con.add(jb_book);
		jb_book.setBounds(300, 90, 100, 30);
		
		JButton jb_record = new JButton("records");
		con.add(jb_record);
		jb_record.setBounds(400, 90, 100, 30);
		
		//
		jb_user.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("---------------------->");
				Iterator<Object> it = ConnectDB.reading("users").iterator();
				model.clear();
				while(it.hasNext()){
					User ob = (User) it.next();
					System.out.println(ob);
					model.addElement(ob);
				}
			}
		});
		
		//
		jb_emp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("---------------------->");
				Iterator<Object> it = ConnectDB.reading("employees").iterator();
				model.clear();
				while(it.hasNext()){
					Employee ob = (Employee) it.next();
					System.out.println(ob);
					model.addElement(ob);
				}
			}
		});
		
		//
		jb_book.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("---------------------->");
				Iterator<Object> it = ConnectDB.reading("books").iterator();
				model.clear();
				while(it.hasNext()){
					Book ob = (Book) it.next();
					System.out.println(ob);
					model.addElement(ob);
				}
			}
		});
		
		//
		jb_record.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("---------------------->");
				Iterator<Object> it = ConnectDB.reading("records").iterator();
				model.clear();
				while(it.hasNext()){
					Record ob = (Record) it.next();
					System.out.println(ob);
					model.addElement(ob);
				}
			}
		});
		
		jlist.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Object obj = jlist.getSelectedValue();
				System.out.println(obj);
			}
		});
		
        //
        JLabel jlb_first = new JLabel("first");
        con.add(jlb_first);
        jlb_first.setBounds(50, 30, 100, 20);
        final JTextArea first = new JTextArea("");
        con.add(first);
        first.setBounds(100, 30, 150, 20);
        
        JLabel jlb_second = new JLabel("second");
        con.add(jlb_second);
        jlb_second.setBounds(260, 30, 100, 20);
        final JTextArea second = new JTextArea("");
        con.add(second);
        second.setBounds(320, 30, 150, 20);
        
        JLabel jlb_third = new JLabel("third");
        con.add(jlb_third);
        jlb_third.setBounds(480, 30, 100, 20);
        final JTextArea third = new JTextArea("");
        con.add(third);
        third.setBounds(520, 30, 150, 20);
        
        JLabel jlb_table = new JLabel("which table");
        con.add(jlb_table);
        jlb_table.setBounds(230, 60, 100, 20);
        final JTextArea table = new JTextArea("");
        con.add(table);
        table.setBounds(320, 60, 150, 20);
        
      //add
        JButton bt_add = new JButton("add");
        con.add(bt_add);
        bt_add.setBounds(100, 600, 100, 20);
        bt_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ta = table.getText().trim();
				String f = first.getText();
				String s = second.getText();
				String t = third.getText();
				
				//
				table.setText("");
				first.setText("");
				second.setText("");
				third.setText("");
				
				if(ta.equals("users")){
					ConnectDB.writing(new User(f, s));
				}else if(ta.equals("employees")){
					ConnectDB.writing(new Employee(f, s));
				}else if(ta.equals("books")){
					ConnectDB.writing(new Book(f, s, t));
				}else if(ta.equals("records")){
					ConnectDB.writing(new Record(f, s, t));
				}else{
					table.setText("wrong table name");
				}
				jlist.setModel(jlist.getModel());
			}
		});
        
      //delete
        JButton bt_delete = new JButton("delete");
        con.add(bt_delete);
        bt_delete.setBounds(300, 600, 100, 20);
        bt_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ta = table.getText().trim();
				table.setText("");
				Object obj = jlist.getSelectedValue();
				if(ta.equals("users")){
					User u = (User)obj;
					ConnectDB.deleting(u);
				}else if(ta.equals("employees")){
					Employee e = (Employee)obj;
					ConnectDB.deleting(e);
				}else if(ta.equals("books")){
					Book b = (Book)obj;
					ConnectDB.deleting(b);
				}else if(ta.equals("records")){
					Record re = (Record)obj;
					ConnectDB.deleting(re);
				}else{
					table.setText("wrong table name");
				}
				
				DefaultListModel<Object> m = (DefaultListModel<Object>) jlist.getModel(); 
				m.removeElement(obj);
				jlist.setModel(m);
				System.out.println(obj);
			}
		});
        
        
		//
		this.setBounds(300, 300, 700, 700);;
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		new GUI();
	}
}
