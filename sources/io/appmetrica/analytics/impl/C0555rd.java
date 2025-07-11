package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.rd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0555rd implements JsonParser, Converter {

    /* renamed from: a  reason: collision with root package name */
    public final RemoteConfigExtensionConfiguration f1025a;
    public final /* synthetic */ JsonParser b;
    public final /* synthetic */ Converter c;

    public C0555rd(RemoteConfigExtensionConfiguration<Object> remoteConfigExtensionConfiguration) {
        this.f1025a = remoteConfigExtensionConfiguration;
        this.b = remoteConfigExtensionConfiguration.getJsonParser();
        this.c = remoteConfigExtensionConfiguration.getProtobufConverter();
    }

    public final byte[] a(Object obj) {
        return (byte[]) this.c.fromModel(obj);
    }

    public final Object b(JSONObject jSONObject) {
        return this.b.parseOrNull(jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return (byte[]) this.c.fromModel(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    public final Object parse(JSONObject jSONObject) {
        return this.b.parse(jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Parser
    public final Object parseOrNull(JSONObject jSONObject) {
        return this.b.parseOrNull(jSONObject);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return this.c.toModel((byte[]) obj);
    }

    public final Object a(JSONObject jSONObject) {
        return this.b.parse(jSONObject);
    }

    public final Object a(byte[] bArr) {
        return this.c.toModel(bArr);
    }

    public final RemoteConfigExtensionConfiguration<Object> a() {
        return this.f1025a;
    }
}
