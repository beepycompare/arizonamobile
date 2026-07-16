package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* loaded from: classes5.dex */
public final class Gn implements InterfaceC0623u {
    public final C0675w b;

    /* renamed from: a  reason: collision with root package name */
    public final C0649v f569a = new C0649v();
    public final Lazy c = LazyKt.lazy(new Fn(this));

    public Gn(Context context) {
        this.b = new C0675w(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0623u
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
