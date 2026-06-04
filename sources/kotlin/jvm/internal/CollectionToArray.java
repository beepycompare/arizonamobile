package kotlin.jvm.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: CollectionToArray.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aY\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0087\u0080\u0004b\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\rb\u0016\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t¢\u0006\u0004\b\t\u0010\n\u001ak\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0087\u0080\u0004b\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\rb\u0016\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t¢\u0006\u0004\b\t\u0010\u0016\u001a\u007f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00192\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u001b2(\u0010\u001c\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u001dH\u0082\u0088\u0004¢\u0006\u0002\u0010\u001e\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0003\"\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "Lkotlin/Deprecated;", "message", "This function will be made internal in a future release", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.9", "errorSince", "2.1", "Lkotlin/jvm/JvmName;", "name", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CollectionToArray {
    private static final Object[] EMPTY = new Object[0];
    private static final int MAX_SIZE = 2147483645;

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.9")
    public static final Object[] toArray(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        Intrinsics.checkNotNullParameter(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i = 0;
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
        } else {
            Iterator<?> it = collection.iterator();
            if (!it.hasNext()) {
                if (objArr.length > 0) {
                    objArr[0] = null;
                }
            } else {
                if (size <= objArr.length) {
                    objArr2 = objArr;
                } else {
                    Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArr2 = (Object[]) newInstance;
                }
                while (true) {
                    int i2 = i + 1;
                    objArr2[i] = it.next();
                    if (i2 >= objArr2.length) {
                        if (!it.hasNext()) {
                            return objArr2;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = MAX_SIZE;
                            if (i2 >= MAX_SIZE) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i3);
                        Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        if (objArr2 == objArr) {
                            objArr[i2] = null;
                            return objArr;
                        }
                        Object[] copyOf = Arrays.copyOf(objArr2, i2);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                        return copyOf;
                    }
                    i = i2;
                }
            }
        }
        return objArr;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] toArrayImpl(Collection<?> collection, Function0<Object[]> function0, Function1<? super Integer, Object[]> function1, Function2<? super Object[], ? super Integer, Object[]> function2) {
        int size = collection.size();
        if (size == 0) {
            return function0.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return function0.invoke();
        }
        int i = 0;
        ?? r3 = function1.invoke(Integer.valueOf(size));
        while (true) {
            int i2 = i + 1;
            r3[i] = it.next();
            if (i2 >= r3.length) {
                if (!it.hasNext()) {
                    return r3;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    i3 = MAX_SIZE;
                    if (i2 >= MAX_SIZE) {
                        throw new OutOfMemoryError();
                    }
                }
                r3 = Arrays.copyOf((Object[]) r3, i3);
                Intrinsics.checkNotNullExpressionValue(r3, "copyOf(...)");
            } else if (!it.hasNext()) {
                return function2.invoke(r3, Integer.valueOf(i2));
            }
            i = i2;
            r3 = r3;
        }
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.9")
    public static final Object[] toArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        int size = collection.size();
        if (size == 0) {
            return EMPTY;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return EMPTY;
        }
        Object[] objArr = new Object[size];
        int i = 0;
        while (true) {
            int i2 = i + 1;
            objArr[i] = it.next();
            if (i2 >= objArr.length) {
                if (!it.hasNext()) {
                    return objArr;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    i3 = MAX_SIZE;
                    if (i2 >= MAX_SIZE) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr = Arrays.copyOf(objArr, i3);
                Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(...)");
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr, i2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                return copyOf;
            }
            i = i2;
        }
    }
}
