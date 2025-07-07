package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Stack.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\r\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u0019J\r\u0010\u001c\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010 J\r\u0010!\u001a\u00028\u0000¢\u0006\u0004\b\"\u0010\u001eJ\u0015\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00028\u0000¢\u0006\u0004\b%\u0010\u0014J\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0088\u0001\u0003\u0092\u0001\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u0005¨\u0006."}, d2 = {"Landroidx/compose/runtime/Stack;", ExifInterface.GPS_DIRECTION_TRUE, "", "backing", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "constructor-impl", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "size", "", "getSize-impl", "(Ljava/util/ArrayList;)I", "clear", "", "clear-impl", "(Ljava/util/ArrayList;)V", "equals", "", "other", "equals-impl", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "(Ljava/util/ArrayList;)Z", "isNotEmpty", "isNotEmpty-impl", "peek", "peek-impl", "(Ljava/util/ArrayList;)Ljava/lang/Object;", FirebaseAnalytics.Param.INDEX, "(Ljava/util/ArrayList;I)Ljava/lang/Object;", "pop", "pop-impl", Constants.PUSH, "value", "push-impl", "toArray", "", "toArray-impl", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "toString", "", "toString-impl", "(Ljava/util/ArrayList;)Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Stack<T> {
    private final ArrayList<T> backing;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Stack m3502boximpl(ArrayList arrayList) {
        return new Stack(arrayList);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> ArrayList<T> m3504constructorimpl(ArrayList<T> arrayList) {
        return arrayList;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3506equalsimpl(ArrayList<T> arrayList, Object obj) {
        return (obj instanceof Stack) && Intrinsics.areEqual(arrayList, ((Stack) obj).m3518unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3507equalsimpl0(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
        return Intrinsics.areEqual(arrayList, arrayList2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3509hashCodeimpl(ArrayList<T> arrayList) {
        return arrayList.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3517toStringimpl(ArrayList<T> arrayList) {
        return "Stack(backing=" + arrayList + ')';
    }

    public boolean equals(Object obj) {
        return m3506equalsimpl(this.backing, obj);
    }

    public int hashCode() {
        return m3509hashCodeimpl(this.backing);
    }

    public String toString() {
        return m3517toStringimpl(this.backing);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ ArrayList m3518unboximpl() {
        return this.backing;
    }

    private /* synthetic */ Stack(ArrayList arrayList) {
        this.backing = arrayList;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ ArrayList m3505constructorimpl$default(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            arrayList = new ArrayList();
        }
        return m3504constructorimpl(arrayList);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static final int m3508getSizeimpl(ArrayList<T> arrayList) {
        return arrayList.size();
    }

    /* renamed from: push-impl  reason: not valid java name */
    public static final boolean m3515pushimpl(ArrayList<T> arrayList, T t) {
        return arrayList.add(t);
    }

    /* renamed from: pop-impl  reason: not valid java name */
    public static final T m3514popimpl(ArrayList<T> arrayList) {
        return arrayList.remove(m3508getSizeimpl(arrayList) - 1);
    }

    /* renamed from: peek-impl  reason: not valid java name */
    public static final T m3512peekimpl(ArrayList<T> arrayList) {
        return arrayList.get(m3508getSizeimpl(arrayList) - 1);
    }

    /* renamed from: peek-impl  reason: not valid java name */
    public static final T m3513peekimpl(ArrayList<T> arrayList, int i) {
        return arrayList.get(i);
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static final boolean m3510isEmptyimpl(ArrayList<T> arrayList) {
        return arrayList.isEmpty();
    }

    /* renamed from: isNotEmpty-impl  reason: not valid java name */
    public static final boolean m3511isNotEmptyimpl(ArrayList<T> arrayList) {
        return !m3510isEmptyimpl(arrayList);
    }

    /* renamed from: clear-impl  reason: not valid java name */
    public static final void m3503clearimpl(ArrayList<T> arrayList) {
        arrayList.clear();
    }

    /* renamed from: toArray-impl  reason: not valid java name */
    public static final T[] m3516toArrayimpl(ArrayList<T> arrayList) {
        int size = arrayList.size();
        T[] tArr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            tArr[i] = arrayList.get(i);
        }
        return tArr;
    }
}
