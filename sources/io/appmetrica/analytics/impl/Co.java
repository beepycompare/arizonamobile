package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public final class Co {

    /* renamed from: a  reason: collision with root package name */
    public final Context f385a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final yo c;
    public final yo d;

    public Co(Context context) {
        this.f385a = context;
        C0727ya c0727ya = new C0727ya(context, "appmetrica_vital.dat");
        this.c = new yo(Ka.j().x(), c0727ya);
        this.d = new yo(new C0508pf(C0649v7.a(context).d()), c0727ya);
    }

    public final yo a() {
        return this.c;
    }

    public final yo b() {
        return this.d;
    }
}
