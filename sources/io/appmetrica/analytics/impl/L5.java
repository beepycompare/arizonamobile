package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* loaded from: classes4.dex */
public final class L5 {
    public final Te a(Context context) {
        SafePackageManager safePackageManager = Ue.f671a;
        return (Te) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Te.UNDEFINED, new Se());
    }
}
