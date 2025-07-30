package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.InternalModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.ub  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC0630ub {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1083a;

    static {
        int[] iArr = new int[InternalModuleEvent.Category.values().length];
        iArr[InternalModuleEvent.Category.SYSTEM.ordinal()] = 1;
        iArr[InternalModuleEvent.Category.GENERAL.ordinal()] = 2;
        f1083a = iArr;
    }
}
