package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.en  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0243en implements InterfaceC0569s {
    public final C0619u b;

    /* renamed from: a  reason: collision with root package name */
    public final C0594t f835a = new C0594t();
    public final Lazy c = LazyKt.lazy(new C0218dn(this));

    public C0243en(Context context) {
        this.b = new C0619u(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0569s
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
