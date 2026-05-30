package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.idsync.internal.model.NetworkType;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class w {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f438a;

    static {
        int[] iArr = new int[NetworkType.values().length];
        try {
            iArr[NetworkType.CELL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        f438a = iArr;
    }
}
