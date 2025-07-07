package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: JvmAnnotatedString.jvm.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a,\u0010\b\u001a\u00020\t*\u00020\t2\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0000¨\u0006\f"}, d2 = {"collectRangeTransitions", "", "ranges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", TypedValues.AttributesType.S_TARGET, "Ljava/util/SortedSet;", "", "transform", "Landroidx/compose/ui/text/AnnotatedString;", "Lkotlin/Function3;", "", "ui-text_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JvmAnnotatedString_jvmKt {
    public static final AnnotatedString transform(final AnnotatedString annotatedString, final Function3<? super String, ? super Integer, ? super Integer, String> function3) {
        ArrayList arrayList;
        TreeSet sortedSetOf = SetsKt.sortedSetOf(0, Integer.valueOf(annotatedString.getText().length()));
        collectRangeTransitions(annotatedString.getAnnotations$ui_text_release(), sortedSetOf);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(0, 0));
        CollectionsKt.windowed$default(sortedSetOf, 2, 0, false, new Function1<List<? extends Integer>, Integer>() { // from class: androidx.compose.ui.text.JvmAnnotatedString_jvmKt$transform$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.String] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Integer invoke2(List<Integer> list) {
                int intValue;
                int intValue2 = list.get(0).intValue();
                objectRef.element += function3.invoke(annotatedString.getText(), Integer.valueOf(intValue2), Integer.valueOf(intValue));
                return mutableMapOf.put(Integer.valueOf(list.get(1).intValue()), Integer.valueOf(objectRef.element.length()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(List<? extends Integer> list) {
                return invoke2((List<Integer>) list);
            }
        }, 6, null);
        List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release();
        if (annotations$ui_text_release != null) {
            ArrayList arrayList2 = new ArrayList(annotations$ui_text_release.size());
            int size = annotations$ui_text_release.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<? extends AnnotatedString.Annotation> range = annotations$ui_text_release.get(i);
                AnnotatedString.Annotation item = range.getItem();
                Object obj = mutableMapOf.get(Integer.valueOf(range.getStart()));
                Intrinsics.checkNotNull(obj);
                int intValue = ((Number) obj).intValue();
                Object obj2 = mutableMapOf.get(Integer.valueOf(range.getEnd()));
                Intrinsics.checkNotNull(obj2);
                arrayList2.add(new AnnotatedString.Range(item, intValue, ((Number) obj2).intValue()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new AnnotatedString(arrayList, (String) objectRef.element);
    }

    private static final void collectRangeTransitions(List<? extends AnnotatedString.Range<?>> list, SortedSet<Integer> sortedSet) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<?> range = list.get(i);
                sortedSet.add(Integer.valueOf(range.getStart()));
                sortedSet.add(Integer.valueOf(range.getEnd()));
            }
        }
    }
}
