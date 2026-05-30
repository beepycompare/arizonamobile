package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class D5 {

    /* renamed from: a  reason: collision with root package name */
    public final PublicLogger f507a;

    public D5(String str) {
        this.f507a = LoggerStorage.getOrCreatePublicLogger(str);
    }

    public final int a(int i) {
        if (i < 100) {
            this.f507a.warning("Value passed as maxReportsInDatabaseCount is invalid. Should be greater than or equal to 100, but was: " + i + ". Default value (100) will be used", new Object[0]);
            return 100;
        } else if (i > 10000) {
            this.f507a.warning("Value passed as maxReportsInDatabaseCount is invalid. Should be less than or equal to 10000, but was: " + i + ". Default value (10000) will be used", new Object[0]);
            return 10000;
        } else {
            return i;
        }
    }
}
