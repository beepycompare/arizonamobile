package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Wk implements ModuleRemoteConfig {

    /* renamed from: a  reason: collision with root package name */
    public final SdkIdentifiers f829a;
    public final RemoteConfigMetaInfo b;
    public final Object c;

    public Wk(SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj) {
        this.f829a = sdkIdentifiers;
        this.b = remoteConfigMetaInfo;
        this.c = obj;
    }

    public final SdkIdentifiers a() {
        return this.f829a;
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
        if (obj instanceof Wk) {
            Wk wk = (Wk) obj;
            return Intrinsics.areEqual(this.f829a, wk.f829a) && Intrinsics.areEqual(this.b, wk.b) && Intrinsics.areEqual(this.c, wk.c);
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final Object getFeaturesConfig() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final SdkIdentifiers getIdentifiers() {
        return this.f829a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final RemoteConfigMetaInfo getRemoteConfigMetaInfo() {
        return this.b;
    }

    public final int hashCode() {
        int hashCode = (this.b.hashCode() + (this.f829a.hashCode() * 31)) * 31;
        Object obj = this.c;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "ServiceModuleRemoteConfigModel(identifiers=" + this.f829a + ", remoteConfigMetaInfo=" + this.b + ", featuresConfig=" + this.c + ')';
    }

    public final Wk a(SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj) {
        return new Wk(sdkIdentifiers, remoteConfigMetaInfo, obj);
    }

    public static Wk a(Wk wk, SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            sdkIdentifiers = wk.f829a;
        }
        if ((i & 2) != 0) {
            remoteConfigMetaInfo = wk.b;
        }
        if ((i & 4) != 0) {
            obj = wk.c;
        }
        wk.getClass();
        return new Wk(sdkIdentifiers, remoteConfigMetaInfo, obj);
    }
}
