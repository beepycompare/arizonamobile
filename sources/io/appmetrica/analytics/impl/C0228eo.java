package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.eo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0228eo {
    public static final int[] c = {0, 1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f974a = new SparseArray();
    public int b = 0;

    public C0228eo(int[] iArr) {
        for (int i : iArr) {
            this.f974a.put(i, new HashMap());
        }
    }
}
