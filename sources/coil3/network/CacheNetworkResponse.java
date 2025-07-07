package coil3.network;

import coil3.network.NetworkHeaders;
import coil3.network.internal.UtilsKt;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import okio.BufferedSink;
import okio.BufferedSource;
/* compiled from: CacheNetworkResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcoil3/network/CacheNetworkResponse;", "", "<init>", "()V", "readFrom", "Lcoil3/network/NetworkResponse;", "source", "Lokio/BufferedSource;", "writeTo", "", "response", "sink", "Lokio/BufferedSink;", "coil-network-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CacheNetworkResponse {
    public static final CacheNetworkResponse INSTANCE = new CacheNetworkResponse();

    private CacheNetworkResponse() {
    }

    public final NetworkResponse readFrom(BufferedSource bufferedSource) {
        int parseInt = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        long parseLong = Long.parseLong(bufferedSource.readUtf8LineStrict());
        long parseLong2 = Long.parseLong(bufferedSource.readUtf8LineStrict());
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        int parseInt2 = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        for (int i = 0; i < parseInt2; i++) {
            UtilsKt.append(builder, bufferedSource.readUtf8LineStrict());
        }
        return new NetworkResponse(parseInt, parseLong, parseLong2, builder.build(), null, null, 48, null);
    }

    public final void writeTo(NetworkResponse networkResponse, BufferedSink bufferedSink) {
        bufferedSink.writeDecimalLong(networkResponse.getCode()).writeByte(10);
        bufferedSink.writeDecimalLong(networkResponse.getRequestMillis()).writeByte(10);
        bufferedSink.writeDecimalLong(networkResponse.getResponseMillis()).writeByte(10);
        Set<Map.Entry<String, List<String>>> entrySet = networkResponse.getHeaders().asMap().entrySet();
        Iterator<T> it = entrySet.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((List) ((Map.Entry) it.next()).getValue()).size();
        }
        bufferedSink.writeDecimalLong(i).writeByte(10);
        for (Map.Entry<String, List<String>> entry : entrySet) {
            for (String str : entry.getValue()) {
                bufferedSink.writeUtf8(entry.getKey()).writeUtf8(StringUtils.PROCESS_POSTFIX_DELIMITER).writeUtf8(str).writeByte(10);
            }
        }
    }
}
