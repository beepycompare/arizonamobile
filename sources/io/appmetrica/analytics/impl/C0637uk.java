package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.uk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0637uk implements ModuleRemoteConfig {

    /* renamed from: a  reason: collision with root package name */
    public final SdkIdentifiers f1080a;
    public final RemoteConfigMetaInfo b;
    public final Object c;

    public C0637uk(SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj) {
        this.f1080a = sdkIdentifiers;
        this.b = remoteConfigMetaInfo;
        this.c = obj;
    }

    public final C0637uk a(SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj) {
        return new C0637uk(sdkIdentifiers, remoteConfigMetaInfo, obj);
    }

    public final RemoteConfigMetaInfo b() {
        return this.b;
    }

    public final Object c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0637uk) {
            C0637uk c0637uk = (C0637uk) obj;
            return Intrinsics.areEqual(this.f1080a, c0637uk.f1080a) && Intrinsics.areEqual(this.b, c0637uk.b) && Intrinsics.areEqual(this.c, c0637uk.c);
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final Object getFeaturesConfig() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final SdkIdentifiers getIdentifiers() {
        return this.f1080a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final RemoteConfigMetaInfo getRemoteConfigMetaInfo() {
        return this.b;
    }

    public final int hashCode() {
        int hashCode = (this.b.hashCode() + (this.f1080a.hashCode() * 31)) * 31;
        Object obj = this.c;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "ServiceModuleRemoteConfigModel(identifiers=" + this.f1080a + ", remoteConfigMetaInfo=" + this.b + ", featuresConfig=" + this.c + ')';
    }

    public final SdkIdentifiers a() {
        return this.f1080a;
    }

    public static C0637uk a(C0637uk c0637uk, SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            sdkIdentifiers = c0637uk.f1080a;
        }
        if ((i & 2) != 0) {
            remoteConfigMetaInfo = c0637uk.b;
        }
        if ((i & 4) != 0) {
            obj = c0637uk.c;
        }
        c0637uk.getClass();
        return new C0637uk(sdkIdentifiers, remoteConfigMetaInfo, obj);
    }
}
