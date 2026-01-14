package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
/* renamed from: io.appmetrica.analytics.idsync.impl.b  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0099b implements y {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f464a;

    public C0099b(ServiceContext serviceContext) {
        this.f464a = serviceContext;
    }

    @Override // io.appmetrica.analytics.idsync.impl.y
    public final boolean a() {
        return this.f464a.getActiveNetworkTypeProvider().getNetworkType(this.f464a.getContext()) == NetworkType.CELL;
    }
}
