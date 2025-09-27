package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Tk {

    /* renamed from: a  reason: collision with root package name */
    public final Xk f690a;
    public final Map b;

    public Tk(Context context, C0476o5 c0476o5) {
        c0476o5.a();
        Xk xk = new Xk(context, c0476o5);
        this.f690a = xk;
        this.b = MapsKt.toMutableMap(xk.a());
    }
}
