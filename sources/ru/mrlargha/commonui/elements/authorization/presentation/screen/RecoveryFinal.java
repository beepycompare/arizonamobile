package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RecoveryFinal;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "recoveryFinal", "Landroidx/constraintlayout/widget/ConstraintLayout;", "recoveryFinalBinding", "Lru/mrlargha/commonui/databinding/AccountRecoveryFinalBinding;", "timer", "Landroid/os/CountDownTimer;", "videoBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "setRecoveryValue", "", "recoveryMethodType", "recoveryValue", "", "resetRecoveryFinal", "setVisible", "visible", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecoveryFinal implements InterfaceController {
    private final IBackendNotifier notifier;
    private final ConstraintLayout recoveryFinal;
    private final AccountRecoveryFinalBinding recoveryFinalBinding;
    private CountDownTimer timer;
    private final BackgroundVideoBinding videoBinding;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(View view) {
    }

    public RecoveryFinal(final Activity targetActivity, final int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
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
                RecoveryFinal._init_$lambda$1(RecoveryFinal.this, i, targetActivity, view);
            }
        });
        bind.accountRecoveryFinalLoginButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryFinal._init_$lambda$2(RecoveryFinal.this, targetActivity, i, view);
            }
        });
        bind.accountRecoveryFinal.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryFinal._init_$lambda$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v3, types: [ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal$1$2] */
    public static final void _init_$lambda$1(final RecoveryFinal recoveryFinal, int i, Activity activity, View view) {
        if (recoveryFinal.timer != null) {
            Toast.makeText(activity, "Для повторной отправки необходимо дождаться завершения таймера", 0).show();
            return;
        }
        recoveryFinal.notifier.clickedWrapper(i, 5, 0);
        recoveryFinal.recoveryFinalBinding.accountRecoveryFinalIsExist.setText("Письмо отправлено:");
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
                AccountRecoveryFinalBinding accountRecoveryFinalBinding2;
                accountRecoveryFinalBinding = RecoveryFinal.this.recoveryFinalBinding;
                accountRecoveryFinalBinding.accountRecoveryFinalIsExist.setText("Письмо не пришло?");
                accountRecoveryFinalBinding2 = RecoveryFinal.this.recoveryFinalBinding;
                accountRecoveryFinalBinding2.accountRecoveryFinalReplyButton.setText("Отправить повторно");
                RecoveryFinal.this.timer = null;
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(RecoveryFinal recoveryFinal, Activity activity, int i, View view) {
        recoveryFinal.resetRecoveryFinal();
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTH_INIT.getId(), activity, i);
        InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTHORIZATION_NEWS.getId(), activity, i).setVisible(true);
        recoveryFinal.setVisible(false);
        orCreateInterface.setVisible(true);
    }

    public final void setRecoveryValue(int i, String recoveryValue) {
        Intrinsics.checkNotNullParameter(recoveryValue, "recoveryValue");
        String str = recoveryValue;
        this.recoveryFinalBinding.accountRecoveryFinalPlaceholder.setText(str);
        if (i == RecoveryMethodType.MAIL.getId()) {
            this.recoveryFinalBinding.accountRecoveryFinalIcon.setImageResource(R.drawable.mail_ic);
            this.recoveryFinalBinding.accountRecoveryDescription.setText("Новый пароль уже выслан на вашу почту, проверьте спам, если не можете найти его");
        } else if (i == RecoveryMethodType.VK.getId()) {
            this.recoveryFinalBinding.accountRecoveryFinalIcon.setImageResource(R.drawable.vk_ic);
            this.recoveryFinalBinding.accountRecoveryDescription.setText("Новый пароль уже выслан в Вконтакте. Проверьте личные сообщения");
        }
        this.recoveryFinalBinding.accountRecoveryFinalPlaceholder.setText(str);
    }

    public final void resetRecoveryFinal() {
        this.recoveryFinalBinding.accountRecoveryFinalIcon.setImageResource(R.drawable.mail_ic);
        this.recoveryFinalBinding.accountRecoveryFinalPlaceholder.setText("Почта");
        this.recoveryFinalBinding.accountRecoveryFinalIsExist.setText("Письмо не пришло?");
        this.recoveryFinalBinding.accountRecoveryFinalReplyButton.setText("Отправить повторно");
        this.recoveryFinalBinding.accountRecoveryDescription.setText("Новый пароль уже выслан на вашу почту, проверьте спам, если не можете найти его");
        this.timer = null;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.recoveryFinalBinding.accountRecoveryFinal.setVisibility(z ? 0 : 8);
    }
}
