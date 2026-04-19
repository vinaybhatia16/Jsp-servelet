import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TestTheme {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();

	}

	public static void testAdd() throws SQLException {
		ThemeBean bean = new ThemeBean();
		ThemeModel model = new ThemeModel();

		bean.setThemeId(6);
		bean.setThemeCode("223");
		bean.setThemeName("newdark");
		bean.setColor("black");
		bean.setStatus("notactive");
		model.Add(bean);

	}

	public static void testUpdate() throws SQLException {
		ThemeBean bean = new ThemeBean();
		ThemeModel model = new ThemeModel();

		bean.setThemeCode("32323");
		bean.setThemeName("blue");
		bean.setColor("red");
		bean.setStatus("active");
		bean.setThemeId(6);
		model.Update(bean);

	}

	public static void testDelete() throws SQLException {

		ThemeBean bean = new ThemeBean();
		ThemeModel model = new ThemeModel();
		bean.setThemeId(6);
		model.Delete(bean);
	}

	public static void testFindByPk() throws Exception {
		ThemeBean bean = new ThemeBean();
		ThemeModel model = new ThemeModel();
		bean = model.FindByPk(5);
		if (bean != null) {
			System.out.println(bean.getThemeId());
			System.out.println(bean.getThemeCode());
			System.out.println(bean.getThemeName());
			System.out.println(bean.getColor());
			System.err.println(bean.getStatus());
		} else {
			System.out.println("record not found");
		}
	}

	public static void testSearch() throws Exception {
	    ThemeBean bean = new ThemeBean();
	    ThemeModel model = new ThemeModel();

	    // uncomment to search by id or name
	    // bean.setThemeId(1);
	    // bean.setThemeName("Dark");

	    List<ThemeBean> list = model.Search(bean);

	    if (list.size() == 0) {
	        // no records found
	        System.out.println("Record not found");

	    } else {
	        // records found - print them
	        System.out.println("Total records found: " + list.size());
	        System.out.println("------");

	        Iterator<ThemeBean> it = list.iterator();
	        while (it.hasNext()) {
	            bean = it.next();
	            System.out.println(bean.getThemeId());
	            System.out.println(bean.getThemeCode());
	            System.out.println(bean.getThemeName());
	            System.out.println(bean.getColor());
	            System.out.println(bean.getStatus()); // changed System.err to System.out
	            System.out.println("------");
	        }
	    }
	}
}
