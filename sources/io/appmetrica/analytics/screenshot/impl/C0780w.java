package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.w  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0780w implements InterfaceC0767i {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1381a;
    public final U b;

    public C0780w(ClientContext clientContext, U u) {
        this.f1381a = clientContext;
        this.b = u;
    }

    @Override // io.appmetrica.analytics.screenshot.impl.InterfaceC0767i
    public final List<T> a() {
        return CollectionsKt.listOf((Object[]) new T[]{new C0762d(this.f1381a, this.b), new C0779v(this.f1381a, this.b), new g0(this.f1381a, this.b)});
    }
}
