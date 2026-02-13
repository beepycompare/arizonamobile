package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.yb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0724yb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f1320a;
    public final Lazy b = LazyKt.lazy(new C0699xb(this));

    public C0724yb(X4 x4) {
        this.f1320a = x4;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final C0381kh getConfig() {
        return (C0381kh) this.b.getValue();
    }
}
