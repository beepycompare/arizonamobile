package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.ml  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0437ml {

    /* renamed from: a  reason: collision with root package name */
    public final C0541ql f1102a;
    public final Map b;

    public C0437ml(Context context, C0266g5 c0266g5) {
        c0266g5.a();
        C0541ql c0541ql = new C0541ql(context, c0266g5);
        this.f1102a = c0541ql;
        this.b = MapsKt.toMutableMap(c0541ql.a());
    }
}
