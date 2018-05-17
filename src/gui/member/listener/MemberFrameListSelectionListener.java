package gui.member.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.member.MemberFrame;
import system.DAO.imp.CafeDAOImp;

public class MemberFrameListSelectionListener implements ListSelectionListener {
	MemberFrame memberFrame;
	CafeDAOImp cafeDAOImp; 
	public MemberFrameListSelectionListener(MemberFrame memberFrame) {
		this.memberFrame = memberFrame;
		cafeDAOImp = CafeDAOImp.getInstance();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == memberFrame.memberList)
        {
            String str = (String)memberFrame.memberList.getSelectedValue();
            memberFrame.resultField.setText(str);
        }
	}
}
