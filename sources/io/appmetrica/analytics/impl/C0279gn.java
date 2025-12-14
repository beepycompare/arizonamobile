package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.gn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0279gn implements InterfaceC0583t {
    public final C0633v b;

    /* renamed from: a  reason: collision with root package name */
    public final C0608u f1009a = new C0608u();
    public final Lazy c = LazyKt.lazy(new C0253fn(this));

    public C0279gn(Context context) {
        this.b = new C0633v(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583t
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
