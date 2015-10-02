package com.android.reverse.collecter;

import org.keplerproject.luajava.JavaFunction;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import com.android.reverse.hook.HookHelperFacktory;
import com.android.reverse.hook.HookHelperInterface;
import com.android.reverse.util.JsonWriter;
import com.android.reverse.util.Logger;

public class LuaScriptInvoker{
	
	private static LuaScriptInvoker luaInvoker;
	private HookHelperInterface hookhelper = HookHelperFacktory.getHookHelper();

	
	private LuaScriptInvoker(){
		
	}
	
	
	public static LuaScriptInvoker getInstance(){
		if(luaInvoker == null)
			luaInvoker = new LuaScriptInvoker();
		return luaInvoker;
	}
	
	private void initLuaContext(LuaState luaState){
		try {
			JavaFunction logfunction = new LogFunctionCallBack(luaState);
			logfunction.register("log");
			JavaFunction tostringfunction = new ToStringFunctionCallBack(luaState);
			tostringfunction.register("tostring");
			luaState.pushJavaObject(ModuleContext.getInstance().getAppContext().getApplicationContext());
			luaState.setGlobal("context");
			luaState.pushJavaObject(ZjDroidLuaJavaAPI.getInstance());
			luaState.setGlobal("zjdroid");
		} catch (LuaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void invokeScript(String script){
		LuaState luaState = LuaStateFactory.newLuaState();
		luaState.openLibs();
		this.initLuaContext(luaState);
		int error = luaState.LdoString(script);
		if(error!=0){
			Logger.log("Read/Parse lua error. Exit");
			return;
		}
		
		luaState.close();
	}
	
	public void invokeFileScript(String scriptFilePath){
		LuaState luaState = LuaStateFactory.newLuaState();
		luaState.openLibs();
		this.initLuaContext(luaState);
		int error = luaState.LdoFile(scriptFilePath);
		if(error!=0){
			Logger.log("Read/Parse lua error. Exit");
			return;
		}
		luaState.close();
	}
	
	public static class ToStringFunctionCallBack extends JavaFunction{

		public ToStringFunctionCallBack(LuaState L) {
			super(L);
		}

		@Override
		public int execute() throws LuaException {
			
			int param_size = this.L.getTop();
			for(int i=2; i<=param_size; i++){
				try {
					String objDsrc = JsonWriter.parserInstanceToJson(this.getParam(i).getObject());
					Logger.log(objDsrc);
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
			return 0;
		}
		
	}
	
	public static class LogFunctionCallBack extends JavaFunction{

		public LogFunctionCallBack(LuaState L) {
			super(L);
		}

		@Override
		public int execute() throws LuaException {
			
			int param_size = this.L.getTop();
			if(param_size ==2 ){
				String message = this.L.getLuaObject(2).getString();
				Logger.log(message);
			}
			
			return 0;
		}
		
	}
}
