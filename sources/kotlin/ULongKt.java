package kotlin;

import com.facebook.internal.NativeProtocol;
/* compiled from: ULong.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\tH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\n\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u000bH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\f\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\rH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u000e\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0010\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u0011H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"toULong", "Lkotlin/ULong;", "", "(B)J", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.5", "Lkotlin/internal/InlineOnly;", "Lkotlin/internal/IntrinsicConstEvaluation;", "", "(S)J", "", "(I)J", "", "(J)J", "", "(F)J", "", "(D)J", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ULongKt {
    private static final long toULong(byte b) {
        return ULong.m10078constructorimpl(b);
    }

    private static final long toULong(short s) {
        return ULong.m10078constructorimpl(s);
    }

    private static final long toULong(int i) {
        return ULong.m10078constructorimpl(i);
    }

    private static final long toULong(long j) {
        return ULong.m10078constructorimpl(j);
    }

    private static final long toULong(float f) {
        return UnsignedKt.doubleToULong(f);
    }

    private static final long toULong(double d) {
        return UnsignedKt.doubleToULong(d);
    }
}
