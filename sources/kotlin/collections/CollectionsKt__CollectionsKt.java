package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0006\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002H\u0086\u0080\u0004\u001a/\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000b\u001a\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\u0002\b\f\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011b\u0002\b\f\u001a7\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0013j\b\u0012\u0004\u0012\u0002H\u0002`\u0014\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011b\u0002\b\f¢\u0006\u0002\u0010\u0015\u001a/\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000b\u001a9\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0013j\b\u0012\u0004\u0012\u0002H\u0002`\u0014\"\u0004\b\u0000\u0010\u00022\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0016\u001a)\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\b\b\u0000\u0010\u0002*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u0001H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u001a\u001a7\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\b\b\u0000\u0010\u0002*\u00020\u00182\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00020\u0003\"\u0004\u0018\u0001H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000b\u001aV\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u001c\u001a\u00020\u001d2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u00020\u001fH\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011b\u0002\b\fø\u0001\u0000\u001aV\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u001c\u001a\u00020\u001d2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u00020\u001fH\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011b\u0002\b\fø\u0001\u0000\u001a]\u0010$\u001a\b\u0012\u0004\u0012\u0002H%0\b\"\u0004\b\u0000\u0010%2#\b\u0001\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0\u000e\u0012\u0004\u0012\u00020'0\u001f¢\u0006\u0002\b(:\u0002\b)H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(*b\u0002\b\fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001ae\u0010$\u001a\b\u0012\u0004\u0012\u0002H%0\b\"\u0004\b\u0000\u0010%2\u0006\u0010+\u001a\u00020\u001d2#\b\u0001\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0\u000e\u0012\u0004\u0012\u00020'0\u001f¢\u0006\u0002\b(:\u0002\b)H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(*b\u0002\b\fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u001e\u00103\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u0088\u0004b\u0002\b\f\u001a?\u00104\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(5b\u0002\b\f\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a&\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004b\u0002\b\f\u001a&\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\bH\u0087\u0088\u0004b\u0002\b\f\u001a[\u00107\u001a\u0002H8\"\u0010\b\u0000\u00109*\u0006\u0012\u0002\b\u00030\u0001*\u0002H8\"\u0004\b\u0001\u00108*\u0002H92\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H80;H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(5b\u0002\b\fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010<\u001a1\u0010=\u001a\u00020\u0005\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b>*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u0088\u0004b\u0002\b\f\u001a6\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020@2\u0006\u0010A\u001a\u00020BH\u0087\u0080\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(5\u001a \u0010C\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0080\u0080\u0004\u001aI\u0010D\u001a\u00020\u001d\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020E*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u0001H\u00022\b\b\u0002\u0010F\u001a\u00020\u001d2\b\b\u0002\u0010G\u001a\u00020\u001dH\u0086\u0080\u0004¢\u0006\u0002\u0010H\u001aW\u0010D\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\u0019\u001a\u0002H\u00022\u001a\u0010I\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020Jj\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`K2\b\b\u0002\u0010F\u001a\u00020\u001d2\b\b\u0002\u0010G\u001a\u00020\u001dH\u0086\u0080\u0004¢\u0006\u0002\u0010L\u001ah\u0010M\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010N*\b\u0012\u0004\u0012\u0002HN0E*\b\u0012\u0004\u0012\u0002H\u00020\b2\b\u0010O\u001a\u0004\u0018\u0001HN2\b\b\u0002\u0010F\u001a\u00020\u001d2\b\b\u0002\u0010G\u001a\u00020\u001d2\u0016\b\u0004\u0010P\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001HN0\u001fH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010Q\u001aB\u0010D\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\b\b\u0002\u0010F\u001a\u00020\u001d2\b\b\u0002\u0010G\u001a\u00020\u001d2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001d0\u001fH\u0086\u0080\u0004\u001a'\u0010S\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001dH\u0082\u0080\u0004¢\u0006\u0002\bT\u001a\u001c\u0010U\u001a\u00020'H\u0081\u0080\u0004b\u0002\bVb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(5\u001a\u001c\u0010W\u001a\u00020'H\u0081\u0080\u0004b\u0002\bVb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(5\u001a#\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00032\n\u0010Y\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010Z\u001a5\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\n\u0010Y\u001a\u0006\u0012\u0002\b\u00030\u00012\f\u0010[\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0080\u0080\u0004¢\u0006\u0002\u0010\\\"\u001d\u0010,\u001a\u00020-*\u0006\u0012\u0002\b\u00030\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b.\u0010/\"%\u00100\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b1\u00102\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006]"}, d2 = {"asCollection", "", ExifInterface.GPS_DIRECTION_TRUE, "", "isVarargs", "", "([Ljava/lang/Object;Z)Ljava/util/Collection;", "emptyList", "", "listOf", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "Lkotlin/internal/InlineOnly;", "mutableListOf", "", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.1", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "()Ljava/util/ArrayList;", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "List", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "MutableList", "buildList", ExifInterface.LONGITUDE_EAST, "builderAction", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/BuilderInference;", "1.6", "capacity", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "(Ljava/util/List;)I", "isNotEmpty", "isNullOrEmpty", "1.3", "orEmpty", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "containsAll", "Lkotlin/internal/OnlyInputTypes;", "shuffled", "", "random", "Lkotlin/random/Random;", "optimizeReadOnlyList", "binarySearch", "", "fromIndex", "toIndex", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "comparison", "rangeCheck", "rangeCheck$CollectionsKt__CollectionsKt", "throwIndexOverflow", "Lkotlin/PublishedApi;", "throwCountOverflow", "collectionToArrayCommonImpl", "collection", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes5.dex */
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static final <T> Collection<T> asCollection(T[] tArr, boolean z) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayAsCollection(tArr, z);
    }

    public static /* synthetic */ Collection asCollection$default(Object[] objArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return CollectionsKt.asCollection(objArr, z);
    }

    public static final <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static final <T> List<T> listOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length > 0 ? ArraysKt.asList(elements) : CollectionsKt.emptyList();
    }

    private static final <T> List<T> listOf() {
        return CollectionsKt.emptyList();
    }

    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<>();
    }

    public static final <T> List<T> mutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(CollectionsKt.asCollection(elements, true));
    }

    public static final <T> ArrayList<T> arrayListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(CollectionsKt.asCollection(elements, true));
    }

    public static final <T> List<T> listOfNotNull(T t) {
        return t != null ? CollectionsKt.listOf(t) : CollectionsKt.emptyList();
    }

    public static final <T> List<T> listOfNotNull(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.filterNotNull(elements);
    }

    private static final <T> List<T> List(int i, Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(init.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    private static final <T> List<T> MutableList(int i, Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(init.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    private static final <E> List<E> buildList(Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List createListBuilder = CollectionsKt.createListBuilder();
        builderAction.invoke(createListBuilder);
        return CollectionsKt.build(createListBuilder);
    }

    private static final <E> List<E> buildList(int i, Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List createListBuilder = CollectionsKt.createListBuilder(i);
        builderAction.invoke(createListBuilder);
        return CollectionsKt.build(createListBuilder);
    }

    public static final IntRange getIndices(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    private static final <T> boolean isNotEmpty(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return !collection.isEmpty();
    }

    private static final <T> boolean isNullOrEmpty(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Collection<T> orEmpty(Collection<? extends T> collection) {
        return collection == 0 ? CollectionsKt.emptyList() : collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> orEmpty(List<? extends T> list) {
        return list == 0 ? CollectionsKt.emptyList() : list;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Collection collection, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return collection.isEmpty() ? defaultValue.invoke() : collection;
    }

    private static final <T> boolean containsAll(Collection<? extends T> collection, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return collection.containsAll(elements);
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        CollectionsKt.shuffle(mutableList, random);
        return mutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : CollectionsKt.listOf(list.get(0));
        }
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, comparable, i, i2);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compareValues = ComparisonsKt.compareValues(list.get(i4), t);
            if (compareValues < 0) {
                i = i4 + 1;
            } else if (compareValues <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, obj, comparator, i, i2);
    }

    public static final <T> int binarySearch(List<? extends T> list, T t, Comparator<? super T> comparator, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compare = comparator.compare((T) list.get(i4), t);
            if (compare < 0) {
                i = i4 + 1;
            } else if (compare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int binarySearchBy$default(List list, Comparable comparable, int i, int i2, Function1 selector, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return CollectionsKt.binarySearch(list, i, i2, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, comparable));
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> list, K k, int i, int i2, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return CollectionsKt.binarySearch(list, i, i2, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, k));
    }

    public static /* synthetic */ int binarySearch$default(List list, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, i, i2, function1);
    }

    public static final <T> int binarySearch(List<? extends T> list, int i, int i2, Function1<? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int intValue = comparison.invoke((T) list.get(i4)).intValue();
            if (intValue < 0) {
                i = i4 + 1;
            } else if (intValue <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 > i) {
            throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
        }
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final Object[] collectionToArrayCommonImpl(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        int i = 0;
        if (collection.isEmpty()) {
            return new Object[0];
        }
        Object[] objArr = new Object[collection.size()];
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    public static final <T> T[] collectionToArrayCommonImpl(Collection<?> collection, T[] array) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(array, "array");
        int i = 0;
        if (collection.isEmpty()) {
            return (T[]) CollectionsKt.terminateCollectionToArray(0, array);
        }
        int length = array.length;
        T[] tArr = array;
        if (length < collection.size()) {
            tArr = (T[]) ArraysKt.arrayOfNulls(array, collection.size());
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            tArr[i] = it.next();
            i++;
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(collection.size(), tArr);
    }
}
