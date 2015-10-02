package com.android.reverse.collecter;

public class ZjDroidLuaJavaAPI {
	private static ZjDroidLuaJavaAPI zjdroidLuaJavaApi;

	private ZjDroidLuaJavaAPI(){
		
	}
	
	
	public static ZjDroidLuaJavaAPI getInstance(){
		if(zjdroidLuaJavaApi == null)
			zjdroidLuaJavaApi = new ZjDroidLuaJavaAPI();
		return zjdroidLuaJavaApi;
	}
	
	public Class<?> forname(String className){
		return DexFileInfoCollecter.getInstance().loadClass(className);
	}

}
