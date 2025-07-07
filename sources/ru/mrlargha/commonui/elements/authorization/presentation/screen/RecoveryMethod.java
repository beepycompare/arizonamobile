package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.AccountRecoveryMethodBinding;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
/* compiled from: RecoveryMethod.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RecoveryMethod;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "recoveryMethod", "Landroidx/constraintlayout/widget/ConstraintLayout;", "recoveryMethodBinding", "Lru/mrlargha/commonui/databinding/AccountRecoveryMethodBinding;", "videoBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "whiteColor", "grayColor", "selectedMethod", "", "setVisible", "", "visible", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecoveryMethod implements InterfaceController {
    private final int backendID;
    private final int grayColor;
    private final ConstraintLayout recoveryMethod;
    private final AccountRecoveryMethodBinding recoveryMethodBinding;
    private String selectedMethod;
    private final Activity targetActivity;
    private final BackgroundVideoBinding videoBinding;
    private final int whiteColor;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(View view) {
    }

    public RecoveryMethod(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.backendID = i;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.account_recovery_method, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.recoveryMethod = constraintLayout;
        AccountRecoveryMethodBinding bind = AccountRecoveryMethodBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.recoveryMethodBinding = bind;
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), targetActivity, i);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        BackgroundVideoBinding mainBinding = ((RegistrationVideoBackground) orCreateInterface).getMainBinding();
        this.videoBinding = mainBinding;
        this.whiteColor = Color.parseColor("#FFFFFF");
        this.grayColor = Color.parseColor("#7E7E7E");
        mainBinding.video.addView(bind.accountRecoveryMethod, -1, -1);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainBinding.video);
        constraintSet.connect(bind.accountRecoveryMethod.getId(), 1, mainBinding.video.getId(), 1);
        constraintSet.connect(bind.accountRecoveryMethod.getId(), 3, mainBinding.video.getId(), 3);
        constraintSet.connect(bind.accountRecoveryMethod.getId(), 4, mainBinding.video.getId(), 4);
        constraintSet.applyTo(mainBinding.video);
        bind.accountRecoveryMethodMail.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryMethod$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryMethod._init_$lambda$0(RecoveryMethod.this, view);
            }
        });
        bind.accountRecoveryMethodVk.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryMethod$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryMethod._init_$lambda$1(RecoveryMethod.this, view);
            }
        });
        bind.accountRecoveryMethodTelegram.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryMethod$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryMethod._init_$lambda$2(RecoveryMethod.this, view);
            }
        });
        bind.accountRecoveryMethodNext.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryMethod$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryMethod._init_$lambda$4(RecoveryMethod.this, view);
            }
        });
        bind.accountRecoveryMethod.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryMethod$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryMethod._init_$lambda$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(RecoveryMethod recoveryMethod, View view) {
        recoveryMethod.selectedMethod = "Почта";
        view.setBackgroundResource(R.drawable.authorization_border_red);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodVk.setBackgroundResource(R.drawable.authorization_border);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodTelegram.setBackgroundResource(R.drawable.authorization_border);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodMailIcon.setColorFilter(recoveryMethod.whiteColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMailPlaceholder.setTextColor(recoveryMethod.whiteColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodVkIcon.setColorFilter(recoveryMethod.grayColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryVkPlaceholder.setTextColor(recoveryMethod.grayColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodTelegramIcon.setColorFilter(recoveryMethod.grayColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryTelegramPlaceholder.setTextColor(recoveryMethod.grayColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(RecoveryMethod recoveryMethod, View view) {
        recoveryMethod.selectedMethod = "Вконтакте";
        view.setBackgroundResource(R.drawable.authorization_border_red);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodMail.setBackgroundResource(R.drawable.authorization_border);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodTelegram.setBackgroundResource(R.drawable.authorization_border);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodVkIcon.setColorFilter(recoveryMethod.whiteColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryVkPlaceholder.setTextColor(recoveryMethod.whiteColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodMailIcon.setColorFilter(recoveryMethod.grayColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMailPlaceholder.setTextColor(recoveryMethod.grayColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodTelegramIcon.setColorFilter(recoveryMethod.grayColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryTelegramPlaceholder.setTextColor(recoveryMethod.grayColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(RecoveryMethod recoveryMethod, View view) {
        recoveryMethod.selectedMethod = "Телеграм";
        view.setBackgroundResource(R.drawable.authorization_border_red);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodMail.setBackgroundResource(R.drawable.authorization_border);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodVk.setBackgroundResource(R.drawable.authorization_border);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodTelegramIcon.setColorFilter(recoveryMethod.whiteColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryTelegramPlaceholder.setTextColor(recoveryMethod.whiteColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodMailIcon.setColorFilter(recoveryMethod.grayColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMailPlaceholder.setTextColor(recoveryMethod.grayColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryMethodVkIcon.setColorFilter(recoveryMethod.grayColor);
        recoveryMethod.recoveryMethodBinding.accountRecoveryVkPlaceholder.setTextColor(recoveryMethod.grayColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(RecoveryMethod recoveryMethod, View view) {
        String str = recoveryMethod.selectedMethod;
        if (str != null) {
            InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.RECOVERY_HANDLER.getId(), recoveryMethod.targetActivity, recoveryMethod.backendID);
            Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler");
            RecoveryHandler recoveryHandler = (RecoveryHandler) orCreateInterface;
            recoveryHandler.selectRecoveryMethod(str);
            recoveryMethod.setVisible(false);
            recoveryHandler.setVisible(true);
        }
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.recoveryMethodBinding.accountRecoveryMethod.setVisibility(z ? 0 : 8);
    }
}
