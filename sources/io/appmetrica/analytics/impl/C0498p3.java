package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.p3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0498p3 extends Z2 {
    public C0498p3(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    public final int b() {
        return this.f865a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0493oo
    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = this.f865a;
            if (length > i) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                this.c.warning("\"%s\" %s exceeded limit of %d bytes", this.b, bArr, Integer.valueOf(this.f865a));
                return bArr2;
            }
        }
        return bArr;
    }

    public final String a() {
        return this.b;
    }
}
