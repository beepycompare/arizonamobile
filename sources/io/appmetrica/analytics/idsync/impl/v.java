package io.appmetrica.analytics.idsync.impl;
/* loaded from: classes3.dex */
public abstract /* synthetic */ class v {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f476a = {1, 2, 3, 4};

    public static /* synthetic */ int a(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] b(int i) {
        int[] iArr = new int[i];
        System.arraycopy(f476a, 0, iArr, 0, i);
        return iArr;
    }
}
