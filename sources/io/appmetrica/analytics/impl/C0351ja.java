package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ja  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0351ja {

    /* renamed from: a  reason: collision with root package name */
    public final Context f921a;
    public final C0132an b;
    public final C0570s3 c;
    public final SafePackageManager d;

    public C0351ja(Context context, C0132an c0132an, C0570s3 c0570s3, SafePackageManager safePackageManager) {
        this.f921a = context;
        this.b = c0132an;
        this.c = c0570s3;
        this.d = safePackageManager;
    }

    public C0351ja(Context context) {
        this(context, new C0132an(context, "io.appmetrica.analytics.build_id"), new C0570s3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
