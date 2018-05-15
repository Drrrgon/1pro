package gui.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;

import gui.MemberOrderFrame;
import gui.OrderFrame;

public class MemberOrderRadioButtonListener implements ItemListener {
	MemberOrderFrame memberOrderFrame;
	boolean bonus;
	
	public MemberOrderRadioButtonListener(MemberOrderFrame memberOrderFrame){
		this.memberOrderFrame = memberOrderFrame;
	}

	/**
	 * 라디오 버튼의 상태를 변경하는 메서드입니다. 
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		 AbstractButton sel = (AbstractButton)e.getItemSelectable();
		 if(e.getStateChange() == ItemEvent.SELECTED)
			 
         {

                if ( sel.getText().equals("사용") )

                {

                     System.out.println( "사용" );
                     bonus=true;

                }

                else if ( sel.getText().equals( "적립" ) )

                {

                      System.out.println( "적립" );
                      bonus=false;

                }

         }
	
		
	}
	/**
	 * @return 멤버의 상태를 반환합니다.
	 * TRUE이면 회원 FLASE 이면 비회원
	 */
	public boolean getMemberStatement() {
		return bonus;
	}
}
