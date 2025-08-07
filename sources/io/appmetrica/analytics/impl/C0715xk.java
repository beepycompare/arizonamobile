package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.xk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0715xk implements ModuleRemoteConfig {

    /* renamed from: a  reason: collision with root package name */
    public final SdkIdentifiers f1140a;
    public final RemoteConfigMetaInfo b;
    public final Object c;

    public C0715xk(SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj) {
        this.f1140a = sdkIdentifiers;
        this.b = remoteConfigMetaInfo;
        this.c = obj;
    }

    public final C0715xk a(SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj) {
        return new C0715xk(sdkIdentifiers, remoteConfigMetaInfo, obj);
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
        if (obj instanceof C0715xk) {
            C0715xk c0715xk = (C0715xk) obj;
            return Intrinsics.areEqual(this.f1140a, c0715xk.f1140a) && Intrinsics.areEqual(this.b, c0715xk.b) && Intrinsics.areEqual(this.c, c0715xk.c);
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final Object getFeaturesConfig() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final SdkIdentifiers getIdentifiers() {
        return this.f1140a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final RemoteConfigMetaInfo getRemoteConfigMetaInfo() {
        return this.b;
    }

    public final int hashCode() {
        int hashCode = (this.b.hashCode() + (this.f1140a.hashCode() * 31)) * 31;
        Object obj = this.c;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "ServiceModuleRemoteConfigModel(identifiers=" + this.f1140a + ", remoteConfigMetaInfo=" + this.b + ", featuresConfig=" + this.c + ')';
    }

    public final SdkIdentifiers a() {
        return this.f1140a;
    }

    public static C0715xk a(C0715xk c0715xk, SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            sdkIdentifiers = c0715xk.f1140a;
        }
        if ((i & 2) != 0) {
            remoteConfigMetaInfo = c0715xk.b;
        }
        if ((i & 4) != 0) {
            obj = c0715xk.c;
        }
        c0715xk.getClass();
        return new C0715xk(sdkIdentifiers, remoteConfigMetaInfo, obj);
    }
}
