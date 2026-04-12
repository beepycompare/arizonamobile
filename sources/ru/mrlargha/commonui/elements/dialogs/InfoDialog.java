package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.InfoDialogBinding;
/* compiled from: InfoDialog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "Landroid/text/SpannableString;", "info", "leftButtonText", "rightButtonText", "sampDialogId", "<init>", "(Landroid/app/Activity;ILandroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;I)V", "dialogLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/InfoDialogBinding;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InfoDialog extends AbstractDialog {
    private final InfoDialogBinding binding;
    private final View dialogLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoDialog(Activity targetActivity, int i, SpannableString caption, SpannableString info, SpannableString leftButtonText, SpannableString rightButtonText, final int i2) {
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
        bind.infoText.setText(info);
        Intrinsics.checkNotNullExpressionValue(dialogLayout, "dialogLayout");
        addViewToConstraintLayout(dialogLayout, -1, -1);
        bind.caption.setText(caption);
        bind.infoText.setMovementMethod(new ScrollingMovementMethod());
        setVisibility(true);
        SpannableString spannableString = leftButtonText;
        if (spannableString.length() == 0) {
            bind.buttons.button1.setVisibility(8);
        } else {
            bind.buttons.tvAccept.setText(spannableString);
            bind.buttons.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoDialog.lambda$0$0(InfoDialog.this, i2, view);
                }
            });
        }
        SpannableString spannableString2 = rightButtonText;
        if (spannableString2.length() == 0) {
            bind.buttons.button2.setVisibility(8);
        } else {
            bind.buttons.tvCancel.setText(spannableString2);
            bind.buttons.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoDialog.lambda$0$1(InfoDialog.this, i2, view);
                }
            });
        }
        bind.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog.lambda$0$2(InfoDialog.this, i2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$0(InfoDialog infoDialog, int i, View view) {
        infoDialog.getNotifier().onDialogResponseWrapper(i, 1, -1, new byte[0]);
        infoDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$1(InfoDialog infoDialog, int i, View view) {
        infoDialog.getNotifier().onDialogResponseWrapper(i, 0, -1, new byte[0]);
        infoDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$2(InfoDialog infoDialog, int i, View view) {
        infoDialog.getNotifier().onDialogResponseWrapper(i, 0, -1, new byte[0]);
        infoDialog.getNotifier().destroyDialog();
    }
}
