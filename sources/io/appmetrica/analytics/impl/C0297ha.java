package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0297ha {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1013a;
    public final C0724xn b;
    public final C0341j3 c;
    public final SafePackageManager d;

    public C0297ha(Context context, C0724xn c0724xn, C0341j3 c0341j3, SafePackageManager safePackageManager) {
        this.f1013a = context;
        this.b = c0724xn;
        this.c = c0341j3;
        this.d = safePackageManager;
    }

    public C0297ha(Context context) {
        this(context, new C0724xn(context, "io.appmetrica.analytics.build_id"), new C0341j3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
