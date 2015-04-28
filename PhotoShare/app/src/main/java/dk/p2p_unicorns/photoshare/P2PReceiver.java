package dk.p2p_unicorns.photoshare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;

public class P2PReceiver extends BroadcastReceiver{

    private final WifiP2pManager mManager;
    private MainActivity mainActivity;

    public P2PReceiver(WifiP2pManager mManager, Channel mChannel,
			MainActivity mainActivity) {
		super();
        this.mainActivity = mainActivity;
        this.mManager = mManager;
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		String event = intent.getAction();
		
		if(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(event)) {

            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if(state == WifiP2pManager.WIFI_P2P_STATE_ENABLED){
                mainActivity.setIsWifiEnabled(true);
            }
            else {
                mainActivity.setIsWifiEnabled(false);
            }
			
		} else if(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(event)) {
            // The peer list has changed!  We should probably do something about
            // that.
		} else if(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(event)) {
            // Connection state changed!  We should probably do something about
            // that.
		} else if(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(event)) {
//            DeviceListFragment fragment = (DeviceListFragment) activity.getFragmentManager()
//                    .findFragmentById(R.id.frag_list);
//            fragment.updateThisDevice((WifiP2pDevice) intent.getParcelableExtra(
//                    WifiP2pManager.EXTRA_WIFI_P2P_DEVICE));
		}
		
	}

}
