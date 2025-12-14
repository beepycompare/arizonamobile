package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* loaded from: classes5.dex */
public final class N9 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f699a;
    public final Wm b;
    public final X2 c;
    public final SafePackageManager d;

    public N9(Context context, Wm wm, X2 x2, SafePackageManager safePackageManager) {
        this.f699a = context;
        this.b = wm;
        this.c = x2;
        this.d = safePackageManager;
    }

    public N9(Context context) {
        this(context, new Wm(context, "io.appmetrica.analytics.build_id"), new X2(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
