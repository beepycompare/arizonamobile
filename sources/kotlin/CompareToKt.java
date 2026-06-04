package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: compareTo.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\u008c\u0004b\u0002\b\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u0005¨\u0006\n"}, d2 = {"compareTo", "", ExifInterface.GPS_DIRECTION_TRUE, "", "other", "(Ljava/lang/Comparable;Ljava/lang/Object;)I", "Lkotlin/internal/InlineOnly;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.6", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CompareToKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> int compareTo(Comparable<? super T> comparable, T t) {
        Intrinsics.checkNotNullParameter(comparable, "<this>");
        return comparable.compareTo(t);
    }
}
