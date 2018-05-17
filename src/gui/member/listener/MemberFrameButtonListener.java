package gui.member.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.member.MemberFrame;
import system.DAO.imp.CafeDAOImp;
import vo.MemberVo;
import vo.MenuVo;

public class MemberFrameButtonListener implements ActionListener{
	MemberFrame memberFrame;
	CafeDAOImp cafeDAOImp; 
	
	
	public MemberFrameButtonListener(MemberFrame memberFrame){
		this.memberFrame = memberFrame;
		cafeDAOImp = CafeDAOImp.getInstance();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton resource = (JButton) e.getSource();
		if(resource == memberFrame.deleteMember){ //delete
			MemberVo member= new MemberVo();
			List<MemberVo> tempList2 = (List<MemberVo>) memberFrame.getMemberVoList();
			member = (tempList2.get(memberFrame.memberList.getSelectedIndex()));
			if(cafeDAOImp.deleteMemberByTelNo(member.getTelNo()) ==0) {
				memberFrame.resultField.setText("회원 삭제 실패");
			}else {
				memberFrame.resultField.setText("회원 삭제 성공");
				tempList2.remove(member);
				memberFrame.modelMenuList.removeElementAt(memberFrame.memberList.getSelectedIndex());
				memberFrame.setCursor(0);
			}			
		}//delete
		if(resource == memberFrame.serchMember) {//serchmember
			
			List<MemberVo> list = null;
			try {
				list = cafeDAOImp.serchMember(Integer.parseInt(memberFrame.telNumber.getText()));				
			}catch(NumberFormatException v){
				JOptionPane.showConfirmDialog(resource, "전화번호는 숫자만 입력해 주세요", "숫자 오류", JOptionPane.PLAIN_MESSAGE);				
				memberFrame.telNumber.setText("");
			}
			memberFrame.modelMenuList.removeAllElements();
			
			for(MemberVo temp : list) {
				memberFrame.modelMenuList.addElement(temp.toString());
			}
			
		}//serhMember
		if(resource == memberFrame.addMember) { //addmember
			boolean number = true;			
			List<MemberVo> tempList = (List<MemberVo>) memberFrame.getMemberVoList();
			MemberVo member = new MemberVo();
			if(memberFrame.telNumber.getText().length() == 0 || memberFrame.name.getText().length() == 0  ) {
				JOptionPane.showConfirmDialog(resource, "이름과 전화 번호를 정확히 입력해 주세요.", "공백 오류", JOptionPane.PLAIN_MESSAGE);
			}
			try {
				Integer.parseInt(memberFrame.telNumber.getText());
				number = true;
			}catch(NumberFormatException v){
				JOptionPane.showConfirmDialog(resource, "전화번호는 숫자만 입력해 주세요", "숫자 오류", JOptionPane.PLAIN_MESSAGE);
				number = false;
				memberFrame.telNumber.setText("");
			}
			if(number) {
				member.setmName(memberFrame.name.getText());
				member.setTelNo(memberFrame.telNumber.getText());
				int re = cafeDAOImp.insertMember(member);
				System.out.println(re);
				JOptionPane.showConfirmDialog(resource, "회원등록되었습니다.", "회원등록", JOptionPane.PLAIN_MESSAGE);
				memberFrame.telNumber.setText("");
				memberFrame.name.setText("");
				memberFrame.modelMenuList.addElement(member.toString());
				tempList.add(member);
			}
		}//addmember
	}
}


