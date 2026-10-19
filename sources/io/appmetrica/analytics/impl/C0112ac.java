package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0112ac implements ConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0441n5 f890a;
    public final Lazy b = LazyKt.lazy(new Zb(this));

    public C0112ac(C0441n5 c0441n5) {
        this.f890a = c0441n5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a */
    public final Eh getConfig() {
        return (Eh) this.b.getValue();
    }
}
