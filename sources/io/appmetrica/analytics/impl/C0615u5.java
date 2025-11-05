package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.u5  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0615u5 {

    /* renamed from: a  reason: collision with root package name */
    public final PublicLogger f1144a;

    public C0615u5(String str) {
        this.f1144a = LoggerStorage.getOrCreatePublicLogger(str);
    }

    public final int a(int i) {
        if (i < 100) {
            this.f1144a.warning("Value passed as maxReportsInDatabaseCount is invalid. Should be greater than or equal to 100, but was: " + i + ". Default value (100) will be used", new Object[0]);
            return 100;
        } else if (i > 10000) {
            this.f1144a.warning("Value passed as maxReportsInDatabaseCount is invalid. Should be less than or equal to 10000, but was: " + i + ". Default value (10000) will be used", new Object[0]);
            return 10000;
        } else {
            return i;
        }
    }
}
