package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.zb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0745zb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f1329a;
    public final Lazy b = LazyKt.lazy(new C0720yb(this));

    public C0745zb(Y4 y4) {
        this.f1329a = y4;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final C0402lh getConfig() {
        return (C0402lh) this.b.getValue();
    }
}
