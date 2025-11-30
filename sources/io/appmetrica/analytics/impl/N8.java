package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes5.dex */
public final class N8 {

    /* renamed from: a  reason: collision with root package name */
    public final int f601a;
    public final S8 b;
    public P8 c;

    public N8(S8 s8, int i) {
        this.f601a = i;
        this.b = s8;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        P8 p8;
        int i;
        int i2;
        byte[] bArr;
        S8 s8 = this.b;
        s8.getClass();
        try {
            bArr = s8.c.get("event_hashes");
        } catch (Throwable unused) {
            Q8 q8 = s8.f675a;
            s8.b.getClass();
            C0644v9 c0644v9 = new C0644v9();
            q8.getClass();
            p8 = new P8(c0644v9.f1166a, c0644v9.b, c0644v9.c, CollectionUtils.hashSetFromIntArray(c0644v9.d));
        }
        if (bArr != null && bArr.length != 0) {
            Q8 q82 = s8.f675a;
            C0644v9 state = s8.b.toState(bArr);
            q82.getClass();
            p8 = new P8(state.f1166a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = p8;
            i = p8.c;
            i2 = this.f601a;
            if (i == i2) {
                p8.c = i2;
                p8.d = 0;
                S8 s82 = this.b;
                IBinaryDataHelper iBinaryDataHelper = s82.c;
                R8 r8 = s82.b;
                s82.f675a.getClass();
                iBinaryDataHelper.insert("event_hashes", r8.toByteArray((R8) Q8.a(p8)));
                return;
            }
            return;
        }
        Q8 q83 = s8.f675a;
        s8.b.getClass();
        C0644v9 c0644v92 = new C0644v9();
        q83.getClass();
        p8 = new P8(c0644v92.f1166a, c0644v92.b, c0644v92.c, CollectionUtils.hashSetFromIntArray(c0644v92.d));
        this.c = p8;
        i = p8.c;
        i2 = this.f601a;
        if (i == i2) {
        }
    }
}
