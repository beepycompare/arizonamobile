package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
/* renamed from: io.appmetrica.analytics.idsync.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0098b implements y {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f468a;

    public C0098b(ServiceContext serviceContext) {
        this.f468a = serviceContext;
    }

    @Override // io.appmetrica.analytics.idsync.impl.y
    public final boolean a() {
        return this.f468a.getActiveNetworkTypeProvider().getNetworkType(this.f468a.getContext()) == NetworkType.CELL;
    }
}
