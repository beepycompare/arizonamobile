package io.appmetrica.analytics.impl;

import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.og  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0478og implements Wo {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[Catch: all -> 0x004d, TryCatch #0 {all -> 0x004d, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:22:0x0046, B:14:0x0028), top: B:27:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x004d, TryCatch #0 {all -> 0x004d, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:22:0x0046, B:14:0x0028), top: B:27:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // io.appmetrica.analytics.impl.Wo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(C0290h9 c0290h9, Eh eh) {
        Bg bg;
        String str;
        byte[] bytes;
        int a2;
        if (!StringUtils.isNullOrEmpty(c0290h9.b)) {
            try {
                byte[] decode = Base64.decode(c0290h9.b, 0);
                if (decode != null && decode.length != 0) {
                    bg = new Bg(decode);
                    C0685wg c0685wg = new C0685wg();
                    str = bg.f483a;
                    if (str != null) {
                        bytes = new byte[0];
                    } else {
                        bytes = str.getBytes();
                    }
                    c0685wg.f1272a = bytes;
                    c0685wg.c = bg.b;
                    c0685wg.b = bg.c;
                    a2 = AbstractC0160c8.a(bg.d);
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
                    c0685wg.d = i;
                    return MessageNano.toByteArray(c0685wg);
                }
                bg = null;
                C0685wg c0685wg2 = new C0685wg();
                str = bg.f483a;
                if (str != null) {
                }
                c0685wg2.f1272a = bytes;
                c0685wg2.c = bg.b;
                c0685wg2.b = bg.c;
                a2 = AbstractC0160c8.a(bg.d);
                int i2 = 1;
                if (a2 != 1) {
                }
                c0685wg2.d = i2;
                return MessageNano.toByteArray(c0685wg2);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
