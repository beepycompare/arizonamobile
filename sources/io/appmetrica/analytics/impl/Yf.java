package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public final class Yf implements no {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // io.appmetrica.analytics.impl.no
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(C0211d9 c0211d9, C0667vh c0667vh) {
        C0741yg c0741yg;
        String str;
        byte[] bytes;
        int ordinal;
        if (!TextUtils.isEmpty(c0211d9.b)) {
            try {
                byte[] decode = Base64.decode(c0211d9.b, 0);
                if (decode != null && decode.length != 0) {
                    c0741yg = new C0741yg(decode);
                    C0293gg c0293gg = new C0293gg();
                    str = c0741yg.f1146a;
                    if (str != null) {
                        bytes = new byte[0];
                    } else {
                        bytes = str.getBytes();
                    }
                    c0293gg.f855a = bytes;
                    c0293gg.c = c0741yg.b;
                    c0293gg.b = c0741yg.c;
                    ordinal = c0741yg.d.ordinal();
                    int i = 1;
                    if (ordinal != 1) {
                        i = 2;
                        if (ordinal != 2) {
                            i = 0;
                        }
                    }
                    c0293gg.d = i;
                    return MessageNano.toByteArray(c0293gg);
                }
                c0741yg = null;
                C0293gg c0293gg2 = new C0293gg();
                str = c0741yg.f1146a;
                if (str != null) {
                }
                c0293gg2.f855a = bytes;
                c0293gg2.c = c0741yg.b;
                c0293gg2.b = c0741yg.c;
                ordinal = c0741yg.d.ordinal();
                int i2 = 1;
                if (ordinal != 1) {
                }
                c0293gg2.d = i2;
                return MessageNano.toByteArray(c0293gg2);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
