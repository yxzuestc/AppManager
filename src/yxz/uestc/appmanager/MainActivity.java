package yxz.uestc.appmanager;


import yxz.uestc.infoProcess.AppInfo;
import yxz.uestc.infoProcess.InstalledAppFinder;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.Activity;

public class MainActivity extends Activity {

	
	private ListView appList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupRes();
		init();
		
	}

	
	
	
	/**
	 * 初始化数据
	 */
	private void init(){
		InstalledAppFinder appFinder=new InstalledAppFinder(this);
		SimpleAdapter adapter=new AppInfo.AppInfoAdapter().createListViewAdapter(
				this, appFinder.getInstalledAppList(), R.layout.app_search_item);
		appList.setAdapter(adapter);
	}
	
	/**
	 *初始化组件 
	 */
	private void setupRes(){
		appList=(ListView)findViewById(R.id.listView_appList);
	}
	
	
}