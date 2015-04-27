package dk.p2p_unicorns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;

public class P2PReceiver extends BroadcastReceiver{
	
	public P2PReceiver(WifiP2pManager mManager, Channel mChannel,
			MainActivity mainActivity) {
		super();
		
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		String event = intent.getAction();
		
		if(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(event)) {
			
		} else if(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(event)) {
			
		} else if(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(event)) {
			
		} else if(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(event)) {
			
		}
		
	}

}
