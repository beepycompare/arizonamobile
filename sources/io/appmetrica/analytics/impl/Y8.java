package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class Y8 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f856a;

    static {
        int[] iArr = new int[ModuleEvent.Category.values().length];
        try {
            iArr[ModuleEvent.Category.GENERAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[ModuleEvent.Category.SYSTEM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f856a = iArr;
    }
}
