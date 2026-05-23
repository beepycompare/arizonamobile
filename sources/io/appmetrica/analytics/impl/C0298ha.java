package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0298ha {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1010a;
    public final C0725xn b;
    public final C0342j3 c;
    public final SafePackageManager d;

    public C0298ha(Context context, C0725xn c0725xn, C0342j3 c0342j3, SafePackageManager safePackageManager) {
        this.f1010a = context;
        this.b = c0725xn;
        this.c = c0342j3;
        this.d = safePackageManager;
    }

    public C0298ha(Context context) {
        this(context, new C0725xn(context, "io.appmetrica.analytics.build_id"), new C0342j3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
