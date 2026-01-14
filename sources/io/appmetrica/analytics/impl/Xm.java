package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Xm extends M2 {
    public Xm(int i, String str) {
        this(i, str, PublicLogger.getAnonymousInstance());
    }

    public final int b() {
        return this.f685a;
    }

    public Xm(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    @Override // io.appmetrica.analytics.impl.Ln
    public final String a(String str) {
        if (str != null) {
            int length = str.length();
            int i = this.f685a;
            if (length > i) {
                String substring = str.substring(0, i);
                this.c.warning("\"%s\" %s size exceeded limit of %d characters", this.b, str, Integer.valueOf(this.f685a));
                return substring;
            }
        }
        return str;
    }

    public final String a() {
        return this.b;
    }
}
