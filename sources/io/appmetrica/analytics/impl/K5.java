package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.EnumSet;
/* loaded from: classes4.dex */
public final class K5 implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final Context f517a;
    public final L5 b = new L5();
    public final EnumSet c = EnumSet.of(Te.OFFLINE);
    public final String d = "connection based";

    public K5(Context context) {
        this.f517a = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        L5 l5 = this.b;
        Context context = this.f517a;
        l5.getClass();
        SafePackageManager safePackageManager = Ue.f671a;
        return !this.c.contains((Te) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Te.UNDEFINED, new Se()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.d;
    }
}
