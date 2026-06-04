package kotlin.contracts;

import com.facebook.internal.NativeProtocol;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
/* compiled from: Effect.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§\u0084\bb\u0002\b\u0006b\u0002\b\u0007b\u0002\b\bÊ\u0001\u0002\b\u0006Ê\u0001\u0002\b\u0007Ê\u0001\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¨\u0006\t"}, d2 = {"Lkotlin/contracts/SimpleEffect;", "Lkotlin/contracts/Effect;", "implies", "Lkotlin/contracts/ConditionalEffect;", "booleanExpression", "", "Lkotlin/internal/ContractsDsl;", "Lkotlin/contracts/ExperimentalContracts;", "Lkotlin/IgnorableReturnValue;", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SimpleEffect extends Effect {
    @IgnorableReturnValue
    ConditionalEffect implies(boolean z);
}
