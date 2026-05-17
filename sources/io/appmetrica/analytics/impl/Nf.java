package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public final class Nf implements to {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // io.appmetrica.analytics.impl.to
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(N8 n8, C0380kh c0380kh) {
        C0454ng c0454ng;
        String str;
        byte[] bytes;
        int ordinal;
        if (!TextUtils.isEmpty(n8.b)) {
            try {
                byte[] decode = Base64.decode(n8.b, 0);
                if (decode != null && decode.length != 0) {
                    c0454ng = new C0454ng(decode);
                    Vf vf = new Vf();
                    str = c0454ng.f1142a;
                    if (str != null) {
                        bytes = new byte[0];
                    } else {
                        bytes = str.getBytes();
                    }
                    vf.f833a = bytes;
                    vf.c = c0454ng.b;
                    vf.b = c0454ng.c;
                    ordinal = c0454ng.d.ordinal();
                    int i = 1;
                    if (ordinal != 1) {
                        i = 2;
                        if (ordinal != 2) {
                            i = 0;
                        }
                    }
                    vf.d = i;
                    return MessageNano.toByteArray(vf);
                }
                c0454ng = null;
                Vf vf2 = new Vf();
                str = c0454ng.f1142a;
                if (str != null) {
                }
                vf2.f833a = bytes;
                vf2.c = c0454ng.b;
                vf2.b = c0454ng.c;
                ordinal = c0454ng.d.ordinal();
                int i2 = 1;
                if (ordinal != 1) {
                }
                vf2.d = i2;
                return MessageNano.toByteArray(vf2);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
