package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public final class xo {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1142a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final to c;
    public final to d;

    public xo(Context context) {
        this.f1142a = context;
        C0679wa c0679wa = new C0679wa(context, "appmetrica_vital.dat");
        this.c = new to(Ia.j().x(), c0679wa);
        this.d = new to(new C0460nf(C0626u7.a(context).d()), c0679wa);
    }

    public final to a() {
        return this.c;
    }

    public final to b() {
        return this.d;
    }
}
