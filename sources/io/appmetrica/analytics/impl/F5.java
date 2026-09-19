package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.EnumSet;
/* loaded from: classes5.dex */
public final class F5 implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final Context f541a;
    public final C0336j b = Na.k().b();
    public final EnumSet c = EnumSet.of(NetworkType.OFFLINE);
    public final String d = "connection based";

    public F5(Context context) {
        this.f541a = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        C0336j c0336j = this.b;
        Context context = this.f541a;
        c0336j.getClass();
        C0198df c0198df = AbstractC0301hf.f1017a;
        return !this.c.contains((NetworkType) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", NetworkType.UNDEFINED, new C0275gf()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.d;
    }
}
