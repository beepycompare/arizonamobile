package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.f9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0255f9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f844a;
    public final C0380k9 b;
    public C0306h9 c;

    public C0255f9(C0380k9 c0380k9, int i) {
        this.f844a = i;
        this.b = c0380k9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0306h9 c0306h9;
        int i;
        int i2;
        byte[] bArr;
        C0380k9 c0380k9 = this.b;
        c0380k9.getClass();
        try {
            bArr = c0380k9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0331i9 c0331i9 = c0380k9.f924a;
            c0380k9.b.getClass();
            P9 p9 = new P9();
            c0331i9.getClass();
            c0306h9 = new C0306h9(p9.f592a, p9.b, p9.c, CollectionUtils.hashSetFromIntArray(p9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0331i9 c0331i92 = c0380k9.f924a;
            P9 state = c0380k9.b.toState(bArr);
            c0331i92.getClass();
            c0306h9 = new C0306h9(state.f592a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0306h9;
            i = c0306h9.c;
            i2 = this.f844a;
            if (i == i2) {
                c0306h9.c = i2;
                c0306h9.d = 0;
                C0380k9 c0380k92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0380k92.c;
                C0355j9 c0355j9 = c0380k92.b;
                c0380k92.f924a.getClass();
                P9 a2 = C0331i9.a(c0306h9);
                c0355j9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                return;
            }
            return;
        }
        C0331i9 c0331i93 = c0380k9.f924a;
        c0380k9.b.getClass();
        P9 p92 = new P9();
        c0331i93.getClass();
        c0306h9 = new C0306h9(p92.f592a, p92.b, p92.c, CollectionUtils.hashSetFromIntArray(p92.d));
        this.c = c0306h9;
        i = c0306h9.c;
        i2 = this.f844a;
        if (i == i2) {
        }
    }
}
