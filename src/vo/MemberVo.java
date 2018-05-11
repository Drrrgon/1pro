package vo;

public class MemberVo{
    private int memberNo;
    private int telNo;
    private String mName;
    private int mBonus;
    
    public MemberVo(){}

	public MemberVo(int memberNo, int telNo, String mName, int mBonus) {
		super();
		this.memberNo = memberNo;
		this.telNo = telNo;
		this.mName = mName;
		this.mBonus = mBonus;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getTelNo() {
		return telNo;
	}

	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getmBonus() {
		return mBonus;
	}

	public void setmBonus(int mBonus) {
		this.mBonus = mBonus;
	}

	@Override
	public String toString() {
		return "MemberVo [memberNo=" + memberNo + ", telNo=" + telNo + ", mName=" + mName + ", mBonus=" + mBonus + "]";
	}
    
    
}