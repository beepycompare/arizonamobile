package io.appmetrica.analytics.networkokhttp.impl;

import io.appmetrica.analytics.networkapi.Call;
import io.appmetrica.analytics.networkapi.NetworkClient;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import io.appmetrica.analytics.networkapi.Request;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.OkHttpClient;
/* loaded from: classes5.dex */
public final class f extends NetworkClient {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f1382a;

    public f(NetworkClientSettings networkClientSettings) {
        this(networkClientSettings, null, 2, null);
    }

    @Override // io.appmetrica.analytics.networkapi.NetworkClient
    public final Call newCall(Request request) {
        return new c(this.f1382a, request, getSettings());
    }

    public final String toString() {
        return "OkHttpNetworkClient(settings=" + getSettings() + ')';
    }

    public /* synthetic */ f(NetworkClientSettings networkClientSettings, OkHttpClient okHttpClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkClientSettings, (i & 2) != 0 ? e.a(networkClientSettings) : okHttpClient);
    }

    public f(NetworkClientSettings networkClientSettings, OkHttpClient okHttpClient) {
        super(networkClientSettings);
        this.f1382a = okHttpClient;
    }
}
