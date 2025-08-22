package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.bn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0158bn extends Z2 {
    public C0158bn(int i, String str) {
        this(i, str, PublicLogger.getAnonymousInstance());
    }

    public final int b() {
        return this.f752a;
    }

    public C0158bn(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    @Override // io.appmetrica.analytics.impl.Nn
    public final String a(String str) {
        if (str != null) {
            int length = str.length();
            int i = this.f752a;
            if (length > i) {
                String substring = str.substring(0, i);
                this.c.warning("\"%s\" %s size exceeded limit of %d characters", this.b, str, Integer.valueOf(this.f752a));
                return substring;
            }
        }
        return str;
    }

    public final String a() {
        return this.b;
    }
}
