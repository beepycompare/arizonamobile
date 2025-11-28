package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public final class Sf implements vo {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // io.appmetrica.analytics.impl.vo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(S8 s8, C0503ph c0503ph) {
        C0576sg c0576sg;
        String str;
        byte[] bytes;
        int ordinal;
        if (!TextUtils.isEmpty(s8.b)) {
            try {
                byte[] decode = Base64.decode(s8.b, 0);
                if (decode != null && decode.length != 0) {
                    c0576sg = new C0576sg(decode);
                    C0118ag c0118ag = new C0118ag();
                    str = c0576sg.f1114a;
                    if (str != null) {
                        bytes = new byte[0];
                    } else {
                        bytes = str.getBytes();
                    }
                    c0118ag.f803a = bytes;
                    c0118ag.c = c0576sg.b;
                    c0118ag.b = c0576sg.c;
                    ordinal = c0576sg.d.ordinal();
                    int i = 1;
                    if (ordinal != 1) {
                        i = 2;
                        if (ordinal != 2) {
                            i = 0;
                        }
                    }
                    c0118ag.d = i;
                    return MessageNano.toByteArray(c0118ag);
                }
                c0576sg = null;
                C0118ag c0118ag2 = new C0118ag();
                str = c0576sg.f1114a;
                if (str != null) {
                }
                c0118ag2.f803a = bytes;
                c0118ag2.c = c0576sg.b;
                c0118ag2.b = c0576sg.c;
                ordinal = c0576sg.d.ordinal();
                int i2 = 1;
                if (ordinal != 1) {
                }
                c0118ag2.d = i2;
                return MessageNano.toByteArray(c0118ag2);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
