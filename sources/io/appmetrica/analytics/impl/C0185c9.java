package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.c9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0185c9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f782a;
    public final C0311h9 b;
    public C0236e9 c;

    public C0185c9(C0311h9 c0311h9, int i) {
        this.f782a = i;
        this.b = c0311h9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0236e9 c0236e9;
        int i;
        int i2;
        byte[] bArr;
        C0311h9 c0311h9 = this.b;
        c0311h9.getClass();
        try {
            bArr = c0311h9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0261f9 c0261f9 = c0311h9.f865a;
            c0311h9.b.getClass();
            M9 m9 = new M9();
            c0261f9.getClass();
            c0236e9 = new C0236e9(m9.f532a, m9.b, m9.c, CollectionUtils.hashSetFromIntArray(m9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0261f9 c0261f92 = c0311h9.f865a;
            M9 state = c0311h9.b.toState(bArr);
            c0261f92.getClass();
            c0236e9 = new C0236e9(state.f532a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0236e9;
            i = c0236e9.c;
            i2 = this.f782a;
            if (i == i2) {
                c0236e9.c = i2;
                c0236e9.d = 0;
                C0311h9 c0311h92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0311h92.c;
                C0286g9 c0286g9 = c0311h92.b;
                c0311h92.f865a.getClass();
                M9 a2 = C0261f9.a(c0236e9);
                c0286g9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                return;
            }
            return;
        }
        C0261f9 c0261f93 = c0311h9.f865a;
        c0311h9.b.getClass();
        M9 m92 = new M9();
        c0261f93.getClass();
        c0236e9 = new C0236e9(m92.f532a, m92.b, m92.c, CollectionUtils.hashSetFromIntArray(m92.d));
        this.c = c0236e9;
        i = c0236e9.c;
        i2 = this.f782a;
        if (i == i2) {
        }
    }
}
