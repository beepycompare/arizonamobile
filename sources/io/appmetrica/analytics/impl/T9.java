package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* loaded from: classes3.dex */
public final class T9 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f702a;
    public final Zm b;
    public final C0208e3 c;
    public final SafePackageManager d;

    public T9(Context context, Zm zm, C0208e3 c0208e3, SafePackageManager safePackageManager) {
        this.f702a = context;
        this.b = zm;
        this.c = c0208e3;
        this.d = safePackageManager;
    }

    public T9(Context context) {
        this(context, new Zm(context, "io.appmetrica.analytics.build_id"), new C0208e3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
