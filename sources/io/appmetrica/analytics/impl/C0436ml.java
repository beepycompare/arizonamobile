package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.ml  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0436ml {

    /* renamed from: a  reason: collision with root package name */
    public final C0540ql f1102a;
    public final Map b;

    public C0436ml(Context context, C0265g5 c0265g5) {
        c0265g5.a();
        C0540ql c0540ql = new C0540ql(context, c0265g5);
        this.f1102a = c0540ql;
        this.b = MapsKt.toMutableMap(c0540ql.a());
    }
}
