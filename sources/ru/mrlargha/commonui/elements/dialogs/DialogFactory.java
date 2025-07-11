package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.elements.dialogs.table.TableCell;
import ru.mrlargha.commonui.elements.dialogs.table.TableDialog;
/* compiled from: DialogFactory.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tJ\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00122\u0006\u0010\u0014\u001a\u00020\fH\u0002J\f\u0010\u0015\u001a\u00020\u0016*\u00020\fH\u0002¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogFactory;", "", "<init>", "()V", "createDialog", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "dialogID", "", "style", "caption", "", "info", "leftButton", "rightButton", "backendId", "parseTable", "", "Lru/mrlargha/commonui/elements/dialogs/table/TableCell;", "data", "toSpannable", "Landroid/text/SpannableString;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DialogFactory {
    public static final DialogFactory INSTANCE = new DialogFactory();

    private DialogFactory() {
    }

    public final SAMPUIElement createDialog(Activity targetActivity, int i, int i2, String caption, String info, String leftButton, String rightButton, int i3) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(leftButton, "leftButton");
        Intrinsics.checkNotNullParameter(rightButton, "rightButton");
        Log.d("MrLargha DialogFactory", "Creating dialog with parameters: ID: " + i + "\nCaption: " + caption + "\n Info: " + info);
        if (i2 != 0) {
            if (i2 == 1) {
                return new UserInputDialog(targetActivity, i3, toSpannable(caption), toSpannable(info), toSpannable(leftButton), toSpannable(rightButton), false, i);
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    return new UserInputDialog(targetActivity, i3, toSpannable(caption), toSpannable(info), toSpannable(leftButton), toSpannable(rightButton), true, i);
                }
                if (i2 != 4) {
                    if (i2 == 5) {
                        return new TableDialog(targetActivity, i3, toSpannable(caption), parseTable(info), toSpannable(leftButton), toSpannable(rightButton), true, i);
                    }
                    throw new IllegalArgumentException("Unsupported style number: " + i2 + "!");
                }
            }
            return new TableDialog(targetActivity, i3, toSpannable(caption), parseTable(info), toSpannable(leftButton), toSpannable(rightButton), false, i);
        }
        return new InfoDialog(targetActivity, i3, toSpannable(caption), toSpannable(info), toSpannable(leftButton), toSpannable(rightButton), i);
    }

    private final List<List<TableCell>> parseTable(String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : StringsKt.split$default((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null)) {
            if (((String) obj2).length() > 0) {
                arrayList.add(obj2);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (String str2 : arrayList2) {
            List<String> split$default = StringsKt.split$default((CharSequence) str2, new String[]{"\t"}, false, 0, 6, (Object) null);
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String str3 : split$default) {
                arrayList4.add(new TableCell(INSTANCE.toSpannable(str3)));
            }
            arrayList3.add(CollectionsKt.toMutableList((Collection) arrayList4));
        }
        ArrayList arrayList5 = arrayList3;
        ArrayList<List> arrayList6 = arrayList5;
        Iterator it = arrayList6.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int size = ((List) next).size();
                do {
                    Object next2 = it.next();
                    int size2 = ((List) next2).size();
                    if (size < size2) {
                        next = next2;
                        size = size2;
                    }
                } while (it.hasNext());
                obj = next;
            } else {
                obj = next;
            }
        } else {
            obj = null;
        }
        List list = (List) obj;
        int size3 = list != null ? list.size() : 0;
        for (List list2 : arrayList6) {
            if (list2.size() < size3) {
                int size4 = size3 - list2.size();
                for (int i = 0; i < size4; i++) {
                    list2.add(new TableCell(""));
                }
            }
        }
        return arrayList5;
    }

    private final SpannableString toSpannable(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            Regex regex = new Regex("\\{[0-9A-z]*\\}");
            MatchResult find = regex.find(str, 0);
            i = 0;
            i2 = -1;
            i3 = -1;
            while (find != null) {
                try {
                    i4 = Color.parseColor('#' + StringsKt.substring(find.getValue(), new IntRange(1, 6)));
                } catch (NumberFormatException unused) {
                    i4 = -1;
                }
                if (i2 != -1) {
                    int i5 = i2 + 1;
                    spannableStringBuilder.append(str.subSequence(i5, find.getRange().getFirst()));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i5 - i, find.getRange().getFirst() - i, 34);
                } else {
                    String substring = str.substring(0, find.getRange().getFirst());
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    spannableStringBuilder.append((CharSequence) substring);
                }
                i += 8;
                i2 = find.getRange().getLast();
                find = regex.find(str, find.getRange().getLast());
                i3 = i4;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("DialogFactory", "last index error");
        }
        if (i2 != -1) {
            int i6 = i2 + 1;
            spannableStringBuilder.append(str.subSequence(i6, StringsKt.getLastIndex(str) + 1));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i6 - i, (StringsKt.getLastIndex(str) + 1) - i, 34);
            SpannableString valueOf = SpannableString.valueOf(spannableStringBuilder);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            return valueOf;
        }
        return new SpannableString(str);
    }
}
