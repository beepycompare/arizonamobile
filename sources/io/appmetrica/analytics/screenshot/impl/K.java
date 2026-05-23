package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class K {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1435a;

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
        f1435a = iArr;
    }
}
