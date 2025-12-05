package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.EnumSet;
/* renamed from: io.appmetrica.analytics.impl.q5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0515q5 implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1164a;
    public final C0332j b = C0470oa.k().b();
    public final EnumSet c = EnumSet.of(NetworkType.OFFLINE);
    public final String d = "connection based";

    public C0515q5(Context context) {
        this.f1164a = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        C0332j c0332j = this.b;
        Context context = this.f1164a;
        c0332j.getClass();
        De de = He.f590a;
        return !this.c.contains((NetworkType) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", NetworkType.UNDEFINED, new Ge()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.d;
    }
}
