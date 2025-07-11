package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Hk {

    /* renamed from: a  reason: collision with root package name */
    public final Lk f465a;
    public final Map b;

    public Hk(Context context, C0398l5 c0398l5) {
        c0398l5.a();
        Lk lk = new Lk(context, c0398l5);
        this.f465a = lk;
        this.b = MapsKt.toMutableMap(lk.a());
    }
}
