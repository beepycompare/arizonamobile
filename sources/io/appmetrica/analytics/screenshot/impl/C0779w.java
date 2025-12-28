package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.w  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0779w implements InterfaceC0766i {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1479a;
    public final U b;

    public C0779w(ClientContext clientContext, U u) {
        this.f1479a = clientContext;
        this.b = u;
    }

    @Override // io.appmetrica.analytics.screenshot.impl.InterfaceC0766i
    public final List<T> a() {
        return CollectionsKt.listOf((Object[]) new T[]{new C0761d(this.f1479a, this.b), new C0778v(this.f1479a, this.b), new g0(this.f1479a, this.b)});
    }
}
