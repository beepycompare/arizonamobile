package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.yb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0723yb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f1320a;
    public final Lazy b = LazyKt.lazy(new C0698xb(this));

    public C0723yb(X4 x4) {
        this.f1320a = x4;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final C0380kh getConfig() {
        return (C0380kh) this.b.getValue();
    }
}
