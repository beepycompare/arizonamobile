package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lkotlinx/metadata/KmLambda;", "Lkotlinx/metadata/KmLambdaVisitor;", "()V", "function", "Lkotlinx/metadata/KmFunction;", "getFunction", "()Lkotlinx/metadata/KmFunction;", "setFunction", "(Lkotlinx/metadata/KmFunction;)V", "accept", "", "visitor", "visitFunction", "Lkotlinx/metadata/KmFunctionVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "name", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmLambda extends KmLambdaVisitor {
    public KmFunction function;

    public KmLambda() {
        super(null, 1, null);
    }

    public final KmFunction getFunction() {
        KmFunction kmFunction = this.function;
        if (kmFunction != null) {
            return kmFunction;
        }
        Intrinsics.throwUninitializedPropertyAccessException("function");
        return null;
    }

    public final void setFunction(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<set-?>");
        this.function = kmFunction;
    }

    @Override // kotlinx.metadata.KmLambdaVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmFunctionVisitor visitFunction(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmFunction kmFunction = new KmFunction(i, name);
        setFunction(kmFunction);
        return kmFunction;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmLambdaVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        KmFunctionVisitor visitFunction = visitor.visitFunction(getFunction().getFlags(), getFunction().getName());
        if (visitFunction != null) {
            getFunction().accept(visitFunction);
        }
        visitor.visitEnd();
    }
}
