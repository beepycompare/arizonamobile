package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0430ma {

    /* renamed from: a  reason: collision with root package name */
    public final Context f991a;
    public final C0236en b;
    public final C0650v3 c;
    public final SafePackageManager d;

    public C0430ma(Context context, C0236en c0236en, C0650v3 c0650v3, SafePackageManager safePackageManager) {
        this.f991a = context;
        this.b = c0236en;
        this.c = c0650v3;
        this.d = safePackageManager;
    }

    public C0430ma(Context context) {
        this(context, new C0236en(context, "io.appmetrica.analytics.build_id"), new C0650v3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
