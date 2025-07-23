package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.en  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0242en implements InterfaceC0568s {
    public final C0618u b;

    /* renamed from: a  reason: collision with root package name */
    public final C0593t f835a = new C0593t();
    public final Lazy c = LazyKt.lazy(new C0217dn(this));

    public C0242en(Context context) {
        this.b = new C0618u(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0568s
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
