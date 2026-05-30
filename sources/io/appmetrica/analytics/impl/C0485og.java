package io.appmetrica.analytics.impl;

import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.og  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0485og implements Wo {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[Catch: all -> 0x004d, TryCatch #0 {all -> 0x004d, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:22:0x0046, B:14:0x0028), top: B:27:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x004d, TryCatch #0 {all -> 0x004d, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:22:0x0046, B:14:0x0028), top: B:27:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // io.appmetrica.analytics.impl.Wo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(C0297h9 c0297h9, Eh eh) {
        Bg bg;
        String str;
        byte[] bytes;
        int a2;
        if (!StringUtils.isNullOrEmpty(c0297h9.b)) {
            try {
                byte[] decode = Base64.decode(c0297h9.b, 0);
                if (decode != null && decode.length != 0) {
                    bg = new Bg(decode);
                    C0692wg c0692wg = new C0692wg();
                    str = bg.f478a;
                    if (str != null) {
                        bytes = new byte[0];
                    } else {
                        bytes = str.getBytes();
                    }
                    c0692wg.f1267a = bytes;
                    c0692wg.c = bg.b;
                    c0692wg.b = bg.c;
                    a2 = AbstractC0167c8.a(bg.d);
                    int i = 1;
                    if (a2 != 1) {
                        i = 2;
                        if (a2 != 2) {
                            i = 3;
                            if (a2 != 3) {
                                i = 0;
                            }
                        }
                    }
                    c0692wg.d = i;
                    return MessageNano.toByteArray(c0692wg);
                }
                bg = null;
                C0692wg c0692wg2 = new C0692wg();
                str = bg.f478a;
                if (str != null) {
                }
                c0692wg2.f1267a = bytes;
                c0692wg2.c = bg.b;
                c0692wg2.b = bg.c;
                a2 = AbstractC0167c8.a(bg.d);
                int i2 = 1;
                if (a2 != 1) {
                }
                c0692wg2.d = i2;
                return MessageNano.toByteArray(c0692wg2);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
