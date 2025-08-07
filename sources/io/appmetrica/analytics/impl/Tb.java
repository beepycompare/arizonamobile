package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* loaded from: classes4.dex */
public final class Tb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0575s5 f651a;
    public final Lazy b = LazyKt.lazy(new Sb(this));

    public Tb(C0575s5 c0575s5) {
        this.f651a = c0575s5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final C0712xh getConfig() {
        return (C0712xh) this.b.getValue();
    }
}
