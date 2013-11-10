package yxz.uestc.infoProcess;

import android.graphics.drawable.Drawable;

class AppInfo {

	private Drawable image;
	private String packageName;
	private String appName;
	public AppInfo(Drawable image, String packageName, String appName) {
		super();
		this.image = image;
		this.packageName = packageName;
		this.appName = appName;
	}
	
	public AppInfo(){}

	public Drawable getImage() {
		return image;
	}

	public void setImage(Drawable image) {
		this.image = image;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

}
