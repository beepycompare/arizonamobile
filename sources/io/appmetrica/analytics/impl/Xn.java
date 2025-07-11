package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Xn {
    public static final int[] c = {0, 1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f712a = new SparseArray();
    public int b = 0;

    public Xn(int[] iArr) {
        for (int i : iArr) {
            this.f712a.put(i, new HashMap());
        }
    }
}
