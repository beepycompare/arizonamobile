package com.arizonagames.feature.minigames.conveyor;

import android.animation.Animator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConveyorGameScreen.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/arizonagames/feature/minigames/conveyor/ConveyorGameScreen$startInfiniteAnimation$1$onGlobalLayout$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "conveyor"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConveyorGameScreen$startInfiniteAnimation$1$onGlobalLayout$1 implements Animator.AnimatorListener {
    final /* synthetic */ ConveyorGameScreen this$0;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConveyorGameScreen$startInfiniteAnimation$1$onGlobalLayout$1(ConveyorGameScreen conveyorGameScreen) {
        this.this$0 = conveyorGameScreen;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        ConveyorGameItemAdapter conveyorGameItemAdapter;
        ConveyorGameItemAdapter conveyorGameItemAdapter2;
        List randomItemImageList;
        Intrinsics.checkNotNullParameter(animation, "animation");
        conveyorGameItemAdapter = this.this$0.itemAdapter;
        conveyorGameItemAdapter.startAnimation();
        conveyorGameItemAdapter2 = this.this$0.itemAdapter;
        randomItemImageList = this.this$0.getRandomItemImageList();
        List list = CollectionsKt.toList(randomItemImageList);
        final ConveyorGameScreen conveyorGameScreen = this.this$0;
        conveyorGameItemAdapter2.submitList(list, new Runnable() { // from class: com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen$startInfiniteAnimation$1$onGlobalLayout$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConveyorGameScreen$startInfiniteAnimation$1$onGlobalLayout$1.onAnimationEnd$lambda$0(ConveyorGameScreen.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onAnimationEnd$lambda$0(ConveyorGameScreen conveyorGameScreen) {
        ConveyorGameItemAdapter conveyorGameItemAdapter;
        conveyorGameItemAdapter = conveyorGameScreen.itemAdapter;
        conveyorGameItemAdapter.notifyDataSetChanged();
    }
}
