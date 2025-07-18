package kotlin.collections;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Arrays.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0004\u001aG\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\u00060\u0003¢\u0006\u0002\u0010\b\u001a)\u0010\t\u001a\u00020\n*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u000b\u001aH\u0010\f\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\r*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\u0002H\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001a5\u0010\u0011\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a?\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u001fH\u0002¢\u0006\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"flatten", "", ExifInterface.GPS_DIRECTION_TRUE, "", "([[Ljava/lang/Object;)Ljava/util/List;", "unzip", "Lkotlin/Pair;", "R", "([Lkotlin/Pair;)Lkotlin/Pair;", "isNullOrEmpty", "", "([Ljava/lang/Object;)Z", "ifEmpty", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contentDeepEqualsImpl", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes5.dex */
public class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public static final <T> List<T> flatten(T[][] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[][] tArr2 = tArr;
        int i = 0;
        for (T[] tArr3 : tArr2) {
            i += tArr3.length;
        }
        ArrayList arrayList = new ArrayList(i);
        int length = tArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            CollectionsKt.addAll(arrayList, tArr[i2]);
        }
        return arrayList;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "<this>");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    private static final boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Object[] objArr, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return objArr.length == 0 ? defaultValue.invoke() : objArr;
    }

    public static final <T> boolean contentDeepEquals(T[] tArr, T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            T t = tArr[i];
            T t2 = tArr2[i];
            if (t != t2) {
                if (t == null || t2 == null) {
                    return false;
                }
                if ((t instanceof Object[]) && (t2 instanceof Object[])) {
                    if (!ArraysKt.contentDeepEquals((Object[]) t, (Object[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof byte[]) && (t2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) t, (byte[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof short[]) && (t2 instanceof short[])) {
                    if (!Arrays.equals((short[]) t, (short[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof int[]) && (t2 instanceof int[])) {
                    if (!Arrays.equals((int[]) t, (int[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof long[]) && (t2 instanceof long[])) {
                    if (!Arrays.equals((long[]) t, (long[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof float[]) && (t2 instanceof float[])) {
                    if (!Arrays.equals((float[]) t, (float[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof double[]) && (t2 instanceof double[])) {
                    if (!Arrays.equals((double[]) t, (double[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof char[]) && (t2 instanceof char[])) {
                    if (!Arrays.equals((char[]) t, (char[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof boolean[]) && (t2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) t, (boolean[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof UByteArray) && (t2 instanceof UByteArray)) {
                    if (!UArraysKt.m9051contentEqualskV0jMPg(((UByteArray) t).m8561unboximpl(), ((UByteArray) t2).m8561unboximpl())) {
                        return false;
                    }
                } else if ((t instanceof UShortArray) && (t2 instanceof UShortArray)) {
                    if (!UArraysKt.m9049contentEqualsFGO6Aew(((UShortArray) t).m8824unboximpl(), ((UShortArray) t2).m8824unboximpl())) {
                        return false;
                    }
                } else if ((t instanceof UIntArray) && (t2 instanceof UIntArray)) {
                    if (!UArraysKt.m9050contentEqualsKJPZfPQ(((UIntArray) t).m8640unboximpl(), ((UIntArray) t2).m8640unboximpl())) {
                        return false;
                    }
                } else if ((t instanceof ULongArray) && (t2 instanceof ULongArray)) {
                    if (!UArraysKt.m9052contentEqualslec5QzE(((ULongArray) t).m8719unboximpl(), ((ULongArray) t2).m8719unboximpl())) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(t, t2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final <T> String contentDeepToString(T[] tArr) {
        if (tArr == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder((RangesKt.coerceAtMost(tArr.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(tArr, sb, new ArrayList());
        return sb.toString();
    }

    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            T t = tArr[i];
            if (t == null) {
                sb.append(AbstractJsonLexerKt.NULL);
            } else if (t instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt((Object[]) t, sb, list);
                Unit unit = Unit.INSTANCE;
            } else if (t instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
                sb.append(arrays);
            } else if (t instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays2, "toString(...)");
                sb.append(arrays2);
            } else if (t instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays3, "toString(...)");
                sb.append(arrays3);
            } else if (t instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays4, "toString(...)");
                sb.append(arrays4);
            } else if (t instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays5, "toString(...)");
                sb.append(arrays5);
            } else if (t instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays6, "toString(...)");
                sb.append(arrays6);
            } else if (t instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays7, "toString(...)");
                sb.append(arrays7);
            } else if (t instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays8, "toString(...)");
                sb.append(arrays8);
            } else if (t instanceof UByteArray) {
                UByteArray uByteArray = (UByteArray) t;
                sb.append(UArraysKt.m9057contentToString2csIQuQ(uByteArray != null ? uByteArray.m8561unboximpl() : null));
            } else if (t instanceof UShortArray) {
                UShortArray uShortArray = (UShortArray) t;
                sb.append(UArraysKt.m9059contentToStringd6D3K8(uShortArray != null ? uShortArray.m8824unboximpl() : null));
            } else if (t instanceof UIntArray) {
                UIntArray uIntArray = (UIntArray) t;
                sb.append(UArraysKt.m9058contentToStringXUkPCBk(uIntArray != null ? uIntArray.m8640unboximpl() : null));
            } else if (t instanceof ULongArray) {
                ULongArray uLongArray = (ULongArray) t;
                sb.append(UArraysKt.m9060contentToStringuLth9ew(uLongArray != null ? uLongArray.m8719unboximpl() : null));
            } else {
                sb.append(t.toString());
            }
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        list.remove(CollectionsKt.getLastIndex(list));
    }
}
