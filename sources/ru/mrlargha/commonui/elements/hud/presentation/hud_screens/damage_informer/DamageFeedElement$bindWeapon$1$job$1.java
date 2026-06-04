package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: DamageInformerElement.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer.DamageFeedElement$bindWeapon$1$job$1", f = "DamageInformerElement.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, nl = {267}, s = {}, v = 2)
/* loaded from: classes6.dex */
final class DamageFeedElement$bindWeapon$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $imageId;
    final /* synthetic */ ImageView $ivWeapon;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DamageFeedElement$bindWeapon$1$job$1(ImageView imageView, int i, Continuation<? super DamageFeedElement$bindWeapon$1$job$1> continuation) {
        super(2, continuation);
        this.$ivWeapon = imageView;
        this.$imageId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DamageFeedElement$bindWeapon$1$job$1(this.$ivWeapon, this.$imageId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DamageFeedElement$bindWeapon$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageView imageView = this.$ivWeapon;
            int i2 = this.$imageId;
            this.label = 1;
            if (UtilsKt.gifGetFromZipAcync(imageView, "items", i2 + ".webp", this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
