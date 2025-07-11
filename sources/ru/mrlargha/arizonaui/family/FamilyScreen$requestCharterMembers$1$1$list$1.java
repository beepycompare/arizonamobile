package ru.mrlargha.arizonaui.family;

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
import ru.mrlargha.arizonaui.family.data.CharterItem;
import ru.mrlargha.arizonaui.family.data.FamilyData;
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lru/mrlargha/arizonaui/family/data/CharterItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.family.FamilyScreen$requestCharterMembers$1$1$list$1", f = "FamilyScreen.kt", i = {}, l = {523}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class FamilyScreen$requestCharterMembers$1$1$list$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends CharterItem>>, Object> {
    final /* synthetic */ FamilyData $it;
    final /* synthetic */ int $page;
    int label;
    final /* synthetic */ FamilyScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen$requestCharterMembers$1$1$list$1(FamilyScreen familyScreen, FamilyData familyData, int i, Continuation<? super FamilyScreen$requestCharterMembers$1$1$list$1> continuation) {
        super(2, continuation);
        this.this$0 = familyScreen;
        this.$it = familyData;
        this.$page = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyScreen$requestCharterMembers$1$1$list$1(this.this$0, this.$it, this.$page, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends CharterItem>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<CharterItem>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<CharterItem>> continuation) {
        return ((FamilyScreen$requestCharterMembers$1$1$list$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FamilyApi familyApi;
        int i;
        String token;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        familyApi = this.this$0.api;
        if (familyApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("api");
            familyApi = null;
        }
        i = this.this$0.serverId;
        int id = this.$it.getId();
        token = this.this$0.getToken();
        this.label = 1;
        Object charter$default = FamilyApi.getCharter$default(familyApi, token, null, i, id, this.$page, this, 2, null);
        return charter$default == coroutine_suspended ? coroutine_suspended : charter$default;
    }
}
