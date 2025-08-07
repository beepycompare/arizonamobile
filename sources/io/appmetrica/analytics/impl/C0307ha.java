package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0307ha {

    /* renamed from: a  reason: collision with root package name */
    public final Context f881a;
    public final Vm b;
    public final C0573s3 c;
    public final SafePackageManager d;

    public C0307ha(Context context, Vm vm, C0573s3 c0573s3, SafePackageManager safePackageManager) {
        this.f881a = context;
        this.b = vm;
        this.c = c0573s3;
        this.d = safePackageManager;
    }

    public C0307ha(Context context) {
        this(context, new Vm(context, "io.appmetrica.analytics.build_id"), new C0573s3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
