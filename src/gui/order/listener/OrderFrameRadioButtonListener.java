package gui.order.listener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractButton;

import gui.order.OrderFrame;

public class OrderFrameRadioButtonListener implements ItemListener {
	OrderFrame orderFrame;
	boolean member;
	
	public OrderFrameRadioButtonListener(OrderFrame orderFrame){
		this.orderFrame = orderFrame;
	}

	/**
	 * 라디오 버튼의 상태를 변경하는 메서드입니다. 
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		 AbstractButton sel = (AbstractButton)e.getItemSelectable();
		 if(e.getStateChange() == ItemEvent.SELECTED){
                if ( sel.getText().equals("회원") ){
                     System.out.println( "회원" );
                     member=true;
                }else if ( sel.getText().equals( "비회원" ) ){
                      System.out.println( "비회원" );
                      member=false;
                }//else if
         }//if		
	}
	/**
	 * @return 멤버의 상태를 반환합니다.
	 * TRUE이면 회원 FLASE 이면 비회원
	 */
	public boolean getMemberStatement() {
		return member;
	}
}
