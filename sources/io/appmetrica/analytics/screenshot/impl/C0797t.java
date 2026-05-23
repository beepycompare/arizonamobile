package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.t  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0797t implements InterfaceC0786h {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1457a;
    public final C b;

    public C0797t(ClientContext clientContext, C c) {
        this.f1457a = clientContext;
        this.b = c;
    }

    @Override // io.appmetrica.analytics.screenshot.impl.InterfaceC0786h
    public final List<B> a() {
        return CollectionsKt.listOf((Object[]) new B[]{new C0782d(this.f1457a, this.b), new C0796s(this.f1457a, this.b), new M(this.f1457a, this.b)});
    }
}
