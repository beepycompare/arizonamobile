package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.fo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0262fo {
    public static final int[] c = {0, 1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f860a = new SparseArray();
    public int b = 0;

    public C0262fo(int[] iArr) {
        for (int i : iArr) {
            this.f860a.put(i, new HashMap());
        }
    }
}
