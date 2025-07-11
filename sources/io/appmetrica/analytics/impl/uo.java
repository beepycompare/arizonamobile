package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public final class uo {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1082a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final qo c;
    public final qo d;

    public uo(Context context) {
        this.f1082a = context;
        C0627ua c0627ua = new C0627ua(context, "appmetrica_vital.dat");
        this.c = new qo(Ga.j().x(), c0627ua);
        this.d = new qo(new C0408lf(C0549r7.a(context).d()), c0627ua);
    }

    public final qo a() {
        return this.c;
    }

    public final qo b() {
        return this.d;
    }
}
