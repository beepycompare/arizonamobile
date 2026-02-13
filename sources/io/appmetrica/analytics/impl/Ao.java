package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class Ao {

    /* renamed from: a  reason: collision with root package name */
    public final Context f504a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final wo c;
    public final wo d;

    public Ao(Context context) {
        this.f504a = context;
        C0142ba c0142ba = new C0142ba(context, "appmetrica_vital.dat");
        this.c = new wo(C0449na.k().y(), c0142ba);
        this.d = new wo(new Ze(C0449na.k().B().e(context)), c0142ba);
    }

    public final wo a() {
        return this.c;
    }

    public final wo b() {
        return this.d;
    }
}
