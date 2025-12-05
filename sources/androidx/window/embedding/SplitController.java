package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: SplitController.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u001c\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0007J\b\u0010\u001d\u001a\u00020\u0017H\u0007J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001cH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Landroidx/window/embedding/SplitController;", "", "embeddingBackend", "Landroidx/window/embedding/EmbeddingBackend;", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "splitInfoList", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/window/embedding/SplitInfo;", "activity", "Landroid/app/Activity;", "splitSupportStatus", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "getSplitSupportStatus", "()Landroidx/window/embedding/SplitController$SplitSupportStatus;", "pinTopActivityStack", "", "taskId", "", "splitPinRule", "Landroidx/window/embedding/SplitPinRule;", "unpinTopActivityStack", "", "setSplitAttributesCalculator", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "clearSplitAttributesCalculator", "updateSplitAttributes", "splitInfo", "splitAttributes", "SplitSupportStatus", "Companion", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SplitController {
    public static final Companion Companion = new Companion(null);
    public static final boolean sDebug = false;
    private final EmbeddingBackend embeddingBackend;

    @JvmStatic
    public static final SplitController getInstance(Context context) {
        return Companion.getInstance(context);
    }

    public SplitController(EmbeddingBackend embeddingBackend) {
        Intrinsics.checkNotNullParameter(embeddingBackend, "embeddingBackend");
        this.embeddingBackend = embeddingBackend;
    }

    public final Flow<List<SplitInfo>> splitInfoList(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return FlowKt.callbackFlow(new SplitController$splitInfoList$1(this, activity, null));
    }

    public final SplitSupportStatus getSplitSupportStatus() {
        return this.embeddingBackend.getSplitSupportStatus();
    }

    public final boolean pinTopActivityStack(int i, SplitPinRule splitPinRule) {
        Intrinsics.checkNotNullParameter(splitPinRule, "splitPinRule");
        return this.embeddingBackend.pinTopActivityStack(i, splitPinRule);
    }

    public final void unpinTopActivityStack(int i) {
        this.embeddingBackend.unpinTopActivityStack(i);
    }

    public final void setSplitAttributesCalculator(Function1<? super SplitAttributesCalculatorParams, SplitAttributes> calculator) {
        Intrinsics.checkNotNullParameter(calculator, "calculator");
        this.embeddingBackend.setSplitAttributesCalculator(calculator);
    }

    public final void clearSplitAttributesCalculator() {
        this.embeddingBackend.clearSplitAttributesCalculator();
    }

    public final void updateSplitAttributes(SplitInfo splitInfo, SplitAttributes splitAttributes) {
        Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
        Intrinsics.checkNotNullParameter(splitAttributes, "splitAttributes");
        this.embeddingBackend.updateSplitAttributes(splitInfo, splitAttributes);
    }

    /* compiled from: SplitController.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/window/embedding/SplitController$SplitSupportStatus;", "", "rawValue", "", "<init>", "(I)V", "toString", "", "Companion", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SplitSupportStatus {
        private final int rawValue;
        public static final Companion Companion = new Companion(null);
        public static final SplitSupportStatus SPLIT_AVAILABLE = new SplitSupportStatus(0);
        public static final SplitSupportStatus SPLIT_UNAVAILABLE = new SplitSupportStatus(1);
        public static final SplitSupportStatus SPLIT_ERROR_PROPERTY_NOT_DECLARED = new SplitSupportStatus(2);

        private SplitSupportStatus(int i) {
            this.rawValue = i;
        }

        public String toString() {
            int i = this.rawValue;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return "SplitSupportStatus: ERROR_SPLIT_PROPERTY_NOT_DECLARED";
                    }
                    return "UNKNOWN";
                }
                return "SplitSupportStatus: UNAVAILABLE";
            }
            return "SplitSupportStatus: AVAILABLE";
        }

        /* compiled from: SplitController.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/window/embedding/SplitController$SplitSupportStatus$Companion;", "", "<init>", "()V", "SPLIT_AVAILABLE", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "SPLIT_UNAVAILABLE", "SPLIT_ERROR_PROPERTY_NOT_DECLARED", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: SplitController.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/window/embedding/SplitController$Companion;", "", "<init>", "()V", "sDebug", "", "getInstance", "Landroidx/window/embedding/SplitController;", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SplitController getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new SplitController(EmbeddingBackend.Companion.getInstance(context));
        }
    }
}
