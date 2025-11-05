package ru.mrlargha.arizona.rating;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.palette.graphics.Palette;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.item.rating.databinding.RatingItemBinding;
/* compiled from: ItemsAdapter.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000f"}, d2 = {"ru/mrlargha/arizona/rating/MembersViewHolder$binding$1$1", "Lcom/squareup/picasso/Target;", "onBitmapLoaded", "", "bitmap", "Landroid/graphics/Bitmap;", "from", "Lcom/squareup/picasso/Picasso$LoadedFrom;", "onBitmapFailed", "e", "Ljava/lang/Exception;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onPrepareLoad", "placeHolderDrawable", "item-rating_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MembersViewHolder$binding$1$1 implements Target {
    final /* synthetic */ RatingItemBinding $this_apply;
    final /* synthetic */ View $view;

    @Override // com.squareup.picasso.Target
    public void onPrepareLoad(Drawable drawable) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MembersViewHolder$binding$1$1(RatingItemBinding ratingItemBinding, View view) {
        this.$this_apply = ratingItemBinding;
        this.$view = view;
    }

    @Override // com.squareup.picasso.Target
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap != null) {
            this.$this_apply.image.setImageBitmap(bitmap);
            Palette.Builder from = Palette.from(bitmap);
            final RatingItemBinding ratingItemBinding = this.$this_apply;
            from.generate(new Palette.PaletteAsyncListener() { // from class: ru.mrlargha.arizona.rating.MembersViewHolder$binding$1$1$$ExternalSyntheticLambda0
                @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                public final void onGenerated(Palette palette) {
                    MembersViewHolder$binding$1$1.onBitmapLoaded$lambda$0(RatingItemBinding.this, palette);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBitmapLoaded$lambda$0(RatingItemBinding ratingItemBinding, Palette palette) {
        int dominantColor = palette != null ? palette.getDominantColor(0) : 0;
        CustomCardView cardBg = ratingItemBinding.cardBg;
        Intrinsics.checkNotNullExpressionValue(cardBg, "cardBg");
        CustomCardView.setBackground$default(cardBg, dominantColor, 0, null, null, 12, null);
    }

    @Override // com.squareup.picasso.Target
    public void onBitmapFailed(Exception exc, Drawable drawable) {
        ImageView image = this.$this_apply.image;
        Intrinsics.checkNotNullExpressionValue(image, "image");
        Context context = this.$view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        UtilsKt.setNotLoadedImage(image, context);
        if (exc != null) {
            exc.printStackTrace();
        }
    }
}
