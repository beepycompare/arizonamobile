package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.EnumSet;
/* loaded from: classes4.dex */
public final class Q9 implements IExecutionPolicy {
    public static final EnumSet c = EnumSet.of(Re.OFFLINE);

    /* renamed from: a  reason: collision with root package name */
    public final I5 f593a = new I5();
    public final Context b;

    public Q9(Context context) {
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        I5 i5 = this.f593a;
        Context context = this.b;
        i5.getClass();
        SafePackageManager safePackageManager = Se.f626a;
        return !c.contains((Re) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Re.UNDEFINED, new Qe()));
    }
}
