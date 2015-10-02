package org.keplerproject.luajava;

import com.android.reverse.collecter.DexFileInfoCollecter;

public class LuaClassLoader {
	
	public static Class forName(String className){
		return DexFileInfoCollecter.getInstance().loadClass(className);
	}

}
