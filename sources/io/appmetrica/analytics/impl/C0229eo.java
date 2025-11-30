package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.eo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0229eo {
    public static final int[] c = {0, 1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f877a = new SparseArray();
    public int b = 0;

    public C0229eo(int[] iArr) {
        for (int i : iArr) {
            this.f877a.put(i, new HashMap());
        }
    }
}
