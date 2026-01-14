package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.fn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0258fn implements InterfaceC0587t {
    public final C0637v b;

    /* renamed from: a  reason: collision with root package name */
    public final C0612u f1001a = new C0612u();
    public final Lazy c = LazyKt.lazy(new C0232en(this));

    public C0258fn(Context context) {
        this.b = new C0637v(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0587t
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
