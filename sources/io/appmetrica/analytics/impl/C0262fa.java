package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.fa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0262fa {

    /* renamed from: a  reason: collision with root package name */
    public final Context f834a;
    public final Sm b;
    public final C0578s3 c;
    public final SafePackageManager d;

    public C0262fa(Context context, Sm sm, C0578s3 c0578s3, SafePackageManager safePackageManager) {
        this.f834a = context;
        this.b = sm;
        this.c = c0578s3;
        this.d = safePackageManager;
    }

    public C0262fa(Context context) {
        this(context, new Sm(context, "io.appmetrica.analytics.build_id"), new C0578s3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
