package com.arizonagames.feature.arizona.imageviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.arizonagames.feature.arizona.imageviewer.databinding.ArizonaImageViewerBinding;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
/* compiled from: ArizonaImageViewerView.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001c\u001a\u00020\bH\u0014J\u0016\u0010\u001d\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\r\u0010!\u001a\u00020\bH\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020\bH\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/ArizonaImageViewerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "backendId", "", "onCloseClick", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;ILkotlin/jvm/functions/Function0;)V", "binding", "Lcom/arizonagames/feature/arizona/imageviewer/databinding/ArizonaImageViewerBinding;", "pagerAdapter", "Lcom/arizonagames/feature/arizona/imageviewer/ImageViewerPagerAdapter;", "welcomeBannersRetrofitClient", "Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersRetrofitClient;", "getWelcomeBannersRetrofitClient", "()Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersRetrofitClient;", "welcomeBannersRetrofitClient$delegate", "Lkotlin/Lazy;", "welcomeBannersRepository", "Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersRepository;", "getWelcomeBannersRepository", "()Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersRepository;", "welcomeBannersRepository$delegate", "bannersLoadJob", "Lkotlinx/coroutines/Job;", "onDetachedFromWindow", "submitImageUrls", "imageUrls", "", "", "loadWelcomeBanners", "loadWelcomeBanners$image_viewer", "showPreviousItem", "showNextItem", "updateNavigation", "position", "renderPageIndicator", "selectedPosition", "Companion", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArizonaImageViewerView extends FrameLayout {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String TAG = "ArizonaImageViewer";
    private Job bannersLoadJob;
    private final ArizonaImageViewerBinding binding;
    private final ImageViewerPagerAdapter pagerAdapter;
    private final Lazy welcomeBannersRepository$delegate;
    private final Lazy welcomeBannersRetrofitClient$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaImageViewerView(final Context context, final int i, final Function0<Unit> onCloseClick) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        ArizonaImageViewerBinding inflate = ArizonaImageViewerBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ImageViewerPagerAdapter imageViewerPagerAdapter = new ImageViewerPagerAdapter();
        this.pagerAdapter = imageViewerPagerAdapter;
        this.welcomeBannersRetrofitClient$delegate = LazyKt.lazy(new Function0() { // from class: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArizonaImageViewerView.welcomeBannersRetrofitClient_delegate$lambda$0(context, i);
            }
        });
        this.welcomeBannersRepository$delegate = LazyKt.lazy(new Function0() { // from class: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArizonaImageViewerView.welcomeBannersRepository_delegate$lambda$0(ArizonaImageViewerView.this);
            }
        });
        inflate.contentPager.setAdapter(imageViewerPagerAdapter);
        inflate.contentPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ArizonaImageViewerView.this.updateNavigation(i2);
            }
        });
        inflate.closeButton.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0.this.invoke();
            }
        });
        inflate.previousButton.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaImageViewerView.this.showPreviousItem();
            }
        });
        inflate.nextButton.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaImageViewerView.this.showNextItem();
            }
        });
        updateNavigation(0);
    }

    private final WelcomeBannersRetrofitClient getWelcomeBannersRetrofitClient() {
        return (WelcomeBannersRetrofitClient) this.welcomeBannersRetrofitClient$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final WelcomeBannersRetrofitClient welcomeBannersRetrofitClient_delegate$lambda$0(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new WelcomeBannersRetrofitClient(applicationContext, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WelcomeBannersRepository getWelcomeBannersRepository() {
        return (WelcomeBannersRepository) this.welcomeBannersRepository$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final WelcomeBannersRepository welcomeBannersRepository_delegate$lambda$0(ArizonaImageViewerView arizonaImageViewerView) {
        return new WelcomeBannersRepository(arizonaImageViewerView.getWelcomeBannersRetrofitClient().getApiService(), null, 2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Job job = this.bannersLoadJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.bannersLoadJob = null;
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitImageUrls(List<String> list) {
        this.pagerAdapter.submitImageUrls(list);
        if (!list.isEmpty()) {
            this.binding.contentPager.setCurrentItem(0, false);
        }
        this.binding.contentLoader.setVisibility(8);
        updateNavigation(0);
    }

    public final void loadWelcomeBanners$image_viewer() {
        Job launch$default;
        Job job = this.bannersLoadJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.binding.contentLoader.setVisibility(0);
        launch$default = BuildersKt__Builders_commonKt.launch$default(getWelcomeBannersRetrofitClient().getRetrofit().getScope(), null, null, new ArizonaImageViewerView$loadWelcomeBanners$1(this, null), 3, null);
        this.bannersLoadJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPreviousItem() {
        this.binding.contentPager.setCurrentItem(RangesKt.coerceAtLeast(this.binding.contentPager.getCurrentItem() - 1, 0), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNextItem() {
        int coerceAtMost = RangesKt.coerceAtMost(this.binding.contentPager.getCurrentItem() + 1, this.pagerAdapter.getItemCount() - 1);
        if (coerceAtMost >= 0) {
            this.binding.contentPager.setCurrentItem(coerceAtMost, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNavigation(int i) {
        this.binding.previousButton.setEnabled(i > 0);
        this.binding.nextButton.setEnabled(i < this.pagerAdapter.getItemCount() - 1);
        renderPageIndicator(i);
    }

    private final void renderPageIndicator(int i) {
        this.binding.pageIndicator.setState(this.pagerAdapter.getItemCount(), i);
    }

    /* compiled from: ArizonaImageViewerView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/ArizonaImageViewerView$Companion;", "", "<init>", "()V", "TAG", "", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
