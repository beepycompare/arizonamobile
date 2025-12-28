package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class Bo {

    /* renamed from: a  reason: collision with root package name */
    public final Context f514a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final xo c;
    public final xo d;

    public Bo(Context context) {
        this.f514a = context;
        C0163ca c0163ca = new C0163ca(context, "appmetrica_vital.dat");
        this.c = new xo(C0470oa.k().y(), c0163ca);
        this.d = new xo(new C0116af(C0470oa.k().B().e(context)), c0163ca);
    }

    public final xo a() {
        return this.c;
    }

    public final xo b() {
        return this.d;
    }
}
