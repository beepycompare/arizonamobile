package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.y5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0727y5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1166a;

    public C0727y5(String str) {
        this.f1166a = str;
    }

    public final PublicLogger a() {
        return LoggerStorage.getOrCreatePublicLogger(this.f1166a);
    }
}
