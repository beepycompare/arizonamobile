package com.google.android.vending.licensing;
/* loaded from: classes4.dex */
public class NullDeviceLimiter implements DeviceLimiter {
    @Override // com.google.android.vending.licensing.DeviceLimiter
    public int isDeviceAllowed(String str) {
        return 256;
    }
}
