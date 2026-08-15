package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0118ac implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0447n5 f887a;
    public final Lazy b = LazyKt.lazy(new Zb(this));

    public C0118ac(C0447n5 c0447n5) {
        this.f887a = c0447n5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final Eh getConfig() {
        return (Eh) this.b.getValue();
    }
}
