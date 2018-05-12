package system.DAO;

import java.util.List;

import vo.MenuVo;

public interface CafeDAO {
	public List getAllMenu();
	public void deleteMenu(MenuVo menu);
	public void insertMenu(MenuVo menu);
}
