package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
/* renamed from: io.appmetrica.analytics.idsync.impl.b  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0100b implements t {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f359a;

    public C0100b(ServiceContext serviceContext) {
        this.f359a = serviceContext;
    }

    @Override // io.appmetrica.analytics.idsync.impl.t
    public final boolean a() {
        return this.f359a.getActiveNetworkTypeProvider().getNetworkType(this.f359a.getContext()) == NetworkType.CELL;
    }
}
