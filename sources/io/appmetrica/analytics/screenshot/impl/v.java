package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class v implements InterfaceC0786h {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1459a;
    public final C b;

    public v(ClientContext clientContext, C c) {
        this.f1459a = clientContext;
        this.b = c;
    }

    @Override // io.appmetrica.analytics.screenshot.impl.InterfaceC0786h
    public final List<B> a() {
        return CollectionsKt.listOf((Object[]) new B[]{new C0796s(this.f1459a, this.b), new M(this.f1459a, this.b)});
    }
}
