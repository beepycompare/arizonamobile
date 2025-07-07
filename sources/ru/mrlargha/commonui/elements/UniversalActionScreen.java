package ru.mrlargha.commonui.elements;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.UniversalActionScreenBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: UniversalActionScreen.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0017H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/UniversalActionScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "universalAction", "Landroid/view/View;", "kotlin.jvm.PlatformType", "universalActionBinding", "Lru/mrlargha/commonui/databinding/UniversalActionScreenBinding;", "isScreenVisible", "", "setVisibility", "", "visible", "onBackendMessage", "data", "", "subId", "setProgress", "Lru/mrlargha/commonui/elements/UniversalAction;", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UniversalActionScreen extends SAMPUIElement {
    private boolean isScreenVisible;
    private final View universalAction;
    private final UniversalActionScreenBinding universalActionBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniversalActionScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View universalAction = targetActivity.getLayoutInflater().inflate(R.layout.universal_action_screen, (ViewGroup) null);
        this.universalAction = universalAction;
        final UniversalActionScreenBinding bind = UniversalActionScreenBinding.bind(universalAction);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.universalActionBinding = bind;
        Intrinsics.checkNotNullExpressionValue(universalAction, "universalAction");
        addViewToConstraintLayout(universalAction, -1, -1);
        bind.rodinaProgressTouchIcon.startAnimation(AnimationUtils.loadAnimation(targetActivity, R.anim.bounce));
        bind.rodinaProgressTouchContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.UniversalActionScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversalActionScreen.lambda$1$lambda$0(UniversalActionScreenBinding.this, this, view);
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        this.isScreenVisible = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$1$lambda$0(UniversalActionScreenBinding universalActionScreenBinding, UniversalActionScreen universalActionScreen, View view) {
        ProgressBar progressBar = universalActionScreenBinding.rodinaProgressBar;
        progressBar.setProgress(progressBar.getProgress() + 1);
        SAMPUIElement.notifyClick$default(universalActionScreen, 0, -1, null, 4, null);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        UniversalAction universalAction;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i != 0 || (universalAction = (UniversalAction) MapperKt.jsonToModel(data, UniversalAction.class, getBackendID(), getTargetActivity(), getNotifier())) == null) {
            return;
        }
        setProgress(universalAction);
    }

    private final void setProgress(UniversalAction universalAction) {
        UniversalActionScreenBinding universalActionScreenBinding = this.universalActionBinding;
        universalActionScreenBinding.rodinaProgressTouchIcon.startAnimation(AnimationUtils.loadAnimation(getTargetActivity(), R.anim.bounce));
        universalActionScreenBinding.rodinaProgressBar.setProgress(universalAction.getProgress());
        universalActionScreenBinding.rodinaUniversalActionText.setText(universalAction.getText());
    }

    /* compiled from: UniversalActionScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/UniversalActionScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new UniversalActionScreen(targetActivity, i);
        }
    }
}
