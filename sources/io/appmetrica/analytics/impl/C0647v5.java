package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.v5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0647v5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1086a;

    public C0647v5(String str) {
        this.f1086a = str;
    }

    public final PublicLogger a() {
        return LoggerStorage.getOrCreatePublicLogger(this.f1086a);
    }
}
