package ru.mrlargha.arizonaui.family;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import ru.mrlargha.arizonaui.family.data.FamilyData;
import ru.mrlargha.arizonaui.family.data.MemberItem;
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lru/mrlargha/arizonaui/family/data/MemberItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.family.FamilyScreen$requestMembersName$1$1$list$1", f = "FamilyScreen.kt", i = {}, l = {TypedValues.PositionType.TYPE_TRANSITION_EASING}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class FamilyScreen$requestMembersName$1$1$list$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MemberItem>>, Object> {
    final /* synthetic */ FamilyData $it;
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ FamilyScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen$requestMembersName$1$1$list$1(FamilyScreen familyScreen, FamilyData familyData, String str, Continuation<? super FamilyScreen$requestMembersName$1$1$list$1> continuation) {
        super(2, continuation);
        this.this$0 = familyScreen;
        this.$it = familyData;
        this.$name = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyScreen$requestMembersName$1$1$list$1(this.this$0, this.$it, this.$name, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MemberItem>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<MemberItem>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<MemberItem>> continuation) {
        return ((FamilyScreen$requestMembersName$1$1$list$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object membersName$default = FamilyApi.getMembersName$default(familyApi, token, null, i, id, 1, this.$name, this, 2, null);
        return membersName$default == coroutine_suspended ? coroutine_suspended : membersName$default;
    }
}
