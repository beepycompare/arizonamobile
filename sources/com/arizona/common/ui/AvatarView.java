package com.arizona.common.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arizona.common.R;
import com.arizona.common.model.AvatarData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AvatarView.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/arizona/common/ui/AvatarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarImage", "Lcom/arizona/common/ui/TopScaleImageView;", "avatarStatus", "Landroidx/cardview/widget/CardView;", "avatarBackground", "avatarProgress", "Landroid/widget/ProgressBar;", "updateBackgroundColor", "", "color", "updateData", "data", "Lcom/arizona/common/model/AvatarData;", "init", "Companion", "ScaleType", "CommonLibs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AvatarView extends ConstraintLayout {
    private static final String BOT_AVATAR = "https://cdn.azresources.cloud/projects/arizona-rp/assets/images/messenger/bot.webp";
    public static final Companion Companion = new Companion(null);
    private CardView avatarBackground;
    private TopScaleImageView avatarImage;
    private ProgressBar avatarProgress;
    private CardView avatarStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        init();
    }

    public final void updateBackgroundColor(int i) {
        CardView cardView = this.avatarBackground;
        if (cardView != null) {
            cardView.setCardBackgroundColor(i);
        }
    }

    public final void updateData(AvatarData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TopScaleImageView topScaleImageView = this.avatarImage;
        if (topScaleImageView != null) {
            topScaleImageView.setVisibility(0);
        }
        CardView cardView = this.avatarStatus;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        TopScaleImageView topScaleImageView2 = this.avatarImage;
        if (topScaleImageView2 != null) {
            String imageUrl = data.getImageUrl();
            if (imageUrl != null && imageUrl.length() != 0) {
                if (Intrinsics.areEqual(data.getImageUrl(), BOT_AVATAR)) {
                    topScaleImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    topScaleImageView2.setScale(data.getScaleType().getScaleFactor());
                }
                topScaleImageView2.setVisibility(0);
                Intrinsics.checkNotNull(Glide.with(getContext()).load(data.getImageUrl()).error(R.drawable.avatar_error_placeholder).apply((BaseRequestOptions<?>) new RequestOptions().override(Integer.MIN_VALUE).format(DecodeFormat.PREFER_ARGB_8888)).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new RequestListener<Drawable>() { // from class: com.arizona.common.ui.AvatarView$updateData$1$1
                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                        Intrinsics.checkNotNullParameter(target, "target");
                        return false;
                    }

                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean z) {
                        ProgressBar progressBar;
                        Intrinsics.checkNotNullParameter(resource, "resource");
                        Intrinsics.checkNotNullParameter(model, "model");
                        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                        progressBar = AvatarView.this.avatarProgress;
                        if (progressBar != null) {
                            progressBar.setVisibility(8);
                            return false;
                        }
                        return false;
                    }
                }).into(topScaleImageView2));
            } else {
                topScaleImageView2.setVisibility(8);
                ProgressBar progressBar = this.avatarProgress;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
            }
        }
        CardView cardView2 = this.avatarStatus;
        if (cardView2 != null) {
            cardView2.setCardBackgroundColor(data.getStatusColor());
        }
        CardView cardView3 = this.avatarBackground;
        if (cardView3 != null) {
            cardView3.setCardBackgroundColor(data.getBackground());
        }
    }

    private final void init() {
        ConstraintLayout.inflate(getContext(), R.layout.avatar_view, this);
        this.avatarImage = (TopScaleImageView) findViewById(R.id.avatar_image);
        this.avatarBackground = (CardView) findViewById(R.id.avatar_background);
        this.avatarProgress = (ProgressBar) findViewById(R.id.avatar_loader);
        this.avatarStatus = (CardView) findViewById(R.id.avatar_status);
    }

    /* compiled from: AvatarView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/common/ui/AvatarView$Companion;", "", "<init>", "()V", "BOT_AVATAR", "", "CommonLibs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AvatarView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/arizona/common/ui/AvatarView$ScaleType;", "", "scaleFactor", "", "<init>", "(Ljava/lang/String;IF)V", "getScaleFactor", "()F", "MICRO", "MINIMAL", "BIG", "CommonLibs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ScaleType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScaleType[] $VALUES;
        private final float scaleFactor;
        public static final ScaleType MICRO = new ScaleType("MICRO", 0, 0.3f);
        public static final ScaleType MINIMAL = new ScaleType("MINIMAL", 1, 0.7f);
        public static final ScaleType BIG = new ScaleType("BIG", 2, 1.0f);

        private static final /* synthetic */ ScaleType[] $values() {
            return new ScaleType[]{MICRO, MINIMAL, BIG};
        }

        public static EnumEntries<ScaleType> getEntries() {
            return $ENTRIES;
        }

        private ScaleType(String str, int i, float f) {
            this.scaleFactor = f;
        }

        public final float getScaleFactor() {
            return this.scaleFactor;
        }

        static {
            ScaleType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ScaleType valueOf(String str) {
            return (ScaleType) Enum.valueOf(ScaleType.class, str);
        }

        public static ScaleType[] values() {
            return (ScaleType[]) $VALUES.clone();
        }
    }
}
