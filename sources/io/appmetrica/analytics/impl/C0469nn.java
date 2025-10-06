package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.nn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0469nn implements InterfaceC0571s {
    public final C0621u b;

    /* renamed from: a  reason: collision with root package name */
    public final C0596t f1010a = new C0596t();
    public final Lazy c = LazyKt.lazy(new C0443mn(this));

    public C0469nn(Context context) {
        this.b = new C0621u(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0571s
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
