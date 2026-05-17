package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes5.dex */
public final class P {
    public static AdvIdentifiersResult.AdvId a(IdentifiersResult identifiersResult) {
        AdvIdentifiersResult.Details details;
        String str = identifiersResult == null ? null : identifiersResult.id;
        if (identifiersResult == null) {
            details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
        } else {
            int i = O.f721a[identifiersResult.status.ordinal()];
            if (i == 1) {
                details = AdvIdentifiersResult.Details.OK;
            } else if (i == 2) {
                details = AdvIdentifiersResult.Details.FEATURE_DISABLED;
            } else if (i == 3) {
                details = AdvIdentifiersResult.Details.IDENTIFIER_PROVIDER_UNAVAILABLE;
            } else if (i == 4) {
                details = AdvIdentifiersResult.Details.INVALID_ADV_ID;
            } else if (i != 5) {
                details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
            } else {
                details = AdvIdentifiersResult.Details.FORBIDDEN_BY_CLIENT_CONFIG;
            }
        }
        return new AdvIdentifiersResult.AdvId(str, details, identifiersResult != null ? identifiersResult.errorExplanation : null);
    }
}
