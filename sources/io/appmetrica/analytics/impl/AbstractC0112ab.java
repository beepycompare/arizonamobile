package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.InternalModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.ab  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC0112ab {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f893a;

    static {
        int[] iArr = new int[InternalModuleEvent.Category.values().length];
        iArr[InternalModuleEvent.Category.SYSTEM.ordinal()] = 1;
        iArr[InternalModuleEvent.Category.GENERAL.ordinal()] = 2;
        f893a = iArr;
    }
}
