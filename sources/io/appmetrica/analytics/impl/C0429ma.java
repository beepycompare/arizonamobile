package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0429ma {

    /* renamed from: a  reason: collision with root package name */
    public final Context f986a;
    public final C0235en b;
    public final C0649v3 c;
    public final SafePackageManager d;

    public C0429ma(Context context, C0235en c0235en, C0649v3 c0649v3, SafePackageManager safePackageManager) {
        this.f986a = context;
        this.b = c0235en;
        this.c = c0649v3;
        this.d = safePackageManager;
    }

    public C0429ma(Context context) {
        this(context, new C0235en(context, "io.appmetrica.analytics.build_id"), new C0649v3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
