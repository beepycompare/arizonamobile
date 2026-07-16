package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.InfoDialogBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: InfoDialog.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0014\u001a\u00020\t*\u00020\u0007H\u0002J\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u0007H\u0002R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "", "info", "Landroid/text/SpannableString;", "leftButtonText", "rightButtonText", "sampDialogId", "<init>", "(Landroid/app/Activity;ILjava/lang/String;Landroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;I)V", "dialogLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/InfoDialogBinding;", "resolveInfoDialogCaption", "parseInfoDialogCaption", "Lru/mrlargha/commonui/elements/dialogs/InfoDialog$InfoDialogCaption;", "InfoDialogCaption", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InfoDialog extends AbstractDialog {
    private final InfoDialogBinding binding;
    private final View dialogLayout;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoDialog(Activity targetActivity, int i, String caption, SpannableString info, SpannableString leftButtonText, SpannableString rightButtonText, final int i2) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        View dialogLayout = LayoutInflater.from(targetActivity).inflate(R.layout.info_dialog, (ViewGroup) null, false);
        this.dialogLayout = dialogLayout;
        InfoDialogBinding bind = InfoDialogBinding.bind(dialogLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog.lambda$0$0(view);
            }
        });
        bind.infoText.setText(info);
        Intrinsics.checkNotNullExpressionValue(dialogLayout, "dialogLayout");
        addViewToConstraintLayout(dialogLayout, -1, -1);
        bind.caption.setText(resolveInfoDialogCaption(caption));
        bind.infoText.setMovementMethod(new ScrollingMovementMethod());
        setVisibility(true);
        SpannableString spannableString = leftButtonText;
        if (spannableString.length() == 0) {
            bind.buttons.button1.setVisibility(8);
        } else {
            bind.buttons.tvAccept.setText(spannableString);
            bind.buttons.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoDialog.lambda$0$1(InfoDialog.this, i2, view);
                }
            });
        }
        SpannableString spannableString2 = rightButtonText;
        if (spannableString2.length() == 0) {
            bind.buttons.button2.setVisibility(8);
        } else {
            bind.buttons.tvCancel.setText(spannableString2);
            bind.buttons.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoDialog.lambda$0$2(InfoDialog.this, i2, view);
                }
            });
        }
        bind.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog.lambda$0$3(InfoDialog.this, i2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$1(InfoDialog infoDialog, int i, View view) {
        infoDialog.getNotifier().onDialogResponseWrapper(i, 1, -1, new byte[0]);
        infoDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$2(InfoDialog infoDialog, int i, View view) {
        infoDialog.getNotifier().onDialogResponseWrapper(i, 0, -1, new byte[0]);
        infoDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$3(InfoDialog infoDialog, int i, View view) {
        infoDialog.getNotifier().onDialogResponseWrapper(i, 0, -1, new byte[0]);
        infoDialog.getNotifier().destroyDialog();
    }

    private final SpannableString resolveInfoDialogCaption(String str) {
        String text;
        SpannableString spannable$default;
        InfoDialogCaption parseInfoDialogCaption = parseInfoDialogCaption(str);
        return (parseInfoDialogCaption == null || (text = parseInfoDialogCaption.getText()) == null || (spannable$default = ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, text, 0.0f, null, 3, null)) == null) ? ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, str, 0.0f, null, 3, null) : spannable$default;
    }

    private final InfoDialogCaption parseInfoDialogCaption(String str) {
        Object m9898constructorimpl;
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (StringsKt.startsWith$default(obj, "{", false, 2, (Object) null) && StringsKt.endsWith$default(obj, "}", false, 2, (Object) null)) {
            try {
                Result.Companion companion = Result.Companion;
                JsonReader jsonReader = new JsonReader(new StringReader(obj));
                jsonReader.setStrictness(Strictness.LENIENT);
                InfoDialogCaption infoDialogCaption = (InfoDialogCaption) MapperKt.getGson().fromJson(jsonReader, InfoDialogCaption.class);
                jsonReader.close();
                m9898constructorimpl = Result.m9898constructorimpl(infoDialogCaption);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m9904isFailureimpl(m9898constructorimpl) ? null : m9898constructorimpl;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InfoDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialog$InfoDialogCaption;", "", "text", "", "value", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getText", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/dialogs/InfoDialog$InfoDialogCaption;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class InfoDialogCaption {
        private final String text;
        private final Integer value;

        public InfoDialogCaption() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ InfoDialogCaption copy$default(InfoDialogCaption infoDialogCaption, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = infoDialogCaption.text;
            }
            if ((i & 2) != 0) {
                num = infoDialogCaption.value;
            }
            return infoDialogCaption.copy(str, num);
        }

        public final String component1() {
            return this.text;
        }

        public final Integer component2() {
            return this.value;
        }

        public final InfoDialogCaption copy(String str, Integer num) {
            return new InfoDialogCaption(str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InfoDialogCaption) {
                InfoDialogCaption infoDialogCaption = (InfoDialogCaption) obj;
                return Intrinsics.areEqual(this.text, infoDialogCaption.text) && Intrinsics.areEqual(this.value, infoDialogCaption.value);
            }
            return false;
        }

        public int hashCode() {
            String str = this.text;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.value;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            String str = this.text;
            return "InfoDialogCaption(text=" + str + ", value=" + this.value + ")";
        }

        public InfoDialogCaption(String str, Integer num) {
            this.text = str;
            this.value = num;
        }

        public /* synthetic */ InfoDialogCaption(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
        }

        public final String getText() {
            return this.text;
        }

        public final Integer getValue() {
            return this.value;
        }
    }
}
