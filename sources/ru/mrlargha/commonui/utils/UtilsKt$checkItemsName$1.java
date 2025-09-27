package ru.mrlargha.commonui.utils;

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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryApi;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt$checkItemsName$1", f = "Utils.kt", i = {}, l = {342}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes6.dex */
public final class UtilsKt$checkItemsName$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<InventoryApi> $api;
    final /* synthetic */ boolean $isArizona;
    final /* synthetic */ int $serverId;
    final /* synthetic */ String $token;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilsKt$checkItemsName$1(Ref.ObjectRef<InventoryApi> objectRef, boolean z, String str, int i, Continuation<? super UtilsKt$checkItemsName$1> continuation) {
        super(2, continuation);
        this.$api = objectRef;
        this.$isArizona = z;
        this.$token = str;
        this.$serverId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UtilsKt$checkItemsName$1(this.$api, this.$isArizona, this.$token, this.$serverId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UtilsKt$checkItemsName$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InventoryApi inventoryApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$api.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("api");
                inventoryApi = null;
            } else {
                inventoryApi = this.$api.element;
            }
            InventoryApi inventoryApi2 = inventoryApi;
            String str = this.$isArizona ? BuildConfig.FLAVOR : "rodina";
            String str2 = this.$token;
            this.label = 1;
            obj = InventoryApi.get$default(inventoryApi2, str2, str, this.$serverId, null, this, 8, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        UtilsKt.setItemsName((List) obj);
        return Unit.INSTANCE;
    }
}
