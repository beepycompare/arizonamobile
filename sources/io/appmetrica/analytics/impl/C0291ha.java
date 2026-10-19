package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0291ha {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1016a;
    public final C0718xn b;
    public final C0335j3 c;
    public final SafePackageManager d;

    public C0291ha(Context context, C0718xn c0718xn, C0335j3 c0335j3, SafePackageManager safePackageManager) {
        this.f1016a = context;
        this.b = c0718xn;
        this.c = c0335j3;
        this.d = safePackageManager;
    }

    public C0291ha(Context context) {
        this(context, new C0718xn(context, "io.appmetrica.analytics.build_id"), new C0335j3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
