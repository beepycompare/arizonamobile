package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* loaded from: classes4.dex */
public final class Rb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f608a;
    public final Lazy b = LazyKt.lazy(new Qb(this));

    public Rb(C0572s5 c0572s5) {
        this.f608a = c0572s5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final C0659vh getConfig() {
        return (C0659vh) this.b.getValue();
    }
}
