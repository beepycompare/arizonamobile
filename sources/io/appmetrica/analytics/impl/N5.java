package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.EnumSet;
/* loaded from: classes4.dex */
public final class N5 implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final Context f589a;
    public final O5 b = new O5();
    public final EnumSet c = EnumSet.of(Ze.OFFLINE);
    public final String d = "connection based";

    public N5(Context context) {
        this.f589a = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        O5 o5 = this.b;
        Context context = this.f589a;
        o5.getClass();
        Ve ve = AbstractC0124af.f793a;
        return !this.c.contains((Ze) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Ze.UNDEFINED, new Ye()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.d;
    }
}
