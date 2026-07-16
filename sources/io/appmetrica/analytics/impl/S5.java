package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class S5 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f761a;

    static {
        int[] iArr = new int[ActivityEvent.values().length];
        try {
            iArr[ActivityEvent.RESUMED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[ActivityEvent.PAUSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f761a = iArr;
    }
}
