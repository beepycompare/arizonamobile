package io.appmetrica.analytics.networkokhttp.impl;

import io.appmetrica.analytics.networkapi.Request;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1392a;

    static {
        int[] iArr = new int[Request.Method.values().length];
        iArr[Request.Method.GET.ordinal()] = 1;
        iArr[Request.Method.POST.ordinal()] = 2;
        f1392a = iArr;
    }
}
