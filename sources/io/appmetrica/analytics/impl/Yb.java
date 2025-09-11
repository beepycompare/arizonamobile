package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* loaded from: classes4.dex */
public final class Yb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0651v5 f756a;
    public final Lazy b = LazyKt.lazy(new Xb(this));

    public Yb(C0651v5 c0651v5) {
        this.f756a = c0651v5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final Gh getConfig() {
        return (Gh) this.b.getValue();
    }
}
