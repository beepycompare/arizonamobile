package kotlin.io.encoding;

import com.facebook.internal.NativeProtocol;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Base64IOStream.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a(\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¨\u0006\n"}, d2 = {"decodingWith", "Ljava/io/InputStream;", "base64", "Lkotlin/io/encoding/Base64;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.8", "Lkotlin/io/encoding/ExperimentalEncodingApi;", "encodingWith", "Ljava/io/OutputStream;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/io/encoding/StreamEncodingKt")
/* loaded from: classes5.dex */
class StreamEncodingKt__Base64IOStreamKt {
    public static final InputStream decodingWith(InputStream inputStream, Base64 base64) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(base64, "base64");
        return new DecodeInputStream(inputStream, base64);
    }

    public static final OutputStream encodingWith(OutputStream outputStream, Base64 base64) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(base64, "base64");
        return new EncodeOutputStream(outputStream, base64);
    }
}
