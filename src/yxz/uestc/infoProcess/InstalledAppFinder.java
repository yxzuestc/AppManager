package yxz.uestc.infoProcess;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

public class InstalledAppFinder {

	private ArrayList<AppInfo> installedAppList=new ArrayList<AppInfo>();
	
	private Activity context;
	
	public InstalledAppFinder(Activity context){
		this.context=context;
		searchInstalledApp();
	}
	
	/**
	 * 获取安装的应用程序信息
	 * @return
	 */
	public ArrayList<AppInfo> getInstalledAppList(){
		return installedAppList;
	}
	
	
	/**
	 * 查找系统中的第三方应用
	 */
	private void searchInstalledApp(){
		PackageManager packageManager=context.getPackageManager();
		List<PackageInfo> appPackages=
				packageManager.getInstalledPackages(
						PackageManager.GET_UNINSTALLED_PACKAGES);
		for(PackageInfo appPackage:appPackages){
			if(!isSystemApp(appPackage)){//非系统应用
				installedAppList.add(parseAppInfo(appPackage));
			}
		}
	
	}
	/**
	 * 判断是否是系统应用
	 * @param packageInfo
	 * @return
	 */
	private boolean isSystemApp(PackageInfo packageInfo){
		if((packageInfo.applicationInfo.flags&ApplicationInfo.FLAG_SYSTEM)==0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 解析应用数据
	 * @param packageInfo
	 * @return
	 */
	private AppInfo parseAppInfo(PackageInfo packageInfo){
		String appName=packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
		String packageName=packageInfo.packageName;
		Drawable icon=packageInfo.applicationInfo.loadIcon(context.getPackageManager());
		AppInfo appInfo=new AppInfo(icon, packageName, appName);
		return appInfo;
	}
	
	
	
}
