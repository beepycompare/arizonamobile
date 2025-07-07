package io.appmetrica.analytics.networktasks.internal;

import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.network.internal.Response;
import io.appmetrica.analytics.networktasks.impl.a;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public class CacheControlHttpsConnectionPerformer {

    /* renamed from: a  reason: collision with root package name */
    private final a f1233a;
    private final SSLSocketFactory b;

    /* loaded from: classes4.dex */
    public interface Client {
        String getOldETag();

        void onError();

        void onNotModified();

        void onResponse(String str, byte[] bArr);
    }

    public CacheControlHttpsConnectionPerformer(SSLSocketFactory sSLSocketFactory) {
        this(new a(), sSLSocketFactory);
    }

    public void performConnection(String str, Client client) {
        Response a2;
        int code;
        try {
            a aVar = this.f1233a;
            String oldETag = client.getOldETag();
            SSLSocketFactory sSLSocketFactory = this.b;
            aVar.getClass();
            a2 = a.a(oldETag, str, sSLSocketFactory);
            code = a2.getCode();
        } catch (Throwable unused) {
        }
        if (code == 200) {
            List list = (List) CollectionUtils.getFromMapIgnoreCase(a2.getHeaders(), HttpHeaders.ETAG);
            client.onResponse((list == null || list.size() <= 0 || (r0 = (String) list.get(0)) == null) ? "" : "", a2.getResponseData());
        } else if (code == 304) {
            client.onNotModified();
        } else {
            client.onError();
        }
    }

    CacheControlHttpsConnectionPerformer(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.f1233a = aVar;
        this.b = sSLSocketFactory;
    }
}
