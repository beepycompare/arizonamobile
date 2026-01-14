package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.do  reason: invalid class name */
/* loaded from: classes5.dex */
public final class Cdo {
    public static final int[] c = {0, 1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f965a = new SparseArray();
    public int b = 0;

    public Cdo(int[] iArr) {
        for (int i : iArr) {
            this.f965a.put(i, new HashMap());
        }
    }
}
