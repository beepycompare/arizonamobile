package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.ao  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0140ao {
    public static final int[] c = {0, 1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f773a = new SparseArray();
    public int b = 0;

    public C0140ao(int[] iArr) {
        for (int i : iArr) {
            this.f773a.put(i, new HashMap());
        }
    }
}
