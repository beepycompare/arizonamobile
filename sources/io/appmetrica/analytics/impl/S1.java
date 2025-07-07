package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.internal.AppMetricaService;
/* loaded from: classes4.dex */
public final class S1 {
    public final Intent a(Context context, String str) {
        Intent intent = new Intent(context, AppMetricaService.class);
        intent.setAction(str);
        return intent;
    }
}
