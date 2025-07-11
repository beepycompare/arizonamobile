package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class O {
    public static AdvIdentifiersResult.AdvId a(IdentifiersResult identifiersResult) {
        AdvIdentifiersResult.Details details;
        String str = identifiersResult == null ? null : identifiersResult.id;
        if (identifiersResult == null) {
            details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
        } else {
            switch (N.f544a[identifiersResult.status.ordinal()]) {
                case 1:
                    details = AdvIdentifiersResult.Details.OK;
                    break;
                case 2:
                    details = AdvIdentifiersResult.Details.NO_STARTUP;
                    break;
                case 3:
                    details = AdvIdentifiersResult.Details.FEATURE_DISABLED;
                    break;
                case 4:
                    details = AdvIdentifiersResult.Details.IDENTIFIER_PROVIDER_UNAVAILABLE;
                    break;
                case 5:
                    details = AdvIdentifiersResult.Details.INVALID_ADV_ID;
                    break;
                case 6:
                    details = AdvIdentifiersResult.Details.FORBIDDEN_BY_CLIENT_CONFIG;
                    break;
                default:
                    details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
                    break;
            }
        }
        return new AdvIdentifiersResult.AdvId(str, details, identifiersResult != null ? identifiersResult.errorExplanation : null);
    }
}
