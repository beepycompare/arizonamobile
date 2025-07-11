package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Tm extends Z2 {
    public Tm(int i, String str) {
        this(i, str, PublicLogger.getAnonymousInstance());
    }

    public final int b() {
        return this.f731a;
    }

    public Tm(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    @Override // io.appmetrica.analytics.impl.Fn
    public final String a(String str) {
        if (str != null) {
            int length = str.length();
            int i = this.f731a;
            if (length > i) {
                String substring = str.substring(0, i);
                this.c.warning("\"%s\" %s size exceeded limit of %d characters", this.b, str, Integer.valueOf(this.f731a));
                return substring;
            }
        }
        return str;
    }

    public final String a() {
        return this.b;
    }
}
