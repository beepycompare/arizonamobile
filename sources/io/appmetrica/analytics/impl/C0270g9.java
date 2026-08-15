package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.g9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0270g9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f996a;
    public final C0399l9 b;
    public C0322i9 c;

    public C0270g9(C0399l9 c0399l9, int i) {
        this.f996a = i;
        this.b = c0399l9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0322i9 c0322i9;
        int i;
        int i2;
        byte[] bArr;
        C0399l9 c0399l9 = this.b;
        c0399l9.getClass();
        try {
            bArr = c0399l9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0347j9 c0347j9 = c0399l9.f1079a;
            c0399l9.b.getClass();
            O9 o9 = new O9();
            c0347j9.getClass();
            c0322i9 = new C0322i9(o9.f701a, o9.b, o9.c, CollectionUtils.hashSetFromIntArray(o9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0347j9 c0347j92 = c0399l9.f1079a;
            O9 state = c0399l9.b.toState(bArr);
            c0347j92.getClass();
            c0322i9 = new C0322i9(state.f701a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0322i9;
            i = c0322i9.c;
            i2 = this.f996a;
            if (i == i2) {
                c0322i9.c = i2;
                c0322i9.d = 0;
                C0399l9 c0399l92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0399l92.c;
                C0373k9 c0373k9 = c0399l92.b;
                c0399l92.f1079a.getClass();
                iBinaryDataHelper.insert("event_hashes", c0373k9.toByteArray((C0373k9) C0347j9.a(c0322i9)));
                return;
            }
            return;
        }
        C0347j9 c0347j93 = c0399l9.f1079a;
        c0399l9.b.getClass();
        O9 o92 = new O9();
        c0347j93.getClass();
        c0322i9 = new C0322i9(o92.f701a, o92.b, o92.c, CollectionUtils.hashSetFromIntArray(o92.d));
        this.c = c0322i9;
        i = c0322i9.c;
        i2 = this.f996a;
        if (i == i2) {
        }
    }
}
