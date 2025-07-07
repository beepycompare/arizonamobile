package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.bn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0173bn implements InterfaceC0574s {
    public final C0624u b;

    /* renamed from: a  reason: collision with root package name */
    public final C0599t f773a = new C0599t();
    public final Lazy c = LazyKt.lazy(new C0147an(this));

    public C0173bn(Context context) {
        this.b = new C0624u(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0574s
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
