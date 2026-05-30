package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
/* renamed from: io.appmetrica.analytics.idsync.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0100b implements y {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f419a;

    public C0100b(ServiceContext serviceContext) {
        this.f419a = serviceContext;
    }

    @Override // io.appmetrica.analytics.idsync.impl.y
    public final boolean a() {
        return this.f419a.getActiveNetworkTypeProvider().getNetworkType(this.f419a.getContext()) == NetworkType.CELL;
    }
}
