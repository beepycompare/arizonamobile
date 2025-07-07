package com.AdX.tag;

import android.os.Build;
/* loaded from: classes3.dex */
public class DeviceSerial {

    /* loaded from: classes3.dex */
    private static class DeviceSerialHolder {
        private static final DeviceSerial INSTANCE = new DeviceSerial(null);

        private DeviceSerialHolder() {
        }
    }

    private DeviceSerial() {
    }

    /* synthetic */ DeviceSerial(DeviceSerial deviceSerial) {
        this();
    }

    public static String getDeviceSerial() {
        return Build.SERIAL;
    }

    public static DeviceSerial getInstance() {
        return DeviceSerialHolder.INSTANCE;
    }
}
