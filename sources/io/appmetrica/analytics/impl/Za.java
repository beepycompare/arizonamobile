package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.InternalModuleEvent;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class Za {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f884a;

    static {
        int[] iArr = new int[InternalModuleEvent.Category.values().length];
        iArr[InternalModuleEvent.Category.SYSTEM.ordinal()] = 1;
        iArr[InternalModuleEvent.Category.GENERAL.ordinal()] = 2;
        f884a = iArr;
    }
}
