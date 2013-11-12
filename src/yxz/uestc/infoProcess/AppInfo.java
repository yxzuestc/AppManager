package yxz.uestc.infoProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import yxz.uestc.appmanager.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class AppInfo {

	private Drawable image;
	private String packageName;
	private String appName;
	AppInfo(Drawable image, String packageName, String appName) {
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
	
	
	public static class AppInfoAdapter{
		
		private static final String IMAGE="image";
		private static final String APP_NAME="appName";
		private static final String PACKAGE_NAME="packageName";
		
		
		public SimpleAdapter createListViewAdapter(
				Activity context,List<AppInfo> appInfo,int listviewItem){
			List<HashMap<String, Object>> adapterList=new ArrayList<HashMap<String,Object>>();
			for(AppInfo info:appInfo){
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put(IMAGE, info.getImage());
				map.put(APP_NAME, info.getAppName());
				map.put(PACKAGE_NAME, info.getPackageName());
				adapterList.add(map);
			}
			
			SimpleAdapter adapter=new SimpleAdapter(
					context, adapterList, listviewItem, 
					new String[]{IMAGE,APP_NAME,PACKAGE_NAME}, 
					new int[]{R.id.imgApp,R.id.textView_appName,R.id.textView_packageName});
			adapter.setViewBinder(new MyViewBinder());
			return adapter;
		}
		
		
		/**
		 * @author yuanxz
		 * 主要使SimpleAdapter可以直接接收Drawble和Bitmap类型的资源，而不只是资源id
		 */
		private class MyViewBinder implements SimpleAdapter.ViewBinder{

			@Override
			public boolean setViewValue(View view, Object data,
					String textRepresentation) {
				// TODO Auto-generated method stub
				if((view instanceof ImageView)&&((data instanceof Drawable))){
					ImageView imageView=(ImageView)view;
					Drawable drawable=(Drawable)data;
					imageView.setImageDrawable(drawable);
					return true;
				}else if((view instanceof ImageView)&&(data instanceof Bitmap)){
					ImageView imageView=(ImageView)view;
					Bitmap bitmap=(Bitmap)data;
					imageView.setImageBitmap(bitmap);
					return true;
				}
				return false;
			}
			
		}
		
		
	}
	
	

}
