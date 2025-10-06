package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* loaded from: classes4.dex */
public final class O5 {
    public final Ze a(Context context) {
        Ve ve = AbstractC0125af.f794a;
        return (Ze) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Ze.UNDEFINED, new Ye());
    }
}
