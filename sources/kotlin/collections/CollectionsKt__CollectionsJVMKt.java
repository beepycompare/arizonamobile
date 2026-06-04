package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001a5\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\u0007\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\bH\u0081\u0088\u0004b\u0002\b\n¢\u0006\u0002\u0010\t\u001aN\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0004\b\u0000\u0010\f2\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0081\u0088\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nø\u0001\u0000\u001aV\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0016\u001a\u00020\u00172\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0081\u0088\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nø\u0001\u0000\u001a(\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f\"\u0004\b\u0000\u0010\fH\u0081\u0080\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u001a0\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0081\u0080\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u001a6\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0004\b\u0000\u0010\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0081\u0080\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u001a$\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001cH\u0087\u0088\u0004b\u0002\b\n\u001a.\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0087\u0080\u0004b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f\u001a6\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0087\u0080\u0004b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f\u001a'\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\b2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%H\u0081\u0088\u0004b\u0002\b\n¢\u0006\u0002\u0010&\u001a9\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0081\u0088\u0004b\u0002\b\n¢\u0006\u0002\u0010(\u001a1\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010*\u001a\u00020\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0080\u0080\u0004¢\u0006\u0002\u0010+\u001a3\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010#0\b\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\b2\u0006\u0010-\u001a\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010/\u001a,\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0017H\u0081\u0088\bb\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nb\u0002\b2\u001a,\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0017H\u0081\u0088\bb\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nb\u0002\b2\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"listOf", "", ExifInterface.GPS_DIRECTION_TRUE, "element", "(Ljava/lang/Object;)Ljava/util/List;", "asArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "Lkotlin/internal/InlineOnly;", "buildListInternal", ExifInterface.LONGITUDE_EAST, "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/PublishedApi;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3", "capacity", "", "createListBuilder", "build", "builder", "toList", "Ljava/util/Enumeration;", "shuffled", "", "1.2", "random", "Ljava/util/Random;", "collectionToArray", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "terminateCollectionToArray", "collectionSize", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "checkIndexOverflow", FirebaseAnalytics.Param.INDEX, "Lkotlin/IgnorableReturnValue;", "checkCountOverflow", "count", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes5.dex */
public class CollectionsKt__CollectionsJVMKt {
    public static final <T> List<T> listOf(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(...)");
        return singletonList;
    }

    private static final <T> ArrayList<T> asArrayList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList<>(CollectionsKt.asCollection(tArr, true));
    }

    private static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List createListBuilder = CollectionsKt.createListBuilder();
        builderAction.invoke(createListBuilder);
        return CollectionsKt.build(createListBuilder);
    }

    private static final <E> List<E> buildListInternal(int i, Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List createListBuilder = CollectionsKt.createListBuilder(i);
        builderAction.invoke(createListBuilder);
        return CollectionsKt.build(createListBuilder);
    }

    public static final <E> List<E> createListBuilder() {
        return new ListBuilder(0, 1, null);
    }

    public static final <E> List<E> createListBuilder(int i) {
        return new ListBuilder(i);
    }

    public static final <E> List<E> build(List<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    private static final <T> List<T> toList(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        Intrinsics.checkNotNullExpressionValue(list, "list(...)");
        return list;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList, random);
        return mutableList;
    }

    private static final Object[] collectionToArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        return CollectionToArray.toArray(collection);
    }

    private static final <T> T[] collectionToArray(Collection<?> collection, T[] array) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(collection, array);
    }

    public static final <T> T[] terminateCollectionToArray(int i, T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (i < array.length) {
            array[i] = null;
        }
        return array;
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (z && Intrinsics.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    @IgnorableReturnValue
    private static final int checkIndexOverflow(int i) {
        if (i < 0) {
            CollectionsKt.throwIndexOverflow();
        }
        return i;
    }

    @IgnorableReturnValue
    private static final int checkCountOverflow(int i) {
        if (i < 0) {
            CollectionsKt.throwCountOverflow();
        }
        return i;
    }
}
