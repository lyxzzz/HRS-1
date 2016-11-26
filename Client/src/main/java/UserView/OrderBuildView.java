package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uiService.OrderBuildUiService;

public class OrderBuildView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label13,label14,label15,label16,label17,label1_1,label5_1;
	private JButton button1,button2;
	private JComboBox<Integer> comboBox1,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6,comboBox11,comboBox12;
	private JComboBox<String> comboBox10,comboBox13;
	private JPanel pane,panel1,panel3;
	private OrderBuildUiService controller;
	private int year,month,day;

	public OrderBuildView(OrderBuildUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		this.validate();
		pane=new JPanel();
		pane=this;
	}

	private void initButton() {
		JPanel panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		panel.add(button1);
		this.add(panel);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toHotelBrowseView();
			}
		});
		Calendar ca = Calendar.getInstance();
		year = ca.get(Calendar.YEAR);//获取年份
		month=ca.get(Calendar.MONTH)+1;//获取月份
		day=ca.get(Calendar.DATE);//获取日
		
		Calendar cal=Calendar.getInstance();
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));	
		label1=new JLabel("                          开  始  时  间 ");
		label1_1=new JLabel("（默认为当天中午12点整）");
		comboBox1= new JComboBox<Integer>();
		if((month==12&&day==30)||(month==12&&day==31)){
		    comboBox1.addItem(year);
		    comboBox1.addItem(year+1);
		}
		else{
			comboBox1.addItem(year);
		}

		
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected=(int)comboBox1.getSelectedItem();
				comboBox2.removeAllItems();
				if(selected==year){
				if(((day==30||day==31)&&month!=12)||(day==29&&(month==2||month==4||month==6||month==9||month==11))||(month==2&&(day==28||day==27))){
					comboBox2.addItem(month);
					comboBox2.addItem(month+1);
				}
				if((day==30||day==31)&&month==12){
					comboBox2.addItem(month);
					comboBox2.addItem(1);
				}
				else{
					comboBox2.addItem(month);
				}
				}
				else if(selected==year+1){
					comboBox2.addItem(1);
				}
				label9.setText("订单最晚执行时间:"+comboBox1.getSelectedItem()+"年"+comboBox2.getSelectedItem()+"月"+comboBox3.getSelectedItem()+"日当晚凌晨12点整");
				}
			}
		});
		label2=new JLabel("年");
		comboBox2= new JComboBox<Integer>();
		int	selected=(int)comboBox1.getSelectedItem();
		if(selected==year){
		if(((day==30||day==31)&&month!=12)||(day==29&&(month==2||month==4||month==6||month==9||month==11))||(month==2&&(day==28||day==27))){
			comboBox2.addItem(month);
			comboBox2.addItem(month+1);
		}
		if((day==30||day==31)&&month==12){
			comboBox2.addItem(month);
			comboBox2.addItem(1);
		}
		else{
			comboBox2.addItem(month);
		}
		}
		else if(selected==year+1){
			comboBox2.addItem(1);
		}
		
	//确定日
		
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){	
					comboBox3.removeAllItems();
					int	selected1=(int)comboBox1.getSelectedItem();
					int selected2=(int)comboBox2.getSelectedItem();
					if(year==selected1&&month==selected2){
						if(day==31){
							comboBox3.addItem(31);
						}
						else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
							comboBox3.addItem(30);
							comboBox3.addItem(31);
						}
						else if(day==30&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(30);
						}
						else if(day==29&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(29);
							comboBox3.addItem(30);
						}
						else if(day==29&&month==2){
							comboBox3.addItem(29);
						}
						else if(day==28&&month==2){
							comboBox3.addItem(28);
						}
						else{
							comboBox3.addItem(day);
							comboBox3.addItem(day+1);
							comboBox3.addItem(day+2);
						}
					}
					else if(year==selected1&&month!=selected2){
						if(day==31){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
							comboBox3.addItem(1);
						}
						else if(day==30&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(day==29&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(1);
						}
						else if(day==29&&month==2){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(day==28&&month==2){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
					}
					else if(year!=selected1){
						if(day==30){
							comboBox3.addItem(1);
						}
						else if(day==31){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
					}
					label9.setText("订单最晚执行时间:"+comboBox1.getSelectedItem()+"年"+comboBox2.getSelectedItem()+"月"+comboBox3.getSelectedItem()+"日当晚凌晨12点整");
					}
				}
		});
		label3=new JLabel("月");
		comboBox3= new JComboBox<Integer>();
	
		
		int	selected1=(int)comboBox1.getSelectedItem();
		int selected2=(int)comboBox2.getSelectedItem();
		if(year==selected1&&month==selected2){
			if(day==31){
				comboBox3.addItem(31);
			}
			else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
				comboBox3.addItem(30);
				comboBox3.addItem(31);
			}
			else if(day==30&&(month==4||month==6||month==9||month==11)){
				comboBox3.addItem(30);
			}
			else if(day==29&&(month==4||month==6||month==9||month==11)){
				comboBox3.addItem(29);
				comboBox3.addItem(30);
			}
			else if(day==29&&month==2){
				comboBox3.addItem(29);
			}
			else if(day==28&&month==2){
				comboBox3.addItem(28);
			}
			else{
				comboBox3.addItem(day);
				comboBox3.addItem(day+1);
				comboBox3.addItem(day+2);
			}
		}
		else if(year==selected1&&month!=selected2){
			if(day==31){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
			else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
				comboBox3.addItem(1);
			}
			else if(day==30&&(month==4||month==6||month==9||month==11)){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
			else if(day==29&&(month==4||month==6||month==9||month==11)){
				comboBox3.addItem(1);
			}
			else if(day==29&&month==2){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
			else if(day==28&&month==2){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
		}
		else if(year!=selected1){
			if(day==30){
				comboBox3.addItem(1);
			}
			else if(day==31){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
		}

		comboBox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){	
		label9.setText("订单最晚执行时间:"+comboBox1.getSelectedItem()+"年"+comboBox2.getSelectedItem()+"月"+comboBox3.getSelectedItem()+"日当晚凌晨12点整");
				}
			}
		});
		label4=new JLabel("日");
		panel1.add(label1);
		panel1.add(comboBox1);
		panel1.add(label2);
		panel1.add(comboBox2);
		panel1.add(label3);
		panel1.add(comboBox3);
		panel1.add(label4);
		panel1.add(label1_1);
		this.add(panel1);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		label5=new JLabel("                          退  房  时  间 ");
		label5_1=new JLabel("（默认为当天中午12点整）");
		comboBox4= new JComboBox<Integer>();
		for(int i=2016;i<2101;i++){
		    comboBox4.addItem(i);
			}
		comboBox4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected1=(int)comboBox4.getSelectedItem();
				int selected2=(int)comboBox5.getSelectedItem();
				cal.set(Calendar.YEAR,selected1);
				cal.set(Calendar.MONTH,selected2-1);
				int maxDate=cal.getActualMaximum(Calendar.DATE);
				comboBox6.removeAllItems();
				for(int k=1;k<maxDate+1;k++){
					comboBox6.addItem(k);
				}
				}
			}
		});
		label6=new JLabel("年");
		comboBox5= new JComboBox<Integer>();
		for(int i=1;i<13;i++){
		    comboBox5.addItem(i);
			}
		comboBox5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected1=(int)comboBox4.getSelectedItem();
				int selected2=(int)comboBox5.getSelectedItem();
				cal.set(Calendar.YEAR,selected1);
				cal.set(Calendar.MONTH,selected2-1);
				int maxDate=cal.getActualMaximum(Calendar.DATE);
				comboBox6.removeAllItems();
				for(int k=1;k<maxDate+1;k++){
					comboBox6.addItem(k);
				}
				}
			}
		});
		label7=new JLabel("月");
		comboBox6= new JComboBox<Integer>();		
		for(int i=1;i<32;i++){
		    comboBox6.addItem(i);
			}
		label8=new JLabel("日");
		panel2.add(label5);
		panel2.add(comboBox4);
		panel2.add(label6);
		panel2.add(comboBox5);
		panel2.add(label7);
		panel2.add(comboBox6);
		panel2.add(label8);
		panel2.add(label5_1);
		this.add(panel2);
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		label9=new JLabel("订单最晚执行时间:"+year+"年"+month+"月"+day+"日当晚凌晨12点整");
		panel3.add(label9);
		this.add(panel3);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		label13=new JLabel("房  间  类  型 ");
		JLabel label13_1=new JLabel(" ");
		comboBox10= new JComboBox<String>();
		comboBox10.setPreferredSize(new Dimension(170,22));
		panel4.add(label13);
		panel4.add(comboBox10);
		panel4.add(label13_1);
		this.add(panel4);
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		label14=new JLabel("房  间  数  量 ");
		JLabel label14_1=new JLabel(" ");
		comboBox11= new JComboBox<Integer>();
		comboBox11.setPreferredSize(new Dimension(170,22));
		for(int i=1;i<101;i++){
		    comboBox11.addItem(i);
			}
		panel5.add(label14);
		panel5.add(comboBox11);
		panel5.add(label14_1);
		this.add(panel5);
		JPanel panel6 = new JPanel();
		panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
		label15=new JLabel("预计入住人数 ");
		comboBox12= new JComboBox<Integer>();
		for(int i=1;i<101;i++){
		    comboBox12.addItem(i);
			}
		comboBox12.setPreferredSize(new Dimension(170,22));
		panel6.add(label15);
		panel6.add(comboBox12);
		this.add(panel6);
		JPanel panel7 = new JPanel();
		panel7.setLayout(new FlowLayout(FlowLayout.CENTER));
		label16=new JLabel("有  无  儿  童 ");
		JLabel label16_1=new JLabel(" ");
		comboBox13= new JComboBox<String>();
		comboBox13.addItem("无");
		comboBox13.addItem("有");
		comboBox13.setPreferredSize(new Dimension(170,22));
		panel7.add(label16);
		panel7.add(comboBox13);
		panel7.add(label16_1);
		this.add(panel7);
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		label17=new JLabel("已为你选择了最低的优惠策略，打折后总计    元");
		panel8.add(label17);
		this.add(panel8);
		JPanel panel9 = new JPanel();
		panel9.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("提交订单");
		panel9.add(button2);
		this.add(panel9);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Calendar cal=Calendar.getInstance();
				int nowyear=cal.get(Calendar.YEAR);
				int nowmonth=cal.get(Calendar.MONTH);
				int nowday=cal.get(Calendar.DATE);
				
				Calendar cal1=Calendar.getInstance();
				Calendar cal2=Calendar.getInstance();
				cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
				cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());
			
				Date date1=cal1.getTime();
				Date date2=cal2.getTime();
				
			    if(nowday!=day){
			    	int option = JOptionPane.showConfirmDialog(pane,"开始时间过期，刷新界面？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
				     switch (option) {
				     case JOptionPane.YES_OPTION: 
				     comboBox1.removeAllItems();
				     comboBox2.removeAllItems();
				     comboBox3.removeAllItems();
				     label9.setText("订单最晚执行时间:"+nowyear+"年"+nowmonth+"月"+nowday+"日当晚凌晨12点整");
					if((nowmonth==12&&nowday==30)||(nowmonth==12&&nowday==31)){
					    comboBox1.addItem(nowyear);
					    comboBox1.addItem(nowyear+1);
					}
					else{
						comboBox1.addItem(nowyear);
					}

					
					comboBox1.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange() == ItemEvent.SELECTED){		
							int	selected=(int)comboBox1.getSelectedItem();
							comboBox2.removeAllItems();
							if(selected==nowyear){
							if(((nowday==30||nowday==31)&&nowmonth!=12)||(nowday==29&&(nowmonth==2||nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11))||(nowmonth==2&&(nowday==28||nowday==27))){
								comboBox2.addItem(nowmonth);
								comboBox2.addItem(nowmonth+1);
							}
							if((nowday==30||nowday==31)&&nowmonth==12){
								comboBox2.addItem(nowmonth);
								comboBox2.addItem(1);
							}
							else{
								comboBox2.addItem(nowmonth);
							}
							}
							else if(selected==nowyear+1){
								comboBox2.addItem(1);
							}
							label9.setText("订单最晚执行时间:"+comboBox1.getSelectedItem()+"年"+comboBox2.getSelectedItem()+"月"+comboBox3.getSelectedItem()+"日当晚凌晨12点整");
							}
						}
					});
					int	selected=(int)comboBox1.getSelectedItem();
					if(selected==nowyear){
					if(((nowday==30||nowday==31)&&nowmonth!=12)||(nowday==29&&(nowmonth==2||nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11))||(nowmonth==2&&(nowday==28||nowday==27))){
						comboBox2.addItem(nowmonth);
						comboBox2.addItem(nowmonth+1);
					}
					if((nowday==30||nowday==31)&&nowmonth==12){
						comboBox2.addItem(nowmonth);
						comboBox2.addItem(1);
					}
					else{
						comboBox2.addItem(nowmonth);
					}
					}
					else if(selected==nowyear+1){
						comboBox2.addItem(1);
					}
					
					comboBox2.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange() == ItemEvent.SELECTED){	
								comboBox3.removeAllItems();
								int	selected1=(int)comboBox1.getSelectedItem();
								int selected2=(int)comboBox2.getSelectedItem();
								if(nowyear==selected1&&nowmonth==selected2){
									if(nowday==31){
										comboBox3.addItem(31);
									}
									else if(nowday==30&&(nowmonth==1||nowmonth==3||nowmonth==5||nowmonth==7||nowmonth==8||nowmonth==10||nowmonth==12)){
										comboBox3.addItem(30);
										comboBox3.addItem(31);
									}
									else if(nowday==30&&(nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11)){
										comboBox3.addItem(30);
									}
									else if(nowday==29&&(nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11)){
										comboBox3.addItem(29);
										comboBox3.addItem(30);
									}
									else if(nowday==29&&nowmonth==2){
										comboBox3.addItem(29);
									}
									else if(nowday==28&&nowmonth==2){
										comboBox3.addItem(28);
									}
									else{
										comboBox3.addItem(nowday);
										comboBox3.addItem(nowday+1);
										comboBox3.addItem(nowday+2);
									}
								}
								else if(nowyear==selected1&&nowmonth!=selected2){
									if(nowday==31){
										comboBox3.addItem(1);
										comboBox3.addItem(2);
									}
									else if(nowday==30&&(nowmonth==1||nowmonth==3||nowmonth==5||nowmonth==7||nowmonth==8||nowmonth==10||nowmonth==12)){
										comboBox3.addItem(1);
									}
									else if(nowday==30&&(nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11)){
										comboBox3.addItem(1);
										comboBox3.addItem(2);
									}
									else if(nowday==29&&(nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11)){
										comboBox3.addItem(1);
									}
									else if(nowday==29&&nowmonth==2){
										comboBox3.addItem(1);
										comboBox3.addItem(2);
									}
									else if(nowday==28&&nowmonth==2){
										comboBox3.addItem(1);
										comboBox3.addItem(2);
									}
								}
								else if(nowyear!=selected1){
									if(nowday==30){
										comboBox3.addItem(1);
									}
									else if(nowday==31){
										comboBox3.addItem(1);
										comboBox3.addItem(2);
									}
								}
								label9.setText("订单最晚执行时间:"+comboBox1.getSelectedItem()+"年"+comboBox2.getSelectedItem()+"月"+comboBox3.getSelectedItem()+"日当晚凌晨12点整");
								}
							}
					});
								
					int	selected1=(int)comboBox1.getSelectedItem();
					int selected2=(int)comboBox2.getSelectedItem();
					if(nowyear==selected1&&nowmonth==selected2){
						if(nowday==31){
							comboBox3.addItem(31);
						}
						else if(nowday==30&&(nowmonth==1||nowmonth==3||nowmonth==5||nowmonth==7||nowmonth==8||nowmonth==10||nowmonth==12)){
							comboBox3.addItem(30);
							comboBox3.addItem(31);
						}
						else if(nowday==30&&(nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11)){
							comboBox3.addItem(30);
						}
						else if(nowday==29&&(nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11)){
							comboBox3.addItem(29);
							comboBox3.addItem(30);
						}
						else if(nowday==29&&nowmonth==2){
							comboBox3.addItem(29);
						}
						else if(nowday==28&&nowmonth==2){
							comboBox3.addItem(28);
						}
						else{
							comboBox3.addItem(nowday);
							comboBox3.addItem(nowday+1);
							comboBox3.addItem(nowday+2);
						}
					}
					else if(nowyear==selected1&&nowmonth!=selected2){
						if(nowday==31){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(nowday==30&&(nowmonth==1||nowmonth==3||nowmonth==5||nowmonth==7||nowmonth==8||nowmonth==10||nowmonth==12)){
							comboBox3.addItem(1);
						}
						else if(nowday==30&&(nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11)){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(nowday==29&&(nowmonth==4||nowmonth==6||nowmonth==9||nowmonth==11)){
							comboBox3.addItem(1);
						}
						else if(nowday==29&&nowmonth==2){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(nowday==28&&nowmonth==2){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
					}
					else if(nowyear!=selected1){
						if(nowday==30){
							comboBox3.addItem(1);
						}
						else if(nowday==31){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
					}
					comboBox3.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange() == ItemEvent.SELECTED){	
					label9.setText("订单最晚执行时间:"+comboBox1.getSelectedItem()+"年"+comboBox2.getSelectedItem()+"月"+comboBox3.getSelectedItem()+"日当晚凌晨12点整");
							}
						}
					});
				     
				     case JOptionPane.NO_OPTION:
				     }
			    }			    
				else if(date1.getTime()-date2.getTime()>=0){
					JOptionPane.showMessageDialog(pane, "            时间冲突！","", JOptionPane.ERROR_MESSAGE);
				}
				else{
					int option = JOptionPane.showConfirmDialog(pane,"            确认提交？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
					     switch (option) {
					     case JOptionPane.YES_OPTION: 
					     controller.toHotelBrowseView();
					     case JOptionPane.NO_OPTION:
					     }
			}
			}
		});
	}
}