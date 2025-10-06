package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.jo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0366jo {
    public static final int[] c = {0, 1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f944a = new SparseArray();
    public int b = 0;

    public C0366jo(int[] iArr) {
        for (int i : iArr) {
            this.f944a.put(i, new HashMap());
        }
    }
}
