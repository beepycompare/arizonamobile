package com.arizonagames.feature.arizona.imageviewer;

import android.app.Activity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: ArizonaImageViewerScreen.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/ArizonaImageViewerScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "imageViewer", "Lcom/arizonagames/feature/arizona/imageviewer/ArizonaImageViewerView;", "visibilityAnimationGeneration", "isClosingAnimationRunning", "", "setVisibility", "", "visible", "showWithAnimation", "wasVisible", "wasClosing", "hideWithAnimation", "completeHideAnimation", "animationGeneration", "restoreAnimationState", "prepareOpeningAnimationState", "Spawner", "Companion", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArizonaImageViewerScreen extends SAMPUIElement {
    @Deprecated
    public static final float CLOSE_ACCELERATION_FACTOR = 1.2f;
    @Deprecated
    public static final long CLOSE_ANIMATION_DURATION_MS = 180;
    @Deprecated
    public static final int CLOSE_CLICK_ID = 0;
    @Deprecated
    public static final int CLOSE_CLICK_SUB_ID = 0;
    @Deprecated
    public static final float CLOSE_END_ALPHA = 0.0f;
    @Deprecated
    public static final float CLOSE_END_SCALE = 0.975f;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final long OPEN_ANIMATION_DURATION_MS = 260;
    @Deprecated
    public static final float OPEN_DECELERATION_FACTOR = 1.45f;
    @Deprecated
    public static final float OPEN_START_ALPHA = 0.0f;
    @Deprecated
    public static final float OPEN_START_SCALE = 0.96f;
    private final ArizonaImageViewerView imageViewer;
    private boolean isClosingAnimationRunning;
    private int visibilityAnimationGeneration;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaImageViewerScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        ArizonaImageViewerView arizonaImageViewerView = new ArizonaImageViewerView(targetActivity, i, new Function0() { // from class: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArizonaImageViewerScreen.imageViewer$lambda$0(ArizonaImageViewerScreen.this);
            }
        });
        arizonaImageViewerView.setId(View.generateViewId());
        this.imageViewer = arizonaImageViewerView;
        prepareOpeningAnimationState();
        addViewToConstraintLayout(arizonaImageViewerView, -1, -1);
        super.setVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit imageViewer$lambda$0(ArizonaImageViewerScreen arizonaImageViewerScreen) {
        SAMPUIElement.notifyClick$default(arizonaImageViewerScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        boolean isOnScreen = isOnScreen();
        boolean z2 = this.isClosingAnimationRunning;
        if (z || !z2) {
            if (z) {
                showWithAnimation(isOnScreen, z2);
                bringToFront();
                this.imageViewer.loadWelcomeBanners$image_viewer();
                return;
            }
            hideWithAnimation(isOnScreen);
        }
    }

    private final void showWithAnimation(boolean z, boolean z2) {
        this.visibilityAnimationGeneration++;
        this.isClosingAnimationRunning = false;
        this.imageViewer.animate().cancel();
        if (z && !z2) {
            super.setVisibility(true);
            restoreAnimationState();
            return;
        }
        final int i = this.visibilityAnimationGeneration;
        prepareOpeningAnimationState();
        super.setVisibility(true);
        this.imageViewer.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(260L).setInterpolator(new DecelerateInterpolator(1.45f)).withEndAction(new Runnable() { // from class: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerScreen$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ArizonaImageViewerScreen.showWithAnimation$lambda$0(i, this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showWithAnimation$lambda$0(int i, ArizonaImageViewerScreen arizonaImageViewerScreen) {
        if (i == arizonaImageViewerScreen.visibilityAnimationGeneration) {
            arizonaImageViewerScreen.restoreAnimationState();
        }
    }

    private final void hideWithAnimation(boolean z) {
        int i = this.visibilityAnimationGeneration;
        if (!z) {
            this.visibilityAnimationGeneration = i + 1;
            this.imageViewer.animate().cancel();
            super.setVisibility(false);
            restoreAnimationState();
            return;
        }
        final int i2 = i + 1;
        this.visibilityAnimationGeneration = i2;
        this.isClosingAnimationRunning = true;
        this.imageViewer.animate().cancel();
        this.imageViewer.animate().alpha(0.0f).scaleX(0.975f).scaleY(0.975f).setDuration(180L).setInterpolator(new AccelerateInterpolator(1.2f)).withEndAction(new Runnable() { // from class: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerScreen$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ArizonaImageViewerScreen.this.completeHideAnimation(i2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeHideAnimation(int i) {
        if (i != this.visibilityAnimationGeneration) {
            return;
        }
        this.isClosingAnimationRunning = false;
        super.setVisibility(false);
        restoreAnimationState();
    }

    private final void restoreAnimationState() {
        this.imageViewer.setAlpha(1.0f);
        this.imageViewer.setScaleX(1.0f);
        this.imageViewer.setScaleY(1.0f);
    }

    private final void prepareOpeningAnimationState() {
        this.imageViewer.setAlpha(0.0f);
        this.imageViewer.setScaleX(0.96f);
        this.imageViewer.setScaleY(0.96f);
    }

    /* compiled from: ArizonaImageViewerScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/ArizonaImageViewerScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_IMAGE_VIEWER);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new ArizonaImageViewerScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    /* compiled from: ArizonaImageViewerScreen.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/ArizonaImageViewerScreen$Companion;", "", "<init>", "()V", "CLOSE_CLICK_ID", "", "CLOSE_CLICK_SUB_ID", "OPEN_START_ALPHA", "", "OPEN_START_SCALE", "CLOSE_END_ALPHA", "CLOSE_END_SCALE", "OPEN_ANIMATION_DURATION_MS", "", "CLOSE_ANIMATION_DURATION_MS", "OPEN_DECELERATION_FACTOR", "CLOSE_ACCELERATION_FACTOR", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
