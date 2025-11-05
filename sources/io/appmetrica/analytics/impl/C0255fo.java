package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.fo  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0255fo {
    public static final int[] c = {0, 1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f882a = new SparseArray();
    public int b = 0;

    public C0255fo(int[] iArr) {
        for (int i : iArr) {
            this.f882a.put(i, new HashMap());
        }
    }
}
