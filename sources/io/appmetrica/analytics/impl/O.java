package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class O {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f695a;

    static {
        int[] iArr = new int[IdentifierStatus.values().length];
        f695a = iArr;
        try {
            iArr[IdentifierStatus.OK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f695a[IdentifierStatus.NO_STARTUP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f695a[IdentifierStatus.FEATURE_DISABLED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f695a[IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f695a[IdentifierStatus.INVALID_ADV_ID.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f695a[IdentifierStatus.FORBIDDEN_BY_CLIENT_CONFIG.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
