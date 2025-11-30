package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.gn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0280gn implements InterfaceC0584t {
    public final C0634v b;

    /* renamed from: a  reason: collision with root package name */
    public final C0609u f912a = new C0609u();
    public final Lazy c = LazyKt.lazy(new C0254fn(this));

    public C0280gn(Context context) {
        this.b = new C0634v(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0584t
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
