package com.bhushan;

/*Online Java Paper Test*/  

import java.awt.*;  
import java.awt.event.*;

import javax.swing.*;  
  
class MainPage extends JFrame implements ActionListener  
{  
   
	private static final long serialVersionUID = 1L;
	JLabel labelQuestions,lblNewBackground,lbltime,lblseconds_left;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,bk;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0,seconds=60;  
    int m[]=new int[10];  
    
  //Countdown Timer
    Timer timer=new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
				seconds--;
				lblseconds_left.setText(String.valueOf(seconds));
				if(seconds<=0)
				{
					 b1.setEnabled(false);  
					 bk.setEnabled(false);
		             b2.setText("Result");  
		             timer.stop();
				}
			}
		
	});
 
    MainPage(String s)  
    {  
        super(s); 
    	timer.start();
        setTitle("Online Examination");
        getContentPane().setBackground(new Color(102, 255, 153));
        labelQuestions=new JLabel();  
        labelQuestions.setBackground(new Color(0, 0, 0));
        labelQuestions.setForeground(new Color(0, 0, 0));
        getContentPane().add(labelQuestions);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            getContentPane().add(jb[i]);  
            bg.add(jb[i]);  
            jb[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));

        }  
        b1=new JButton("Next"); 
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        getContentPane().add(b1);getContentPane().add(b2);
        set();  
        labelQuestions.setBounds(129,22,850,50); 
        labelQuestions.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(102,267,145,44);  
        b2.setBounds(267,265,237,44);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        getContentPane().setLayout(null);
        
        lblseconds_left = new JLabel("");
        lblseconds_left.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        lblseconds_left.setBackground(new Color(255, 0, 0));
        lblseconds_left.setForeground(Color.WHITE);
        lblseconds_left.setBounds(911, 0, 113, 86);
        lblseconds_left.setBorder(BorderFactory.createBevelBorder(1));
        lblseconds_left.setBorder(BorderFactory.createBevelBorder(1));
        lblseconds_left.setOpaque(true);
		lblseconds_left.setHorizontalAlignment(JTextField.CENTER);
		lblseconds_left.setText(String.valueOf(seconds));
        getContentPane().add(lblseconds_left);
        
        lbltime = new JLabel("Time Left");
        lbltime.setForeground(new Color(0, 0, 0));
        lbltime.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        lbltime.setBounds(911, 83, 113, 32);
        getContentPane().add(lbltime);
        setLocation(200,100);  
        setVisible(true);  
        setSize(1050,600);  
    
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set(); 
            if(current==9 || seconds<=0)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
       
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            getContentPane().add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9 || seconds<=0) 
            {
            	 b2.setText("Result");  
                 setVisible(false);  
                 setVisible(true); 
            }
                
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"Correct Ans="+count);  
            //System.exit(0);  
            LoginForm frame = new LoginForm();
			frame.setVisible(true);
			dispose();
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            labelQuestions.setText("Que1: Which one among these is not a primitive datatype?");  
            jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");   
        }  
        if(current==1)  
        {  
            labelQuestions.setText("Que2: Which class is available to all the class automatically?");  
            jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");  
        }  
        if(current==2)  
        {  
            labelQuestions.setText("Que3: Which package is directly available to our class without importing it?");  
            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");  
        }  
        if(current==3)  
        {  
            labelQuestions.setText("Que4: String class is defined in which package?");  
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");  
        }  
        if(current==4)  
        {  
            labelQuestions.setText("Que5: Which is base class of all classes?");  
            jb[0].setText("itrator");jb[1].setText("object");jb[2].setText("lang");jb[3].setText("java");  
        }  
        if(current==5)  
        {  
            labelQuestions.setText("Que6: Which one among these is not a keyword?");  
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            labelQuestions.setText("Que7: Which one among these is not a class? ");  
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");  
                        jb[3].setText("Button");  
        }  
        if(current==7)  
        {  
            labelQuestions.setText("Que8: which one among these is not a function of Object class?");  
            jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");  
                        jb[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            labelQuestions.setText("Que9: which function is not present in Applet class?");  
            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");  
        }  
        if(current==9)  
        {  
            labelQuestions.setText("Que10: Which one among these is not a valid component?");  
            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");  
                        jb[3].setText("JTextArea");  
        }  
        labelQuestions.setBounds(84,11,850,50);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);
       
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
       
    }  
}