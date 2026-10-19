package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.g9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0264g9 {

    /* renamed from: a  reason: collision with root package name */
    public final int f999a;
    public final C0393l9 b;
    public C0316i9 c;

    public C0264g9(C0393l9 c0393l9, int i) {
        this.f999a = i;
        this.b = c0393l9;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        C0316i9 c0316i9;
        int i;
        int i2;
        byte[] bArr;
        C0393l9 c0393l9 = this.b;
        c0393l9.getClass();
        try {
            bArr = c0393l9.c.get("event_hashes");
        } catch (Throwable unused) {
            C0341j9 c0341j9 = c0393l9.f1082a;
            c0393l9.b.getClass();
            O9 o9 = new O9();
            c0341j9.getClass();
            c0316i9 = new C0316i9(o9.f704a, o9.b, o9.c, CollectionUtils.hashSetFromIntArray(o9.d));
        }
        if (bArr != null && bArr.length != 0) {
            C0341j9 c0341j92 = c0393l9.f1082a;
            O9 state = c0393l9.b.toState(bArr);
            c0341j92.getClass();
            c0316i9 = new C0316i9(state.f704a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            this.c = c0316i9;
            i = c0316i9.c;
            i2 = this.f999a;
            if (i == i2) {
                c0316i9.c = i2;
                c0316i9.d = 0;
                C0393l9 c0393l92 = this.b;
                IBinaryDataHelper iBinaryDataHelper = c0393l92.c;
                C0367k9 c0367k9 = c0393l92.b;
                c0393l92.f1082a.getClass();
                iBinaryDataHelper.insert("event_hashes", c0367k9.toByteArray((C0367k9) C0341j9.a(c0316i9)));
                return;
            }
            return;
        }
        C0341j9 c0341j93 = c0393l9.f1082a;
        c0393l9.b.getClass();
        O9 o92 = new O9();
        c0341j93.getClass();
        c0316i9 = new C0316i9(o92.f704a, o92.b, o92.c, CollectionUtils.hashSetFromIntArray(o92.d));
        this.c = c0316i9;
        i = c0316i9.c;
        i2 = this.f999a;
        if (i == i2) {
        }
    }
}
