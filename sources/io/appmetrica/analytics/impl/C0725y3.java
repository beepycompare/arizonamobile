package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.y3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0725y3 extends AbstractC0165c3 {
    public C0725y3(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    public final int b() {
        return this.f820a;
    }

    @Override // io.appmetrica.analytics.impl.Rn
    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = this.f820a;
            if (length > i) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                this.c.warning("\"%s\" %s exceeded limit of %d bytes", this.b, bArr, Integer.valueOf(this.f820a));
                return bArr2;
            }
        }
        return bArr;
    }

    public final String a() {
        return this.b;
    }
}
