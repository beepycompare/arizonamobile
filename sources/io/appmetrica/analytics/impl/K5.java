package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.EnumSet;
/* loaded from: classes4.dex */
public final class K5 implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final Context f525a;
    public final L5 b = new L5();
    public final EnumSet c = EnumSet.of(Ve.OFFLINE);
    public final String d = "connection based";

    public K5(Context context) {
        this.f525a = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        L5 l5 = this.b;
        Context context = this.f525a;
        l5.getClass();
        Re re = We.f709a;
        return !this.c.contains((Ve) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Ve.UNDEFINED, new Ue()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.d;
    }
}
