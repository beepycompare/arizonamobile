package ru.mrlargha.commonui.elements;

import android.app.Activity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.NumberKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
/* compiled from: MicButton.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/MicButton;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", TtmlNode.TAG_LAYOUT, "Landroid/widget/FrameLayout;", "button", "Landroidx/appcompat/widget/AppCompatImageView;", "kotlin.jvm.PlatformType", "shouldMoveButton", "", "gestureDetector", "Landroid/view/GestureDetector;", "isEventFitsScreen", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "onBackendMessage", "", "data", "", "subId", "isEventOnButton", "e", "setButtonPosition", "x", "", "y", "Companion", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MicButton extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MicStatusElement";
    private static final String X_MIC_STATUS_POS = "X_MIC_STATUS_POS";
    private static final String Y_MIC_STATUS_POS = "Y_MIC_STATUS_POS";
    private final AppCompatImageView button;
    private final GestureDetector gestureDetector;
    private final FrameLayout layout;
    private boolean shouldMoveButton;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicButton(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.mic_status_element, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.layout = frameLayout;
        AppCompatImageView appCompatImageView = (AppCompatImageView) frameLayout.findViewById(R.id.mic_status_button);
        this.button = appCompatImageView;
        this.gestureDetector = new GestureDetector(targetActivity, new GestureDetector.OnGestureListener() { // from class: ru.mrlargha.commonui.elements.MicButton$gestureDetector$1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent e1, float f, float f2) {
                Intrinsics.checkNotNullParameter(e1, "e1");
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent e1, float f, float f2) {
                Intrinsics.checkNotNullParameter(e1, "e1");
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                boolean isEventOnButton;
                Intrinsics.checkNotNullParameter(e, "e");
                isEventOnButton = MicButton.this.isEventOnButton(e);
                return isEventOnButton;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                boolean isEventOnButton;
                Intrinsics.checkNotNullParameter(e, "e");
                MicButton.this.shouldMoveButton = false;
                Log.d("MicStatusElement", "onSingleTapUp: up");
                isEventOnButton = MicButton.this.isEventOnButton(e);
                return isEventOnButton;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e) {
                boolean isEventOnButton;
                Intrinsics.checkNotNullParameter(e, "e");
                isEventOnButton = MicButton.this.isEventOnButton(e);
                if (isEventOnButton) {
                    MicButton.this.shouldMoveButton = true;
                    Log.d("MicStatusElement", "onLongPress: longpressed");
                }
            }
        });
        addViewToConstraintLayout(frameLayout, -1, -1);
        setButtonPosition(getSharedPreferences().getFloat(X_MIC_STATUS_POS, NumberKt.toPx((Number) 20)), getSharedPreferences().getFloat(Y_MIC_STATUS_POS, (frameLayout.getHeight() / 2) - (appCompatImageView.getWidth() / 2)));
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.MicButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = MicButton._init_$lambda$0(MicButton.this, view, motionEvent);
                return _init_$lambda$0;
            }
        });
        appCompatImageView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.MicButton$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$1;
                _init_$lambda$1 = MicButton._init_$lambda$1(view, motionEvent);
                return _init_$lambda$1;
            }
        });
    }

    /* compiled from: MicButton.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/MicButton$Companion;", "", "<init>", "()V", "TAG", "", MicButton.X_MIC_STATUS_POS, MicButton.Y_MIC_STATUS_POS, "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(MicButton micButton, View view, MotionEvent motionEvent) {
        micButton.gestureDetector.onTouchEvent(motionEvent);
        if (micButton.shouldMoveButton) {
            if (motionEvent.getAction() == 2) {
                float x = motionEvent.getX() - (micButton.button.getWidth() / 2);
                float y = motionEvent.getY() - (micButton.button.getHeight() / 2);
                Intrinsics.checkNotNull(motionEvent);
                if (micButton.isEventFitsScreen(motionEvent)) {
                    micButton.setButtonPosition(x, y);
                }
            } else if (motionEvent.getAction() == 1) {
                Intrinsics.checkNotNull(motionEvent);
                if (micButton.isEventFitsScreen(motionEvent)) {
                    micButton.getSharedPreferences().edit().putFloat(X_MIC_STATUS_POS, micButton.button.getX()).putFloat(Y_MIC_STATUS_POS, micButton.button.getY()).apply();
                }
            }
        }
        if (motionEvent.getAction() == 1 && !micButton.shouldMoveButton && micButton.isEventOnButton(motionEvent)) {
            SAMPUIElement.notifyClick$default(micButton, 0, 0, null, 6, null);
            Log.d(TAG, "Microphone button: clicked");
        }
        return micButton.isEventOnButton(motionEvent);
    }

    private final boolean isEventFitsScreen(MotionEvent motionEvent) {
        return motionEvent.getX() + ((float) (this.button.getWidth() / 2)) <= ((float) this.layout.getWidth()) && motionEvent.getY() + ((float) (this.button.getHeight() / 2)) <= ((float) this.layout.getHeight()) && motionEvent.getX() - ((float) (this.button.getWidth() / 2)) >= 0.0f && motionEvent.getY() - ((float) (this.button.getHeight() / 2)) >= 0.0f;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(data, "data");
        AppCompatImageView appCompatImageView = this.button;
        if (i == 1) {
            i2 = R.drawable.mic_not_used;
        } else if (i == 2) {
            i2 = R.drawable.mic_used;
        } else {
            i2 = R.drawable.mic_disabled;
        }
        appCompatImageView.setImageResource(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEventOnButton(MotionEvent motionEvent) {
        return motionEvent != null && motionEvent.getX() >= this.button.getX() && motionEvent.getX() <= this.button.getX() + ((float) this.button.getWidth()) && motionEvent.getY() >= this.button.getY() && motionEvent.getY() <= this.button.getY() + ((float) this.button.getHeight());
    }

    private final void setButtonPosition(float f, float f2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) NumberKt.toPx((Number) 60), (int) NumberKt.toPx((Number) 60));
        layoutParams.leftMargin = (int) f;
        layoutParams.topMargin = (int) f2;
        this.button.setLayoutParams(layoutParams);
    }

    /* compiled from: MicButton.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/MicButton$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new MicButton(targetActivity, i);
        }
    }
}
