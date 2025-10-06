package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.k9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0377k9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f953a;
    public final C0507p9 b;
    public C0429m9 c;

    public C0377k9(C0507p9 c0507p9, int i) {
        this.f953a = i;
        this.b = c0507p9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0429m9 c0429m9;
        int i;
        int i2;
        byte[] bArr;
        C0507p9 c0507p9 = this.b;
        c0507p9.getClass();
        try {
            bArr = c0507p9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0455n9 c0455n9 = c0507p9.f1034a;
            c0507p9.b.getClass();
            U9 u9 = new U9();
            c0455n9.getClass();
            c0429m9 = new C0429m9(u9.f698a, u9.b, u9.c, CollectionUtils.hashSetFromIntArray(u9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0455n9 c0455n92 = c0507p9.f1034a;
            U9 state = c0507p9.b.toState(bArr);
            c0455n92.getClass();
            c0429m9 = new C0429m9(state.f698a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0429m9;
            i = c0429m9.c;
            i2 = this.f953a;
            if (i == i2) {
                c0429m9.c = i2;
                c0429m9.d = 0;
                C0507p9 c0507p92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0507p92.c;
                C0481o9 c0481o9 = c0507p92.b;
                c0507p92.f1034a.getClass();
                U9 a2 = C0455n9.a(c0429m9);
                c0481o9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                return;
            }
            return;
        }
        C0455n9 c0455n93 = c0507p9.f1034a;
        c0507p9.b.getClass();
        U9 u92 = new U9();
        c0455n93.getClass();
        c0429m9 = new C0429m9(u92.f698a, u92.b, u92.c, CollectionUtils.hashSetFromIntArray(u92.d));
        this.c = c0429m9;
        i = c0429m9.c;
        i2 = this.f953a;
        if (i == i2) {
        }
    }
}
