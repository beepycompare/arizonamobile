package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.g9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0271g9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f994a;
    public final C0400l9 b;
    public C0323i9 c;

    public C0271g9(C0400l9 c0400l9, int i) {
        this.f994a = i;
        this.b = c0400l9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0323i9 c0323i9;
        int i;
        int i2;
        byte[] bArr;
        C0400l9 c0400l9 = this.b;
        c0400l9.getClass();
        try {
            bArr = c0400l9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0348j9 c0348j9 = c0400l9.f1077a;
            c0400l9.b.getClass();
            O9 o9 = new O9();
            c0348j9.getClass();
            c0323i9 = new C0323i9(o9.f699a, o9.b, o9.c, CollectionUtils.hashSetFromIntArray(o9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0348j9 c0348j92 = c0400l9.f1077a;
            O9 state = c0400l9.b.toState(bArr);
            c0348j92.getClass();
            c0323i9 = new C0323i9(state.f699a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0323i9;
            i = c0323i9.c;
            i2 = this.f994a;
            if (i == i2) {
                c0323i9.c = i2;
                c0323i9.d = 0;
                C0400l9 c0400l92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0400l92.c;
                C0374k9 c0374k9 = c0400l92.b;
                c0400l92.f1077a.getClass();
                iBinaryDataHelper.insert("event_hashes", c0374k9.toByteArray((C0374k9) C0348j9.a(c0323i9)));
                return;
            }
            return;
        }
        C0348j9 c0348j93 = c0400l9.f1077a;
        c0400l9.b.getClass();
        O9 o92 = new O9();
        c0348j93.getClass();
        c0323i9 = new C0323i9(o92.f699a, o92.b, o92.c, CollectionUtils.hashSetFromIntArray(o92.d));
        this.c = c0323i9;
        i = c0323i9.c;
        i2 = this.f994a;
        if (i == i2) {
        }
    }
}
