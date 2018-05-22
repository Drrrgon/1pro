package vo;

public class MemberVo{
    private int memberNo;
    private String telNo;
    private String memberName;
    private int mBonus;
    
    public MemberVo(){}

	public MemberVo(int memberNo, String telNo, String memberName, int mBonus) {
		super();
		this.memberNo = memberNo;
		this.telNo = telNo;
		this.memberName = memberName;
		this.mBonus = mBonus;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getmName() {
		return memberName;
	}

	public void setmName(String memberName) {
		this.memberName = memberName;
	}

	public int getmBonus() {
		return mBonus;
	}

	public void setmBonus(int mBonus) {
		this.mBonus = mBonus;
	}

	@Override
	public String toString() {
		return " 이름 : " + memberName + "      전화번호 : " + telNo +  "      마일리지 : " + mBonus ;
	}
    
    
}