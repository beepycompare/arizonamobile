package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsItem;
import io.appmetrica.analytics.StartupParamsItemStatus;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes5.dex */
public final class Tl {

    /* renamed from: a  reason: collision with root package name */
    public final Vl f804a = new Vl();

    public final StartupParamsItem a(IdentifiersResult identifiersResult) {
        StartupParamsItemStatus startupParamsItemStatus;
        String str = identifiersResult.id;
        Vl vl = this.f804a;
        IdentifierStatus identifierStatus = identifiersResult.status;
        vl.getClass();
        int i = Ul.f817a[identifierStatus.ordinal()];
        if (i == 1) {
            startupParamsItemStatus = StartupParamsItemStatus.OK;
        } else if (i == 2) {
            startupParamsItemStatus = StartupParamsItemStatus.PROVIDER_UNAVAILABLE;
        } else if (i == 3) {
            startupParamsItemStatus = StartupParamsItemStatus.INVALID_VALUE_FROM_PROVIDER;
        } else if (i == 4) {
            startupParamsItemStatus = StartupParamsItemStatus.FEATURE_DISABLED;
        } else if (i != 5) {
            startupParamsItemStatus = StartupParamsItemStatus.UNKNOWN_ERROR;
        } else {
            startupParamsItemStatus = StartupParamsItemStatus.FORBIDDEN_BY_CLIENT_CONFIG;
        }
        return new StartupParamsItem(str, startupParamsItemStatus, identifiersResult.errorExplanation);
    }
}
