package com.arizonagames.feature.arizona.imageviewer;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.imageviewer.ImageViewerPagerAdapter;
import com.arizonagames.feature.arizona.imageviewer.databinding.ArizonaImageViewerPageBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ImageViewerPagerAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/ImageViewerPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/arizona/imageviewer/ImageViewerPagerAdapter$ImagePageViewHolder;", "<init>", "()V", "imageUrls", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "getItemCount", "submitImageUrls", "newImageUrls", "ImagePageViewHolder", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageViewerPagerAdapter extends RecyclerView.Adapter<ImagePageViewHolder> {
    private List<String> imageUrls = CollectionsKt.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ImagePageViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ArizonaImageViewerPageBinding inflate = ArizonaImageViewerPageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ImagePageViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ImagePageViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.imageUrls.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(ImagePageViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.recycle();
        super.onViewRecycled((ImageViewerPagerAdapter) holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.imageUrls.size();
    }

    public final void submitImageUrls(List<String> newImageUrls) {
        Intrinsics.checkNotNullParameter(newImageUrls, "newImageUrls");
        this.imageUrls = newImageUrls;
        notifyDataSetChanged();
    }

    /* compiled from: ImageViewerPagerAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\tJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/ImageViewerPagerAdapter$ImagePageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/arizonagames/feature/arizona/imageviewer/databinding/ArizonaImageViewerPageBinding;", "<init>", "(Lcom/arizonagames/feature/arizona/imageviewer/databinding/ArizonaImageViewerPageBinding;)V", "boundImageUrl", "", "bind", "", "imageUrl", "recycle", "finishLoading", "isSuccessful", "", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ImagePageViewHolder extends RecyclerView.ViewHolder {
        private final ArizonaImageViewerPageBinding binding;
        private String boundImageUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImagePageViewHolder(ArizonaImageViewerPageBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bind(final String imageUrl) {
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            this.boundImageUrl = null;
            Picasso.get().cancelRequest(this.binding.image);
            this.boundImageUrl = imageUrl;
            this.binding.image.setImageDrawable(null);
            this.binding.image.setVisibility(4);
            this.binding.loader.setVisibility(0);
            Picasso.get().load(imageUrl).fit().noFade().into(this.binding.image, new Callback() { // from class: com.arizonagames.feature.arizona.imageviewer.ImageViewerPagerAdapter$ImagePageViewHolder$bind$1
                @Override // com.squareup.picasso.Callback
                public void onSuccess() {
                    ImageViewerPagerAdapter.ImagePageViewHolder.this.finishLoading(imageUrl, true);
                }

                @Override // com.squareup.picasso.Callback
                public void onError(Exception exc) {
                    ImageViewerPagerAdapter.ImagePageViewHolder.this.finishLoading(imageUrl, false);
                }
            });
        }

        public final void recycle() {
            this.boundImageUrl = null;
            Picasso.get().cancelRequest(this.binding.image);
            this.binding.image.setImageDrawable(null);
            this.binding.image.setVisibility(4);
            this.binding.loader.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void finishLoading(String str, boolean z) {
            if (Intrinsics.areEqual(this.boundImageUrl, str)) {
                this.binding.loader.setVisibility(8);
                this.binding.image.setVisibility(z ? 0 : 4);
            }
        }
    }
}
