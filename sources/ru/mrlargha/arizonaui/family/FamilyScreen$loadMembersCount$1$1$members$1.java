package ru.mrlargha.arizonaui.family;

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
import ru.mrlargha.arizonaui.family.data.FamilyData;
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.family.FamilyScreen$loadMembersCount$1$1$members$1", f = "FamilyScreen.kt", i = {}, l = {661}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class FamilyScreen$loadMembersCount$1$1$members$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ FamilyData $it;
    int label;
    final /* synthetic */ FamilyScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen$loadMembersCount$1$1$members$1(FamilyScreen familyScreen, FamilyData familyData, Continuation<? super FamilyScreen$loadMembersCount$1$1$members$1> continuation) {
        super(2, continuation);
        this.this$0 = familyScreen;
        this.$it = familyData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyScreen$loadMembersCount$1$1$members$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((FamilyScreen$loadMembersCount$1$1$members$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FamilyApi familyApi;
        String token;
        int i;
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
        token = this.this$0.getToken();
        i = this.this$0.serverId;
        this.label = 1;
        Object membersCount$default = FamilyApi.getMembersCount$default(familyApi, token, null, i, this.$it.getId(), this, 2, null);
        return membersCount$default == coroutine_suspended ? coroutine_suspended : membersCount$default;
    }
}
