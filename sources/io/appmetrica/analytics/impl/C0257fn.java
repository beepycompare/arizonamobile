package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.fn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0257fn implements InterfaceC0586t {
    public final C0636v b;

    /* renamed from: a  reason: collision with root package name */
    public final C0611u f1000a = new C0611u();
    public final Lazy c = LazyKt.lazy(new C0231en(this));

    public C0257fn(Context context) {
        this.b = new C0636v(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0586t
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
