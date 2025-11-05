package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.an  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0125an extends U2 {
    public C0125an(int i, String str) {
        this(i, str, PublicLogger.getAnonymousInstance());
    }

    public final int b() {
        return this.f715a;
    }

    public C0125an(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    @Override // io.appmetrica.analytics.impl.Nn
    public final String a(String str) {
        if (str != null) {
            int length = str.length();
            int i = this.f715a;
            if (length > i) {
                String substring = str.substring(0, i);
                this.c.warning("\"%s\" %s size exceeded limit of %d characters", this.b, str, Integer.valueOf(this.f715a));
                return substring;
            }
        }
        return str;
    }

    public final String a() {
        return this.b;
    }
}
