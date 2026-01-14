package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* loaded from: classes5.dex */
public final class M9 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f691a;
    public final Vm b;
    public final W2 c;
    public final SafePackageManager d;

    public M9(Context context, Vm vm, W2 w2, SafePackageManager safePackageManager) {
        this.f691a = context;
        this.b = vm;
        this.c = w2;
        this.d = safePackageManager;
    }

    public M9(Context context) {
        this(context, new Vm(context, "io.appmetrica.analytics.build_id"), new W2(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
