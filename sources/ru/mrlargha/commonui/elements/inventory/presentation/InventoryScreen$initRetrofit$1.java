package ru.mrlargha.commonui.elements.inventory.presentation;

import com.arizona.game.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryApi;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InventoryScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$initRetrofit$1", f = "InventoryScreen.kt", i = {}, l = {470}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class InventoryScreen$initRetrofit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InventoryScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InventoryScreen$initRetrofit$1(InventoryScreen inventoryScreen, Continuation<? super InventoryScreen$initRetrofit$1> continuation) {
        super(2, continuation);
        this.this$0 = inventoryScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InventoryScreen$initRetrofit$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InventoryScreen$initRetrofit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InventoryApi inventoryApi;
        String token;
        int i;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            inventoryApi = this.this$0.api;
            if (inventoryApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("api");
                inventoryApi = null;
            }
            InventoryApi inventoryApi2 = inventoryApi;
            token = this.this$0.getToken();
            i = this.this$0.serverId;
            z = this.this$0.isArizonaType;
            String str = z ? BuildConfig.FLAVOR : "rodina";
            this.label = 1;
            obj = InventoryApi.get$default(inventoryApi2, token, str, i, null, this, 8, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        UtilsKt.setItemsName((List) obj);
        SAMPUIElement.notifyClick$default(this.this$0, 0, 10, null, 4, null);
        return Unit.INSTANCE;
    }
}
