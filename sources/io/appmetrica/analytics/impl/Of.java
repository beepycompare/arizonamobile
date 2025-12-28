package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public final class Of implements uo {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // io.appmetrica.analytics.impl.uo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(O8 o8, C0402lh c0402lh) {
        C0476og c0476og;
        String str;
        byte[] bytes;
        int ordinal;
        if (!TextUtils.isEmpty(o8.b)) {
            try {
                byte[] decode = Base64.decode(o8.b, 0);
                if (decode != null && decode.length != 0) {
                    c0476og = new C0476og(decode);
                    Wf wf = new Wf();
                    str = c0476og.f1148a;
                    if (str != null) {
                        bytes = new byte[0];
                    } else {
                        bytes = str.getBytes();
                    }
                    wf.f838a = bytes;
                    wf.c = c0476og.b;
                    wf.b = c0476og.c;
                    ordinal = c0476og.d.ordinal();
                    int i = 1;
                    if (ordinal != 1) {
                        i = 2;
                        if (ordinal != 2) {
                            i = 0;
                        }
                    }
                    wf.d = i;
                    return MessageNano.toByteArray(wf);
                }
                c0476og = null;
                Wf wf2 = new Wf();
                str = c0476og.f1148a;
                if (str != null) {
                }
                wf2.f838a = bytes;
                wf2.c = c0476og.b;
                wf2.b = c0476og.c;
                ordinal = c0476og.d.ordinal();
                int i2 = 1;
                if (ordinal != 1) {
                }
                wf2.d = i2;
                return MessageNano.toByteArray(wf2);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
