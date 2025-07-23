package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.f9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0254f9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f844a;
    public final C0379k9 b;
    public C0305h9 c;

    public C0254f9(C0379k9 c0379k9, int i) {
        this.f844a = i;
        this.b = c0379k9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0305h9 c0305h9;
        int i;
        int i2;
        byte[] bArr;
        C0379k9 c0379k9 = this.b;
        c0379k9.getClass();
        try {
            bArr = c0379k9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0330i9 c0330i9 = c0379k9.f924a;
            c0379k9.b.getClass();
            P9 p9 = new P9();
            c0330i9.getClass();
            c0305h9 = new C0305h9(p9.f592a, p9.b, p9.c, CollectionUtils.hashSetFromIntArray(p9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0330i9 c0330i92 = c0379k9.f924a;
            P9 state = c0379k9.b.toState(bArr);
            c0330i92.getClass();
            c0305h9 = new C0305h9(state.f592a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0305h9;
            i = c0305h9.c;
            i2 = this.f844a;
            if (i == i2) {
                c0305h9.c = i2;
                c0305h9.d = 0;
                C0379k9 c0379k92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0379k92.c;
                C0354j9 c0354j9 = c0379k92.b;
                c0379k92.f924a.getClass();
                P9 a2 = C0330i9.a(c0305h9);
                c0354j9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                return;
            }
            return;
        }
        C0330i9 c0330i93 = c0379k9.f924a;
        c0379k9.b.getClass();
        P9 p92 = new P9();
        c0330i93.getClass();
        c0305h9 = new C0305h9(p92.f592a, p92.b, p92.c, CollectionUtils.hashSetFromIntArray(p92.d));
        this.c = c0305h9;
        i = c0305h9.c;
        i2 = this.f844a;
        if (i == i2) {
        }
    }
}
