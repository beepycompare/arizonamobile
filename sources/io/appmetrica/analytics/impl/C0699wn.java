package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.UnsupportedEncodingException;
/* renamed from: io.appmetrica.analytics.impl.wn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0699wn extends Z2 {
    public C0699wn(int i, String str) {
        this(i, str, PublicLogger.getAnonymousInstance());
    }

    public final int b() {
        return this.f865a;
    }

    public C0699wn(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0493oo
    public final String a(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return str;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            int i = this.f865a;
            if (length > i) {
                String str2 = new String(bytes, 0, i, "UTF-8");
                try {
                    this.c.warning("\"%s\" %s exceeded limit of %d bytes", this.b, str, Integer.valueOf(this.f865a));
                } catch (UnsupportedEncodingException unused) {
                }
                return str2;
            }
            return str;
        } catch (UnsupportedEncodingException unused2) {
            return str;
        }
    }
}
