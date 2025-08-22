package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.fg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0254fg implements vo {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0015, B:11:0x001c, B:13:0x0025, B:15:0x002c, B:20:0x0043, B:14:0x0028), top: B:25:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // io.appmetrica.analytics.impl.vo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(C0325i9 c0325i9, Ch ch) {
        Fg fg;
        String str;
        byte[] bytes;
        int ordinal;
        if (!TextUtils.isEmpty(c0325i9.b)) {
            try {
                byte[] decode = Base64.decode(c0325i9.b, 0);
                if (decode != null && decode.length != 0) {
                    fg = new Fg(decode);
                    C0459ng c0459ng = new C0459ng();
                    str = fg.f436a;
                    if (str != null) {
                        bytes = new byte[0];
                    } else {
                        bytes = str.getBytes();
                    }
                    c0459ng.f984a = bytes;
                    c0459ng.c = fg.b;
                    c0459ng.b = fg.c;
                    ordinal = fg.d.ordinal();
                    int i = 1;
                    if (ordinal != 1) {
                        i = 2;
                        if (ordinal != 2) {
                            i = 0;
                        }
                    }
                    c0459ng.d = i;
                    return MessageNano.toByteArray(c0459ng);
                }
                fg = null;
                C0459ng c0459ng2 = new C0459ng();
                str = fg.f436a;
                if (str != null) {
                }
                c0459ng2.f984a = bytes;
                c0459ng2.c = fg.b;
                c0459ng2.b = fg.c;
                ordinal = fg.d.ordinal();
                int i2 = 1;
                if (ordinal != 1) {
                }
                c0459ng2.d = i2;
                return MessageNano.toByteArray(c0459ng2);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
