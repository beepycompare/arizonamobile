package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.bn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0165bn implements InterfaceC0566s {
    public final C0616u b;

    /* renamed from: a  reason: collision with root package name */
    public final C0591t f774a = new C0591t();
    public final Lazy c = LazyKt.lazy(new C0139an(this));

    public C0165bn(Context context) {
        this.b = new C0616u(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0566s
    public final Map<String, String> a(Map<String, String> map) {
        map.putAll((Map) this.c.getValue());
        return map;
    }
}
