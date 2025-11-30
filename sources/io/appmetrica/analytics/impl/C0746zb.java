package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.zb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0746zb implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f1232a;
    public final Lazy b = LazyKt.lazy(new C0721yb(this));

    public C0746zb(Y4 y4) {
        this.f1232a = y4;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final C0403lh getConfig() {
        return (C0403lh) this.b.getValue();
    }
}
