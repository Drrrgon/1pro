package gui.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;

import gui.OrderFrame;

public class RadioButtonListener implements ItemListener {
	OrderFrame order1;
	boolean member;
	
	public RadioButtonListener(OrderFrame order1){
		this.order1 = order1;
	}

	/**
	 * 라디오 버튼의 상태를 변경하는 메서드입니다. 
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		 AbstractButton sel = (AbstractButton)e.getItemSelectable();
		 if(e.getStateChange() == ItemEvent.SELECTED)
			 
         {

                if ( sel.getText().equals("회원") )

                {

                     System.out.println( "회원" );
                     member=true;

                }

                else if ( sel.getText().equals( "비회원" ) )

                {

                      System.out.println( "비회원" );
                      member=false;

                }

         }
	
		
	}
	/**
	 * @return 멤버의 상태를 반환합니다.
	 * TRUE이면 회원 FLASE 이면 비회원
	 */
	public boolean getMemberStatement() {
		return member;
	}
}
