package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes5.dex */
public final class M8 {

    /* renamed from: a  reason: collision with root package name */
    public final int f690a;
    public final R8 b;
    public O8 c;

    public M8(R8 r8, int i) {
        this.f690a = i;
        this.b = r8;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        O8 o8;
        int i;
        int i2;
        byte[] bArr;
        R8 r8 = this.b;
        r8.getClass();
        try {
            bArr = r8.c.get("event_hashes");
        } catch (Throwable unused) {
            P8 p8 = r8.f764a;
            r8.b.getClass();
            C0622u9 c0622u9 = new C0622u9();
            p8.getClass();
            o8 = new O8(c0622u9.f1254a, c0622u9.b, c0622u9.c, CollectionUtils.hashSetFromIntArray(c0622u9.d));
        }
        if (bArr != null && bArr.length != 0) {
            P8 p82 = r8.f764a;
            C0622u9 state = r8.b.toState(bArr);
            p82.getClass();
            o8 = new O8(state.f1254a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = o8;
            i = o8.c;
            i2 = this.f690a;
            if (i == i2) {
                o8.c = i2;
                o8.d = 0;
                R8 r82 = this.b;
                IBinaryDataHelper iBinaryDataHelper = r82.c;
                Q8 q8 = r82.b;
                r82.f764a.getClass();
                iBinaryDataHelper.insert("event_hashes", q8.toByteArray((Q8) P8.a(o8)));
                return;
            }
            return;
        }
        P8 p83 = r8.f764a;
        r8.b.getClass();
        C0622u9 c0622u92 = new C0622u9();
        p83.getClass();
        o8 = new O8(c0622u92.f1254a, c0622u92.b, c0622u92.c, CollectionUtils.hashSetFromIntArray(c0622u92.d));
        this.c = o8;
        i = o8.c;
        i2 = this.f690a;
        if (i == i2) {
        }
    }
}
