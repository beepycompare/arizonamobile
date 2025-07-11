package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.fa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0254fa {

    /* renamed from: a  reason: collision with root package name */
    public final Context f835a;
    public final Sm b;
    public final C0570s3 c;
    public final SafePackageManager d;

    public C0254fa(Context context, Sm sm, C0570s3 c0570s3, SafePackageManager safePackageManager) {
        this.f835a = context;
        this.b = sm;
        this.c = c0570s3;
        this.d = safePackageManager;
    }

    public C0254fa(Context context) {
        this(context, new Sm(context, "io.appmetrica.analytics.build_id"), new C0570s3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
