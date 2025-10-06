package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsItem;
import io.appmetrica.analytics.StartupParamsItemStatus;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* renamed from: io.appmetrica.analytics.impl.cm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0184cm {

    /* renamed from: a  reason: collision with root package name */
    public final C0235em f830a = new C0235em();

    public final StartupParamsItem a(IdentifiersResult identifiersResult) {
        StartupParamsItemStatus startupParamsItemStatus;
        String str = identifiersResult.id;
        C0235em c0235em = this.f830a;
        IdentifierStatus identifierStatus = identifiersResult.status;
        c0235em.getClass();
        switch (AbstractC0210dm.f851a[identifierStatus.ordinal()]) {
            case 1:
                startupParamsItemStatus = StartupParamsItemStatus.OK;
                break;
            case 2:
                startupParamsItemStatus = StartupParamsItemStatus.PROVIDER_UNAVAILABLE;
                break;
            case 3:
                startupParamsItemStatus = StartupParamsItemStatus.INVALID_VALUE_FROM_PROVIDER;
                break;
            case 4:
                startupParamsItemStatus = StartupParamsItemStatus.NETWORK_ERROR;
                break;
            case 5:
                startupParamsItemStatus = StartupParamsItemStatus.FEATURE_DISABLED;
                break;
            case 6:
                startupParamsItemStatus = StartupParamsItemStatus.FORBIDDEN_BY_CLIENT_CONFIG;
                break;
            default:
                startupParamsItemStatus = StartupParamsItemStatus.UNKNOWN_ERROR;
                break;
        }
        return new StartupParamsItem(str, startupParamsItemStatus, identifiersResult.errorExplanation);
    }
}
