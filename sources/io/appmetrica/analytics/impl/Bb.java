package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.InternalModuleEvent;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class Bb {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f473a;

    static {
        int[] iArr = new int[InternalModuleEvent.Category.values().length];
        try {
            iArr[InternalModuleEvent.Category.SYSTEM.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[InternalModuleEvent.Category.GENERAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f473a = iArr;
    }
}
