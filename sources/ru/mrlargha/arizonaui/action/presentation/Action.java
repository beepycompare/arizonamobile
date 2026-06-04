package ru.mrlargha.arizonaui.action.presentation;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.ActionBinding;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: Action.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0006J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0012J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0006H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lru/mrlargha/arizonaui/action/presentation/Action;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "action", "Landroid/widget/RelativeLayout;", "getAction", "()Landroid/widget/RelativeLayout;", "actionBinding", "Lru/mrlargha/arizonaui/databinding/ActionBinding;", "getActionBinding", "()Lru/mrlargha/arizonaui/databinding/ActionBinding;", "setAction", "", "text", "", "setProgress", "time", "onPause", "owner", "Landroidx/lifecycle/LifecycleOwner;", "hideView", "onBackendMessageHandled", "data", "subId", "Spawner", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Action extends SAMPUIElement implements DefaultLifecycleObserver {
    private final RelativeLayout action;
    private final ActionBinding actionBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Action(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.action, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        this.action = relativeLayout;
        ActionBinding bind = ActionBinding.bind(relativeLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.actionBinding = bind;
        SAMPUIElement.addViewToConstraintLayout$default(this, relativeLayout, 0, 0, 6, null);
        setVisibility(false);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }

    public final RelativeLayout getAction() {
        return this.action;
    }

    public final ActionBinding getActionBinding() {
        return this.actionBinding;
    }

    public final void setAction(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.actionBinding.actionDescription;
        String str = text;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '\"') {
                sb.append(charAt);
            }
        }
        textView.setText(sb.toString());
    }

    public final void setProgress(int i) {
        final long j = i * 1000;
        final long j2 = j / 100;
        final Ref.IntRef intRef = new Ref.IntRef();
        getTargetActivity().runOnUiThread(new Runnable() { // from class: ru.mrlargha.arizonaui.action.presentation.Action$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                new CountDownTimer(j, j2) { // from class: ru.mrlargha.arizonaui.action.presentation.Action$setProgress$1$1
                    @Override // android.os.CountDownTimer
                    public void onTick(long j3) {
                        r5.getActionBinding().actionPgb.setProgress(r6.element);
                        r5.getActionBinding().actionPercent.setText(r6.element + "%");
                        r6.element++;
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        r5.hideView();
                    }
                }.start();
            }
        });
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        hideView();
        super.onPause(owner);
    }

    public final void hideView() {
        setVisibility(false);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setAction(data);
        } else if (i != 1) {
        } else {
            setProgress(Integer.parseInt(data));
        }
    }

    /* compiled from: Action.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/arizonaui/action/presentation/Action$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_ACTION);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new Action(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
