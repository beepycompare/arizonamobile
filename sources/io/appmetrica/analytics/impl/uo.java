package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public final class uo {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1081a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final qo c;
    public final qo d;

    public uo(Context context) {
        this.f1081a = context;
        C0635ua c0635ua = new C0635ua(context, "appmetrica_vital.dat");
        this.c = new qo(Ga.j().x(), c0635ua);
        this.d = new qo(new C0416lf(C0557r7.a(context).d()), c0635ua);
    }

    public final qo a() {
        return this.c;
    }

    public final qo b() {
        return this.d;
    }
}
