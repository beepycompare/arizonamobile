package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CoroutineContextImpl.kt */
@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a[\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010\u0005\u001aH\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¨\u0006\u0012"}, d2 = {"getPolymorphicElement", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3", "Lkotlin/ExperimentalStdlibApi;", "Lkotlin/Deprecated;", "message", "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "2.4", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.")
    @DeprecatedSinceKotlin(warningSince = "2.4")
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element element, CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            if (abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey())) {
                E e = (E) abstractCoroutineContextKey.tryCast$kotlin_stdlib(element);
                if (e instanceof CoroutineContext.Element) {
                    return e;
                }
            }
            return null;
        } else if (element.getKey() == key) {
            return element;
        } else {
            return null;
        }
    }

    @Deprecated(message = "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.")
    @DeprecatedSinceKotlin(warningSince = "2.4")
    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element element, CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(key instanceof AbstractCoroutineContextKey)) {
            return element.getKey() == key ? EmptyCoroutineContext.INSTANCE : element;
        }
        AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
        return (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey()) || abstractCoroutineContextKey.tryCast$kotlin_stdlib(element) == null) ? element : EmptyCoroutineContext.INSTANCE;
    }
}
