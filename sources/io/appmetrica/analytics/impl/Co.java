package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class Co {

    /* renamed from: a  reason: collision with root package name */
    public final Context f431a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final yo c;
    public final yo d;

    public Co(Context context) {
        this.f431a = context;
        C0319ia c0319ia = new C0319ia(context, "appmetrica_vital.dat");
        this.c = new yo(C0620ua.k().z(), c0319ia);
        this.d = new yo(new C0220ef(C0264g7.a(context).d()), c0319ia);
    }

    public final yo a() {
        return this.c;
    }

    public final yo b() {
        return this.d;
    }
}
