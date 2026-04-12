package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.elements.dialogs.table.TableCell;
import ru.mrlargha.commonui.elements.dialogs.table.TableDialog;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: DialogFactory.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00152\u0006\u0010\u0017\u001a\u00020\fH\u0002¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogFactory;", "", "<init>", "()V", "createDialog", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "dialogID", "", "style", "caption", "", "info", "leftButton", "rightButton", "backendId", "inputHint", "context", "Landroid/content/Context;", "parseTable", "", "Lru/mrlargha/commonui/elements/dialogs/table/TableCell;", "data", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogFactory {
    public static final DialogFactory INSTANCE = new DialogFactory();

    private DialogFactory() {
    }

    public final SAMPUIElement createDialog(Activity targetActivity, int i, int i2, String caption, String info, String leftButton, String rightButton, int i3, String inputHint, Context context) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(leftButton, "leftButton");
        Intrinsics.checkNotNullParameter(rightButton, "rightButton");
        Intrinsics.checkNotNullParameter(inputHint, "inputHint");
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d("MrLargha DialogFactory", "Creating dialog with parameters: ID: " + i + "\nCaption: " + caption + "\n Info: " + info + " \n Style " + i2);
        ChatEmoji.INSTANCE.init(context);
        switch (i2) {
            case 0:
                return new InfoDialog(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, info, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, 1, null), i);
            case 1:
                return new UserInputDialog(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, info, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, 1, null), false, i, inputHint);
            case 2:
            case 4:
                return new TableDialog(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, 1, null), parseTable(info), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, 1, null), false, i);
            case 3:
                return new UserInputDialog(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, info, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, 1, null), true, i, inputHint);
            case 5:
                return new TableDialog(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, 1, null), parseTable(info), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, 1, null), true, i);
            case 6:
                return new DialogWithdraw(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, info, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, 1, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, 1, null), false, i, inputHint);
            default:
                throw new IllegalArgumentException("Unsupported style number: " + i2 + "!");
        }
    }

    private final List<List<TableCell>> parseTable(String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : StringsKt.split$default((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null)) {
            if (((String) obj2).length() > 0) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            List<String> split$default = StringsKt.split$default((CharSequence) ((String) it.next()), new String[]{"\t"}, false, 0, 6, (Object) null);
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String str2 : split$default) {
                arrayList4.add(new TableCell(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, str2, 0.0f, 1, null)));
            }
            arrayList3.add(CollectionsKt.toMutableList((Collection) arrayList4));
        }
        ArrayList arrayList5 = arrayList3;
        ArrayList<List> arrayList6 = arrayList5;
        Iterator it2 = arrayList6.iterator();
        if (it2.hasNext()) {
            obj = it2.next();
            if (it2.hasNext()) {
                int size = ((List) obj).size();
                do {
                    Object next = it2.next();
                    int size2 = ((List) next).size();
                    if (size < size2) {
                        obj = next;
                        size = size2;
                    }
                } while (it2.hasNext());
            }
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
}
