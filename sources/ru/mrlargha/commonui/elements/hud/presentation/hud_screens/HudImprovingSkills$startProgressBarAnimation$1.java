package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudImprovingSkillsBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HudImprovingSkills.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudImprovingSkills$startProgressBarAnimation$1", f = "HudImprovingSkills.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class HudImprovingSkills$startProgressBarAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HudImprovingSkillsBinding $binding;
    final /* synthetic */ HudImprovingSkillsModel $improvingSkillsModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HudImprovingSkills$startProgressBarAnimation$1(HudImprovingSkillsBinding hudImprovingSkillsBinding, HudImprovingSkillsModel hudImprovingSkillsModel, Continuation<? super HudImprovingSkills$startProgressBarAnimation$1> continuation) {
        super(2, continuation);
        this.$binding = hudImprovingSkillsBinding;
        this.$improvingSkillsModel = hudImprovingSkillsModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HudImprovingSkills$startProgressBarAnimation$1(this.$binding, this.$improvingSkillsModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HudImprovingSkills$startProgressBarAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int proc;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final HudImprovingSkillsBinding hudImprovingSkillsBinding = this.$binding;
        final HudImprovingSkillsModel hudImprovingSkillsModel = this.$improvingSkillsModel;
        HudImprovingSkills hudImprovingSkills = HudImprovingSkills.INSTANCE;
        ProgressBar progressBar = hudImprovingSkillsBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        proc = HudImprovingSkills.INSTANCE.getProc(hudImprovingSkillsModel.getNextExp(), hudImprovingSkillsModel.getMaxExp());
        hudImprovingSkills.animateProgressBar(progressBar, proc, 1000L, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudImprovingSkills$startProgressBarAnimation$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invokeSuspend$lambda$1$lambda$0;
                invokeSuspend$lambda$1$lambda$0 = HudImprovingSkills$startProgressBarAnimation$1.invokeSuspend$lambda$1$lambda$0(HudImprovingSkillsModel.this, hudImprovingSkillsBinding);
                return invokeSuspend$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$lambda$0(HudImprovingSkillsModel hudImprovingSkillsModel, HudImprovingSkillsBinding hudImprovingSkillsBinding) {
        if (hudImprovingSkillsModel.getNextExp() == hudImprovingSkillsModel.getMaxExp()) {
            hudImprovingSkillsBinding.skillToContainer.setBackgroundResource(R.drawable.hud_improving_skills_progress_yellow_bg);
            hudImprovingSkillsBinding.tvSkillsTo.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        return Unit.INSTANCE;
    }
}
