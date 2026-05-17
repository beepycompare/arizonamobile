package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* loaded from: classes5.dex */
public final class Jk {

    /* renamed from: a  reason: collision with root package name */
    public final Nk f652a;
    public final Map b;

    public Jk(Context context, Q4 q4) {
        q4.a();
        Nk nk = new Nk(context, q4);
        this.f652a = nk;
        this.b = MapsKt.toMutableMap(nk.a());
    }
}
