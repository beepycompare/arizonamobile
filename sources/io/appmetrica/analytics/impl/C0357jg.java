package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.jg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0357jg implements zo {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // io.appmetrica.analytics.impl.zo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(C0402l9 c0402l9, Gh gh) {
        Jg jg;
        String str;
        byte[] bytes;
        int ordinal;
        if (!TextUtils.isEmpty(c0402l9.b)) {
            try {
                byte[] decode = Base64.decode(c0402l9.b, 0);
                if (decode != null && decode.length != 0) {
                    jg = new Jg(decode);
                    C0562rg c0562rg = new C0562rg();
                    str = jg.f520a;
                    if (str != null) {
                        bytes = new byte[0];
                    } else {
                        bytes = str.getBytes();
                    }
                    c0562rg.f1068a = bytes;
                    c0562rg.c = jg.b;
                    c0562rg.b = jg.c;
                    ordinal = jg.d.ordinal();
                    int i = 1;
                    if (ordinal != 1) {
                        i = 2;
                        if (ordinal != 2) {
                            i = 0;
                        }
                    }
                    c0562rg.d = i;
                    return MessageNano.toByteArray(c0562rg);
                }
                jg = null;
                C0562rg c0562rg2 = new C0562rg();
                str = jg.f520a;
                if (str != null) {
                }
                c0562rg2.f1068a = bytes;
                c0562rg2.c = jg.b;
                c0562rg2.b = jg.c;
                ordinal = jg.d.ordinal();
                int i2 = 1;
                if (ordinal != 1) {
                }
                c0562rg2.d = i2;
                return MessageNano.toByteArray(c0562rg2);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
