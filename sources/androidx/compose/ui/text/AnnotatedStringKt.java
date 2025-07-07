package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: AnnotatedString.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\"\u0010\t\u001a\u00020\u00012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0086\b\u001a@\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\u0018\u00010\u00102\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u00102\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0010H\u0002\u001a(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0000\u001a\b\u0010\u001c\u001a\u00020\u0001H\u0000\u001aD\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0\u0011\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u001e0\u0011\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0002\u001a(\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0018H\u0000\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010(\u001a\u00020)\u001a\u0014\u0010*\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010(\u001a\u00020)\u001aD\u0010+\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\u0018\u00010\u0010*\u00020\u00012\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000bH\u0002\u001a*\u0010-\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0011\u0018\u00010\u0010*\u00020\u00012\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0002\u001aa\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0010\"\u0004\b\u0000\u0010\u001e*\u00020\u00012\u0006\u0010/\u001a\u00020\u00062>\b\u0004\u00100\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H\u001e01H\u0080\b\u001a \u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0010*\u00020\u00012\u0006\u0010/\u001a\u00020\u0006H\u0000\u001a\u001c\u00106\u001a\u00020\u0001*\u00020\u00012\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0002\u001a\u0014\u00107\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010(\u001a\u00020)\u001a\u0014\u00108\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010(\u001a\u00020)\u001a?\u00109\u001a\u0002H:\"\b\b\u0000\u0010:*\u00020;*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0019\b\u0004\u00100\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H:0\u000b¢\u0006\u0002\b\u000eH\u0086\b¢\u0006\u0002\u0010>\u001a?\u00109\u001a\u0002H:\"\b\b\u0000\u0010:*\u00020;*\u00020\f2\u0006\u0010?\u001a\u00020@2\u0019\b\u0004\u00100\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H:0\u000b¢\u0006\u0002\b\u000eH\u0087\b¢\u0006\u0002\u0010A\u001aG\u00109\u001a\u0002H:\"\b\b\u0000\u0010:*\u00020;*\u00020\f2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0019\b\u0004\u00100\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H:0\u000b¢\u0006\u0002\b\u000eH\u0086\b¢\u0006\u0002\u0010D\u001a@\u0010E\u001a\u0002H:\"\b\b\u0000\u0010:*\u00020;*\u00020F2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H:0\u000b¢\u0006\u0002\b\u000eH\u0000¢\u0006\u0002\u0010I\u001a=\u0010J\u001a\u0002H:\"\b\b\u0000\u0010:*\u00020;*\u00020\f2\u0006\u0010K\u001a\u00020L2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H:0\u000b¢\u0006\u0002\b\u000eH\u0086\b¢\u0006\u0002\u0010M\u001a?\u0010N\u001a\u0002H:\"\b\b\u0000\u0010:*\u00020;*\u00020\f2\u0006\u0010O\u001a\u00020\u00062\u0019\b\u0004\u00100\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H:0\u000b¢\u0006\u0002\b\u000eH\u0086\b¢\u0006\u0002\u0010P\u001a=\u0010N\u001a\u0002H:\"\b\b\u0000\u0010:*\u00020;*\u00020\f2\u0006\u0010O\u001a\u00020\b2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H:0\u000b¢\u0006\u0002\b\u000eH\u0086\b¢\u0006\u0002\u0010Q\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"EmptyAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "AnnotatedString", "text", "", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "buildAnnotatedString", "builder", "Lkotlin/Function1;", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "", "Lkotlin/ExtensionFunctionType;", "constructAnnotationsFromSpansAndParagraphs", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "spanStyles", "paragraphStyles", "contains", "", "baseStart", "", "baseEnd", "targetStart", "targetEnd", "emptyAnnotatedString", "filterRanges", ExifInterface.GPS_DIRECTION_TRUE, "ranges", TtmlNode.START, TtmlNode.END, "intersect", "lStart", "lEnd", "rStart", "rEnd", "capitalize", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "decapitalize", "getLocalAnnotations", "predicate", "getLocalParagraphStyles", "mapEachParagraphStyle", "defaultParagraphStyle", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "annotatedString", "normalizedParagraphStyles", "substringWithoutParagraphStyles", "toLowerCase", "toUpperCase", "withAnnotation", "R", "", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/TtsAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/UrlAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tag", "annotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withBulletListItem", "Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;", "bullet", "Landroidx/compose/ui/text/Bullet;", "(Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;Landroidx/compose/ui/text/Bullet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/LinkAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withStyle", "style", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/ParagraphStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/SpanStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnotatedStringKt {
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", null, 2, null);

    public static final boolean contains(int i, int i2, int i3, int i4) {
        if (i <= i3 && i4 <= i2) {
            if (i2 == i4) {
                if ((i3 == i4) == (i == i2)) {
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean intersect(int i, int i2, int i3, int i4) {
        return ((i < i4) & (i3 < i2)) | (((i == i2) | (i3 == i4)) & (i == i3));
    }

    public static final List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> constructAnnotationsFromSpansAndParagraphs(List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<ParagraphStyle>> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        if (list2.isEmpty()) {
            return list;
        }
        if (list.isEmpty()) {
            return list2;
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i));
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList.add(list2.get(i2));
        }
        return arrayList;
    }

    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(AnnotatedString annotatedString, ParagraphStyle paragraphStyle) {
        List emptyList;
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStylesOrNull$ui_text_release == null || (emptyList = CollectionsKt.sortedWith(paragraphStylesOrNull$ui_text_release, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedStringKt$normalizedParagraphStyles$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((AnnotatedString.Range) t).getStart()), Integer.valueOf(((AnnotatedString.Range) t2).getStart()));
            }
        })) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        int size = emptyList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            AnnotatedString.Range range = (AnnotatedString.Range) emptyList.get(i2);
            AnnotatedString.Range copy$default = AnnotatedString.Range.copy$default(range, paragraphStyle.merge((ParagraphStyle) range.getItem()), 0, 0, null, 14, null);
            while (i < copy$default.getStart()) {
                ArrayDeque arrayDeque2 = arrayDeque;
                if (arrayDeque2.isEmpty()) {
                    break;
                }
                AnnotatedString.Range range2 = (AnnotatedString.Range) arrayDeque.last();
                if (copy$default.getStart() < range2.getEnd()) {
                    arrayList.add(new AnnotatedString.Range(range2.getItem(), i, copy$default.getStart()));
                    i = copy$default.getStart();
                } else {
                    arrayList.add(new AnnotatedString.Range(range2.getItem(), i, range2.getEnd()));
                    i = range2.getEnd();
                    while (!arrayDeque2.isEmpty() && i == ((AnnotatedString.Range) arrayDeque.last()).getEnd()) {
                        arrayDeque.removeLast();
                    }
                }
            }
            if (i < copy$default.getStart()) {
                arrayList.add(new AnnotatedString.Range(paragraphStyle, i, copy$default.getStart()));
                i = copy$default.getStart();
            }
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayDeque.lastOrNull();
            if (range3 != null) {
                if (range3.getStart() == copy$default.getStart() && range3.getEnd() == copy$default.getEnd()) {
                    arrayDeque.removeLast();
                    arrayDeque.add(new AnnotatedString.Range(((ParagraphStyle) range3.getItem()).merge((ParagraphStyle) copy$default.getItem()), copy$default.getStart(), copy$default.getEnd()));
                } else if (range3.getStart() == range3.getEnd()) {
                    arrayList.add(new AnnotatedString.Range(range3.getItem(), range3.getStart(), range3.getEnd()));
                    arrayDeque.removeLast();
                    arrayDeque.add(new AnnotatedString.Range(copy$default.getItem(), copy$default.getStart(), copy$default.getEnd()));
                } else if (range3.getEnd() < copy$default.getEnd()) {
                    throw new IllegalArgumentException();
                } else {
                    arrayDeque.add(new AnnotatedString.Range(((ParagraphStyle) range3.getItem()).merge((ParagraphStyle) copy$default.getItem()), copy$default.getStart(), copy$default.getEnd()));
                }
            } else {
                arrayDeque.add(new AnnotatedString.Range(copy$default.getItem(), copy$default.getStart(), copy$default.getEnd()));
            }
        }
        while (i <= annotatedString.getText().length()) {
            ArrayDeque arrayDeque3 = arrayDeque;
            if (arrayDeque3.isEmpty()) {
                break;
            }
            AnnotatedString.Range range4 = (AnnotatedString.Range) arrayDeque.last();
            arrayList.add(new AnnotatedString.Range(range4.getItem(), i, range4.getEnd()));
            i = range4.getEnd();
            while (!arrayDeque3.isEmpty() && i == ((AnnotatedString.Range) arrayDeque.last()).getEnd()) {
                arrayDeque.removeLast();
            }
        }
        if (i < annotatedString.getText().length()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, i, annotatedString.getText().length()));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, 0, 0));
        }
        return arrayList;
    }

    private static final List<AnnotatedString.Range<ParagraphStyle>> getLocalParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release;
        if (i == i2 || (paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        if (i != 0 || i2 < annotatedString.getText().length()) {
            ArrayList arrayList = new ArrayList(paragraphStylesOrNull$ui_text_release.size());
            int size = paragraphStylesOrNull$ui_text_release.size();
            for (int i3 = 0; i3 < size; i3++) {
                AnnotatedString.Range<ParagraphStyle> range = paragraphStylesOrNull$ui_text_release.get(i3);
                if (intersect(i, i2, range.getStart(), range.getEnd())) {
                    ArrayList arrayList2 = arrayList;
                    ParagraphStyle item = range.getItem();
                    int start = range.getStart();
                    if (start < i) {
                        start = i;
                    }
                    if (start > i2) {
                        start = i2;
                    }
                    int i4 = start - i;
                    int end = range.getEnd();
                    if (end < i) {
                        end = i;
                    }
                    if (end > i2) {
                        end = i2;
                    }
                    arrayList2.add(new AnnotatedString.Range(item, i4, end - i));
                }
            }
            return arrayList;
        }
        return paragraphStylesOrNull$ui_text_release;
    }

    public static /* synthetic */ List getLocalAnnotations$default(AnnotatedString annotatedString, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        return getLocalAnnotations(annotatedString, i, i2, function1);
    }

    private static final List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> getLocalAnnotations(AnnotatedString annotatedString, int i, int i2, Function1<? super AnnotatedString.Annotation, Boolean> function1) {
        List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> annotations$ui_text_release;
        if (i == i2 || (annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            if (function1 == null) {
                return annotations$ui_text_release;
            }
            ArrayList arrayList = new ArrayList(annotations$ui_text_release.size());
            int size = annotations$ui_text_release.size();
            for (int i3 = 0; i3 < size; i3++) {
                AnnotatedString.Range<? extends AnnotatedString.Annotation> range = annotations$ui_text_release.get(i3);
                if (function1.invoke(range.getItem()).booleanValue()) {
                    arrayList.add(range);
                }
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(annotations$ui_text_release.size());
        int size2 = annotations$ui_text_release.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range<? extends AnnotatedString.Annotation> range2 = annotations$ui_text_release.get(i4);
            boolean z = true;
            if (((function1 != null ? function1.invoke(range2.getItem()).booleanValue() : true) && intersect(i, i2, range2.getStart(), range2.getEnd())) ? false : false) {
                arrayList2.add(new AnnotatedString.Range(range2.getItem(), RangesKt.coerceIn(range2.getStart(), i, i2) - i, RangesKt.coerceIn(range2.getEnd(), i, i2) - i, range2.getTag()));
            }
        }
        return arrayList2;
    }

    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        String str;
        if (i != i2) {
            str = annotatedString.getText().substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        } else {
            str = "";
        }
        List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> localAnnotations = getLocalAnnotations(annotatedString, i, i2, new Function1<AnnotatedString.Annotation, Boolean>() { // from class: androidx.compose.ui.text.AnnotatedStringKt$substringWithoutParagraphStyles$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AnnotatedString.Annotation annotation) {
                return Boolean.valueOf(!(annotation instanceof ParagraphStyle));
            }
        });
        if (localAnnotations == null) {
            localAnnotations = CollectionsKt.emptyList();
        }
        return new AnnotatedString(str, localAnnotations);
    }

    public static final <T> List<T> mapEachParagraphStyle(AnnotatedString annotatedString, ParagraphStyle paragraphStyle, Function2<? super AnnotatedString, ? super AnnotatedString.Range<ParagraphStyle>, ? extends T> function2) {
        List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles = normalizedParagraphStyles(annotatedString, paragraphStyle);
        ArrayList arrayList = new ArrayList(normalizedParagraphStyles.size());
        int size = normalizedParagraphStyles.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<ParagraphStyle> range = normalizedParagraphStyles.get(i);
            arrayList.add(function2.invoke(substringWithoutParagraphStyles(annotatedString, range.getStart(), range.getEnd()), range));
        }
        return arrayList;
    }

    public static /* synthetic */ AnnotatedString toUpperCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toUpperCase(annotatedString, localeList);
    }

    public static final AnnotatedString toUpperCase(AnnotatedString annotatedString, final LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new Function3<String, Integer, Integer, String>() { // from class: androidx.compose.ui.text.AnnotatedStringKt$toUpperCase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            public final String invoke(String str, int i, int i2) {
                String substring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                return StringKt.toUpperCase(substring, LocaleList.this);
            }
        });
    }

    public static /* synthetic */ AnnotatedString toLowerCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toLowerCase(annotatedString, localeList);
    }

    public static final AnnotatedString toLowerCase(AnnotatedString annotatedString, final LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new Function3<String, Integer, Integer, String>() { // from class: androidx.compose.ui.text.AnnotatedStringKt$toLowerCase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            public final String invoke(String str, int i, int i2) {
                String substring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                return StringKt.toLowerCase(substring, LocaleList.this);
            }
        });
    }

    public static /* synthetic */ AnnotatedString capitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return capitalize(annotatedString, localeList);
    }

    public static final AnnotatedString capitalize(AnnotatedString annotatedString, final LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new Function3<String, Integer, Integer, String>() { // from class: androidx.compose.ui.text.AnnotatedStringKt$capitalize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            public final String invoke(String str, int i, int i2) {
                if (i == 0) {
                    String substring = str.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return StringKt.capitalize(substring, LocaleList.this);
                }
                String substring2 = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                return substring2;
            }
        });
    }

    public static /* synthetic */ AnnotatedString decapitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return decapitalize(annotatedString, localeList);
    }

    public static final AnnotatedString decapitalize(AnnotatedString annotatedString, final LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new Function3<String, Integer, Integer, String>() { // from class: androidx.compose.ui.text.AnnotatedStringKt$decapitalize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            public final String invoke(String str, int i, int i2) {
                if (i == 0) {
                    String substring = str.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return StringKt.decapitalize(substring, LocaleList.this);
                }
                String substring2 = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                return substring2;
            }
        });
    }

    public static final <R> R withStyle(AnnotatedString.Builder builder, SpanStyle spanStyle, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int pushStyle = builder.pushStyle(spanStyle);
        try {
            return function1.invoke(builder);
        } finally {
            builder.pop(pushStyle);
        }
    }

    public static final <R> R withStyle(AnnotatedString.Builder builder, ParagraphStyle paragraphStyle, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int pushStyle = builder.pushStyle(paragraphStyle);
        try {
            return function1.invoke(builder);
        } finally {
            builder.pop(pushStyle);
        }
    }

    public static final <R> R withAnnotation(AnnotatedString.Builder builder, String str, String str2, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int pushStringAnnotation = builder.pushStringAnnotation(str, str2);
        try {
            return function1.invoke(builder);
        } finally {
            builder.pop(pushStringAnnotation);
        }
    }

    public static final <R> R withAnnotation(AnnotatedString.Builder builder, TtsAnnotation ttsAnnotation, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int pushTtsAnnotation = builder.pushTtsAnnotation(ttsAnnotation);
        try {
            return function1.invoke(builder);
        } finally {
            builder.pop(pushTtsAnnotation);
        }
    }

    @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(expression = "withLink(, block)", imports = {}))
    public static final <R> R withAnnotation(AnnotatedString.Builder builder, UrlAnnotation urlAnnotation, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int pushUrlAnnotation = builder.pushUrlAnnotation(urlAnnotation);
        try {
            return function1.invoke(builder);
        } finally {
            builder.pop(pushUrlAnnotation);
        }
    }

    public static final <R> R withLink(AnnotatedString.Builder builder, LinkAnnotation linkAnnotation, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int pushLink = builder.pushLink(linkAnnotation);
        try {
            return function1.invoke(builder);
        } finally {
            builder.pop(pushLink);
        }
    }

    public static /* synthetic */ Object withBulletListItem$default(AnnotatedString.Builder.BulletScope bulletScope, Bullet bullet, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            bullet = null;
        }
        return withBulletListItem(bulletScope, bullet, function1);
    }

    public static final <R> R withBulletListItem(AnnotatedString.Builder.BulletScope bulletScope, Bullet bullet, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Bullet bullet2;
        Pair pair = (Pair) CollectionsKt.lastOrNull((List<? extends Object>) bulletScope.getBulletListSettingStack$ui_text_release());
        long m6887unboximpl = pair != null ? ((TextUnit) pair.getFirst()).m6887unboximpl() : BulletKt.getDefaultBulletIndentation();
        if (bullet != null) {
            bullet2 = bullet;
        } else if (pair == null || (bullet2 = (Bullet) pair.getSecond()) == null) {
            bullet2 = BulletKt.getDefaultBullet();
        }
        int pushStyle = bulletScope.getBuilder$ui_text_release().pushStyle(new ParagraphStyle(0, 0, 0L, new TextIndent(m6887unboximpl, m6887unboximpl, null), (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, (int) TypedValues.PositionType.TYPE_PERCENT_WIDTH, (DefaultConstructorMarker) null));
        int pushBullet$ui_text_release = bulletScope.getBuilder$ui_text_release().pushBullet$ui_text_release(bullet2);
        try {
            return function1.invoke(bulletScope.getBuilder$ui_text_release());
        } finally {
            bulletScope.getBuilder$ui_text_release().pop(pushBullet$ui_text_release);
            bulletScope.getBuilder$ui_text_release().pop(pushStyle);
        }
    }

    public static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> list, int i, int i2) {
        if (!(i <= i2)) {
            InlineClassHelperKt.throwIllegalArgumentException("start (" + i + ") should be less than or equal to end (" + i2 + ')');
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<? extends T> range = list.get(i3);
            if (intersect(i, i2, range.getStart(), range.getEnd())) {
                arrayList.add(new AnnotatedString.Range(range.getItem(), Math.max(i, range.getStart()) - i, Math.min(i2, range.getEnd()) - i, range.getTag()));
            }
        }
        ArrayList arrayList2 = arrayList;
        return arrayList2.isEmpty() ? null : arrayList2;
    }

    public static /* synthetic */ AnnotatedString AnnotatedString$default(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            paragraphStyle = null;
        }
        return AnnotatedString(str, spanStyle, paragraphStyle);
    }

    public static final AnnotatedString AnnotatedString(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        return new AnnotatedString(str, CollectionsKt.listOf(new AnnotatedString.Range(spanStyle, 0, str.length())), paragraphStyle == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    public static final AnnotatedString AnnotatedString(String str, ParagraphStyle paragraphStyle) {
        return new AnnotatedString(str, CollectionsKt.emptyList(), CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    public static final AnnotatedString buildAnnotatedString(Function1<? super AnnotatedString.Builder, Unit> function1) {
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        function1.invoke(builder);
        return builder.toAnnotatedString();
    }

    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }
}
