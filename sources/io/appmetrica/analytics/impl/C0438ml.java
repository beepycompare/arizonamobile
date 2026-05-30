package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.ml  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0438ml {

    /* renamed from: a  reason: collision with root package name */
    public final C0542ql f1100a;
    public final Map b;

    public C0438ml(Context context, C0267g5 c0267g5) {
        c0267g5.a();
        C0542ql c0542ql = new C0542ql(context, c0267g5);
        this.f1100a = c0542ql;
        this.b = MapsKt.toMutableMap(c0542ql.a());
    }
}
