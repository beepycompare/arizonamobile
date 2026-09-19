package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.g9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0269g9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f996a;
    public final C0398l9 b;
    public C0321i9 c;

    public C0269g9(C0398l9 c0398l9, int i) {
        this.f996a = i;
        this.b = c0398l9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0321i9 c0321i9;
        int i;
        int i2;
        byte[] bArr;
        C0398l9 c0398l9 = this.b;
        c0398l9.getClass();
        try {
            bArr = c0398l9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0346j9 c0346j9 = c0398l9.f1079a;
            c0398l9.b.getClass();
            O9 o9 = new O9();
            c0346j9.getClass();
            c0321i9 = new C0321i9(o9.f701a, o9.b, o9.c, CollectionUtils.hashSetFromIntArray(o9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0346j9 c0346j92 = c0398l9.f1079a;
            O9 state = c0398l9.b.toState(bArr);
            c0346j92.getClass();
            c0321i9 = new C0321i9(state.f701a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0321i9;
            i = c0321i9.c;
            i2 = this.f996a;
            if (i == i2) {
                c0321i9.c = i2;
                c0321i9.d = 0;
                C0398l9 c0398l92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0398l92.c;
                C0372k9 c0372k9 = c0398l92.b;
                c0398l92.f1079a.getClass();
                iBinaryDataHelper.insert("event_hashes", c0372k9.toByteArray((C0372k9) C0346j9.a(c0321i9)));
                return;
            }
            return;
        }
        C0346j9 c0346j93 = c0398l9.f1079a;
        c0398l9.b.getClass();
        O9 o92 = new O9();
        c0346j93.getClass();
        c0321i9 = new C0321i9(o92.f701a, o92.b, o92.c, CollectionUtils.hashSetFromIntArray(o92.d));
        this.c = c0321i9;
        i = c0321i9.c;
        i2 = this.f996a;
        if (i == i2) {
        }
    }
}
