package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.nn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0468nn implements InterfaceC0570s {
    public final C0620u b;

    /* renamed from: a  reason: collision with root package name */
    public final C0595t f1005a = new C0595t();
    public final Lazy c = LazyKt.lazy(new C0442mn(this));

    public C0468nn(Context context) {
        this.b = new C0620u(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0570s
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
