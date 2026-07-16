package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
/* renamed from: io.appmetrica.analytics.impl.wm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC0698wm {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1273a;

    static {
        int[] iArr = new int[IdentifierStatus.values().length];
        try {
            iArr[IdentifierStatus.OK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[IdentifierStatus.INVALID_ADV_ID.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[IdentifierStatus.FEATURE_DISABLED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[IdentifierStatus.FORBIDDEN_BY_CLIENT_CONFIG.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f1273a = iArr;
    }
}
