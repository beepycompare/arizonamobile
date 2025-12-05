package androidx.window.embedding;

import androidx.window.embedding.OverlayAttributes;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: OverlayCreateParams.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/window/embedding/OverlayCreateParams;", "", "tag", "", "overlayAttributes", "Landroidx/window/embedding/OverlayAttributes;", "<init>", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "getTag", "()Ljava/lang/String;", "getOverlayAttributes", "()Landroidx/window/embedding/OverlayAttributes;", "toString", "Builder", "Companion", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlayCreateParams {
    public static final Companion Companion = new Companion(null);
    private final OverlayAttributes overlayAttributes;
    private final String tag;

    public OverlayCreateParams() {
        this(null, null, 3, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverlayCreateParams(String tag) {
        this(tag, null, 2, null);
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    @JvmStatic
    public static final String generateOverlayTag() {
        return Companion.generateOverlayTag();
    }

    public OverlayCreateParams(String tag, OverlayAttributes overlayAttributes) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(overlayAttributes, "overlayAttributes");
        this.tag = tag;
        this.overlayAttributes = overlayAttributes;
    }

    public /* synthetic */ OverlayCreateParams(String str, OverlayAttributes overlayAttributes, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.generateOverlayTag() : str, (i & 2) != 0 ? new OverlayAttributes.Builder().build() : overlayAttributes);
    }

    public final String getTag() {
        return this.tag;
    }

    public final OverlayAttributes getOverlayAttributes() {
        return this.overlayAttributes;
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(OverlayCreateParams.class).getSimpleName() + ":{ , tag=" + this.tag + ", attrs=" + this.overlayAttributes + AbstractJsonLexerKt.END_OBJ;
    }

    /* compiled from: OverlayCreateParams.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/window/embedding/OverlayCreateParams$Builder;", "", "<init>", "()V", "tag", "", "launchAttrs", "Landroidx/window/embedding/OverlayAttributes;", "setTag", "setOverlayAttributes", "attrs", "build", "Landroidx/window/embedding/OverlayCreateParams;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        private OverlayAttributes launchAttrs;
        private String tag;

        public final Builder setTag(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.tag = tag;
            return this;
        }

        public final Builder setOverlayAttributes(OverlayAttributes attrs) {
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            this.launchAttrs = attrs;
            return this;
        }

        public final OverlayCreateParams build() {
            String str = this.tag;
            if (str == null) {
                str = OverlayCreateParams.Companion.generateOverlayTag();
            }
            OverlayAttributes overlayAttributes = this.launchAttrs;
            if (overlayAttributes == null) {
                overlayAttributes = new OverlayAttributes.Builder().build();
            }
            return new OverlayCreateParams(str, overlayAttributes);
        }
    }

    /* compiled from: OverlayCreateParams.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Landroidx/window/embedding/OverlayCreateParams$Companion;", "", "<init>", "()V", "generateOverlayTag", "", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String generateOverlayTag() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            return StringsKt.substring(uuid, new IntRange(0, 32));
        }
    }
}
