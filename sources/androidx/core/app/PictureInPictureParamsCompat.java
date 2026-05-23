package androidx.core.app;

import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.graphics.Rect;
import android.os.Build;
import android.util.Rational;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PictureInPictureParamsCompat.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\"#$%Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010 \u001a\u00020!H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u0006&"}, d2 = {"Landroidx/core/app/PictureInPictureParamsCompat;", "", "isEnabled", "", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "isSeamlessResizeEnabled", "closeAction", "expandedAspectRatio", "title", "", "subTitle", "<init>", "(ZLandroid/util/Rational;Ljava/util/List;Landroid/graphics/Rect;ZLandroid/app/RemoteAction;Landroid/util/Rational;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "()Z", "getAspectRatio", "()Landroid/util/Rational;", "getActions", "()Ljava/util/List;", "getSourceRectHint", "()Landroid/graphics/Rect;", "getCloseAction", "()Landroid/app/RemoteAction;", "getExpandedAspectRatio", "getTitle", "()Ljava/lang/CharSequence;", "getSubTitle", "toPictureInPictureParams", "Landroid/app/PictureInPictureParams;", "Builder", "Api26Impl", "Api31Impl", "Api33Impl", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PictureInPictureParamsCompat {
    private final List<RemoteAction> actions;
    private final Rational aspectRatio;
    private final RemoteAction closeAction;
    private final Rational expandedAspectRatio;
    private final boolean isEnabled;
    private final boolean isSeamlessResizeEnabled;
    private final Rect sourceRectHint;
    private final CharSequence subTitle;
    private final CharSequence title;

    public PictureInPictureParamsCompat() {
        this(false, null, null, null, false, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public PictureInPictureParamsCompat(boolean z, Rational rational, List<RemoteAction> actions, Rect rect, boolean z2, RemoteAction remoteAction, Rational rational2, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.isEnabled = z;
        this.aspectRatio = rational;
        this.actions = actions;
        this.sourceRectHint = rect;
        this.isSeamlessResizeEnabled = z2;
        this.closeAction = remoteAction;
        this.expandedAspectRatio = rational2;
        this.title = charSequence;
        this.subTitle = charSequence2;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final Rational getAspectRatio() {
        return this.aspectRatio;
    }

    public /* synthetic */ PictureInPictureParamsCompat(boolean z, Rational rational, List list, Rect rect, boolean z2, RemoteAction remoteAction, Rational rational2, CharSequence charSequence, CharSequence charSequence2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        CharSequence charSequence3;
        CharSequence charSequence4;
        RemoteAction remoteAction2;
        Rational rational3;
        Rect rect2;
        boolean z3;
        Rational rational4;
        List list2;
        PictureInPictureParamsCompat pictureInPictureParamsCompat;
        boolean z4;
        z = (i & 1) != 0 ? true : z;
        rational = (i & 2) != 0 ? null : rational;
        list = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
        rect = (i & 8) != 0 ? null : rect;
        z2 = (i & 16) != 0 ? false : z2;
        remoteAction = (i & 32) != 0 ? null : remoteAction;
        rational2 = (i & 64) != 0 ? null : rational2;
        charSequence = (i & 128) != 0 ? null : charSequence;
        if ((i & 256) != 0) {
            charSequence3 = null;
            rational3 = rational2;
            charSequence4 = charSequence;
            z3 = z2;
            remoteAction2 = remoteAction;
            list2 = list;
            rect2 = rect;
            z4 = z;
            rational4 = rational;
            pictureInPictureParamsCompat = this;
        } else {
            charSequence3 = charSequence2;
            charSequence4 = charSequence;
            remoteAction2 = remoteAction;
            rational3 = rational2;
            rect2 = rect;
            z3 = z2;
            rational4 = rational;
            list2 = list;
            pictureInPictureParamsCompat = this;
            z4 = z;
        }
        new PictureInPictureParamsCompat(z4, rational4, list2, rect2, z3, remoteAction2, rational3, charSequence4, charSequence3);
    }

    public final List<RemoteAction> getActions() {
        return this.actions;
    }

    public final Rect getSourceRectHint() {
        return this.sourceRectHint;
    }

    public final boolean isSeamlessResizeEnabled() {
        return this.isSeamlessResizeEnabled;
    }

    public final RemoteAction getCloseAction() {
        return this.closeAction;
    }

    public final Rational getExpandedAspectRatio() {
        return this.expandedAspectRatio;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final CharSequence getSubTitle() {
        return this.subTitle;
    }

    public final PictureInPictureParams toPictureInPictureParams() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.create(this.aspectRatio, this.actions, this.sourceRectHint, this.isEnabled, this.isSeamlessResizeEnabled, this.expandedAspectRatio, this.closeAction, this.title, this.subTitle);
        }
        int i = Build.VERSION.SDK_INT;
        Rational rational = this.aspectRatio;
        if (i >= 31) {
            return Api31Impl.create(rational, this.actions, this.sourceRectHint, this.isEnabled, this.isSeamlessResizeEnabled);
        }
        return Api26Impl.create(rational, this.actions, this.sourceRectHint);
    }

    /* compiled from: PictureInPictureParamsCompat.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0014\u0010\u0015\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/core/app/PictureInPictureParamsCompat$Builder;", "", "<init>", "()V", "enabled", "", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "seamlessResizeEnabled", "closeAction", "expandedAspectRatio", "title", "", "subTitle", "setEnabled", "setAspectRatio", "setActions", "setSourceRectHint", "setSeamlessResizeEnabled", "setCloseAction", "setExpandedAspectRatio", "setTitle", "setSubTitle", "build", "Landroidx/core/app/PictureInPictureParamsCompat;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {
        private Rational aspectRatio;
        private RemoteAction closeAction;
        private Rational expandedAspectRatio;
        private boolean seamlessResizeEnabled;
        private Rect sourceRectHint;
        private CharSequence subTitle;
        private CharSequence title;
        private boolean enabled = true;
        private List<RemoteAction> actions = CollectionsKt.emptyList();

        public final Builder setEnabled(boolean z) {
            this.enabled = z;
            return this;
        }

        public final Builder setAspectRatio(Rational rational) {
            this.aspectRatio = rational;
            return this;
        }

        public final Builder setActions(List<RemoteAction> actions) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            this.actions = actions;
            return this;
        }

        public final Builder setSourceRectHint(Rect rect) {
            this.sourceRectHint = rect;
            return this;
        }

        public final Builder setSeamlessResizeEnabled(boolean z) {
            this.seamlessResizeEnabled = z;
            return this;
        }

        public final Builder setCloseAction(RemoteAction remoteAction) {
            this.closeAction = remoteAction;
            return this;
        }

        public final Builder setExpandedAspectRatio(Rational rational) {
            this.expandedAspectRatio = rational;
            return this;
        }

        public final Builder setTitle(CharSequence charSequence) {
            this.title = charSequence;
            return this;
        }

        public final Builder setSubTitle(CharSequence charSequence) {
            this.subTitle = charSequence;
            return this;
        }

        public final PictureInPictureParamsCompat build() {
            return new PictureInPictureParamsCompat(this.enabled, this.aspectRatio, this.actions, this.sourceRectHint, this.seamlessResizeEnabled, this.closeAction, this.expandedAspectRatio, this.title, this.subTitle);
        }
    }

    /* compiled from: PictureInPictureParamsCompat.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\r"}, d2 = {"Landroidx/core/app/PictureInPictureParamsCompat$Api26Impl;", "", "<init>", "()V", "create", "Landroid/app/PictureInPictureParams;", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class Api26Impl {
        public static final Api26Impl INSTANCE = new Api26Impl();

        private Api26Impl() {
        }

        @JvmStatic
        public static final PictureInPictureParams create(Rational rational, List<RemoteAction> actions, Rect rect) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            PictureInPictureParams build = new PictureInPictureParams.Builder().setAspectRatio(rational).setActions(actions).setSourceRectHint(rect).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }
    }

    /* compiled from: PictureInPictureParamsCompat.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/core/app/PictureInPictureParamsCompat$Api31Impl;", "", "<init>", "()V", "create", "Landroid/app/PictureInPictureParams;", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "autoEnterEnabled", "", "seamlessResizeEnabled", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class Api31Impl {
        public static final Api31Impl INSTANCE = new Api31Impl();

        private Api31Impl() {
        }

        @JvmStatic
        public static final PictureInPictureParams create(Rational rational, List<RemoteAction> actions, Rect rect, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            PictureInPictureParams build = new PictureInPictureParams.Builder().setAspectRatio(rational).setActions(actions).setSourceRectHint(rect).setAutoEnterEnabled(z).setSeamlessResizeEnabled(z2).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }
    }

    /* compiled from: PictureInPictureParamsCompat.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¨\u0006\u0015"}, d2 = {"Landroidx/core/app/PictureInPictureParamsCompat$Api33Impl;", "", "<init>", "()V", "create", "Landroid/app/PictureInPictureParams;", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "autoEnterEnabled", "", "seamlessResizeEnabled", "expandedAspectRatio", "closeAction", "title", "", "subTitle", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @JvmStatic
        public static final PictureInPictureParams create(Rational rational, List<RemoteAction> actions, Rect rect, boolean z, boolean z2, Rational rational2, RemoteAction remoteAction, CharSequence charSequence, CharSequence charSequence2) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            PictureInPictureParams build = new PictureInPictureParams.Builder().setAspectRatio(rational).setActions(actions).setSourceRectHint(rect).setAutoEnterEnabled(z).setSeamlessResizeEnabled(z2).setExpandedAspectRatio(rational2).setCloseAction(remoteAction).setTitle(charSequence).setSubtitle(charSequence2).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }
    }
}
