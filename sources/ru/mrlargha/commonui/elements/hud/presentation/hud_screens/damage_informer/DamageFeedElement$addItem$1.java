package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer;

import androidx.compose.runtime.GapComposerKt;
import androidx.media3.common.C;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import okhttp3.internal.ws.WebSocketProtocol;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer.DamageFeedElement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DamageInformerElement.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer.DamageFeedElement$addItem$1", f = "DamageInformerElement.kt", i = {}, l = {GapComposerKt.nodeKey}, m = "invokeSuspend", n = {}, nl = {WebSocketProtocol.PAYLOAD_SHORT}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class DamageFeedElement$addItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DamageFeedElement.ActiveDamageItem $activeItem;
    final /* synthetic */ DamageLogItem $item;
    int label;
    final /* synthetic */ DamageFeedElement this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DamageFeedElement$addItem$1(DamageLogItem damageLogItem, DamageFeedElement damageFeedElement, DamageFeedElement.ActiveDamageItem activeDamageItem, Continuation<? super DamageFeedElement$addItem$1> continuation) {
        super(2, continuation);
        this.$item = damageLogItem;
        this.this$0 = damageFeedElement;
        this.$activeItem = activeDamageItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DamageFeedElement$addItem$1(this.$item, this.this$0, this.$activeItem, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DamageFeedElement$addItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Long showTime = this.$item.getShowTime();
            long longValue = showTime != null ? showTime.longValue() : C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
            this.label = 1;
            if (DelayKt.delay(longValue, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.removeByToken(this.$item.getType(), this.$activeItem.getToken());
        return Unit.INSTANCE;
    }
}
