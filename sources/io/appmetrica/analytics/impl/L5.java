package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* loaded from: classes4.dex */
public final class L5 {
    public final Ve a(Context context) {
        Re re = We.f709a;
        return (Ve) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Ve.UNDEFINED, new Ue());
    }
}
