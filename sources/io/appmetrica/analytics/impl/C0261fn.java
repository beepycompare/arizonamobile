package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.fn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0261fn extends AbstractC0164c3 {
    public C0261fn(int i, String str) {
        this(i, str, PublicLogger.getAnonymousInstance());
    }

    public final int b() {
        return this.f820a;
    }

    public C0261fn(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    @Override // io.appmetrica.analytics.impl.Rn
    public final String a(String str) {
        if (str != null) {
            int length = str.length();
            int i = this.f820a;
            if (length > i) {
                String substring = str.substring(0, i);
                this.c.warning("\"%s\" %s size exceeded limit of %d characters", this.b, str, Integer.valueOf(this.f820a));
                return substring;
            }
        }
        return str;
    }

    public final String a() {
        return this.b;
    }
}
