package androidx.compose.foundation.style;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: StyleState.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
final class MutableStyleState$processInteractions$2<T> implements FlowCollector {
    final /* synthetic */ InteractionSet<FocusInteraction.Focus> $focusedInteractions;
    final /* synthetic */ InteractionSet<HoverInteraction.Enter> $hoveredInteractions;
    final /* synthetic */ InteractionSet<PressInteraction.Press> $pressedInteractions;
    final /* synthetic */ MutableStyleState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableStyleState$processInteractions$2(InteractionSet<PressInteraction.Press> interactionSet, MutableStyleState mutableStyleState, InteractionSet<HoverInteraction.Enter> interactionSet2, InteractionSet<FocusInteraction.Focus> interactionSet3) {
        this.$pressedInteractions = interactionSet;
        this.this$0 = mutableStyleState;
        this.$hoveredInteractions = interactionSet2;
        this.$focusedInteractions = interactionSet3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
        MutableStyleState$processInteractions$2$emit$1 mutableStyleState$processInteractions$2$emit$1;
        int i;
        MutableStyleState mutableStyleState;
        Iterator<Map.Entry<StyleStateKey<?>, Object>> it;
        if (continuation instanceof MutableStyleState$processInteractions$2$emit$1) {
            mutableStyleState$processInteractions$2$emit$1 = (MutableStyleState$processInteractions$2$emit$1) continuation;
            if ((mutableStyleState$processInteractions$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                mutableStyleState$processInteractions$2$emit$1.label -= Integer.MIN_VALUE;
                Object obj = mutableStyleState$processInteractions$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = mutableStyleState$processInteractions$2$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (interaction instanceof PressInteraction.Press) {
                        this.$pressedInteractions.add(interaction);
                        this.this$0.setPressed(true);
                    } else if (interaction instanceof PressInteraction.Release) {
                        this.$pressedInteractions.remove(((PressInteraction.Release) interaction).getPress());
                        this.this$0.setPressed(this.$pressedInteractions.isNotEmpty());
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        this.$pressedInteractions.remove(((PressInteraction.Cancel) interaction).getPress());
                        this.this$0.setPressed(this.$pressedInteractions.isNotEmpty());
                    } else if (interaction instanceof HoverInteraction.Enter) {
                        this.$hoveredInteractions.add(interaction);
                        this.this$0.setHovered(true);
                    } else if (interaction instanceof HoverInteraction.Exit) {
                        this.$hoveredInteractions.remove(((HoverInteraction.Exit) interaction).getEnter());
                        this.this$0.setHovered(this.$hoveredInteractions.isNotEmpty());
                    } else if (interaction instanceof FocusInteraction.Focus) {
                        this.$focusedInteractions.add(interaction);
                        this.this$0.setFocused(true);
                    } else if (interaction instanceof FocusInteraction.Unfocus) {
                        this.$focusedInteractions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
                        this.this$0.setFocused(this.$focusedInteractions.isNotEmpty());
                    } else {
                        mutableStyleState = this.this$0;
                        it = this.this$0.getCustomStates$foundation().entrySet().iterator();
                    }
                    return Unit.INSTANCE;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    it = (Iterator) mutableStyleState$processInteractions$2$emit$1.L$2;
                    ResultKt.throwOnFailure(obj);
                    mutableStyleState = (MutableStyleState) mutableStyleState$processInteractions$2$emit$1.L$1;
                    interaction = (Interaction) mutableStyleState$processInteractions$2$emit$1.L$0;
                }
                while (it.hasNext()) {
                    mutableStyleState$processInteractions$2$emit$1.L$0 = interaction;
                    mutableStyleState$processInteractions$2$emit$1.L$1 = mutableStyleState;
                    mutableStyleState$processInteractions$2$emit$1.L$2 = it;
                    mutableStyleState$processInteractions$2$emit$1.label = 1;
                    if (it.next().getKey().processInteractionAccess$foundation(interaction, mutableStyleState, mutableStyleState$processInteractions$2$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        mutableStyleState$processInteractions$2$emit$1 = new MutableStyleState$processInteractions$2$emit$1(this, continuation);
        Object obj2 = mutableStyleState$processInteractions$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = mutableStyleState$processInteractions$2$emit$1.label;
        if (i != 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Interaction) obj, (Continuation<? super Unit>) continuation);
    }
}
