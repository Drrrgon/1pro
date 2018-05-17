package gui.order.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.order.OrderDeleteFrame;
import system.DAO.imp.CafeDAOImp;
import vo.MemberVo;
import vo.OrdersVo;

public class OrderDeleteFrameListener implements ActionListener{
	OrderDeleteFrame orderDeleteFrame;
	CafeDAOImp cafeDAOImp; 
	
	
	public OrderDeleteFrameListener(OrderDeleteFrame orderDeleteFrame){
		this.orderDeleteFrame = orderDeleteFrame;
		cafeDAOImp = CafeDAOImp.getInstance();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "주문취소":
			JButton resource = (JButton) e.getSource();
			OrdersVo temp2= new OrdersVo();
			List<OrdersVo> tempList2 = (List<OrdersVo>) orderDeleteFrame.getOrdersVoList();
			
			temp2 = (tempList2.get(orderDeleteFrame.listOrder1.getSelectedIndex()));
			
			if(temp2.getUseBonus() == 0) {// 회원이 아닌 오더
				if(cafeDAOImp.deleteOrder(temp2) ==0) {
					orderDeleteFrame.txtOrder5.setText("메뉴 삭제 실패");
				}else {
					orderDeleteFrame.txtOrder5.setText("메뉴 삭제 성공");
					JOptionPane.showConfirmDialog(resource, "주문취소되었습니다.","주문취소", JOptionPane.PLAIN_MESSAGE);
					tempList2.remove(temp2);
					orderDeleteFrame.modelMenuList.removeElementAt(orderDeleteFrame.listOrder1.getSelectedIndex());
					orderDeleteFrame.setCursor(0);
				}
				
			}else {// 회원이 주문한 오더
				int originalTotal = cafeDAOImp.getMenuPrice(temp2.getMenuNo()) * temp2.getCount();
				int savedTotal = temp2.getTotal();				
				MemberVo member = new MemberVo();
				member.setTelNo(temp2.getTelNo());
				if(originalTotal > savedTotal) { // 원래 가격이 저장된 가격보다 크면 마일리지가 차감 고로 마일리지를 더해줘야 한다.					
					
					member.setmBonus(originalTotal-savedTotal);
//					bonus = originalTotal-savedTotal;
//					int savedBonus = cafeDAOImp.getBouns(member);
					cafeDAOImp.addBonus(member);
				}else{// 총 가격이 그대로라면 마일리지 적립 고로 마일리지에서 값을 빼 주어야 한다.					
//					bonus = (int)(savedTotal/10);
					member.setmBonus((int)(savedTotal/10));
					cafeDAOImp.minusBonus(member);
				}
//				temp2.getTelNo();				
//				temp2.getMenuNo();
//				cafeDAOImp.getMenuPrice(temp2.getMenuNo());
				if(cafeDAOImp.deleteOrder(temp2) ==0) {
					orderDeleteFrame.txtOrder5.setText("메뉴 삭제 실패");
				}else {
					orderDeleteFrame.txtOrder5.setText("메뉴 삭제 성공");
					JOptionPane.showConfirmDialog(resource, "주문취소되었습니다.","주문취소", JOptionPane.PLAIN_MESSAGE);
					tempList2.remove(temp2);
					orderDeleteFrame.modelMenuList.removeElementAt(orderDeleteFrame.listOrder1.getSelectedIndex());
					orderDeleteFrame.setCursor(0);
				}
			}
						
			break;
		default:
			break;
		}
	}

}
