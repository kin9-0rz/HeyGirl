package com.android.reverse.apimonitor;


import com.android.reverse.hook.HookHelperFacktory;
import com.android.reverse.hook.HookHelperInterface;

public abstract class ApiMonitorHook {
	
   protected HookHelperInterface hookhelper = HookHelperFacktory.getHookHelper();
   public abstract void startHook();
    
}
