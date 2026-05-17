package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class I implements InterfaceC0769i {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1451a;
    public final U b;

    public I(ClientContext clientContext, U u) {
        this.f1451a = clientContext;
        this.b = u;
    }

    @Override // io.appmetrica.analytics.screenshot.impl.InterfaceC0769i
    public final List<T> a() {
        return CollectionsKt.listOf((Object[]) new T[]{new C0781v(this.f1451a, this.b), new g0(this.f1451a, this.b)});
    }
}
