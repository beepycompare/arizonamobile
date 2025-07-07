package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes4.dex */
public abstract /* synthetic */ class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1290a;

    static {
        int[] iArr = new int[ActivityEvent.values().length];
        iArr[ActivityEvent.RESUMED.ordinal()] = 1;
        iArr[ActivityEvent.PAUSED.ordinal()] = 2;
        f1290a = iArr;
    }
}
