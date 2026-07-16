package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.q5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0526q5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1162a;

    public C0526q5(String str) {
        this.f1162a = str;
    }

    public final PublicLogger a() {
        return LoggerStorage.getOrCreatePublicLogger(this.f1162a);
    }
}
