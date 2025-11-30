package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
/* renamed from: io.appmetrica.analytics.idsync.impl.b  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0100b implements t {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f362a;

    public C0100b(ServiceContext serviceContext) {
        this.f362a = serviceContext;
    }

    @Override // io.appmetrica.analytics.idsync.impl.t
    public final boolean a() {
        return this.f362a.getActiveNetworkTypeProvider().getNetworkType(this.f362a.getContext()) == NetworkType.CELL;
    }
}
