package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsItem;
import io.appmetrica.analytics.StartupParamsItemStatus;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* renamed from: io.appmetrica.analytics.impl.vm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0665vm {

    /* renamed from: a  reason: collision with root package name */
    public final C0717xm f1257a = new C0717xm();

    public final StartupParamsItem a(IdentifiersResult identifiersResult) {
        StartupParamsItemStatus startupParamsItemStatus;
        String str = identifiersResult.id;
        C0717xm c0717xm = this.f1257a;
        IdentifierStatus identifierStatus = identifiersResult.status;
        c0717xm.getClass();
        int i = AbstractC0691wm.f1276a[identifierStatus.ordinal()];
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
