package io.appmetrica.analytics.networkapi;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lio/appmetrica/analytics/networkapi/NetworkClient;", "", "Lio/appmetrica/analytics/networkapi/Request;", "request", "Lio/appmetrica/analytics/networkapi/Call;", "newCall", "Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", "getSettings", "()Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", "settings", "<init>", "(Lio/appmetrica/analytics/networkapi/NetworkClientSettings;)V", "Builder", "network-api_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public abstract class NetworkClient {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkClientSettings f1371a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H&R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00028\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lio/appmetrica/analytics/networkapi/NetworkClient$Builder;", "", "Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", "settings", "withSettings", "Lio/appmetrica/analytics/networkapi/NetworkClient;", "build", "<set-?>", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", "getSettings", "()Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", "<init>", "()V", "network-api_release"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static abstract class Builder {

        /* renamed from: a  reason: collision with root package name */
        private NetworkClientSettings f1372a = new NetworkClientSettings.Builder().build();

        public abstract NetworkClient build();

        /* JADX INFO: Access modifiers changed from: protected */
        public final NetworkClientSettings getSettings() {
            return this.f1372a;
        }

        public final Builder withSettings(NetworkClientSettings networkClientSettings) {
            this.f1372a = networkClientSettings;
            return this;
        }
    }

    public NetworkClient(NetworkClientSettings networkClientSettings) {
        this.f1371a = networkClientSettings;
    }

    public final NetworkClientSettings getSettings() {
        return this.f1371a;
    }

    public abstract Call newCall(Request request);
}
