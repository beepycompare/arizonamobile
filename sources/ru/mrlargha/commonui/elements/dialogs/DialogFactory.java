package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.elements.dialogs.table.TableCell;
import ru.mrlargha.commonui.elements.dialogs.table.TableDialog;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: DialogFactory.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007JV\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001b2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogFactory;", "", "<init>", "()V", "customCreators", "", "", "Lru/mrlargha/commonui/elements/dialogs/DialogFactory$DialogCreator;", "registerDialogCreator", "", "style", "creator", "createDialog", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "dialogID", "caption", "", "info", "leftButton", "rightButton", "backendId", "inputHint", "context", "Landroid/content/Context;", "parseTable", "", "Lru/mrlargha/commonui/elements/dialogs/table/TableCell;", "data", "DialogParams", "DialogCreator", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogFactory {
    public static final DialogFactory INSTANCE = new DialogFactory();
    private static final Map<Integer, DialogCreator> customCreators = new LinkedHashMap();

    /* compiled from: DialogFactory.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogFactory$DialogCreator;", "", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "params", "Lru/mrlargha/commonui/elements/dialogs/DialogFactory$DialogParams;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface DialogCreator {
        SAMPUIElement create(DialogParams dialogParams);
    }

    /* compiled from: DialogFactory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003Jm\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010/\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogFactory$DialogParams;", "", "targetActivity", "Landroid/app/Activity;", "dialogID", "", "style", "caption", "", "info", "leftButton", "rightButton", "backendId", "inputHint", "context", "Landroid/content/Context;", "<init>", "(Landroid/app/Activity;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/content/Context;)V", "getTargetActivity", "()Landroid/app/Activity;", "getDialogID", "()I", "getStyle", "getCaption", "()Ljava/lang/String;", "getInfo", "getLeftButton", "getRightButton", "getBackendId", "getInputHint", "getContext", "()Landroid/content/Context;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DialogParams {
        private final int backendId;
        private final String caption;
        private final Context context;
        private final int dialogID;
        private final String info;
        private final String inputHint;
        private final String leftButton;
        private final String rightButton;
        private final int style;
        private final Activity targetActivity;

        public static /* synthetic */ DialogParams copy$default(DialogParams dialogParams, Activity activity, int i, int i2, String str, String str2, String str3, String str4, int i3, String str5, Context context, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                activity = dialogParams.targetActivity;
            }
            if ((i4 & 2) != 0) {
                i = dialogParams.dialogID;
            }
            if ((i4 & 4) != 0) {
                i2 = dialogParams.style;
            }
            if ((i4 & 8) != 0) {
                str = dialogParams.caption;
            }
            if ((i4 & 16) != 0) {
                str2 = dialogParams.info;
            }
            if ((i4 & 32) != 0) {
                str3 = dialogParams.leftButton;
            }
            if ((i4 & 64) != 0) {
                str4 = dialogParams.rightButton;
            }
            if ((i4 & 128) != 0) {
                i3 = dialogParams.backendId;
            }
            if ((i4 & 256) != 0) {
                str5 = dialogParams.inputHint;
            }
            if ((i4 & 512) != 0) {
                context = dialogParams.context;
            }
            String str6 = str5;
            Context context2 = context;
            String str7 = str4;
            int i5 = i3;
            String str8 = str2;
            String str9 = str3;
            return dialogParams.copy(activity, i, i2, str, str8, str9, str7, i5, str6, context2);
        }

        public final Activity component1() {
            return this.targetActivity;
        }

        public final Context component10() {
            return this.context;
        }

        public final int component2() {
            return this.dialogID;
        }

        public final int component3() {
            return this.style;
        }

        public final String component4() {
            return this.caption;
        }

        public final String component5() {
            return this.info;
        }

        public final String component6() {
            return this.leftButton;
        }

        public final String component7() {
            return this.rightButton;
        }

        public final int component8() {
            return this.backendId;
        }

        public final String component9() {
            return this.inputHint;
        }

        public final DialogParams copy(Activity targetActivity, int i, int i2, String caption, String info, String leftButton, String rightButton, int i3, String inputHint, Context context) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            Intrinsics.checkNotNullParameter(caption, "caption");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(leftButton, "leftButton");
            Intrinsics.checkNotNullParameter(rightButton, "rightButton");
            Intrinsics.checkNotNullParameter(inputHint, "inputHint");
            Intrinsics.checkNotNullParameter(context, "context");
            return new DialogParams(targetActivity, i, i2, caption, info, leftButton, rightButton, i3, inputHint, context);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DialogParams) {
                DialogParams dialogParams = (DialogParams) obj;
                return Intrinsics.areEqual(this.targetActivity, dialogParams.targetActivity) && this.dialogID == dialogParams.dialogID && this.style == dialogParams.style && Intrinsics.areEqual(this.caption, dialogParams.caption) && Intrinsics.areEqual(this.info, dialogParams.info) && Intrinsics.areEqual(this.leftButton, dialogParams.leftButton) && Intrinsics.areEqual(this.rightButton, dialogParams.rightButton) && this.backendId == dialogParams.backendId && Intrinsics.areEqual(this.inputHint, dialogParams.inputHint) && Intrinsics.areEqual(this.context, dialogParams.context);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((this.targetActivity.hashCode() * 31) + Integer.hashCode(this.dialogID)) * 31) + Integer.hashCode(this.style)) * 31) + this.caption.hashCode()) * 31) + this.info.hashCode()) * 31) + this.leftButton.hashCode()) * 31) + this.rightButton.hashCode()) * 31) + Integer.hashCode(this.backendId)) * 31) + this.inputHint.hashCode()) * 31) + this.context.hashCode();
        }

        public String toString() {
            Activity activity = this.targetActivity;
            int i = this.dialogID;
            int i2 = this.style;
            String str = this.caption;
            String str2 = this.info;
            String str3 = this.leftButton;
            String str4 = this.rightButton;
            int i3 = this.backendId;
            String str5 = this.inputHint;
            return "DialogParams(targetActivity=" + activity + ", dialogID=" + i + ", style=" + i2 + ", caption=" + str + ", info=" + str2 + ", leftButton=" + str3 + ", rightButton=" + str4 + ", backendId=" + i3 + ", inputHint=" + str5 + ", context=" + this.context + ")";
        }

        public DialogParams(Activity targetActivity, int i, int i2, String caption, String info, String leftButton, String rightButton, int i3, String inputHint, Context context) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            Intrinsics.checkNotNullParameter(caption, "caption");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(leftButton, "leftButton");
            Intrinsics.checkNotNullParameter(rightButton, "rightButton");
            Intrinsics.checkNotNullParameter(inputHint, "inputHint");
            Intrinsics.checkNotNullParameter(context, "context");
            this.targetActivity = targetActivity;
            this.dialogID = i;
            this.style = i2;
            this.caption = caption;
            this.info = info;
            this.leftButton = leftButton;
            this.rightButton = rightButton;
            this.backendId = i3;
            this.inputHint = inputHint;
            this.context = context;
        }

        public final Activity getTargetActivity() {
            return this.targetActivity;
        }

        public final int getDialogID() {
            return this.dialogID;
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getCaption() {
            return this.caption;
        }

        public final String getInfo() {
            return this.info;
        }

        public final String getLeftButton() {
            return this.leftButton;
        }

        public final String getRightButton() {
            return this.rightButton;
        }

        public final int getBackendId() {
            return this.backendId;
        }

        public final String getInputHint() {
            return this.inputHint;
        }

        public final Context getContext() {
            return this.context;
        }
    }

    private DialogFactory() {
    }

    public final void registerDialogCreator(int i, DialogCreator creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        customCreators.put(Integer.valueOf(i), creator);
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
        DialogCreator dialogCreator = customCreators.get(Integer.valueOf(i2));
        if (dialogCreator != null) {
            return dialogCreator.create(new DialogParams(targetActivity, i, i2, caption, info, leftButton, rightButton, i3, inputHint, context));
        }
        switch (i2) {
            case 0:
                return new InfoDialog(targetActivity, i3, caption, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, info, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, null, 3, null), i);
            case 1:
                return new UserInputDialog(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, info, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, null, 3, null), false, i, inputHint);
            case 2:
            case 4:
                return new TableDialog(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, null, 3, null), parseTable(info), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, null, 3, null), false, i);
            case 3:
                return new UserInputDialog(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, info, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, null, 3, null), true, i, inputHint);
            case 5:
                return new TableDialog(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, null, 3, null), parseTable(info), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, null, 3, null), true, i);
            case 6:
                return new DialogWithdraw(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, info, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, leftButton, 0.0f, null, 3, null), ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, rightButton, 0.0f, null, 3, null), false, i, inputHint);
            case 7:
                return new DialogSign(targetActivity, i3, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, caption, 0.0f, null, 3, null), info, ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, !StringsKt.isBlank(leftButton) ? leftButton : rightButton, 0.0f, null, 3, null), i);
            case 8:
                return new DialogBuyCrypto(targetActivity, i3, caption, info, leftButton, rightButton, i, inputHint);
            case 9:
                return new DialogBankTaxPayment(targetActivity, i3, caption, info, leftButton, i);
            case 10:
                return new DialogBankHistory(targetActivity, i3, caption, info, i, false, null, 96, null);
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
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (String str2 : arrayList2) {
            List<String> split$default = StringsKt.split$default((CharSequence) str2, new String[]{"\t"}, false, 0, 6, (Object) null);
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String str3 : split$default) {
                arrayList4.add(new TableCell(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, str3, 0.0f, null, 3, null)));
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
}
