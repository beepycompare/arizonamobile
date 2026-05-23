package io.appmetrica.analytics.network.internal;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.network.impl.c;
import io.appmetrica.analytics.networkapi.NetworkClient;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lio/appmetrica/analytics/network/internal/NetworkClientBuilder;", "Lio/appmetrica/analytics/networkapi/NetworkClient$Builder;", "()V", "build", "Lio/appmetrica/analytics/networkapi/NetworkClient;", "network_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkClientBuilder extends NetworkClient.Builder {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [io.appmetrica.analytics.networkapi.NetworkClient$Builder] */
    @Override // io.appmetrica.analytics.networkapi.NetworkClient.Builder
    public NetworkClient build() {
        NetworkClientSettings settings = getSettings();
        String[] strArr = new String[3];
        Bundle applicationMetaData = NetworkClientServiceLocator.getInstance().getApplicationMetaData();
        c cVar = null;
        strArr[0] = applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.network.custom") : null;
        strArr[1] = "io.appmetrica.analytics.networkokhttp.internal.OkHttpNetworkClientBuilder";
        strArr[2] = "io.appmetrica.analytics.networklegacy.internal.LegacyNetworkClientBuilder";
        Iterator it = CollectionsKt.listOfNotNull((Object[]) strArr).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ?? r1 = (NetworkClient.Builder) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor((String) it.next(), NetworkClient.Builder.class);
            if (r1 != 0) {
                cVar = r1;
                break;
            }
        }
        if (cVar == null) {
            cVar = new c();
        }
        PublicLogger.Companion.getAnonymousInstance().info("Created " + cVar, new Object[0]);
        return cVar.withSettings(settings).build();
    }
}
