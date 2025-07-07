package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Hk {

    /* renamed from: a  reason: collision with root package name */
    public final Lk f464a;
    public final Map b;

    public Hk(Context context, C0406l5 c0406l5) {
        c0406l5.a();
        Lk lk = new Lk(context, c0406l5);
        this.f464a = lk;
        this.b = MapsKt.toMutableMap(lk.a());
    }
}
