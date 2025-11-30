package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class Bo {

    /* renamed from: a  reason: collision with root package name */
    public final Context f416a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final xo c;
    public final xo d;

    public Bo(Context context) {
        this.f416a = context;
        C0164ca c0164ca = new C0164ca(context, "appmetrica_vital.dat");
        this.c = new xo(C0471oa.k().y(), c0164ca);
        this.d = new xo(new C0117af(C0471oa.k().B().e(context)), c0164ca);
    }

    public final xo a() {
        return this.c;
    }

    public final xo b() {
        return this.d;
    }
}
