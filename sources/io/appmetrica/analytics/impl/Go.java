package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public final class Go {

    /* renamed from: a  reason: collision with root package name */
    public final Context f465a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final Co c;
    public final Co d;

    public Go(Context context) {
        this.f465a = context;
        Ba ba = new Ba(context, "appmetrica_vital.dat");
        this.c = new Co(Na.j().x(), ba);
        this.d = new Co(new C0611tf(C0728y7.a(context).d()), ba);
    }

    public final Co a() {
        return this.c;
    }

    public final Co b() {
        return this.d;
    }
}
