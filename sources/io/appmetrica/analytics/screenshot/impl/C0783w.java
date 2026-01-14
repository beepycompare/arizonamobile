package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.w  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0783w implements InterfaceC0770i {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1488a;
    public final U b;

    public C0783w(ClientContext clientContext, U u) {
        this.f1488a = clientContext;
        this.b = u;
    }

    @Override // io.appmetrica.analytics.screenshot.impl.InterfaceC0770i
    public final List<T> a() {
        return CollectionsKt.listOf((Object[]) new T[]{new C0765d(this.f1488a, this.b), new C0782v(this.f1488a, this.b), new g0(this.f1488a, this.b)});
    }
}
