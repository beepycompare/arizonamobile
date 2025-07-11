package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
/* loaded from: classes4.dex */
public abstract /* synthetic */ class N {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f544a;

    static {
        int[] iArr = new int[IdentifierStatus.values().length];
        f544a = iArr;
        try {
            iArr[IdentifierStatus.OK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f544a[IdentifierStatus.NO_STARTUP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f544a[IdentifierStatus.FEATURE_DISABLED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f544a[IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f544a[IdentifierStatus.INVALID_ADV_ID.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f544a[IdentifierStatus.FORBIDDEN_BY_CLIENT_CONFIG.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
