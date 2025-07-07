package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.databinding.HudImprovingSkillsBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: HudImprovingSkills.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J0\u0010\u0017\u001a\u00020\u0007*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudImprovingSkills;", "", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "showImprovingSkills", "", "binding", "Lru/mrlargha/commonui/databinding/HudImprovingSkillsBinding;", "data", "", "initialize", "improvingSkillsModel", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudImprovingSkillsModel;", "startProgressBarAnimation", "hideImprovingSkillsAfterDelay", TypedValues.TransitionType.S_DURATION, "", "getProc", "first", "", "second", "animateProgressBar", "Landroid/widget/ProgressBar;", "toProgress", "", "onEnd", "Lkotlin/Function0;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudImprovingSkills {
    public static final HudImprovingSkills INSTANCE = new HudImprovingSkills();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    /* JADX INFO: Access modifiers changed from: private */
    public final int getProc(double d, double d2) {
        return (int) ((d / d2) * 100);
    }

    private HudImprovingSkills() {
    }

    public final void showImprovingSkills(HudImprovingSkillsBinding binding, String data) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(data, "data");
        HudImprovingSkillsModel hudImprovingSkillsModel = (HudImprovingSkillsModel) MapperKt.toModel(data, HudImprovingSkillsModel.class);
        initialize(binding, hudImprovingSkillsModel);
        startProgressBarAnimation(binding, hudImprovingSkillsModel);
        hideImprovingSkillsAfterDelay(binding, (int) hudImprovingSkillsModel.getDuration());
    }

    private final void initialize(HudImprovingSkillsBinding hudImprovingSkillsBinding, HudImprovingSkillsModel hudImprovingSkillsModel) {
        LinearLayout root = hudImprovingSkillsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        hudImprovingSkillsBinding.tvTitle.setText(hudImprovingSkillsModel.getTitle());
        hudImprovingSkillsBinding.tvDescription.setText(hudImprovingSkillsModel.getDescription());
        hudImprovingSkillsBinding.tvSkillsFrom.setText(String.valueOf((int) hudImprovingSkillsModel.getCurrentLevel()));
        hudImprovingSkillsBinding.tvSkillsTo.setText(String.valueOf((int) hudImprovingSkillsModel.getNextLevel()));
        hudImprovingSkillsBinding.tvHaveExp.setText(String.valueOf((int) hudImprovingSkillsModel.getNextExp()));
        hudImprovingSkillsBinding.tvNeedExp.setText(" / " + ((int) hudImprovingSkillsModel.getMaxExp()));
        hudImprovingSkillsBinding.progressBar.setProgress(INSTANCE.getProc(hudImprovingSkillsModel.getCurrentExp(), hudImprovingSkillsModel.getMaxExp()));
    }

    private final void startProgressBarAnimation(HudImprovingSkillsBinding hudImprovingSkillsBinding, HudImprovingSkillsModel hudImprovingSkillsModel) {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new HudImprovingSkills$startProgressBarAnimation$1(hudImprovingSkillsBinding, hudImprovingSkillsModel, null), 3, null);
    }

    private final void hideImprovingSkillsAfterDelay(HudImprovingSkillsBinding hudImprovingSkillsBinding, int i) {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new HudImprovingSkills$hideImprovingSkillsAfterDelay$1(i, hudImprovingSkillsBinding, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void animateProgressBar$default(HudImprovingSkills hudImprovingSkills, ProgressBar progressBar, int i, long j, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 1000;
        }
        long j2 = j;
        Function0<Unit> function02 = function0;
        if ((i2 & 4) != 0) {
            function02 = null;
        }
        hudImprovingSkills.animateProgressBar(progressBar, i, j2, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateProgressBar(ProgressBar progressBar, int i, long j, final Function0<Unit> function0) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(progressBar, "progress", progressBar.getProgress(), i);
        ofInt.setDuration(j);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudImprovingSkills$animateProgressBar$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Function0<Unit> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
        ofInt.start();
    }
}
