package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.b5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0132b5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f908a;

    public C0132b5(String str) {
        this.f908a = str;
    }

    public final PublicLogger a() {
        return LoggerStorage.getOrCreatePublicLogger(this.f908a);
    }
}
