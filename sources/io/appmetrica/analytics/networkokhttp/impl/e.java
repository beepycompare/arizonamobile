package io.appmetrica.analytics.networkokhttp.impl;

import io.appmetrica.analytics.networkapi.Call;
import io.appmetrica.analytics.networkapi.NetworkClient;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import io.appmetrica.analytics.networkapi.Request;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.OkHttpClient;
/* loaded from: classes5.dex */
public final class e extends NetworkClient {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f1395a;

    public e(NetworkClientSettings networkClientSettings) {
        this(networkClientSettings, null, 2, null);
    }

    @Override // io.appmetrica.analytics.networkapi.NetworkClient
    public final Call newCall(Request request) {
        return new c(this.f1395a, request, getSettings());
    }

    public final String toString() {
        return "OkHttpNetworkClient(settings=" + getSettings() + ')';
    }

    public /* synthetic */ e(NetworkClientSettings networkClientSettings, OkHttpClient okHttpClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkClientSettings, (i & 2) != 0 ? d.a(networkClientSettings) : okHttpClient);
    }

    public e(NetworkClientSettings networkClientSettings, OkHttpClient okHttpClient) {
        super(networkClientSettings);
        this.f1395a = okHttpClient;
    }
}
