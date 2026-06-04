package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeepRecursive.kt */
@Metadata(d1 = {"\u00002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005\"\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0011*r\b\u0002\u0010\t\"5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\r\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\u000e25\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\r\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\u000e¨\u0006\u0012"}, d2 = {"invoke", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/DeepRecursiveFunction;", "value", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.7", "DeepRecursiveFunctionBlock", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "UNDEFINED_RESULT", "Lkotlin/Result;", "Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeepRecursiveKt {
    private static final Object UNDEFINED_RESULT;

    public static final <T, R> R invoke(DeepRecursiveFunction<T, R> deepRecursiveFunction, T t) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "<this>");
        return (R) new DeepRecursiveScopeImpl(deepRecursiveFunction.getBlock$kotlin_stdlib(), t).runCallLoop();
    }

    static {
        Result.Companion companion = Result.Companion;
        UNDEFINED_RESULT = Result.m9896constructorimpl(IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }
}
