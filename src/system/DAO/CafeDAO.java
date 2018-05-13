package system.DAO;

import java.util.List;

import vo.MenuVo;

public interface CafeDAO {
	public List getAllMenu();
	public int deleteMenu(MenuVo menu);
	public int insertMenu(MenuVo menu);
	
}
