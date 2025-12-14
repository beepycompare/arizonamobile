package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Ym extends N2 {
    public Ym(int i, String str) {
        this(i, str, PublicLogger.getAnonymousInstance());
    }

    public final int b() {
        return this.f693a;
    }

    public Ym(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    @Override // io.appmetrica.analytics.impl.Mn
    public final String a(String str) {
        if (str != null) {
            int length = str.length();
            int i = this.f693a;
            if (length > i) {
                String substring = str.substring(0, i);
                this.c.warning("\"%s\" %s size exceeded limit of %d characters", this.b, str, Integer.valueOf(this.f693a));
                return substring;
            }
        }
        return str;
    }

    public final String a() {
        return this.b;
    }
}
