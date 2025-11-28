package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class I implements InterfaceC0767i {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1338a;
    public final U b;

    public I(ClientContext clientContext, U u) {
        this.f1338a = clientContext;
        this.b = u;
    }

    @Override // io.appmetrica.analytics.screenshot.impl.InterfaceC0767i
    public final List<T> a() {
        return CollectionsKt.listOf((Object[]) new T[]{new C0779v(this.f1338a, this.b), new g0(this.f1338a, this.b)});
    }
}
