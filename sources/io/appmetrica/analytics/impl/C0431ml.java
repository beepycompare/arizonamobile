package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.ml  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0431ml {

    /* renamed from: a  reason: collision with root package name */
    public final C0535ql f1105a;
    public final Map b;

    public C0431ml(Context context, C0260g5 c0260g5) {
        c0260g5.a();
        C0535ql c0535ql = new C0535ql(context, c0260g5);
        this.f1105a = c0535ql;
        this.b = MapsKt.toMutableMap(c0535ql.a());
    }
}
