package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Go {
    public static final int[] c = {0, 1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f567a = new SparseArray();
    public int b = 0;

    public Go(int[] iArr) {
        for (int i : iArr) {
            this.f567a.put(i, new HashMap());
        }
    }
}
