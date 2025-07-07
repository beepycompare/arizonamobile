package kotlinx.metadata;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0001H\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0017J\b\u0010\u001e\u001a\u00020\u001dH\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lkotlinx/metadata/KmEffect;", "Lkotlinx/metadata/KmEffectVisitor;", "type", "Lkotlinx/metadata/KmEffectType;", "invocationKind", "Lkotlinx/metadata/KmEffectInvocationKind;", "(Lkotlinx/metadata/KmEffectType;Lkotlinx/metadata/KmEffectInvocationKind;)V", "conclusion", "Lkotlinx/metadata/KmEffectExpression;", "getConclusion", "()Lkotlinx/metadata/KmEffectExpression;", "setConclusion", "(Lkotlinx/metadata/KmEffectExpression;)V", "constructorArguments", "", "getConstructorArguments", "()Ljava/util/List;", "getInvocationKind", "()Lkotlinx/metadata/KmEffectInvocationKind;", "setInvocationKind", "(Lkotlinx/metadata/KmEffectInvocationKind;)V", "getType", "()Lkotlinx/metadata/KmEffectType;", "setType", "(Lkotlinx/metadata/KmEffectType;)V", "accept", "", "visitor", "visitConclusionOfConditionalEffect", "Lkotlinx/metadata/KmEffectExpressionVisitor;", "visitConstructorArgument", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmEffect extends KmEffectVisitor {
    private KmEffectExpression conclusion;
    private final List<KmEffectExpression> constructorArguments;
    private KmEffectInvocationKind invocationKind;
    private KmEffectType type;

    public final KmEffectType getType() {
        return this.type;
    }

    public final void setType(KmEffectType kmEffectType) {
        Intrinsics.checkNotNullParameter(kmEffectType, "<set-?>");
        this.type = kmEffectType;
    }

    public final KmEffectInvocationKind getInvocationKind() {
        return this.invocationKind;
    }

    public final void setInvocationKind(KmEffectInvocationKind kmEffectInvocationKind) {
        this.invocationKind = kmEffectInvocationKind;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmEffect(KmEffectType type, KmEffectInvocationKind kmEffectInvocationKind) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.invocationKind = kmEffectInvocationKind;
        this.constructorArguments = new ArrayList(1);
    }

    public final List<KmEffectExpression> getConstructorArguments() {
        return this.constructorArguments;
    }

    public final KmEffectExpression getConclusion() {
        return this.conclusion;
    }

    public final void setConclusion(KmEffectExpression kmEffectExpression) {
        this.conclusion = kmEffectExpression;
    }

    @Override // kotlinx.metadata.KmEffectVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmEffectExpressionVisitor visitConstructorArgument() {
        return (KmEffectExpressionVisitor) NodesKt.addTo(new KmEffectExpression(), this.constructorArguments);
    }

    @Override // kotlinx.metadata.KmEffectVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmEffectExpressionVisitor visitConclusionOfConditionalEffect() {
        KmEffectExpression kmEffectExpression = new KmEffectExpression();
        this.conclusion = kmEffectExpression;
        return kmEffectExpression;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmEffectVisitor visitor) {
        KmEffectExpressionVisitor visitConclusionOfConditionalEffect;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        for (KmEffectExpression kmEffectExpression : this.constructorArguments) {
            KmEffectExpressionVisitor visitConstructorArgument = visitor.visitConstructorArgument();
            if (visitConstructorArgument != null) {
                kmEffectExpression.accept(visitConstructorArgument);
            }
        }
        KmEffectExpression kmEffectExpression2 = this.conclusion;
        if (kmEffectExpression2 != null && (visitConclusionOfConditionalEffect = visitor.visitConclusionOfConditionalEffect()) != null) {
            kmEffectExpression2.accept(visitConclusionOfConditionalEffect);
        }
        visitor.visitEnd();
    }
}
