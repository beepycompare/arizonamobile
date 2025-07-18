package kotlin.text;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Indent.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0001\u001a\u0011\u0010\t\u001a\u00020\n*\u00020\u0001H\u0002¢\u0006\u0002\b\u000b\u001a!\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001aJ\u0010\u000f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0082\b¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"trimMargin", "", "marginPrefix", "replaceIndentByMargin", "newIndent", "trimIndent", "replaceIndent", "prependIndent", "indent", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "getIndentFunction", "Lkotlin/Function1;", "getIndentFunction$StringsKt__IndentKt", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
public class StringsKt__IndentKt extends StringsKt__AppendableKt {
    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String getIndentFunction$lambda$8$StringsKt__IndentKt(java.lang.String r1) {
        /*
            java.lang.String r0 = "line"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__IndentKt.getIndentFunction$lambda$8$StringsKt__IndentKt(java.lang.String):java.lang.String");
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return StringsKt.trimMargin(str, str2);
    }

    public static final String trimMargin(String str, String marginPrefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return StringsKt.replaceIndentByMargin(str, "", marginPrefix);
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return StringsKt.replaceIndentByMargin(str, str2, str3);
    }

    public static final String replaceIndentByMargin(String str, String newIndent, String marginPrefix) {
        String str2;
        String invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        if (StringsKt.isBlank(marginPrefix)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> lines = StringsKt.lines(str);
        int length = str.length() + (newIndent.length() * lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex = CollectionsKt.getLastIndex(lines);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : lines) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str3 = (String) obj;
            String str4 = null;
            if ((i == 0 || i == lastIndex) && StringsKt.isBlank(str3)) {
                str2 = marginPrefix;
                str3 = null;
            } else {
                String str5 = str3;
                int length2 = str5.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    } else if (!CharsKt.isWhitespace(str5.charAt(i3))) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 == -1) {
                    str2 = marginPrefix;
                } else {
                    str2 = marginPrefix;
                    if (StringsKt.startsWith$default(str3, str2, i3, false, 4, (Object) null)) {
                        Intrinsics.checkNotNull(str3, "null cannot be cast to non-null type java.lang.String");
                        str4 = str3.substring(i3 + str2.length());
                        Intrinsics.checkNotNullExpressionValue(str4, "substring(...)");
                    }
                }
                if (str4 != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(str4)) != null) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
            i = i2;
            marginPrefix = str2;
        }
        return ((StringBuilder) CollectionsKt.joinTo$default(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static final String trimIndent(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.replaceIndent(str, "");
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return StringsKt.replaceIndent(str, str2);
    }

    public static final String replaceIndent(String str, String newIndent) {
        String invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List<String> lines = StringsKt.lines(str);
        List<String> list = lines;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (String str2 : arrayList2) {
            arrayList3.add(Integer.valueOf(indentWidth$StringsKt__IndentKt(str2)));
        }
        Integer num = (Integer) CollectionsKt.minOrNull((Iterable<? extends Comparable>) arrayList3);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex = CollectionsKt.getLastIndex(lines);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str3 = (String) obj2;
            if ((i == 0 || i == lastIndex) && StringsKt.isBlank(str3)) {
                str3 = null;
            } else {
                String drop = StringsKt.drop(str3, intValue);
                if (drop != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(drop)) != null) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList4.add(str3);
            }
            i = i2;
        }
        return ((StringBuilder) CollectionsKt.joinTo$default(arrayList4, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return StringsKt.prependIndent(str, str2);
    }

    public static final String prependIndent(String str, final String indent) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence(str), new Function1() { // from class: kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String prependIndent$lambda$5$StringsKt__IndentKt;
                prependIndent$lambda$5$StringsKt__IndentKt = StringsKt__IndentKt.prependIndent$lambda$5$StringsKt__IndentKt(indent, (String) obj);
                return prependIndent$lambda$5$StringsKt__IndentKt;
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String prependIndent$lambda$5$StringsKt__IndentKt(String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (StringsKt.isBlank(it)) {
            return it.length() < str.length() ? str : it;
        }
        return str + it;
    }

    private static final int indentWidth$StringsKt__IndentKt(String str) {
        String str2 = str;
        int length = str2.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!CharsKt.isWhitespace(str2.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        return i == -1 ? str.length() : i;
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String str) {
        return str.length() == 0 ? new Function1() { // from class: kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StringsKt__IndentKt.getIndentFunction$lambda$8$StringsKt__IndentKt((String) obj);
            }
        } : new Function1() { // from class: kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String indentFunction$lambda$9$StringsKt__IndentKt;
                indentFunction$lambda$9$StringsKt__IndentKt = StringsKt__IndentKt.getIndentFunction$lambda$9$StringsKt__IndentKt(str, (String) obj);
                return indentFunction$lambda$9$StringsKt__IndentKt;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getIndentFunction$lambda$9$StringsKt__IndentKt(String str, String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return str + line;
    }

    private static final String reindent$StringsKt__IndentKt(List<String> list, int i, Function1<? super String, String> function1, Function1<? super String, String> function12) {
        String invoke;
        int lastIndex = CollectionsKt.getLastIndex(list);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if ((i2 == 0 || i2 == lastIndex) && StringsKt.isBlank(str)) {
                str = null;
            } else {
                String invoke2 = function12.invoke(str);
                if (invoke2 != null && (invoke = function1.invoke(invoke2)) != null) {
                    str = invoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i2 = i3;
        }
        return ((StringBuilder) CollectionsKt.joinTo$default(arrayList, new StringBuilder(i), "\n", null, null, 0, null, null, 124, null)).toString();
    }
}
