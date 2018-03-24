package com.kd.tools.redissync;

public interface Sync {
	public void doSync();
	public void doFullSync();
	public void clearData();
}
