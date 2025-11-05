package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes3.dex */
public final class R8 {

    /* renamed from: a  reason: collision with root package name */
    public final int f663a;
    public final W8 b;
    public T8 c;

    public R8(W8 w8, int i) {
        this.f663a = i;
        this.b = w8;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        T8 t8;
        int i;
        int i2;
        byte[] bArr;
        W8 w8 = this.b;
        w8.getClass();
        try {
            bArr = w8.c.get("event_hashes");
        } catch (Throwable unused) {
            U8 u8 = w8.f742a;
            w8.b.getClass();
            B9 b9 = new B9();
            u8.getClass();
            t8 = new T8(b9.f410a, b9.b, b9.c, CollectionUtils.hashSetFromIntArray(b9.d));
        }
        if (bArr != null && bArr.length != 0) {
            U8 u82 = w8.f742a;
            B9 state = w8.b.toState(bArr);
            u82.getClass();
            t8 = new T8(state.f410a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = t8;
            i = t8.c;
            i2 = this.f663a;
            if (i == i2) {
                t8.c = i2;
                t8.d = 0;
                W8 w82 = this.b;
                IBinaryDataHelper iBinaryDataHelper = w82.c;
                V8 v8 = w82.b;
                w82.f742a.getClass();
                iBinaryDataHelper.insert("event_hashes", v8.toByteArray((V8) U8.a(t8)));
                return;
            }
            return;
        }
        U8 u83 = w8.f742a;
        w8.b.getClass();
        B9 b92 = new B9();
        u83.getClass();
        t8 = new T8(b92.f410a, b92.b, b92.c, CollectionUtils.hashSetFromIntArray(b92.d));
        this.c = t8;
        i = t8.c;
        i2 = this.f663a;
        if (i == i2) {
        }
    }
}
