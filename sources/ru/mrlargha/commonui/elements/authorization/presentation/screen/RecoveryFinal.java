package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.AccountRecoveryFinalBinding;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.domain.recovery.RecoveryMethodType;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
/* compiled from: RecoveryFinal.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RecoveryFinal;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "recoveryFinal", "Landroidx/constraintlayout/widget/ConstraintLayout;", "recoveryFinalBinding", "Lru/mrlargha/commonui/databinding/AccountRecoveryFinalBinding;", "timer", "Landroid/os/CountDownTimer;", "videoBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "setRecoveryValue", "", "recoveryMethodType", "recoveryValue", "", "resetRecoveryFinal", "setVisible", "visible", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RecoveryFinal implements InterfaceController {
    private final IBackendNotifier notifier;
    private final ConstraintLayout recoveryFinal;
    private final AccountRecoveryFinalBinding recoveryFinalBinding;
    private final Activity targetActivity;
    private CountDownTimer timer;
    private final BackgroundVideoBinding videoBinding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$2(View view) {
    }

    public RecoveryFinal(Activity targetActivity, final int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.account_recovery_final, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.recoveryFinal = constraintLayout;
        AccountRecoveryFinalBinding bind = AccountRecoveryFinalBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.recoveryFinalBinding = bind;
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), targetActivity, i);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        BackgroundVideoBinding mainBinding = ((RegistrationVideoBackground) orCreateInterface).getMainBinding();
        this.videoBinding = mainBinding;
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.notifier = (IBackendNotifier) targetActivity;
        mainBinding.video.addView(bind.accountRecoveryFinal, -1, -1);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainBinding.video);
        constraintSet.connect(bind.accountRecoveryFinal.getId(), 1, mainBinding.video.getId(), 1);
        constraintSet.connect(bind.accountRecoveryFinal.getId(), 3, mainBinding.video.getId(), 3);
        constraintSet.connect(bind.accountRecoveryFinal.getId(), 4, mainBinding.video.getId(), 4);
        constraintSet.applyTo(mainBinding.video);
        bind.accountRecoveryFinalReplyButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryFinal._init_$lambda$0(RecoveryFinal.this, i, view);
            }
        });
        bind.accountRecoveryFinalLoginButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryFinal._init_$lambda$1(RecoveryFinal.this, i, view);
            }
        });
        bind.accountRecoveryFinal.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryFinal._init_$lambda$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r3v3, types: [ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal$1$2] */
    public static final void _init_$lambda$0(final RecoveryFinal recoveryFinal, int i, View view) {
        if (recoveryFinal.timer != null) {
            Activity activity = recoveryFinal.targetActivity;
            Toast.makeText(activity, activity.getString(R.string.recovery_wait_resend_timer), 0).show();
            return;
        }
        recoveryFinal.notifier.clickedWrapper(i, 5, 0);
        recoveryFinal.recoveryFinalBinding.accountRecoveryFinalIsExist.setText(recoveryFinal.targetActivity.getString(R.string.recovery_sent_label));
        recoveryFinal.timer = new CountDownTimer() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(59000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                AccountRecoveryFinalBinding accountRecoveryFinalBinding;
                accountRecoveryFinalBinding = RecoveryFinal.this.recoveryFinalBinding;
                accountRecoveryFinalBinding.accountRecoveryFinalReplyButton.setText(String.valueOf(j / 1000));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                AccountRecoveryFinalBinding accountRecoveryFinalBinding;
                Activity activity2;
                AccountRecoveryFinalBinding accountRecoveryFinalBinding2;
                Activity activity3;
                accountRecoveryFinalBinding = RecoveryFinal.this.recoveryFinalBinding;
                TextView textView = accountRecoveryFinalBinding.accountRecoveryFinalIsExist;
                activity2 = RecoveryFinal.this.targetActivity;
                textView.setText(activity2.getString(R.string.not_arrived));
                accountRecoveryFinalBinding2 = RecoveryFinal.this.recoveryFinalBinding;
                TextView textView2 = accountRecoveryFinalBinding2.accountRecoveryFinalReplyButton;
                activity3 = RecoveryFinal.this.targetActivity;
                textView2.setText(activity3.getString(R.string.send_again));
                RecoveryFinal.this.timer = null;
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$1(RecoveryFinal recoveryFinal, int i, View view) {
        recoveryFinal.resetRecoveryFinal();
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTH_INIT.getId(), recoveryFinal.targetActivity, i);
        InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTHORIZATION_NEWS.getId(), recoveryFinal.targetActivity, i).setVisible(true);
        recoveryFinal.setVisible(false);
        orCreateInterface.setVisible(true);
    }

    public final void setRecoveryValue(int i, String recoveryValue) {
        Intrinsics.checkNotNullParameter(recoveryValue, "recoveryValue");
        String str = recoveryValue;
        this.recoveryFinalBinding.accountRecoveryFinalPlaceholder.setText(str);
        if (i == RecoveryMethodType.MAIL.getId()) {
            this.recoveryFinalBinding.accountRecoveryFinalIcon.setImageResource(R.drawable.mail_ic);
            this.recoveryFinalBinding.accountRecoveryDescription.setText(this.targetActivity.getString(R.string.mail_sent));
        } else if (i == RecoveryMethodType.VK.getId()) {
            this.recoveryFinalBinding.accountRecoveryFinalIcon.setImageResource(R.drawable.vk_ic);
            this.recoveryFinalBinding.accountRecoveryDescription.setText(this.targetActivity.getString(R.string.recovery_description_vk));
        }
        this.recoveryFinalBinding.accountRecoveryFinalPlaceholder.setText(str);
    }

    public final void resetRecoveryFinal() {
        this.recoveryFinalBinding.accountRecoveryFinalIcon.setImageResource(R.drawable.mail_ic);
        this.recoveryFinalBinding.accountRecoveryFinalPlaceholder.setText(this.targetActivity.getString(R.string.email));
        this.recoveryFinalBinding.accountRecoveryFinalIsExist.setText(this.targetActivity.getString(R.string.not_arrived));
        this.recoveryFinalBinding.accountRecoveryFinalReplyButton.setText(this.targetActivity.getString(R.string.send_again));
        this.recoveryFinalBinding.accountRecoveryDescription.setText(this.targetActivity.getString(R.string.mail_sent));
        this.timer = null;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.recoveryFinalBinding.accountRecoveryFinal.setVisibility(z ? 0 : 8);
    }
}
