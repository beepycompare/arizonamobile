package ru.mrlargha.commonui.elements;

import android.app.Activity;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
/* compiled from: InteractionButton.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/InteractionButton;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "button", "Lcom/google/android/material/button/MaterialButton;", "onBackendMessage", "", "data", "", "subId", "setButtonText", "text", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InteractionButton extends SAMPUIElement {
    private final MaterialButton button;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionButton(Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.interaction_button, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
        MaterialButton materialButton = (MaterialButton) inflate;
        this.button = materialButton;
        addViewToConstraintLayout(materialButton, (int) TypedValue.applyDimension(1, 175.0f, targetActivity.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, targetActivity.getResources().getDisplayMetrics()));
        setPosition(SAMPUIElement.PositionType.CENTER_BOTTOM, 30, 50);
        setVisibility(false);
        materialButton.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.InteractionButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = InteractionButton._init_$lambda$0(InteractionButton.this, i, view, motionEvent);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(InteractionButton interactionButton, int i, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            interactionButton.getNotifier().clickedWrapper(i, 0, -1);
            interactionButton.button.setBackgroundResource(R.drawable.interaction_button_pressed_new);
            return true;
        } else if (action == 1 || action == 3) {
            interactionButton.button.setBackgroundResource(R.drawable.interaction_button_new);
            return false;
        } else {
            return false;
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        setButtonText(data);
    }

    private final void setButtonText(String str) {
        this.button.setText(str);
    }

    /* compiled from: InteractionButton.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/InteractionButton$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new InteractionButton(targetActivity, i);
        }
    }
}
