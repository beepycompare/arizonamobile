package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* loaded from: classes4.dex */
public final class Rb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0580s5 f607a;
    public final Lazy b = LazyKt.lazy(new Qb(this));

    public Rb(C0580s5 c0580s5) {
        this.f607a = c0580s5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final C0667vh getConfig() {
        return (C0667vh) this.b.getValue();
    }
}
