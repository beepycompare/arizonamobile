package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class Ao {

    /* renamed from: a  reason: collision with root package name */
    public final Context f509a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final wo c;
    public final wo d;

    public Ao(Context context) {
        this.f509a = context;
        C0141ba c0141ba = new C0141ba(context, "appmetrica_vital.dat");
        this.c = new wo(C0448na.k().y(), c0141ba);
        this.d = new wo(new Ze(C0448na.k().B().e(context)), c0141ba);
    }

    public final wo a() {
        return this.c;
    }

    public final wo b() {
        return this.d;
    }
}
