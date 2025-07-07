package kotlinx.metadata;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkotlinx/metadata/KmContract;", "Lkotlinx/metadata/KmContractVisitor;", "()V", "effects", "", "Lkotlinx/metadata/KmEffect;", "getEffects", "()Ljava/util/List;", "accept", "", "visitor", "visitEffect", "Lkotlinx/metadata/KmEffectVisitor;", "type", "Lkotlinx/metadata/KmEffectType;", "invocationKind", "Lkotlinx/metadata/KmEffectInvocationKind;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmContract extends KmContractVisitor {
    private final List<KmEffect> effects;

    public KmContract() {
        super(null, 1, null);
        this.effects = new ArrayList(1);
    }

    public final List<KmEffect> getEffects() {
        return this.effects;
    }

    @Override // kotlinx.metadata.KmContractVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmEffectVisitor visitEffect(KmEffectType type, KmEffectInvocationKind kmEffectInvocationKind) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmEffectVisitor) NodesKt.addTo(new KmEffect(type, kmEffectInvocationKind), this.effects);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmContractVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        for (KmEffect kmEffect : this.effects) {
            KmEffectVisitor visitEffect = visitor.visitEffect(kmEffect.getType(), kmEffect.getInvocationKind());
            if (visitEffect != null) {
                kmEffect.accept(visitEffect);
            }
        }
        visitor.visitEnd();
    }
}
