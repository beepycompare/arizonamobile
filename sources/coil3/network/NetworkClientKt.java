package coil3.network;

import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;
/* compiled from: NetworkClient.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"NetworkRequestBody", "Lcoil3/network/NetworkRequestBody;", "bytes", "Lokio/ByteString;", "NetworkResponseBody", "Lcoil3/network/NetworkResponseBody;", "source", "Lokio/BufferedSource;", "coil-network-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkClientKt {
    public static final NetworkRequestBody NetworkRequestBody(ByteString byteString) {
        return ByteStringNetworkRequestBody.m7777boximpl(ByteStringNetworkRequestBody.m7778constructorimpl(byteString));
    }

    public static final NetworkResponseBody NetworkResponseBody(BufferedSource bufferedSource) {
        return SourceResponseBody.m7786boximpl(SourceResponseBody.m7788constructorimpl(bufferedSource));
    }
}
