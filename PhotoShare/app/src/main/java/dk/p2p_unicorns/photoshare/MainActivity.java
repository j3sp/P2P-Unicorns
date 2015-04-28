package dk.p2p_unicorns.photoshare;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private String LOG_TAG = "LOG_TAG";
    private final IntentFilter intentFilter = new IntentFilter();
    WifiP2pManager.Channel mChannel;
    WifiP2pManager mManager;
    P2PReceiver receiver;
    private List peers = new ArrayList();
    private boolean isWifiEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);

        mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
                Log.d(LOG_TAG, "MainActivity->onSuccess: discovery initiation successful");
            }

            @Override
            public void onFailure(int reason) {
                Log.d(LOG_TAG, "MainActivity->onFailure: discovery initiation failed");
            }
        });
    }

    public void setIsWifiEnabled(boolean isEnabled) {
        isWifiEnabled = isEnabled;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "MainActivity->onResume");
        receiver = new P2PReceiver(mManager, mChannel, this);
        registerReceiver(receiver, intentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
