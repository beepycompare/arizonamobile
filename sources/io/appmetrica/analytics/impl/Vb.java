package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* loaded from: classes4.dex */
public final class Vb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f693a;
    public final Lazy b = LazyKt.lazy(new Ub(this));

    public Vb(C0572s5 c0572s5) {
        this.f693a = c0572s5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final Ch getConfig() {
        return (Ch) this.b.getValue();
    }
}
