package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* loaded from: classes5.dex */
public final class Fb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0210e5 f475a;
    public final Lazy b = LazyKt.lazy(new Eb(this));

    public Fb(C0210e5 c0210e5) {
        this.f475a = c0210e5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final C0503ph getConfig() {
        return (C0503ph) this.b.getValue();
    }
}
