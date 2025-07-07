package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OrderedScatterSet.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J:\u0010\u0019\u001a\u00020\u001a2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010 \u001a\u00020\u001aJ:\u0010 \u001a\u00020\u001a2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"J\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0005H\u0007J:\u0010%\u001a\u00020\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u0010&\u001a\u00020\u001a2\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b)\u0010*J\u000b\u0010+\u001a\u00028\u0000¢\u0006\u0002\u0010,J?\u0010+\u001a\u00028\u00002!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010-JA\u0010.\u001a\u0004\u0018\u00018\u00002!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010-J:\u0010/\u001a\u0002002!\u00101\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002000\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J?\u00102\u001a\u0002002!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(3\u0012\u0004\u0012\u0002000\u001cH\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\b4J:\u00105\u001a\u0002002!\u00101\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002000\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u00106\u001a\u00020\u0005H\u0016J\u0006\u00107\u001a\u00020\u001aJ\u0006\u00108\u001a\u00020\u001aJR\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020<2\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020<2\u0016\b\u0002\u0010A\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020<\u0018\u00010\u001cH\u0007J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u0010,J?\u0010B\u001a\u00028\u00002!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010-JA\u0010C\u001a\u0004\u0018\u00018\u00002!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010-J\u0006\u0010D\u001a\u00020\u001aJ\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000FH\u0086\bJ\b\u0010G\u001a\u00020:H\u0016J:\u0010H\u001a\u0002002!\u00101\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002000\u001cH\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010I\u001a\u0002002!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(3\u0012\u0004\u0012\u0002000\u001cH\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001R\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\r\u0012\u0004\b\f\u0010\u0003R\u0018\u0010\u000e\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0003R\u0018\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u0018\u0010\u0013\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003R\u0011\u0010\u0015\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\tR\u0018\u0010\u0017\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u0082\u0001\u0001J\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006K"}, d2 = {"Landroidx/collection/OrderedScatterSet;", ExifInterface.LONGITUDE_EAST, "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "elements", "", "getElements$annotations", "[Ljava/lang/Object;", TtmlNode.TAG_HEAD, "getHead$annotations", TtmlNode.TAG_METADATA, "", "getMetadata$annotations", "nodes", "getNodes$annotations", "size", "getSize", "tail", "getTail$annotations", TtmlNode.COMBINE_ALL, "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "any", "asSet", "", "contains", "(Ljava/lang/Object;)Z", "count", "equals", "other", "findElementIndex", "findElementIndex$collection", "(Ljava/lang/Object;)I", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "forEach", "", "block", "forEachIndex", FirebaseAnalytics.Param.INDEX, "forEachIndex$collection", "forEachReverse", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastOrNull", "none", "toList", "", "toString", "unorderedForEach", "unorderedForEachIndex", "Landroidx/collection/MutableOrderedScatterSet;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class OrderedScatterSet<E> {
    public int _capacity;
    public int _size;
    public Object[] elements;
    public int head;
    public long[] metadata;
    public long[] nodes;
    public int tail;

    public /* synthetic */ OrderedScatterSet(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getHead$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getNodes$annotations() {
    }

    public static /* synthetic */ void getTail$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final String joinToString(CharSequence separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, null, 48, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return joinToString$default(this, separator, prefix, postfix, i, truncated, null, 32, null);
    }

    private OrderedScatterSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = ContainerHelpersKt.EMPTY_OBJECTS;
        this.nodes = SieveCacheKt.getEmptyNodes();
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean none() {
        return this._size == 0;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final void forEachIndex$collection(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.nodes;
        for (int i = this.tail; i != Integer.MAX_VALUE; i = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask)) {
            block.invoke(Integer.valueOf(i));
        }
    }

    public final void unorderedForEachIndex(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        block.invoke(Integer.valueOf((i << 3) + i3));
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    public final void forEach(Function1<? super E, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        for (int i = this.tail; i != Integer.MAX_VALUE; i = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask)) {
            block.invoke(objArr[i]);
        }
    }

    public final void forEachReverse(Function1<? super E, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        for (int i = this.head; i != Integer.MAX_VALUE; i = (int) (jArr[i] & SieveCacheKt.NodeLinkMask)) {
            block.invoke(objArr[i]);
        }
    }

    public final void unorderedForEach(Function1<? super E, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        block.invoke(objArr[(i << 3) + i3]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<E> toList() {
        ArrayList arrayList = new ArrayList(getSize());
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        for (int i = this.tail; i != Integer.MAX_VALUE; i = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask)) {
            arrayList.add(objArr[i]);
        }
        return arrayList;
    }

    public final int count() {
        return getSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String joinToString$default(OrderedScatterSet orderedScatterSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
                i = -1;
            }
            if ((i2 & 16) != 0) {
            }
            Function1<? super E, ? extends CharSequence> function12 = function1;
            if ((i2 & 32) != 0) {
                function12 = null;
            }
            CharSequence charSequence5 = charSequence4;
            Function1<? super E, ? extends CharSequence> function13 = function12;
            return orderedScatterSet.joinToString(charSequence, charSequence2, charSequence3, i, charSequence5, function13);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super E, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        int i2 = this.tail;
        int i3 = 0;
        while (true) {
            if (i2 == Integer.MAX_VALUE) {
                sb.append(postfix);
                break;
            }
            int i4 = (int) ((jArr[i2] >> 31) & SieveCacheKt.NodeLinkMask);
            Object obj = objArr[i2];
            if (i3 == i) {
                sb.append(truncated);
                break;
            }
            if (i3 != 0) {
                sb.append(separator);
            }
            if (function1 == null) {
                sb.append(obj);
            } else {
                sb.append(function1.invoke(obj));
            }
            i3++;
            i2 = i4;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public int hashCode() {
        int i = (this._capacity * 31) + this._size;
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            Object obj = objArr[(i2 << 3) + i4];
                            if (!Intrinsics.areEqual(obj, this)) {
                                i += obj != null ? obj.hashCode() : 0;
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return i;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OrderedScatterSet) {
            OrderedScatterSet orderedScatterSet = (OrderedScatterSet) obj;
            if (orderedScatterSet.getSize() != getSize()) {
                return false;
            }
            Object[] objArr = this.elements;
            long[] jArr = this.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128 && !orderedScatterSet.contains(objArr[(i << 3) + i3])) {
                                return false;
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new Function1<E, CharSequence>(this) { // from class: androidx.collection.OrderedScatterSet$toString$1
            final /* synthetic */ OrderedScatterSet<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
                return invoke((OrderedScatterSet$toString$1<E>) obj);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(E e) {
                if (e == this.this$0) {
                    return "(this)";
                }
                return String.valueOf(e);
            }
        }, 25, null);
    }

    public final Set<E> asSet() {
        return new OrderedSetWrapper(this);
    }

    public final E first() {
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        int i = this.tail;
        if (i == Integer.MAX_VALUE) {
            RuntimeHelpersKt.throwNoSuchElementExceptionForInline("The OrderedScatterSet is empty");
            throw new KotlinNothingValueException();
        }
        long j = jArr[i];
        return (E) objArr[i];
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [E, java.lang.Object] */
    public final E first(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        int i = this.tail;
        while (i != Integer.MAX_VALUE) {
            int i2 = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask);
            ?? r2 = (Object) objArr[i];
            if (predicate.invoke(r2).booleanValue()) {
                return r2;
            }
            i = i2;
        }
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("Could not find a match");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [E, java.lang.Object] */
    public final E firstOrNull(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        int i = this.tail;
        while (i != Integer.MAX_VALUE) {
            int i2 = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask);
            ?? r2 = (Object) objArr[i];
            if (predicate.invoke(r2).booleanValue()) {
                return r2;
            }
            i = i2;
        }
        return null;
    }

    public final E last() {
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        int i = this.head;
        if (i == Integer.MAX_VALUE) {
            RuntimeHelpersKt.throwNoSuchElementExceptionForInline("The OrderedScatterSet is empty");
            throw new KotlinNothingValueException();
        }
        long j = jArr[i];
        return (E) objArr[i];
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [E, java.lang.Object] */
    public final E last(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        int i = this.head;
        while (i != Integer.MAX_VALUE) {
            int i2 = (int) (jArr[i] & SieveCacheKt.NodeLinkMask);
            ?? r2 = (Object) objArr[i];
            if (predicate.invoke(r2).booleanValue()) {
                return r2;
            }
            i = i2;
        }
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("Could not find a match");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [E, java.lang.Object] */
    public final E lastOrNull(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        int i = this.head;
        while (i != Integer.MAX_VALUE) {
            int i2 = (int) (jArr[i] & SieveCacheKt.NodeLinkMask);
            ?? r2 = (Object) objArr[i];
            if (predicate.invoke(r2).booleanValue()) {
                return r2;
            }
            i = i2;
        }
        return null;
    }

    public final boolean all(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && !predicate.invoke(objArr[(i << 3) + i3]).booleanValue()) {
                        return false;
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final boolean any(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && predicate.invoke(objArr[(i << 3) + i3]).booleanValue()) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final int count(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128 && predicate.invoke(objArr[(i << 3) + i4]).booleanValue()) {
                        i2++;
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return i2;
                }
            }
            if (i == length) {
                return i2;
            }
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0070, code lost:
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean contains(E e) {
        int i;
        int hashCode = (e != null ? e.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (i3 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (Intrinsics.areEqual(this.elements[i], e)) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        return i >= 0;
    }

    public final int findElementIndex$collection(E e) {
        int i = 0;
        int hashCode = (e != null ? e.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = i2 >>> 7;
        while (true) {
            int i6 = i5 & i4;
            long[] jArr = this.metadata;
            int i7 = i6 >> 3;
            int i8 = (i6 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (i3 * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i4;
                if (Intrinsics.areEqual(this.elements[numberOfTrailingZeros], e)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i += 8;
            i5 = i6 + i;
        }
    }
}
