package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class dp {

    /* renamed from: a  reason: collision with root package name */
    public final Context f953a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final Zo c;
    public final Zo d;

    public dp(Context context) {
        this.f953a = context;
        C0736ya c0736ya = new C0736ya(context, "appmetrica_vital.dat", Na.k().w().e(), 0L, 8, null);
        this.c = new Zo(Na.k().y(), c0736ya);
        this.d = new Zo(new C0767zf(Na.k().B().e(context)), c0736ya);
    }

    public final Zo a() {
        return this.c;
    }

    public final Zo b() {
        return this.d;
    }
}
