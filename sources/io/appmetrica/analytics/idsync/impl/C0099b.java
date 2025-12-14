package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
/* renamed from: io.appmetrica.analytics.idsync.impl.b  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0099b implements t {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f459a;

    public C0099b(ServiceContext serviceContext) {
        this.f459a = serviceContext;
    }

    @Override // io.appmetrica.analytics.idsync.impl.t
    public final boolean a() {
        return this.f459a.getActiveNetworkTypeProvider().getNetworkType(this.f459a.getContext()) == NetworkType.CELL;
    }
}
