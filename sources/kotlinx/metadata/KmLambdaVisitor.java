package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/metadata/KmLambdaVisitor;", "", "delegate", "(Lkotlinx/metadata/KmLambdaVisitor;)V", "visitEnd", "", "visitFunction", "Lkotlinx/metadata/KmFunctionVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "name", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmLambdaVisitor {
    private final KmLambdaVisitor delegate;

    public KmLambdaVisitor() {
        this(null, 1, null);
    }

    public KmLambdaVisitor(KmLambdaVisitor kmLambdaVisitor) {
        this.delegate = kmLambdaVisitor;
    }

    public /* synthetic */ KmLambdaVisitor(KmLambdaVisitor kmLambdaVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmLambdaVisitor);
    }

    public KmFunctionVisitor visitFunction(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmLambdaVisitor kmLambdaVisitor = this.delegate;
        if (kmLambdaVisitor != null) {
            return kmLambdaVisitor.visitFunction(i, name);
        }
        return null;
    }

    public void visitEnd() {
        KmLambdaVisitor kmLambdaVisitor = this.delegate;
        if (kmLambdaVisitor != null) {
            kmLambdaVisitor.visitEnd();
        }
    }
}
