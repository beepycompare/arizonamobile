package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0132ag implements qo {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // io.appmetrica.analytics.impl.qo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(C0280g9 c0280g9, C0711xh c0711xh) {
        Ag ag;
        String str;
        byte[] bytes;
        int ordinal;
        if (!TextUtils.isEmpty(c0280g9.b)) {
            try {
                byte[] decode = Base64.decode(c0280g9.b, 0);
                if (decode != null && decode.length != 0) {
                    ag = new Ag(decode);
                    C0336ig c0336ig = new C0336ig();
                    str = ag.f339a;
                    if (str != null) {
                        bytes = new byte[0];
                    } else {
                        bytes = str.getBytes();
                    }
                    c0336ig.f901a = bytes;
                    c0336ig.c = ag.b;
                    c0336ig.b = ag.c;
                    ordinal = ag.d.ordinal();
                    int i = 1;
                    if (ordinal != 1) {
                        i = 2;
                        if (ordinal != 2) {
                            i = 0;
                        }
                    }
                    c0336ig.d = i;
                    return MessageNano.toByteArray(c0336ig);
                }
                ag = null;
                C0336ig c0336ig2 = new C0336ig();
                str = ag.f339a;
                if (str != null) {
                }
                c0336ig2.f901a = bytes;
                c0336ig2.c = ag.b;
                c0336ig2.b = ag.c;
                ordinal = ag.d.ordinal();
                int i2 = 1;
                if (ordinal != 1) {
                }
                c0336ig2.d = i2;
                return MessageNano.toByteArray(c0336ig2);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
