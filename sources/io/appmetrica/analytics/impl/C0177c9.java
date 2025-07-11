package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.c9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0177c9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f783a;
    public final C0303h9 b;
    public C0228e9 c;

    public C0177c9(C0303h9 c0303h9, int i) {
        this.f783a = i;
        this.b = c0303h9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0228e9 c0228e9;
        int i;
        int i2;
        byte[] bArr;
        C0303h9 c0303h9 = this.b;
        c0303h9.getClass();
        try {
            bArr = c0303h9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0253f9 c0253f9 = c0303h9.f866a;
            c0303h9.b.getClass();
            M9 m9 = new M9();
            c0253f9.getClass();
            c0228e9 = new C0228e9(m9.f533a, m9.b, m9.c, CollectionUtils.hashSetFromIntArray(m9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0253f9 c0253f92 = c0303h9.f866a;
            M9 state = c0303h9.b.toState(bArr);
            c0253f92.getClass();
            c0228e9 = new C0228e9(state.f533a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0228e9;
            i = c0228e9.c;
            i2 = this.f783a;
            if (i == i2) {
                c0228e9.c = i2;
                c0228e9.d = 0;
                C0303h9 c0303h92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0303h92.c;
                C0278g9 c0278g9 = c0303h92.b;
                c0303h92.f866a.getClass();
                M9 a2 = C0253f9.a(c0228e9);
                c0278g9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                return;
            }
            return;
        }
        C0253f9 c0253f93 = c0303h9.f866a;
        c0303h9.b.getClass();
        M9 m92 = new M9();
        c0253f93.getClass();
        c0228e9 = new C0228e9(m92.f533a, m92.b, m92.c, CollectionUtils.hashSetFromIntArray(m92.d));
        this.c = c0228e9;
        i = c0228e9.c;
        i2 = this.f783a;
        if (i == i2) {
        }
    }
}
