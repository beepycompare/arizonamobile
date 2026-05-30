package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0119ac implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0448n5 f885a;
    public final Lazy b = LazyKt.lazy(new Zb(this));

    public C0119ac(C0448n5 c0448n5) {
        this.f885a = c0448n5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final Eh getConfig() {
        return (Eh) this.b.getValue();
    }
}
