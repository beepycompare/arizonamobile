package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.w  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0782w implements InterfaceC0769i {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1492a;
    public final U b;

    public C0782w(ClientContext clientContext, U u) {
        this.f1492a = clientContext;
        this.b = u;
    }

    @Override // io.appmetrica.analytics.screenshot.impl.InterfaceC0769i
    public final List<T> a() {
        return CollectionsKt.listOf((Object[]) new T[]{new C0764d(this.f1492a, this.b), new C0781v(this.f1492a, this.b), new g0(this.f1492a, this.b)});
    }
}
