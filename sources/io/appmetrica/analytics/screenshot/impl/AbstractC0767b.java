package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* renamed from: io.appmetrica.analytics.screenshot.impl.b  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC0767b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1290a;

    static {
        int[] iArr = new int[ActivityEvent.values().length];
        iArr[ActivityEvent.STARTED.ordinal()] = 1;
        iArr[ActivityEvent.STOPPED.ordinal()] = 2;
        f1290a = iArr;
    }
}
