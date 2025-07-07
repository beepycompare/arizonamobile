package com.wardrumstudios.utils;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import com.nvidia.devtech.NvEventQueueActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class WarBase extends NvEventQueueActivity {
    private static final String TAG = "WarBase";
    public boolean FinalRelease = false;
    public boolean GameServiceLog = false;
    public int MultiplayerVersion = -1;
    private ArrayList<WarActivityLifecycleListener> mLifecycleListeners;
    protected UsbManager mUsbManager;
    protected BroadcastReceiver mUsbReceiver;

    public void AddLifecycleListener(WarActivityLifecycleListener warActivityLifecycleListener) {
        this.mLifecycleListeners.add(warActivityLifecycleListener);
    }

    void CreateUSBReceiver() {
        Log.e(TAG, "Creating USB intent receiver");
        this.mUsbReceiver = new BroadcastReceiver() { // from class: com.wardrumstudios.utils.WarBase.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                System.out.println("BroadcastReceiver WarMedia Base " + action.toString());
                UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                try {
                    if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                        Log.e(WarBase.TAG, "BroadcastReceiver -> ACTION_USB_DEVICE_ATTACHED " + usbDevice.toString());
                        WarBase.this.USBDeviceAttached(usbDevice, usbDevice.getDeviceName());
                    } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                        Log.e(WarBase.TAG, "BroadcastReceiver -> ACTION_USB_DEVICE_DETACHED " + usbDevice.toString());
                        WarBase.this.USBDeviceDetached(usbDevice, usbDevice.getDeviceName());
                    } else if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action)) {
                        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                        Log.e(WarBase.TAG, "BroadcastReceiver ACTION_ACL_CONNECTED name " + bluetoothDevice.getName());
                        if (bluetoothDevice == null || bluetoothDevice.getName() == null || !bluetoothDevice.getName().equals("GS controller")) {
                            return;
                        }
                        WarBase.this.SetGamepad(bluetoothDevice.getName());
                    } else if (!"android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                        Log.e(WarBase.TAG, "BroadcastReceiver -> UNKNOWN ACTION : " + action.toString());
                    } else {
                        BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                        Log.e(WarBase.TAG, "BroadcastReceiver ACTION_ACL_DISCONNECTED name " + bluetoothDevice2.getName());
                        if (bluetoothDevice2 == null || !bluetoothDevice2.getName().equals("GS controller")) {
                            return;
                        }
                        WarBase.this.SetGamepad("");
                    }
                } catch (Exception unused) {
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        registerReceiver(this.mUsbReceiver, intentFilter);
        Log.e(TAG, "Receiver set up");
    }

    public void DestroyUSBReceiver() {
        unregisterReceiver(this.mUsbReceiver);
    }

    public String GetLeaderboardId(String str) {
        return str;
    }

    public void SetGamepad(String str) {
    }

    public void USBDeviceAttached(UsbDevice usbDevice, String str) {
    }

    public void USBDeviceDetached(UsbDevice usbDevice, String str) {
    }

    public boolean isExternalStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Iterator<WarActivityLifecycleListener> it = this.mLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mLifecycleListeners = new ArrayList<>();
        super.onCreate(bundle);
        this.mUsbManager = (UsbManager) getSystemService("usb");
        CreateUSBReceiver();
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onDestroy() {
        DestroyUSBReceiver();
        Iterator<WarActivityLifecycleListener> it = this.mLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onPause() {
        Iterator<WarActivityLifecycleListener> it = this.mLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onResume() {
        Intent intent = getIntent();
        String action = intent.getAction();
        Log.e(TAG, "OnResume -> Intent: " + intent.toString());
        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
        if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
            Log.e(TAG, "OnResume -> ACTION_USB_DEVICE_ATTACHED " + usbDevice.toString());
            USBDeviceAttached(usbDevice, usbDevice.getDeviceName());
        } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
            Log.e(TAG, "OnResume -> ACTION_USB_DEVICE_DETACHED " + usbDevice.toString());
            USBDeviceDetached(usbDevice, usbDevice.getDeviceName());
        }
        Iterator<WarActivityLifecycleListener> it = this.mLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        Iterator<WarActivityLifecycleListener> it = this.mLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onStop() {
        Iterator<WarActivityLifecycleListener> it = this.mLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
        super.onStop();
    }
}
