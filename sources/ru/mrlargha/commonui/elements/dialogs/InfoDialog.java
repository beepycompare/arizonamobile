package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: InfoDialog.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "Landroid/text/SpannableString;", "info", "leftButtonText", "rightButtonText", "sampDialogId", "<init>", "(Landroid/app/Activity;ILandroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;I)V", "dialogLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "infoTextView", "Landroid/widget/TextView;", "captionTextView", "button1", "Landroid/widget/Button;", "button2", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InfoDialog extends AbstractDialog {
    private final Button button1;
    private final Button button2;
    private final TextView captionTextView;
    private final ConstraintLayout dialogLayout;
    private final TextView infoTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoDialog(Activity targetActivity, int i, SpannableString caption, SpannableString info, SpannableString leftButtonText, SpannableString rightButtonText, final int i2) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        View inflate = LayoutInflater.from(targetActivity).inflate(R.layout.info_dialog, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.dialogLayout = constraintLayout;
        View findViewById = constraintLayout.findViewById(R.id.infoText);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.infoTextView = textView;
        View findViewById2 = constraintLayout.findViewById(R.id.caption);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        TextView textView2 = (TextView) findViewById2;
        this.captionTextView = textView2;
        View findViewById3 = constraintLayout.findViewById(R.id.button1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        Button button = (Button) findViewById3;
        this.button1 = button;
        View findViewById4 = constraintLayout.findViewById(R.id.button2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        Button button2 = (Button) findViewById4;
        this.button2 = button2;
        textView.setText(info);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        textView2.setText(caption);
        textView.setMovementMethod(new ScrollingMovementMethod());
        setVisibility(true);
        SpannableString spannableString = leftButtonText;
        if (spannableString.length() == 0) {
            button.setVisibility(8);
        } else {
            button.setText(spannableString);
            button.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoDialog._init_$lambda$0(InfoDialog.this, i2, view);
                }
            });
        }
        SpannableString spannableString2 = rightButtonText;
        if (spannableString2.length() == 0) {
            button2.setVisibility(8);
            return;
        }
        button2.setText(spannableString2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.InfoDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog._init_$lambda$1(InfoDialog.this, i2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(InfoDialog infoDialog, int i, View view) {
        infoDialog.getNotifier().onDialogResponseWrapper(i, 1, -1, new byte[0]);
        infoDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(InfoDialog infoDialog, int i, View view) {
        infoDialog.getNotifier().onDialogResponseWrapper(i, 0, -1, new byte[0]);
        infoDialog.getNotifier().destroyDialog();
    }
}
