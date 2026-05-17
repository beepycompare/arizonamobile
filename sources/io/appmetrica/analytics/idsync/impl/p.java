package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
/* loaded from: classes5.dex */
public final class p implements s {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f482a;
    public final String b = "id_sync";

    public p(ServiceContext serviceContext) {
        this.f482a = serviceContext;
    }

    @Override // io.appmetrica.analytics.idsync.impl.s
    public final void a(String str, SdkIdentifiers sdkIdentifiers) {
        this.f482a.getSelfReporter().reportEvent(this.b, str);
    }
}
