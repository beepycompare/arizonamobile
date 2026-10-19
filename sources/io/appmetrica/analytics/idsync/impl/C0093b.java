package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
/* renamed from: io.appmetrica.analytics.idsync.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0093b implements y {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f424a;

    public C0093b(ServiceContext serviceContext) {
        this.f424a = serviceContext;
    }

    @Override // io.appmetrica.analytics.idsync.impl.y
    public final boolean a() {
        return this.f424a.getActiveNetworkTypeProvider().getNetworkType(this.f424a.getContext()) == NetworkType.CELL;
    }
}
