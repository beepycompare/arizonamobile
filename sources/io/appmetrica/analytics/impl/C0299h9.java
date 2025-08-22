package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.h9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0299h9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f885a;
    public final C0427m9 b;
    public C0350j9 c;

    public C0299h9(C0427m9 c0427m9, int i) {
        this.f885a = i;
        this.b = c0427m9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0350j9 c0350j9;
        int i;
        int i2;
        byte[] bArr;
        C0427m9 c0427m9 = this.b;
        c0427m9.getClass();
        try {
            bArr = c0427m9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0376k9 c0376k9 = c0427m9.f966a;
            c0427m9.b.getClass();
            R9 r9 = new R9();
            c0376k9.getClass();
            c0350j9 = new C0350j9(r9.f632a, r9.b, r9.c, CollectionUtils.hashSetFromIntArray(r9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0376k9 c0376k92 = c0427m9.f966a;
            R9 state = c0427m9.b.toState(bArr);
            c0376k92.getClass();
            c0350j9 = new C0350j9(state.f632a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0350j9;
            i = c0350j9.c;
            i2 = this.f885a;
            if (i == i2) {
                c0350j9.c = i2;
                c0350j9.d = 0;
                C0427m9 c0427m92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0427m92.c;
                C0402l9 c0402l9 = c0427m92.b;
                c0427m92.f966a.getClass();
                R9 a2 = C0376k9.a(c0350j9);
                c0402l9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                return;
            }
            return;
        }
        C0376k9 c0376k93 = c0427m9.f966a;
        c0427m9.b.getClass();
        R9 r92 = new R9();
        c0376k93.getClass();
        c0350j9 = new C0350j9(r92.f632a, r92.b, r92.c, CollectionUtils.hashSetFromIntArray(r92.d));
        this.c = c0350j9;
        i = c0350j9.c;
        i2 = this.f885a;
        if (i == i2) {
        }
    }
}
