package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0296ha {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1013a;
    public final C0723xn b;
    public final C0340j3 c;
    public final SafePackageManager d;

    public C0296ha(Context context, C0723xn c0723xn, C0340j3 c0340j3, SafePackageManager safePackageManager) {
        this.f1013a = context;
        this.b = c0723xn;
        this.c = c0340j3;
        this.d = safePackageManager;
    }

    public C0296ha(Context context) {
        this(context, new C0723xn(context, "io.appmetrica.analytics.build_id"), new C0340j3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
