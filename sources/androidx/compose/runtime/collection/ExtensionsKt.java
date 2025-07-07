package androidx.compose.runtime.collection;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001a3\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0005H\u0080\b\u001a>\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\u0005H\u0000\u001a\u001d\u0010\u000e\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a>\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\u0005H\u0000\u001aD\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\u0005H\u0000\u001a\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000¨\u0006\u0015"}, d2 = {TtmlNode.COMBINE_ALL, "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/ObjectList;", "predicate", "Lkotlin/Function1;", "fastFilter", "fastMap", "R", "transform", "isSorted", "K", "", "selector", "removeLast", "Landroidx/collection/MutableObjectList;", "(Landroidx/collection/MutableObjectList;)Ljava/lang/Object;", "sortBy", "", "sortedBy", "toMutableObjectList", "runtime_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtensionsKt {
    public static final <T, R> ObjectList<R> fastMap(ObjectList<T> objectList, Function1<? super T, ? extends R> function1) {
        MutableObjectList mutableObjectList = new MutableObjectList(objectList.getSize());
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            mutableObjectList.add(function1.invoke(objArr[i2]));
        }
        return mutableObjectList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> MutableObjectList<T> toMutableObjectList(ObjectList<T> objectList) {
        MutableObjectList<T> mutableObjectList = (MutableObjectList<T>) new MutableObjectList(objectList.getSize());
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            mutableObjectList.add(objArr[i2]);
        }
        return mutableObjectList;
    }

    public static final <T, K extends Comparable<? super K>> ObjectList<T> sortedBy(ObjectList<T> objectList, Function1<? super T, ? extends K> function1) {
        if (isSorted(objectList, function1)) {
            return objectList;
        }
        MutableObjectList mutableObjectList = toMutableObjectList(objectList);
        sortBy(mutableObjectList, function1);
        return mutableObjectList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Comparable] */
    public static final <T, K extends Comparable<? super K>> boolean isSorted(ObjectList<T> objectList, Function1<? super T, ? extends K> function1) {
        if (objectList.getSize() <= 1) {
            return true;
        }
        K invoke = function1.invoke(objectList.get(0));
        if (invoke == null) {
            return false;
        }
        int size = objectList.getSize();
        int i = 1;
        while (i < size) {
            K invoke2 = function1.invoke(objectList.get(i));
            if (invoke2 == null || invoke.compareTo(invoke2) > 0) {
                return false;
            }
            i++;
            invoke = invoke2;
        }
        return true;
    }

    public static final <T, K extends Comparable<? super K>> void sortBy(MutableObjectList<T> mutableObjectList, final Function1<? super T, ? extends K> function1) {
        List<T> asMutableList = mutableObjectList.asMutableList();
        if (asMutableList.size() > 1) {
            CollectionsKt.sortWith(asMutableList, new Comparator() { // from class: androidx.compose.runtime.collection.ExtensionsKt$sortBy$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Function1 function12 = Function1.this;
                    return ComparisonsKt.compareValues((Comparable) function12.invoke(t), (Comparable) function12.invoke(t2));
                }
            });
        }
    }

    public static final <T> T removeLast(MutableObjectList<T> mutableObjectList) {
        if (mutableObjectList.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        int size = mutableObjectList.getSize() - 1;
        T t = mutableObjectList.get(size);
        mutableObjectList.removeAt(size);
        return t;
    }

    public static final <T> ObjectList<T> fastFilter(ObjectList<T> objectList, Function1<? super T, Boolean> function1) {
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (!function1.invoke(objArr[i2]).booleanValue()) {
                MutableObjectList mutableObjectList = new MutableObjectList(0, 1, null);
                Object[] objArr2 = objectList.content;
                int i3 = objectList._size;
                for (int i4 = 0; i4 < i3; i4++) {
                    Object obj = objArr2[i4];
                    if (function1.invoke(obj).booleanValue()) {
                        mutableObjectList.add(obj);
                    }
                }
                return mutableObjectList;
            }
        }
        return objectList;
    }

    public static final <T> boolean all(ObjectList<T> objectList, Function1<? super T, Boolean> function1) {
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (!function1.invoke(objArr[i2]).booleanValue()) {
                return false;
            }
        }
        return true;
    }
}
