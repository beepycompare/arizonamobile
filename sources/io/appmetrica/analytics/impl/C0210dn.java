package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.UnsupportedEncodingException;
/* renamed from: io.appmetrica.analytics.impl.dn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0210dn extends AbstractC0164c3 {
    public C0210dn(int i, String str) {
        this(i, str, PublicLogger.getAnonymousInstance());
    }

    public final int b() {
        return this.f815a;
    }

    public C0210dn(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Rn
    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            int i = this.f815a;
            if (length > i) {
                String str2 = new String(bytes, 0, i, "UTF-8");
                try {
                    this.c.warning("\"%s\" %s exceeded limit of %d bytes", this.b, str, Integer.valueOf(this.f815a));
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
